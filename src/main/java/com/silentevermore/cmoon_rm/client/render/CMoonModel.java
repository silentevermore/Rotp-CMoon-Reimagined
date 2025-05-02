package com.silentevermore.cmoon_rm.client.render;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.bb.BlockbenchStandModelHelper;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.pose.IModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.github.standobyte.jojo.entity.stand.StandPose;

import com.silentevermore.cmoon_rm.entity.CMoonEntity;

public class CMoonModel extends HumanoidStandModel<CMoonEntity>{
    public CMoonModel(){
        super();
        BlockbenchStandModelHelper.fillFromBlockbenchExport(new CMoonBlockbench(), this);
    }
    @Override //TODO: IMPLEMENT SUMMON POSES
    protected RotationAngle[][] initSummonPoseRotations(){
        return new RotationAngle[][]{
                new RotationAngle[]{
                        RotationAngle.fromDegrees(head, 12.5, -25, 0),
                        RotationAngle.fromDegrees(body, -5, 0, 0),
                        RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                        RotationAngle.fromDegrees(leftArm, 13.3237, -15.1582, -13.3237),
                        RotationAngle.fromDegrees(leftForeArm, 0, 0, 0),
                        RotationAngle.fromDegrees(rightArm, -45, 0, 12.5),
                        RotationAngle.fromDegrees(rightForeArm, -85, 0, 0),
                        RotationAngle.fromDegrees(leftLeg, 29.6077, -12.5891, -9.9676),
                        RotationAngle.fromDegrees(leftLowerLeg, 0, 0, 0),
                        RotationAngle.fromDegrees(rightLeg, -20.7721, 13.4715, 7.2969),
                        RotationAngle.fromDegrees(rightLowerLeg, 72.5, 0, 0)
                }
        };
    }
    @Override
    protected void initActionPoses(){
        actionAnim.put(StandPose.RANGED_ATTACK, new PosedActionAnimation.Builder<CMoonEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[]{
                        new RotationAngle(body, 0.0F, -0.48F, 0.0F),
                        new RotationAngle(leftArm, 0.0F, 0.0F, -0.7854F),
                        new RotationAngle(leftForeArm, 0.0F, 0.0F, 0.6109F),
                        new RotationAngle(rightArm, -1.0908F, 0.0F, 1.5708F), 
                        new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F)
                }))
                .build(idlePose));
        
        super.initActionPoses();
    }
    @Override // TODO: IMPLEMENT IDLE POSE
    protected ModelPose<CMoonEntity> initIdlePose(){
        return new ModelPose<>(new RotationAngle[]{
                RotationAngle.fromDegrees(body, -5, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(leftArm, -0.1866, 9.7606, -2.1856),
                RotationAngle.fromDegrees(leftArmJoint, 0, 0, 0),
                RotationAngle.fromDegrees(leftForeArm, -17.5, 0, 32.5),
                RotationAngle.fromDegrees(rightArm, 9.9162, -1.2988, 7.3873),
                RotationAngle.fromDegrees(rightArmJoint, 0, 0, 0),
                RotationAngle.fromDegrees(rightForeArm, 0, 0, 0),
                RotationAngle.fromDegrees(leftLeg, 17.5, -12.5, 0),
                RotationAngle.fromDegrees(leftLowerLeg, 0, 0, 0),
                RotationAngle.fromDegrees(rightLeg, 0, 15, 0),
                RotationAngle.fromDegrees(rightLowerLeg, 12.5, 0, 0)
        });
    }
    @Override
    protected IModelPose<CMoonEntity> initIdlePose2Loop(){
        return new ModelPose<>(new RotationAngle[]{
                RotationAngle.fromDegrees(body, -5, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(torso, 0.0F, 0.0F, 0.0F),
                RotationAngle.fromDegrees(leftArm, -0.1866, 9.7606, -2.1856),
                RotationAngle.fromDegrees(leftArmJoint, 0, 0, 0),
                RotationAngle.fromDegrees(leftForeArm, -17.5, 0, 32.5),
                RotationAngle.fromDegrees(rightArm, 9.9162, -1.2988, 7.3873),
                RotationAngle.fromDegrees(rightArmJoint, 0, 0, 0),
                RotationAngle.fromDegrees(rightForeArm, 0, 0, 0),
                RotationAngle.fromDegrees(leftLeg, 17.5, -12.5, 0),
                RotationAngle.fromDegrees(leftLowerLeg, 0, 0, 0),
                RotationAngle.fromDegrees(rightLeg, 0, 15, 0),
                RotationAngle.fromDegrees(rightLowerLeg, 12.5, 0, 0)
        });
    }
}