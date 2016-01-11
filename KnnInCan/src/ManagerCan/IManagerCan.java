package ManagerCan;

import ManagerCan.Peer;
import ManagerCan.Point;
import ManagerCan.Zone;
import ManagerKnn.ManagerDataStore;

import java.util.List;

public interface IManagerCan {
	Peer assignPeerToZone(Peer var1, Zone var2);

	List<Peer> devideGlobalZoneTo_N_ZonesAndPeers();

	void displayAllPeers();

	void displayAllZones();

	Zone inWhichZoneIsthePoint(Point point);

	Peer inWhichPeerIsThePoint(Point point);

	/********* Methods of FileHandler : ManagerKnn Package *********/
	List<Point> getGlobalDataStorePoints(String fileSource);

	List<Point> getAllPointsToBeAppliedByknn(String fileSource);

	void writeListInFile(List<Point> list, String sourceFile, String nameFile);

	void writeStringInFile(String string, String sourceFile, String nameFile);

	/**********
	 * Methods of ManagerDataStore : ManagerKnn Package
	 ***************/
	void addPointToDataStore(ManagerDataStore managerDataStore, Point point);

}
