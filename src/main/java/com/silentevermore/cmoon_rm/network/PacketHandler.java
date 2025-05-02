package com.silentevermore.cmoon_rm.network;

import com.github.standobyte.jojo.network.packets.IModPacketHandler;
import com.silentevermore.cmoon_rm.network.packets.server.CMoonRenderPacket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import javax.annotation.Nullable;
import java.util.Optional;

import static com.silentevermore.cmoon_rm.CMoonAddon.MOD_ID;

public class PacketHandler{
    public static final String PROTOCOL_VERSION="1";
    private static SimpleChannel serverChannel;
    private static SimpleChannel clientChannel;
    private static int packetIndex=0;

    public static void init(){
        serverChannel= NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(MOD_ID, "server_channel"))
                .clientAcceptedVersions(PROTOCOL_VERSION::equals)
                .serverAcceptedVersions(PROTOCOL_VERSION::equals)
                .networkProtocolVersion(()->PROTOCOL_VERSION)
                .simpleChannel();
        clientChannel= NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(MOD_ID, "client_channel"))
                .clientAcceptedVersions(PROTOCOL_VERSION::equals)
                .serverAcceptedVersions(PROTOCOL_VERSION::equals)
                .networkProtocolVersion(()->PROTOCOL_VERSION)
                .simpleChannel();
        packetIndex=0;
        registerMessage(serverChannel, new CMoonRenderPacket.Handler(), Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    }
    private static <MSG> void registerMessage(SimpleChannel channel, IModPacketHandler<MSG> handler, Optional<NetworkDirection> networkDirection){
        if (packetIndex>127) throw new IllegalStateException("Too many packets registered on a single channel (>127)");
        channel.registerMessage(packetIndex++, handler.getPacketClass(), handler::encode, handler::decode, handler::enqueueHandleSetHandled, networkDirection);
    }
    public static void sendToServer(Object msg){
        clientChannel.sendToServer(msg);
    }
    public static void sendToClient(Object msg, ServerPlayerEntity player) {
        if (!(player instanceof FakePlayer)) serverChannel.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }
    public static void sendToClientsTracking(Object msg, Entity entity){
        serverChannel.send(PacketDistributor.TRACKING_ENTITY.with(()->entity), msg);
    }
    public static void sendToClientsTrackingAndSelf(Object msg, Entity entity){
        serverChannel.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(()->entity), msg);
    }
    public static void sendGlobally(Object msg, @Nullable RegistryKey<World> dimension){
        if (dimension!=null){
            serverChannel.send(PacketDistributor.DIMENSION.with(()->dimension), msg);
        }else{
            serverChannel.send(PacketDistributor.ALL.noArg(), msg);
        }
    }
}
