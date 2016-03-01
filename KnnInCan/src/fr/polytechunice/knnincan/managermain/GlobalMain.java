
package fr.polytechunice.knnincan.managermain;

import fr.polytechunice.knnincan.managercan.ManagerCan;
import fr.polytechunice.knnincan.managercan.Peer;
import fr.polytechunice.knnincan.managercan.Point;
import fr.polytechunice.knnincan.managercan.Zone;
import fr.polytechunice.knnincan.managerknn.FileHandler;

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
		
		//change k from here
		int k = 10;

		
		Iterator<Point> iteratorS= SPoints.iterator();

		
	
		
		while (iteratorS.hasNext()) {
			Point point = (Point) iteratorS.next();
			managerCan.addPointToDataStore(managerCan.managerDataStore,point);
		}

		Iterator<Point> iteratorR = RPoints.iterator();
		
		List<Point> resultList=new ArrayList<Point>();
		
		long startGlobal=System.currentTimeMillis();
		
		while (iteratorR.hasNext()) {
		
			Point point = (Point) iteratorR.next();
			
			Peer peer = managerCan.inWhichPeerIsThePoint(point);
			
			System.out.println("The point " + point.toString() + " is in " + peer.toString());
			long startTime = System.currentTimeMillis();
			resultList=peer.KnnAlgorithm(managerCan.managerDataStore,k, point);
			long endTime = System.currentTimeMillis();
			long time=endTime-startTime;
			managerCan.writeStringInFile("*********************************************************************************", workingDir + "\\files",point.getName());
			managerCan.writeStringInFile("\nSequential execution with K=20", workingDir + "\\files",point.getName());
			managerCan.writeStringInFile("\n", workingDir + "\\files",point.getName());
			managerCan.writeListInFile(resultList, workingDir + "\\files", point.getName());
			managerCan.writeStringInFile("\nExecution Time = "+Long.valueOf(time)+" Millis\n", workingDir + "\\files",point.getName());
			peer.displayKnnNeighborsList(managerCan.managerDataStore,resultList);
		
		}
		
		long endGlobal=System.currentTimeMillis();
		
		System.out.println("\nTotal Sequantial Execution Time = "+(endGlobal-startGlobal));
		
		System.out.println("Finished");

	}
}
