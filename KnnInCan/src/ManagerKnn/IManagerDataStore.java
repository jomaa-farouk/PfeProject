
package ManagerKnn;

import ManagerCan.Point;
import java.util.List;

public interface IManagerDataStore {
    void addPointToDataStore(Point point);

    List<Point> KnnAlgorithm(int k, Point point,List<Point> dataStore);

    void displayKnnNeighborsList(List<Point> points);
}
