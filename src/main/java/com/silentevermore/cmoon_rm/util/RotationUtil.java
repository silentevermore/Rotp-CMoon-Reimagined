package com.silentevermore.cmoon_rm.util;

import net.minecraft.util.Direction;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;

public abstract class RotationUtil {
    private static final Direction[][] DIR_WORLD_TO_PLAYER = new Direction[6][];
    static {
        for(Direction gravityDirection : Direction.values()) {
            DIR_WORLD_TO_PLAYER[gravityDirection.ordinal()] = new Direction[6];
            for(Direction direction : Direction.values()) {
                Vector3d directionVector = Vector3d.atCenterOf(direction.getNormal());
                directionVector = RotationUtil.vecWorldToPlayer(directionVector, gravityDirection);
                DIR_WORLD_TO_PLAYER[gravityDirection.ordinal()][direction.ordinal()] = Direction.fromNormal((int)directionVector.x(), (int)directionVector.y(), (int)directionVector.z());
            }
        }
    }

    public static Direction dirWorldToPlayer(Direction direction, Direction gravityDirection) {
        return DIR_WORLD_TO_PLAYER[gravityDirection.ordinal()][direction.ordinal()];
    }

    private static final Direction[][] DIR_PLAYER_TO_WORLD = new Direction[6][];
    static {
        for(Direction gravityDirection : Direction.values()) {
            DIR_PLAYER_TO_WORLD[gravityDirection.ordinal()] = new Direction[6];
            for(Direction direction : Direction.values()){
                Vector3d directionVector = Vector3d.atCenterOf(direction.getNormal());
                directionVector = RotationUtil.vecPlayerToWorld(directionVector, gravityDirection);
                DIR_PLAYER_TO_WORLD[gravityDirection.ordinal()][direction.ordinal()] = Direction.fromNormal((int)directionVector.x(), (int)directionVector.y(), (int)directionVector.z());
            }
        }
    }

    public static Direction dirPlayerToWorld(Direction direction, Direction gravityDirection) {
        return DIR_PLAYER_TO_WORLD[gravityDirection.ordinal()][direction.ordinal()];
    }

    public static Vector3d vecWorldToPlayer(double x, double y, double z, Direction gravityDirection){
        Vector3d vec=Vector3d.ZERO;
        switch(gravityDirection){
            case DOWN:
                vec=new Vector3d( x,  y,  z);
            case UP:
                vec=new Vector3d(-x, -y,  z);
            case NORTH:
                vec=new Vector3d( x,  z, -y);
            case SOUTH:
                vec=new Vector3d(-x, -z, -y);
            case WEST:
                vec=new Vector3d(-z,  x, -y);
            case EAST:
                vec=new Vector3d( z, -x, -y);
        };
        return vec;
    }

    public static Vector3d vecWorldToPlayer(Vector3d vec3d, Direction gravityDirection) {
        return vecWorldToPlayer(vec3d.x, vec3d.y, vec3d.z, gravityDirection);
    }

    public static Vector3d vecPlayerToWorld(double x, double y, double z, Direction gravityDirection) {
        Vector3d vec=Vector3d.ZERO;
        switch(gravityDirection) {
            case DOWN:
                vec=new Vector3d( x,  y,  z);
            case UP:
                vec=new Vector3d(-x, -y,  z);
            case NORTH:
                vec=new Vector3d( x, -z,  y);
            case SOUTH:
                vec=new Vector3d(-x, -z, -y);
            case WEST:
                vec=new Vector3d( y, -z, -x);
            case EAST:
                vec=new Vector3d(-y, -z,  x);
        };
        return vec;
    }

    public static Vector3d vecPlayerToWorld(Vector3d vec3d, Direction gravityDirection) {
        return vecPlayerToWorld(vec3d.x, vec3d.y, vec3d.z, gravityDirection);
    }

    public static Vector3f vecWorldToPlayer(float x, float y, float z, Direction gravityDirection){
        Vector3f vec=Vector3f.YP;
        switch(gravityDirection){
            case DOWN:
                vec=new Vector3f( x,  y,  z);
            case UP:
                vec=new Vector3f(-x, -y,  z);
            case NORTH:
                vec=new Vector3f( x,  z, -y);
            case SOUTH:
                vec=new Vector3f(-x, -z, -y);
            case WEST:
                vec=new Vector3f(-z,  x, -y);
            case EAST:
                vec=new Vector3f( z, -x, -y);
        };
        return vec;
    }

