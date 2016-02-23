
package fr.polytechunice.knnincan.managermain;

import fr.polytechunice.knnincan.managercan.ManagerCan;
import fr.polytechunice.knnincan.managercan.Peer;
import fr.polytechunice.knnincan.managercan.Point;
import fr.polytechunice.knnincan.managercan.ThreadPoint;
import fr.polytechunice.knnincan.managercan.Zone;
import fr.polytechunice.knnincan.managerknn.FileHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GlobalParallelMain {

	public static void main(String[] args) throws InterruptedException {
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

		//change k from here
		byte k = 64;

		Iterator<Point> iteratorS = SPoints.iterator();
		System.out.println(RPoints.size());

		Point point;
		Peer peer;

		System.out.println("Parallel Execution with K=" + k);

		while (iteratorS.hasNext()) {
			point = (Point) iteratorS.next();
			managerCan.addPointToDataStore(managerCan.managerDataStore, point);
			peer = managerCan.inWhichPeerIsThePoint(point);
			RThreadPoints.add(new ThreadPoint(k, point, peer, managerCan.managerDataStore));
		}

		Iterator<Point> iteratorR = RPoints.iterator();

		while (iteratorR.hasNext()) {
			point = (Point) iteratorR.next();
			SThreadPoints.add(
					new ThreadPoint(k, point, managerCan.inWhichPeerIsThePoint(point), managerCan.managerDataStore));
		}

		Iterator<ThreadPoint> iterator = SThreadPoints.iterator();
		ThreadPoint threadPoint;

		long startTime = System.currentTimeMillis();

		while (iterator.hasNext()) {
			threadPoint = (ThreadPoint) iterator.next();
			threadPoint.start();
			threadPoint.join();
		}

		
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;

		System.out.println("\nTotal Parallel Execution Time = " + time);

		System.out.println("\nFinished !");
	}
}
