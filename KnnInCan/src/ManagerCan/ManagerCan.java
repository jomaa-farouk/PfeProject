
package ManagerCan;

import ManagerCan.IManagerCan;
import ManagerCan.Peer;
import ManagerCan.Point;
import ManagerCan.Zone;
import ManagerKnn.FileHandler;
import ManagerKnn.ManagerDataStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManagerCan implements IManagerCan {
    ManagerDataStore managerDataStore;
    int subZonesNumber;
    FileHandler fileHundler;
    Zone globalZone;
    List<Peer> allPeers = new ArrayList();

    public ManagerCan() {
        this.managerDataStore = new ManagerDataStore();
        this.fileHundler = new FileHandler();
    }

    public ManagerCan(Zone globalZone, int subZonesNumber) {
        this.globalZone = globalZone;
        this.subZonesNumber = subZonesNumber;
        this.managerDataStore = new ManagerDataStore();
        this.fileHundler = new FileHandler();
    }

    public List<Point> getGlobalDataStorePoints(String fileSource) {
        return this.fileHundler.getGlobalDataStorePoints(fileSource);
    }

    public List<Point> getAllPointsToBeAppliedByknn(String fileSource) {
        return this.fileHundler.getGlobalDataStorePoints(fileSource);
    }

    public Peer assignPeerToZone(Peer peer, Zone zone) {
        peer.setZone(zone);
        return peer;
    }

    public List<Peer> devideGlobalZoneTo_N_ZonesAndPeers() {
        float N = (float)this.subZonesNumber;
        float globalArea = (this.globalZone.getXmax() - this.globalZone.getXmin()) * (this.globalZone.getYmax() - this.globalZone.getYmin());
        float zoneArea = globalArea / N;
        float margin = (float)Math.sqrt((double)zoneArea);
        int counter = 0;
        float Xmax = this.globalZone.getXmax();
        float X = 0.0F;

        for(float Y = 0.0F; (float)counter < N; X = 0.0F) {
            while(X < Xmax) {
                Zone zone = new Zone(X, Y, X + margin, Y + margin);
                Peer peer = new Peer(counter, "Peer n�" + Integer.toString(counter), zone);
                this.allPeers.add(peer);
                X += margin;
                ++counter;
            }

            Y += margin;
        }

        return this.allPeers;
    }

    public void displayAllPeers() {
        Iterator var1 = this.allPeers.iterator();

        while(var1.hasNext()) {
            Peer peer = (Peer)var1.next();
            peer.displayPeer();
        }

    }

    public void displayAllZones() {
        Iterator var1 = this.allPeers.iterator();

        while(var1.hasNext()) {
            Peer peer = (Peer)var1.next();
            System.out.println(peer.getZone().toString());
        }

    }

    public Peer inWhichPeerIsThePoint(Point point) {
        boolean exist = false;
        Peer findedPeer = null;
        Iterator var4 = this.allPeers.iterator();

        while(var4.hasNext()) {
            Peer peer = (Peer)var4.next();
            if(peer.isPointInThisPeer(point)) {
                exist = true;
                findedPeer = new Peer(peer.getIdPeer(), peer.getPeerTitle(), peer.getZone());
                break;
            }
        }

        if(!exist) {
            System.out.println("There is no Peer which contain this point !");
            return null;
        } else {
            return findedPeer;
        }
    }

    public Zone inWhichZoneIsthePoint(Point point) {
        return this.inWhichPeerIsThePoint(point).getZone();
    }

    public void addPointToDataStore(Point point) {
        this.managerDataStore.addPointToDataStore(point);
    }

    public List<Point> KNNAlgorithm(int k, Point p) {
        return this.managerDataStore.KnnAlgorithm(k, p);
    }

    public void displayKnnNeighborsList(List<Point> list) {
        this.managerDataStore.displayKnnNeighborsList(list);
    }
}
