
package ManagerCan;

import ManagerCan.Point;
import ManagerCan.Zone;

public class Peer {
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
        System.out.println("Peer responsable to the zone " + this.getZone().toString());
    }

    public boolean isPointInThisPeer(Point point) {
        return this.getZone().isPointInThisZone(point);
    }

    public String toString() {
        return "Peer{ Of zone=" + this.zone + '}';
    }
}
