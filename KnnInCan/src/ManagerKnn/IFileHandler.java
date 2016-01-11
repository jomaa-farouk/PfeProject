
package ManagerKnn;

import ManagerCan.Point;
import java.util.List;

public interface IFileHandler {
    List<Point> getGlobalDataStorePoints(String fileSource);

    List<Point> getAllPointsToBeAppliedByknn(String fileSource);

    void displayPointsInFile(String fileSource, List<Point> points);
    
    void writeListInFile(List<Point> list, String sourceFile,String nameFile);
    
    void writeStringInFile(String string, String sourceFile,String nameFile);
}
