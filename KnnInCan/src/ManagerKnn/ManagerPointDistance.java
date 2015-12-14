
package ManagerKnn;

import ManagerCan.Point;
import ManagerKnn.IManagerPointDistance;
import java.util.Comparator;

public class ManagerPointDistance implements IManagerPointDistance, Comparator<ManagerPointDistance> {
    private Point point;
    private float distance;

    public ManagerPointDistance() {
    }

    public ManagerPointDistance(Point point, float distance) {
        this.point = point;
        this.distance = distance;
    }

    public Point getPoint() {
        return this.point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int compare(ManagerPointDistance mpd1, ManagerPointDistance mpd2) {
        return Float.compare(mpd1.getDistance(), mpd2.getDistance());
    }
}
