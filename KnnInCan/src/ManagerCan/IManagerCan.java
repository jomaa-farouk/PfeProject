package ManagerCan;

import ManagerCan.Peer;
import ManagerCan.Point;
import ManagerCan.Zone;
import java.util.List;

public interface IManagerCan {
    Peer assignPeerToZone(Peer var1, Zone var2);

    List<Peer> devideGlobalZoneTo_N_ZonesAndPeers();

    void displayAllPeers();

    void displayAllZones();

    Zone inWhichZoneIsthePoint(Point var1);

    Peer inWhichPeerIsThePoint(Point var1);

    List<Point> getGlobalDataStorePoints(String var1);

    List<Point> getAllPointsToBeAppliedByknn(String var1);

    void addPointToDataStore(Point var1);

    List<Point> KNNAlgorithm(int var1, Point var2);

    void displayKnnNeighborsList(List<Point> var1);
}
