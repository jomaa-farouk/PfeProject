
package ManagerMain;

import ManagerCan.ManagerCan;
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
        String fileRSource = "C:\\Files\\R_Point_Collection.txt";
        String fileSSource = "C:\\Files\\S_Point_Collection.txt";
        List RPoints = fileHundler.getAllPointsToBeAppliedByknn(fileRSource);
        List SPoints = fileHundler.getAllPointsToBeAppliedByknn(fileSSource);
        ArrayList RThreadPoints = new ArrayList();
        ArrayList SThreadPoints = new ArrayList();
        fileHundler.displayPointsInFile(fileSSource, SPoints);
        fileHundler.displayPointsInFile(fileRSource, RPoints);
        byte k = 20;
        Iterator e = RPoints.iterator();

        Point threadPoint;
        while(e.hasNext()) {
            threadPoint = (Point)e.next();
            managerCan.addPointToDataStore(threadPoint);
            RThreadPoints.add(new ThreadPoint(k, threadPoint, managerCan));
        }

        e = SPoints.iterator();

        while(e.hasNext()) {
            threadPoint = (Point)e.next();
            SThreadPoints.add(new ThreadPoint(k, threadPoint, managerCan));
        }

        e = SThreadPoints.iterator();

        ThreadPoint threadPoint1;
        while(e.hasNext()) {
            threadPoint1 = (ThreadPoint)e.next();
            threadPoint1.start();
        }

        try {
            e = SThreadPoints.iterator();

            while(e.hasNext()) {
                threadPoint1 = (ThreadPoint)e.next();
                threadPoint1.join();
            }
        } catch (InterruptedException var13) {
            ;
        }

        System.out.println("Exécution terminée");
    }
}
