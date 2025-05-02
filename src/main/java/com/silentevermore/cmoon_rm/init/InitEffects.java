package com.silentevermore.cmoon_rm.init;

import com.silentevermore.cmoon_rm.CMoonAddon;

import com.silentevermore.cmoon_rm.effect.ArmsInversion;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(
            ForgeRegistries.POTIONS, CMoonAddon.MOD_ID);
    public static final RegistryObject<Effect> ARMS_INVERSION=EFFECTS.register("arms_inversion",
            ()->new ArmsInversion(EffectType.HARMFUL, 0x9fd562));
};
