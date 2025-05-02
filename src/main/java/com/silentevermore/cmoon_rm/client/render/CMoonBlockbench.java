package com.silentevermore.cmoon_rm.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.silentevermore.cmoon_rm.entity.CMoonEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class CMoonBlockbench extends EntityModel<CMoonEntity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer upperPart;
	private final ModelRenderer torso;
	private final ModelRenderer belt_piece_r1;
	private final ModelRenderer belt_r1;
	private final ModelRenderer arrow_r1;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftArmJoint;
	private final ModelRenderer leftForeArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer rightArmJoint;
	private final ModelRenderer rightForeArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer leftLegJoint;
	private final ModelRenderer leftLowerLeg;
	private final ModelRenderer rightLeg;
	private final ModelRenderer rightLegJoint;
	private final ModelRenderer rightLowerLeg;

	public CMoonBlockbench() {
		texWidth = 128;
		texHeight = 128;

		head = new ModelRenderer(this);
		head.setPos(0.0F, 0.0F, 0.0F);
		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.texOffs(64, 6).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 11.0F, 8.0F, 0.25F, false);
		head.texOffs(48, 67).addBox(-4.0F, -11.0F, -4.3F, 8.0F, 11.0F, 0.0F, 0.0F, false);
		head.texOffs(0, 67).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.25F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);


		upperPart = new ModelRenderer(this);
		upperPart.setPos(0.0F, 12.0F, 0.0F);
		body.addChild(upperPart);


		torso = new ModelRenderer(this);
		torso.setPos(0.0F, -12.0F, 0.0F);
		upperPart.addChild(torso);
		torso.texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		torso.texOffs(24, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, 0.25F, false);

		belt_piece_r1 = new ModelRenderer(this);
		belt_piece_r1.setPos(1.4433F, 11.8877F, -2.6287F);
		torso.addChild(belt_piece_r1);
		setRotationAngle(belt_piece_r1, 0.0152F, 0.0859F, 0.2625F);
		belt_piece_r1.texOffs(24, 0).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, 0.0F, false);

		belt_r1 = new ModelRenderer(this);
		belt_r1.setPos(0.1F, 11.0F, 0.5F);
		torso.addChild(belt_r1);
		setRotationAngle(belt_r1, 0.0F, 0.0F, 0.0873F);
		belt_r1.texOffs(60, 41).addBox(-4.6F, -1.0F, -3.0F, 9.0F, 3.0F, 5.0F, 0.0F, false);

		arrow_r1 = new ModelRenderer(this);
		arrow_r1.setPos(0.0F, 11.0F, 2.25F);
		torso.addChild(arrow_r1);
		setRotationAngle(arrow_r1, -0.0436F, 0.0F, 0.0F);
		arrow_r1.texOffs(64, 67).addBox(-4.0F, -11.0F, 0.0F, 8.0F, 12.0F, 0.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setPos(4.0F, -9.5F, 0.0F);
		upperPart.addChild(leftArm);
		leftArm.texOffs(16, 45).addBox(0.0F, -2.5F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftArm.texOffs(0, 51).addBox(0.0F, -2.5F, -2.0F, 4.0F, 4.0F, 4.0F, 0.25F, false);

		leftArmJoint = new ModelRenderer(this);
		leftArmJoint.setPos(2.0F, 3.5F, 0.0F);
		leftArm.addChild(leftArmJoint);
		leftArmJoint.texOffs(44, 61).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		leftForeArm = new ModelRenderer(this);
		leftForeArm.setPos(2.5F, 3.6667F, 0.0F);
		leftArm.addChild(leftForeArm);
		leftForeArm.texOffs(0, 41).addBox(-2.5F, -0.1667F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftForeArm.texOffs(64, 49).addBox(-2.5F, -0.1667F, -2.0F, 4.0F, 6.0F, 4.0F, 0.25F, false);
		leftForeArm.texOffs(22, 62).addBox(0.5F, 4.8333F, -2.0F, 1.0F, 1.0F, 4.0F, 0.1F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setPos(-4.0F, -9.5F, 0.0F);
		upperPart.addChild(rightArm);
		rightArm.texOffs(38, 35).addBox(-4.0F, -2.5F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightArm.texOffs(48, 53).addBox(-4.0F, -2.5F, -2.0F, 4.0F, 4.0F, 4.0F, 0.25F, false);

		rightArmJoint = new ModelRenderer(this);
		rightArmJoint.setPos(-2.0F, 3.5F, 0.0F);
		rightArm.addChild(rightArmJoint);
		rightArmJoint.texOffs(56, 61).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		rightForeArm = new ModelRenderer(this);
		rightForeArm.setPos(-2.5F, 3.6667F, 0.0F);
		rightArm.addChild(rightForeArm);
		rightForeArm.texOffs(12, 62).addBox(-1.5F, 4.8333F, -2.0F, 1.0F, 1.0F, 4.0F, 0.1F, false);
		rightForeArm.texOffs(48, 16).addBox(-1.5F, -0.1667F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightForeArm.texOffs(32, 67).addBox(-1.5F, -0.1667F, -2.0F, 4.0F, 6.0F, 4.0F, 0.25F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setPos(2.0F, 12.0F, 0.0F);
		body.addChild(leftLeg);
		leftLeg.texOffs(32, 6).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftLeg.texOffs(54, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.2F, false);
		leftLeg.texOffs(62, 26).addBox(-1.0F, 4.0F, -2.25F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		leftLegJoint = new ModelRenderer(this);
		leftLegJoint.setPos(0.0F, 6.0F, 0.0F);
		leftLeg.addChild(leftLegJoint);
		leftLegJoint.texOffs(32, 61).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		leftLowerLeg = new ModelRenderer(this);
		leftLowerLeg.setPos(0.0F, 6.0F, 0.0F);
		leftLeg.addChild(leftLowerLeg);
		leftLowerLeg.texOffs(22, 35).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftLowerLeg.texOffs(39, 26).addBox(-2.0F, 4.0F, -3.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		leftLowerLeg.texOffs(32, 55).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.25F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setPos(-2.0F, 12.0F, 0.0F);
		body.addChild(rightLeg);
		rightLeg.texOffs(16, 41).addBox(-1.0F, 4.0F, -2.25F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		rightLeg.texOffs(48, 6).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightLeg.texOffs(16, 55).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.2F, false);

		rightLegJoint = new ModelRenderer(this);
		rightLegJoint.setPos(0.0F, 6.0F, 0.0F);
		rightLeg.addChild(rightLegJoint);
		rightLegJoint.texOffs(0, 59).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		rightLowerLeg = new ModelRenderer(this);
		rightLowerLeg.setPos(0.0F, 6.0F, 0.0F);
		rightLeg.addChild(rightLowerLeg);
		rightLowerLeg.texOffs(0, 32).addBox(-2.0F, 4.0F, -3.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		rightLowerLeg.texOffs(56, 0).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.25F, false);
		rightLowerLeg.texOffs(32, 45).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(CMoonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}