
package ManagerMain;

import ManagerCan.ManagerCan;
import ManagerCan.Peer;
import ManagerCan.Point;
import ManagerCan.Zone;
import ManagerKnn.FileHandler;

import java.util.ArrayList;
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

		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);

		String fileRSource = workingDir + "\\files\\R_Point_Collection.txt";
		String fileSSource = workingDir + "\\files\\S_Point_Collection.txt";

		List<Point> RPoints = fileHundler.getAllPointsToBeAppliedByknn(fileRSource);
		List<Point> SPoints = fileHundler.getAllPointsToBeAppliedByknn(fileSSource);
		fileHundler.displayPointsInFile(fileSSource, SPoints);
		fileHundler.displayPointsInFile(fileRSource, RPoints);
		
		
		byte k = 20;

		
		Iterator<Point> iteratorS= SPoints.iterator();

		
	
		
		while (iteratorS.hasNext()) {
			Point point = (Point) iteratorS.next();
			managerCan.addPointToDataStore(managerCan.managerDataStore,point);
		}

		Iterator<Point> iteratorR = RPoints.iterator();
		
		List<Point> resultList=new ArrayList<Point>();
		
		while (iteratorR.hasNext()) {
			Point point = (Point) iteratorR.next();
			Peer peer = managerCan.inWhichPeerIsThePoint(point);
			System.out.println("The point " + point.toString() + " is in " + peer.toString());
			resultList=peer.KnnAlgorithm(managerCan.managerDataStore,k, point);
			managerCan.writeListInFile(resultList, workingDir + "\\files", point.getName());
			peer.displayKnnNeighborsList(managerCan.managerDataStore,resultList);
		}

	}
}