    public static Vector3f vecWorldToPlayer(Vector3f vec3f, Direction gravityDirection) {
        return vecWorldToPlayer(vec3f.x(), vec3f.y(), vec3f.z(), gravityDirection);
    }

    public static Vector3f vecPlayerToWorld(float x, float y, float z, Direction gravityDirection) {
        Vector3f vec=Vector3f.YP;
        switch(gravityDirection){
            case DOWN:
                vec=new Vector3f( x,  y,  z);
            case UP:
                vec=new Vector3f(-x, -y,  z);
            case NORTH:
                vec=new Vector3f( x, -z,  y);
            case SOUTH:
                vec=new Vector3f(-x, -z, -y);
            case WEST:
                vec=new Vector3f( y, -z, -x);
            case EAST:
                vec=new Vector3f(-y, -z,  x);
        };
        return vec;
    }

    public static Vector3f vecPlayerToWorld(Vector3f vec3f, Direction gravityDirection) {
        return vecPlayerToWorld(vec3f.x(), vec3f.y(), vec3f.z(), gravityDirection);
    }

    public static Vector3d maskWorldToPlayer(double x, double y, double z, Direction gravityDirection){
        Vector3d vec=Vector3d.ZERO;
        switch(gravityDirection){
            case UP:
                vec=new Vector3d(x, y, z);
            case DOWN:
                vec=new Vector3d(x, y, z);
            case NORTH:
                vec=new Vector3d(x, z, y);
            case SOUTH:
                vec=new Vector3d(x, z, y);
            case WEST:
                vec=new Vector3d(z, x, y);
            case EAST:
                vec=new Vector3d(z, x, y);
        };
        return vec;
    }

    public static Vector3d maskWorldToPlayer(Vector3d vec3d, Direction gravityDirection) {
        return maskWorldToPlayer(vec3d.x, vec3d.y, vec3d.z, gravityDirection);
    }

    public static Vector3d maskPlayerToWorld(double x, double y, double z, Direction gravityDirection){
        Vector3d vec=Vector3d.ZERO;
        switch(gravityDirection){
            case UP:
                vec=new Vector3d(x, y, z);
            case DOWN:
                vec=new Vector3d(x, y, z);
            case NORTH:
                vec=new Vector3d(x, z, y);
            case SOUTH:
                vec=new Vector3d(x, z, y);
            case WEST:
                vec=new Vector3d(y, z, x);
            case EAST:
                vec=new Vector3d(y, z, x);
        };
        return vec;
    }

    public static Vector3d maskPlayerToWorld(Vector3d vec3d, Direction gravityDirection) {
        return maskPlayerToWorld(vec3d.x, vec3d.y, vec3d.z, gravityDirection);
    }

    public static AxisAlignedBB boxWorldToPlayer(AxisAlignedBB box, Direction gravityDirection){
        return new AxisAlignedBB(
                RotationUtil.vecWorldToPlayer(box.minX, box.minY, box.minZ, gravityDirection),
                RotationUtil.vecWorldToPlayer(box.maxX, box.maxY, box.maxZ, gravityDirection)
        );
    }

    public static AxisAlignedBB boxPlayerToWorld(AxisAlignedBB box, Direction gravityDirection) {
        return new AxisAlignedBB(
                RotationUtil.vecPlayerToWorld(box.minX, box.minY, box.minZ, gravityDirection),
                RotationUtil.vecPlayerToWorld(box.maxX, box.maxY, box.maxZ, gravityDirection)
        );
    }

    public static Vector2f rotWorldToPlayer(float yaw, float pitch, Direction gravityDirection) {
        Vector3d vec3d = RotationUtil.vecWorldToPlayer(rotToVec(yaw, pitch), gravityDirection);
        return vecToRot(vec3d.x, vec3d.y, vec3d.z);
    }

    public static Vector2f rotWorldToPlayer(Vector2f vec2f, Direction gravityDirection) {
        return rotWorldToPlayer(vec2f.x, vec2f.y, gravityDirection);
    }

