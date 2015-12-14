
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
        String fileRSource = "C:\\Files\\R_Point_Collection.txt";
        String fileSSource = "C:\\Files\\S_Point_Collection.txt";
        List RPoints = fileHundler.getAllPointsToBeAppliedByknn(fileRSource);
        List SPoints = fileHundler.getAllPointsToBeAppliedByknn(fileSSource);
        fileHundler.displayPointsInFile(fileSSource, SPoints);
        fileHundler.displayPointsInFile(fileRSource, RPoints);
        byte k = 20;
        ManagerDataStore managerDataStore = new ManagerDataStore();
        Iterator var8 = RPoints.iterator();

        Point point;
        while(var8.hasNext()) {
            point = (Point)var8.next();
            managerDataStore.addPointToDataStore(point);
        }

        var8 = SPoints.iterator();

        while(var8.hasNext()) {
            point = (Point)var8.next();
            managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(k, point));
        }

    }
}
