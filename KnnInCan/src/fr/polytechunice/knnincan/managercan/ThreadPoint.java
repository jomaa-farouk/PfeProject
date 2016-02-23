
package fr.polytechunice.knnincan.managercan;


import fr.polytechunice.knnincan.managercan.Point;
import fr.polytechunice.knnincan.managerknn.ManagerDataStore;

public class ThreadPoint extends Thread {
	private int k;
	private Point point;
	Peer peer;
    ManagerDataStore managerDataStore;
    
	public ThreadPoint() {
	}

	public ThreadPoint(int k, Point point, Peer peer,ManagerDataStore managerDataStore) {
		this.k = k;
		this.point = point;
		this.peer = peer;
		this.managerDataStore=managerDataStore;
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
		this.peer.displayKnnNeighborsList(this.managerDataStore,this.peer.KnnAlgorithm(this.managerDataStore,this.k, this.point));
	}
}
