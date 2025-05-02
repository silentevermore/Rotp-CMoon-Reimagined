package com.silentevermore.cmoon_rm;

import com.silentevermore.cmoon_rm.init.InitEffects;
import com.silentevermore.cmoon_rm.network.PacketHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.silentevermore.cmoon_rm.init.InitEntities;
import com.silentevermore.cmoon_rm.init.InitSounds;
import com.silentevermore.cmoon_rm.init.InitStands;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CMoonAddon.MOD_ID)
public class CMoonAddon{
    //constants
    public static final String MOD_ID="cmoon_rm";
    public static final Logger LOGGER=LogManager.getLogger();
    //builder
    public CMoonAddon(){
        final IEventBus modEventBus=FMLJavaModLoadingContext.get().getModEventBus();

        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);
        InitEffects.EFFECTS.register(modEventBus);
        PacketHandler.init();
    }
    //methods
    public static Logger getLogger(){
        return LOGGER;
    }
}
