
package ManagerCan;

import java.util.List;

import ManagerCan.Point;
import ManagerCan.Zone;
import ManagerKnn.ManagerDataStore;

public class Peer implements IPeer {
	private int idPeer;
	private String peerTitle;
	private Zone zone;

	public Peer() {
	}

	public Peer(int idPeer, String peerTitle, Zone zone) {
		this.idPeer = idPeer;
		this.peerTitle = peerTitle;
		this.zone = zone;
	}

	public Peer(Zone zone) {
		this.zone = zone;
	}

	public int getIdPeer() {
		return this.idPeer;
	}

	public void setIdPeer(int idPeer) {
		this.idPeer = idPeer;
	}

	public String getPeerTitle() {
		return this.peerTitle;
	}

	public void setPeerTitle(String peerTitle) {
		this.peerTitle = peerTitle;
	}

	public Zone getZone() {
		return this.zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public void displayPeer() {
		System.out.println("Peer responsable to the " + this.getZone().toString());
	}

	public boolean isPointInThisPeer(Point point) {
		return this.getZone().isPointInThisZone(point);
	}

	@Override
	public String toString() {
		return "Peer [idPeer=" + idPeer + ", peerTitle=" + peerTitle + ", zone=" + zone + "]";
	}

	@Override
	public void displayKnnNeighborsList(ManagerDataStore managerDataStore, List<Point> list) {
		managerDataStore.displayKnnNeighborsList(list);
	}

	@Override
	public List<Point> KnnAlgorithm(ManagerDataStore managerDataStore, int k, Point point)
			throws NullPointerException {
		return managerDataStore.KnnAlgorithm(k, point,managerDataStore.getDataStore());
	}

}
