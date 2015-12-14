
package ManagerCan;

import ManagerCan.ManagerCan;
import ManagerCan.Point;

public class ThreadPoint extends Thread {
    private int k;
    private Point point;
    ManagerCan managerCan;

    public ThreadPoint() {
    }

    public ThreadPoint(int k, Point point, ManagerCan managerCan) {
        this.k = k;
        this.point = point;
        this.managerCan = managerCan;
    }

    public int getK() {
        return this.k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Point getPoint() {
        return this.point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void run() {
        System.out.println(this.managerCan);
        this.managerCan.displayKnnNeighborsList(this.managerCan.KNNAlgorithm(this.k, this.point));
    }
}
