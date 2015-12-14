
package ManagerMain;

import ManagerCan.ManagerCan;
import ManagerCan.Peer;
import ManagerCan.Point;
import ManagerCan.Zone;
import ManagerKnn.FileHandler;
import java.util.Iterator;
import java.util.List;

public class GlobalMain {
	public GlobalMain() {
	}

	public static void main(String[] args) {
		FileHandler fileHundler = new FileHandler();
		Zone globalZone = new Zone(0.0F, 0.0F, 10000.0F, 10000.0F);
		ManagerCan managerCan = new ManagerCan(globalZone, 40);
		managerCan.devideGlobalZoneTo_N_ZonesAndPeers();
		System.out.println("All peers :");
		managerCan.displayAllPeers();
		System.out.println("All zones :");
		managerCan.displayAllZones();
		String fileRSource = "C:\\Files\\R_Point_Collection.txt";
		String fileSSource = "C:\\Files\\S_Point_Collection.txt";
		List RPoints = fileHundler.getAllPointsToBeAppliedByknn(fileRSource);
		List SPoints = fileHundler.getAllPointsToBeAppliedByknn(fileSSource);
		fileHundler.displayPointsInFile(fileSSource, SPoints);
		fileHundler.displayPointsInFile(fileRSource, RPoints);
		byte k = 20;
		Iterator var9 = RPoints.iterator();

		Point point;
		while (var9.hasNext()) {
			point = (Point) var9.next();
			managerCan.addPointToDataStore(point);
		}

		var9 = SPoints.iterator();

		while (var9.hasNext()) {
			point = (Point) var9.next();
			Peer peer = managerCan.inWhichPeerIsThePoint(point);
			System.out.println("The point " + point.toString() + " is in " + peer.toString());
			managerCan.displayKnnNeighborsList(managerCan.KNNAlgorithm(k, point));
		}

	}
}
