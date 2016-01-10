
package ManagerMain;

import ManagerCan.ManagerCan;
import ManagerCan.Peer;
import ManagerCan.Point;
import ManagerCan.ThreadPoint;
import ManagerCan.Zone;
import ManagerKnn.FileHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GlobalParallelMain {
	public GlobalParallelMain() {
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

		List<ThreadPoint> RThreadPoints = new ArrayList<ThreadPoint>();
		List<ThreadPoint> SThreadPoints = new ArrayList<ThreadPoint>();
		fileHundler.displayPointsInFile(fileSSource, SPoints);
		fileHundler.displayPointsInFile(fileRSource, RPoints);

		byte k = 20;

		Iterator<Point> iteratorS = SPoints.iterator();
		System.out.println(RPoints.size());
		
		Point point;
		Peer peer;

		while (iteratorS.hasNext()) {
			point = (Point) iteratorS.next();
			managerCan.addPointToDataStore(managerCan.managerDataStore,point);
			peer=managerCan.inWhichPeerIsThePoint(point);
			RThreadPoints.add(new ThreadPoint(k, point,peer,managerCan.managerDataStore));
		}

		Iterator<Point> iteratorR = RPoints.iterator();

		while (iteratorR.hasNext()) {
			point = (Point) iteratorR.next();
			SThreadPoints.add(new ThreadPoint(k, point, managerCan.inWhichPeerIsThePoint(point),managerCan.managerDataStore));
		}

		Iterator<ThreadPoint> iterator = SThreadPoints.iterator();
		ThreadPoint threadPoint;

		while (iterator.hasNext()) {
			threadPoint = (ThreadPoint) iterator.next();
			threadPoint.start();
		}

		try {

			while (iterator.hasNext()) {
				threadPoint = (ThreadPoint) iterator.next();
				threadPoint.join();
			}
		} catch (InterruptedException e) {
			;
		}

		System.out.println("Finished !");
	}
}
