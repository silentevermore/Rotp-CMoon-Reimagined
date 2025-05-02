package com.silentevermore.cmoon_rm.network.packets.server;

import com.github.standobyte.jojo.client.ClientUtil;
import com.github.standobyte.jojo.network.packets.IModPacketHandler;
import com.silentevermore.cmoon_rm.entity.CMoonEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class CMoonRenderPacket{
    //constants
    private final Direction gravityDirection;
    private final int standId;
    //builder
    public CMoonRenderPacket(int cmoon, Direction axis){
        this.standId=cmoon;
        this.gravityDirection=axis;
    }
    //other
    public static class Handler implements IModPacketHandler<CMoonRenderPacket>{
        @Override
        public void encode(CMoonRenderPacket msg, PacketBuffer buf){
            buf.writeInt(msg.standId);
            buf.writeEnum(msg.gravityDirection);
        }
        @Override
        public CMoonRenderPacket decode(PacketBuffer buf){
            return new CMoonRenderPacket(buf.readInt(), buf.readEnum(Direction.class));
        }
        @Override
        public void handle(CMoonRenderPacket msg, Supplier<NetworkEvent.Context> ctx){
            PlayerEntity player=ctx.get().getSender();
            Entity stand=ClientUtil.getEntityById(msg.standId);
            if (stand instanceof CMoonEntity){
                CMoonEntity cmoonEntity=(CMoonEntity) stand;
                cmoonEntity.setGravityDirection(msg.gravityDirection);
            }
        }
        @Override
        public Class<CMoonRenderPacket> getPacketClass(){
            return CMoonRenderPacket.class;
        }
    }
}
