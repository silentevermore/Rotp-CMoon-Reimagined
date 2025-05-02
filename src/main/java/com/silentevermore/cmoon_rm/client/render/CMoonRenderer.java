package com.silentevermore.cmoon_rm.client.render;

import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandModelRegistry;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;
import com.silentevermore.cmoon_rm.CMoonAddon;

import com.silentevermore.cmoon_rm.entity.CMoonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class CMoonRenderer extends StandEntityRenderer<CMoonEntity, StandEntityModel<CMoonEntity>> {
    //builder
    public CMoonRenderer(EntityRendererManager renderManager){
        super(renderManager,
                StandModelRegistry.registerModel(new ResourceLocation(CMoonAddon.MOD_ID, "cmoon"), CMoonModel::new),
                new ResourceLocation(CMoonAddon.MOD_ID, "textures/entity/stand/cmoon.png"), 0);
    }
}
