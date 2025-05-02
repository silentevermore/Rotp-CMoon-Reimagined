package com.silentevermore.cmoon_rm.entity;

import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityType;

import net.minecraft.util.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class CMoonEntity extends StandEntity{
    //constants
    private static Direction gravityDirection=Direction.DOWN;
    //builder
    public CMoonEntity(StandEntityType<CMoonEntity> type, World world) {
        super(type, world);
    }
    //methods
    public Direction getGravityDirection(){
        return gravityDirection;
    }
    public void setGravityDirection(Direction dir){
        gravityDirection=dir;
    }
}
