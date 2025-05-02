package com.silentevermore.cmoon_rm.init;

import java.util.function.Supplier;

import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.util.mc.OstSoundList;
import com.silentevermore.cmoon_rm.CMoonAddon;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, CMoonAddon.MOD_ID); // TODO sounds.json

    public static final RegistryObject<SoundEvent> CMOON_SUMMON_VOICELINE = SOUNDS.register("cmoon_summon_voiceline",
            () -> new SoundEvent(new ResourceLocation(CMoonAddon.MOD_ID, "cmoon_summon_voiceline")));

    public static final Supplier<SoundEvent> CMOON_SUMMON_SOUND = SOUNDS.register("cmoon_summon_sound",
            () -> new SoundEvent(new ResourceLocation(CMoonAddon.MOD_ID, "cmoon_summon_sound")));

    public static final Supplier<SoundEvent> CMOON_UNSUMMON_SOUND = SOUNDS.register("cmoon_unsummon_sound",
            () -> new SoundEvent(new ResourceLocation(CMoonAddon.MOD_ID, "cmoon_unsummon_sound")));

    public static final Supplier<SoundEvent> CMOON_PUNCH_LIGHT = ModSounds.STAND_PUNCH_LIGHT;

    public static final Supplier<SoundEvent> CMOON_PUNCH_HEAVY = ModSounds.STAND_PUNCH_HEAVY;

    public static final Supplier<SoundEvent> CMOON_PUNCH_BARRAGE = ModSounds.STAND_PUNCH_LIGHT;

    public static final Supplier<SoundEvent> CMOON_BARRAGE_SWING = SOUNDS.register("cmoon_barrage_swing",
            () -> new SoundEvent(new ResourceLocation(CMoonAddon.MOD_ID, "cmoon_barrage_swing")));

    public static final Supplier<SoundEvent> CMOON_GRAVITY_SHIFT_NORMAL = SOUNDS.register("cmoon_gravity_shift_normal",
            () -> new SoundEvent(new ResourceLocation(CMoonAddon.MOD_ID, "cmoon_gravity_shift_normal")));

    public static final OstSoundList CMOON_OST = new OstSoundList(
            new ResourceLocation(CMoonAddon.MOD_ID, "cmoon_ost"), SOUNDS);
}