package com.silentevermore.cmoon_rm.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.silentevermore.cmoon_rm.CMoonAddon;
import com.silentevermore.cmoon_rm.entity.CMoonEntity;
import com.silentevermore.cmoon_rm.network.PacketHandler;
import com.silentevermore.cmoon_rm.network.packets.server.CMoonRenderPacket;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class GravityChange extends StandEntityAction{
    //builder
    public GravityChange(StandEntityAction.Builder builder){
        super(builder);
    }
    //overriden methods
    @Override
    public void standPerform(World world, StandEntity stand, IStandPower power, StandEntityTask task){
        LivingEntity user=power.getUser();
        CMoonEntity cmoonEntity=(CMoonEntity) stand;
        Direction user_dir=user.getDirection();
        if (!world.isClientSide()){
            CMoonAddon.getLogger().debug(user_dir.getName());
            cmoonEntity.setGravityDirection(user_dir);
            PacketHandler.sendGlobally(new CMoonRenderPacket(cmoonEntity.getId(), user_dir), world.dimension());
        }
    }
    @Override
    protected ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target){
        return ActionConditionResult.POSITIVE;
    }
}
