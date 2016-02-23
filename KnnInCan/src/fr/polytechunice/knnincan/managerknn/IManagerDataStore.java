
package fr.polytechunice.knnincan.managerknn;

import java.util.List;

import fr.polytechunice.knnincan.managercan.Point;

public interface IManagerDataStore {
    void addPointToDataStore(Point point);

    List<Point> KnnAlgorithm(int k, Point point,List<Point> dataStore);

    void displayKnnNeighborsList(List<Point> points);
}