    public static Vector2f rotPlayerToWorld(float yaw, float pitch, Direction gravityDirection) {
        Vector3d vec3d = RotationUtil.vecPlayerToWorld(rotToVec(yaw, pitch), gravityDirection);
        return vecToRot(vec3d.x, vec3d.y, vec3d.z);
    }

    public static Vector2f rotPlayerToWorld(Vector2f vec2f, Direction gravityDirection) {
        return rotPlayerToWorld(vec2f.x, vec2f.y, gravityDirection);
    }

    private static Vector3d rotToVec(float yaw, float pitch) {
        double radPitch = pitch * 0.017453292;
        double radNegYaw = -yaw * 0.017453292;
        double cosNegYaw = Math.cos(radNegYaw);
        double sinNegYaw = Math.sin(radNegYaw);
        double cosPitch = Math.cos(radPitch);
        double sinPitch = Math.sin(radPitch);
        return new Vector3d(sinNegYaw * cosPitch, -sinPitch, cosNegYaw * cosPitch);
    }

    private static Vector2f vecToRot(double x, double y, double z) {
        double sinPitch = -y;
        double radPitch = Math.asin(sinPitch);
        double cosPitch = Math.cos(radPitch);
        double sinNegYaw = x / cosPitch;
        double cosNegYaw = MathHelper.clamp(z / cosPitch, -1, 1);
        double radNegYaw = Math.acos(cosNegYaw);
        if(sinNegYaw < 0) radNegYaw = Math.PI * 2 - radNegYaw;

        return new Vector2f(MathHelper.wrapDegrees((float)(-radNegYaw) / 0.017453292F), (float)(radPitch) / 0.017453292F);
    }

    private static final Quaternion[] WORLD_ROTATION_QUATERNIONS = new Quaternion[6];
    static {
        WORLD_ROTATION_QUATERNIONS[0] = Quaternion.ONE.copy();

        WORLD_ROTATION_QUATERNIONS[1] = Vector3f.ZP.rotationDegrees(-180);

        WORLD_ROTATION_QUATERNIONS[2] = Vector3f.XP.rotationDegrees(-90);

        WORLD_ROTATION_QUATERNIONS[3] = Vector3f.XP.rotationDegrees(-90);
        WORLD_ROTATION_QUATERNIONS[3].mul(Vector3f.YP.rotationDegrees(-180));

        WORLD_ROTATION_QUATERNIONS[4] = Vector3f.XP.rotationDegrees(-90);
        WORLD_ROTATION_QUATERNIONS[4].mul(Vector3f.YP.rotationDegrees(-90));

        WORLD_ROTATION_QUATERNIONS[5] = Vector3f.XP.rotationDegrees(-90);
        WORLD_ROTATION_QUATERNIONS[5].mul(Vector3f.YP.rotationDegrees(-270));
    }

    public static Quaternion getWorldRotationQuaternion(Direction gravityDirection) {
        return WORLD_ROTATION_QUATERNIONS[gravityDirection.ordinal()];
    }

    private static final Quaternion[] ENTITY_ROTATION_QUATERNIONS = new Quaternion[6];
    static {
        ENTITY_ROTATION_QUATERNIONS[0] = Quaternion.ONE;

        ENTITY_ROTATION_QUATERNIONS[1] = Vector3f.ZP.rotationDegrees(-180);

        ENTITY_ROTATION_QUATERNIONS[2] = Vector3f.XP.rotationDegrees(90);

        ENTITY_ROTATION_QUATERNIONS[3] = Vector3f.XP.rotationDegrees(-90);
        ENTITY_ROTATION_QUATERNIONS[3].mul(Vector3f.XP.rotationDegrees(-180));

        ENTITY_ROTATION_QUATERNIONS[4] = Vector3f.YP.rotationDegrees(90);
        ENTITY_ROTATION_QUATERNIONS[4].mul(Vector3f.XP.rotationDegrees(90));

        ENTITY_ROTATION_QUATERNIONS[5] = Vector3f.XP.rotationDegrees(90);
        ENTITY_ROTATION_QUATERNIONS[5].mul(Vector3f.ZP.rotationDegrees(90));
    }

    public static Quaternion getCameraRotationQuaternion(Direction gravityDirection) {
        return ENTITY_ROTATION_QUATERNIONS[gravityDirection.ordinal()];
    }
}