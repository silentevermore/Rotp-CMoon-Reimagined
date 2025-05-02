package com.silentevermore.cmoon_rm.mixin;

import com.github.standobyte.jojo.mixin.EntityLiquidWalkingMixin;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.silentevermore.cmoon_rm.CMoonAddon;
import com.silentevermore.cmoon_rm.entity.CMoonEntity;
import com.silentevermore.cmoon_rm.init.InitStands;
import com.silentevermore.cmoon_rm.util.RotationUtil;
import net.minecraft.entity.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Entity.class)
public abstract class EntityMixin{
    //variables
    @Shadow private AxisAlignedBB bb;
    @Shadow private Vector3d position;
    @Shadow public abstract Vector3d position();
    @Shadow public abstract float getEyeHeight();
    @Shadow protected abstract float getBlockSpeedFactor();
    @Shadow public abstract Vector3d getDeltaMovement();
    //unique methods
    @Unique
    public Optional<CMoonEntity> getCMoon(){
        if ((Object)this instanceof LivingEntity){
            LivingEntity living=(LivingEntity)(Object) this;
            Optional<IStandPower> optionalStand=IStandPower.getStandPowerOptional(living).resolve();
            IStandPower stand=optionalStand.orElse(null);
            CMoonEntity cmoon=null;
            if (stand!=null && stand.getStandManifestation() instanceof CMoonEntity && stand.getType()==InitStands.CMOON.getStandType())
                cmoon=(CMoonEntity)stand.getStandManifestation();
            return Optional.ofNullable(cmoon);
        }
        return Optional.empty();
    }
    @Unique
    public Direction getGravityDirection(){
        Optional<CMoonEntity> cmoon=getCMoon();
        if (cmoon.isPresent()) return cmoon.get().getGravityDirection();
        return Direction.DOWN;
    }
    //injections
    @Inject(method="getBoundingBox", at=@At("RETURN"), cancellable=true)
    public void getBoundingBox(CallbackInfoReturnable<AxisAlignedBB> cir){
        Direction gravityDir=getGravityDirection();
        if (gravityDir==Direction.DOWN) return;
        AxisAlignedBB box=cir.getReturnValue().move(this.position().reverse());
        if(gravityDir.getAxisDirection()==Direction.AxisDirection.POSITIVE) box = box.move(0d, -1.0e-6d, 0d);
        cir.setReturnValue(RotationUtil.boxPlayerToWorld(box, gravityDir).move(this.position()));
    }

    @Inject(method="getBoundingBoxForPose", at=@At("RETURN"), cancellable=true)
    protected void getBoundingBoxForPose(Pose pose, CallbackInfoReturnable<AxisAlignedBB> cir){
        Direction gravityDir=getGravityDirection();
        if (gravityDir==Direction.DOWN) return;
        AxisAlignedBB box=cir.getReturnValue().move(this.position().reverse());
        if(gravityDir.getAxisDirection()==Direction.AxisDirection.POSITIVE) box = box.move(0d, -1.0e-6d, 0d);
        cir.setReturnValue(RotationUtil.boxPlayerToWorld(box, gravityDir).move(this.position()));
    }

    @Inject(method="getRotationVector", at=@At("RETURN"), cancellable=true)
    public void getRotationVector(CallbackInfoReturnable<Vector2f> cir){
        Direction gravityDir=getGravityDirection();
        if (gravityDir==Direction.DOWN) return;
        cir.setReturnValue(RotationUtil.rotPlayerToWorld(cir.getReturnValue(), gravityDir));
    }

    @Inject(method="getBlockPosBelowThatAffectsMyMovement", at=@At("HEAD"), cancellable=true)
    protected void getBlockPosBelowThatAffectsMyMovement(CallbackInfoReturnable<BlockPos> cir){
        Direction gravityDir=getGravityDirection();
        if (gravityDir==Direction.DOWN) return;
        cir.setReturnValue(new BlockPos(this.position().add(Vector3d.atCenterOf(gravityDir.getNormal())).scale(0.5000001D)));
    }

    @Inject(method="getEyePosition", at=@At("HEAD"), cancellable=true)
    public final void getEyePosition(float p_174824_1_, CallbackInfoReturnable<Vector3d> cir){
        Direction gravityDir=getGravityDirection();
        if (gravityDir==Direction.DOWN) return;
        //cir.setReturnValue(RotationUtil.vecPlayerToWorld(0.0D, this.getEyeHeight(), 0.0D, gravityDir).add(this.position()));
    }

    @ModifyVariable(method="move", at=@At("HEAD"), ordinal=0)
    private Vector3d move(Vector3d dir){
        Direction gravityDir=getGravityDirection();
        if (gravityDir==Direction.DOWN) return dir;
        return RotationUtil.vecPlayerToWorld(dir, gravityDir);
    }

    @ModifyArg(
            method="move",
            at=@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/Entity;setDeltaMovement(Lnet/minecraft/util/math/vector/Vector3d;)V",
                    ordinal=0
            ),
            index=0
    )
    private Vector3d modify_move_multiply_0(Vector3d vec){
        Direction gravityDir=getGravityDirection();
        float f2=this.getBlockSpeedFactor();
        Vector3d init_vec=new Vector3d(f2, 1d, f2);
        if (gravityDir==Direction.DOWN) return this.getDeltaMovement().multiply(init_vec);
        return this.getDeltaMovement().multiply(RotationUtil.maskPlayerToWorld(init_vec, gravityDir));
    }
}
