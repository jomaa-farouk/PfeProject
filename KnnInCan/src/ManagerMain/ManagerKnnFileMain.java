
package ManagerMain;

import ManagerCan.Point;
import ManagerKnn.FileHandler;
import ManagerKnn.ManagerDataStore;
import java.util.Iterator;
import java.util.List;

public class ManagerKnnFileMain {
    public ManagerKnnFileMain() {
    }

    public static void main(String[] args) {
        FileHandler fileHundler = new FileHandler();
        String workingDir = System.getProperty("user.dir");
 	    System.out.println("Current working directory : " + workingDir);
 	    
 	    
        String fileRSource = workingDir+"\\files\\R_Point_Collection.txt";
        String fileSSource = workingDir+"\\files\\S_Point_Collection.txt";
        
        
        List<Point> RPoints = fileHundler.getAllPointsToBeAppliedByknn(fileRSource);
        List<Point> SPoints = fileHundler.getAllPointsToBeAppliedByknn(fileSSource);
        fileHundler.displayPointsInFile(fileSSource, SPoints);
        fileHundler.displayPointsInFile(fileRSource, RPoints);
        
        byte k = 20;
        
        ManagerDataStore managerDataStore = new ManagerDataStore();
        Iterator<Point> iterator= SPoints.iterator();

        Point point;
        while(iterator.hasNext()) {
            point = (Point)iterator.next();
            managerDataStore.addPointToDataStore(point);
        }

        iterator = RPoints.iterator();

        while(iterator.hasNext()) {
            point = (Point)iterator.next();
            managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(k, point,managerDataStore.getDataStore()));
        }

    }
}
