
package ManagerKnn;

import ManagerCan.Point;
import java.util.List;

public interface IFileHandler {
    List<Point> getGlobalDataStorePoints(String var1);

    List<Point> getAllPointsToBeAppliedByknn(String var1);

    void displayPointsInFile(String var1, List<Point> var2);
}
