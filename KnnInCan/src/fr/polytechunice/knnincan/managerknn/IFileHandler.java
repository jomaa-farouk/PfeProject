
package fr.polytechunice.knnincan.managerknn;

import java.util.List;

import fr.polytechunice.knnincan.managercan.Point;

public interface IFileHandler {
    List<Point> getGlobalDataStorePoints(String fileSource);

    List<Point> getAllPointsToBeAppliedByknn(String fileSource);

    void displayPointsInFile(String fileSource, List<Point> points);
    
    void writeListInFile(List<Point> list, String sourceFile,String nameFile);
    
    void writeStringInFile(String string, String sourceFile,String nameFile);
}
