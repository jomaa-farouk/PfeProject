
package ManagerKnn;

import ManagerCan.Point;
import java.util.List;

public interface IManagerDataStore {
    void addPointToDataStore(Point var1);

    List<Point> KnnAlgorithm(int var1, Point var2);

    void displayKnnNeighborsList(List<Point> var1);
}
