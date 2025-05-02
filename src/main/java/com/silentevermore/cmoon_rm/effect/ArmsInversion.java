package com.silentevermore.cmoon_rm.effect;

import com.github.standobyte.jojo.network.packets.fromserver.SpawnParticlePacket;
import com.github.standobyte.jojo.util.mc.MCUtil;
import com.github.standobyte.jojo.util.mc.damage.DamageUtil;
import com.silentevermore.cmoon_rm.CMoonAddon;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public class ArmsInversion extends Effect{
    //builder
    public ArmsInversion(EffectType effectType, int color) {
        super(effectType, color);
    }
    //overriden methods
    @Override
    public void applyEffectTick(LivingEntity living, int ticks){
        CMoonAddon.getLogger().debug(ticks);
        if (!living.level.isClientSide() && living.isAlive() && ticks%2==0){
            MCUtil.sendParticles((ServerWorld) living.level, ParticleTypes.WHITE_ASH.getType(), living.getX(), living.getY(), living.getZ(), 1, 0, 0, 0, 4, SpawnParticlePacket.SpecialContext.AFK);
            DamageUtil.hurtThroughInvulTicks(living, DamageSource.GENERIC, 1);
        }
    }
    @Override
    public boolean isDurationEffectTick(int p_76397_1_, int p_76397_2_){
        return true;
    }
}
