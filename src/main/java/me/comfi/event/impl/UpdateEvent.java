package me.comfi.event.impl;

import me.comfi.event.types.Event;
import me.comfi.util.data.PosRotGroundRecord;

public class UpdateEvent extends Event {

    private final boolean pre;

    private double x, y, z;
    private float yaw, pitch;
    private boolean ground;

    protected UpdateEvent(boolean pre, double x, double y, double z, float yaw, float pitch, boolean ground) {
        this.pre = pre;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.ground = ground;
    }

    protected UpdateEvent(boolean pre, PosRotGroundRecord record) {
        this(pre, record.x(), record.y(), record.z(), record.yaw(), record.pitch(), record.ground());
    }

    public static class Pre extends UpdateEvent {
        public Pre(double x, double y, double z, float yaw, float pitch, boolean ground) {
            super(true, x, y, z, yaw, pitch, ground);
        }

        public Pre(PosRotGroundRecord record) {
            super(true, record);
        }
    }

    public static class Post extends UpdateEvent {
        public Post(double x, double y, double z, float yaw, float pitch, boolean ground) {
            super(false, x, y, z, yaw, pitch, ground);
        }

        public Post(PosRotGroundRecord record) {
            super(false, record);
        }
    }

    public final boolean isPre() {
        return pre;
    }

    public final boolean isPost() {
        return !pre;
    }

    public final double getX() {
        return x;
    }

    public final void setX(double x) {
        this.x = x;
    }

    public final double getY() {
        return y;
    }

    public final void setY(double y) {
        this.y = y;
    }

    public final double getZ() {
        return z;
    }

    public final void setZ(double z) {
        this.z = z;
    }

    public final float getYaw() {
        return yaw;
    }

    public final void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public final float getPitch() {
        return pitch;
    }

    public final void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public final boolean getGround() {
        return ground;
    }

    public final void setGround(boolean ground) {
        this.ground = ground;
    }

    public final PosRotGroundRecord getAsRecord() {
        return new PosRotGroundRecord(x, y, z, yaw, pitch, ground);
    }

}
