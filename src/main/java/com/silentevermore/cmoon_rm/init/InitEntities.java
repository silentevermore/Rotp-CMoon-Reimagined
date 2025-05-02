package com.silentevermore.cmoon_rm.init;

import com.silentevermore.cmoon_rm.CMoonAddon;

import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITIES, CMoonAddon.MOD_ID);
};
