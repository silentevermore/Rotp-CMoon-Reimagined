package com.silentevermore.cmoon_rm.action;

import com.github.standobyte.jojo.action.stand.StandEntityMeleeBarrage;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.util.mc.damage.StandEntityDamageSource;
import com.silentevermore.cmoon_rm.init.InitEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.server.ServerWorld;

public class InversionalBarrage extends StandEntityMeleeBarrage{
    //builder
    public InversionalBarrage(Builder builder) {
        super(builder);
    }
    //overriden methods
    @Override
    public BarrageEntityPunch punchEntity(StandEntity stand, Entity target, StandEntityDamageSource dmgSource){
        if (!stand.level.isClientSide() && target instanceof LivingEntity) {
            final ServerWorld serverWorld = (ServerWorld) stand.level;
            final LivingEntity living = (LivingEntity) target;
            if (target.isAlive()){
                living.addEffect(new EffectInstance(InitEffects.ARMS_INVERSION.get(), 100, 1, false, false));
            }
        }
        return super.punchEntity(stand, target, dmgSource);
    }
}
