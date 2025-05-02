package com.silentevermore.cmoon_rm.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityBlock;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.silentevermore.cmoon_rm.CMoonAddon;
import com.silentevermore.cmoon_rm.action.GravityChange;
import com.silentevermore.cmoon_rm.action.InversionalBarrage;
import com.silentevermore.cmoon_rm.entity.CMoonEntity;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), CMoonAddon.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), CMoonAddon.MOD_ID);

    //C-Moon

    public static final RegistryObject<StandEntityAction> CMOON_PUNCH = ACTIONS.register("cmoon_punch",
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .swingSound(InitSounds.CMOON_BARRAGE_SWING)
                    .punchSound(InitSounds.CMOON_PUNCH_LIGHT)));

    public static final RegistryObject<StandEntityAction> CMOON_BARRAGE = ACTIONS.register("cmoon_barrage",
            () -> new InversionalBarrage(new InversionalBarrage.Builder()
                    .barrageSwingSound(ModSounds.STAND_PUNCH_BARRAGE_SWING)
                    .standSound(StandEntityAction.Phase.PERFORM, InitSounds.CMOON_BARRAGE_SWING)
                    .barrageHitSound(InitSounds.CMOON_PUNCH_BARRAGE)
            ));

    public static final RegistryObject<StandEntityHeavyAttack> CMOON_FINISHER_PUNCH = ACTIONS.register("cmoon_finisher_punch",
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder() // TODO finisher ability
                    .punchSound(InitSounds.CMOON_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityHeavyAttack> CMOON_HEAVY_PUNCH = ACTIONS.register("cmoon_heavy_punch",
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .shiftVariationOf(CMOON_PUNCH).shiftVariationOf(CMOON_BARRAGE)
                    .setFinisherVariation(CMOON_FINISHER_PUNCH)
                    .punchSound(InitSounds.CMOON_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> CMOON_BLOCK = ACTIONS.register("cmoon_block",
            () -> new StandEntityBlock());

    public static final RegistryObject<StandEntityAction> GRAVITATIONAL_CHANGE = ACTIONS.register("cmoon_gravity_change",
            () -> new GravityChange(new StandEntityAction.Builder()
                    .autoSummonStand()
                    .standSound(StandEntityAction.Phase.PERFORM, InitSounds.CMOON_GRAVITY_SHIFT_NORMAL)
            ));
    //stand and stats
    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<CMoonEntity>> CMOON =
            new EntityStandRegistryObject<>("cmoon",
                    STANDS,
                    () -> new EntityStandType.Builder<StandStats>()
                            .color(0x9fd562)
                            .storyPartName(ModStandsInit.PART_6_NAME)
                            .leftClickHotbar(
                                    CMOON_PUNCH.get(),
                                    CMOON_BARRAGE.get()
                            )
                            .rightClickHotbar(
                                    CMOON_BLOCK.get(),
                                    GRAVITATIONAL_CHANGE.get()
                            )
                            .defaultStats(StandStats.class, new StandStats.Builder()
                                    .power(10)
                                    .speed(16)
                                    .range(100, 100)
                                    .durability(10)
                                    .precision(4)
                                    .build())
                            .addSummonShout(InitSounds.CMOON_SUMMON_VOICELINE)
                            .addOst(InitSounds.CMOON_OST)
                            .build(),

                    InitEntities.ENTITIES,
                    () -> new StandEntityType<CMoonEntity>(CMoonEntity::new, 0.7F, 2F)
                            .summonSound(InitSounds.CMOON_SUMMON_SOUND)
                            .unsummonSound(InitSounds.CMOON_UNSUMMON_SOUND))
                    .withDefaultStandAttributes();
}
