package ManagerCan;

import ManagerCan.Point;

public class Zone {
    private float xmin;
    private float ymin;
    private float xmax;
    private float ymax;

    public Zone() {
    }

    public Zone(float xmin, float ymin, float xmax, float ymax) {
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
    }

    public float getXmin() {
        return this.xmin;
    }

    public void setXmin(float xmin) {
        this.xmin = xmin;
    }

    public float getYmin() {
        return this.ymin;
    }

    public void setYmin(float ymin) {
        this.ymin = ymin;
    }

    public float getXmax() {
        return this.xmax;
    }

    public void setXmax(float xmax) {
        this.xmax = xmax;
    }

    public float getYmax() {
        return this.ymax;
    }

    public void setYmax(float ymax) {
        this.ymax = ymax;
    }

    public String toString() {
        return "Zone [xmin=" + this.xmin + ", ymin=" + this.ymin + ", xmax=" + this.xmax + ", ymax=" + this.ymax + "]";
    }

    public boolean isPointInThisZone(Point point) {
        return point.getY() <= this.ymax && point.getY() >= this.ymin && point.getX() <= this.xmax && point.getX() >= this.xmin;
    }
}
