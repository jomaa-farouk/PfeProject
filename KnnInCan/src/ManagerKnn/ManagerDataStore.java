
package ManagerKnn;

import ManagerCan.Point;
import ManagerKnn.IManagerDataStore;
import ManagerKnn.ManagerPointDistance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ManagerDataStore implements IManagerDataStore {
    private List<Point> dataStore = new ArrayList<Point>();

    public ManagerDataStore() {
    }

    public ManagerDataStore(List<Point> dataStore) {
        this.dataStore = dataStore;
    }

    public List<Point> getDataStore() {
        return this.dataStore;
    }

    public void setDataStore(List<Point> dataStore) {
        this.dataStore = dataStore;
    }

    public void addPointToDataStore(Point point) {
        this.dataStore.add(point);
    }

    public List<Point> KnnAlgorithm(int k, Point p,List<Point> dataStore) {
        List<Point> resultList = new ArrayList<Point>();
        List<ManagerPointDistance> listDataStoreDistances = new ArrayList<ManagerPointDistance>();
        Iterator<Point> iterator = dataStore.iterator();

        while(iterator.hasNext()) {
            Point i = (Point)iterator.next();
            if(!i.getName().equals(p.getName())) {
                float dis = (float)Math.sqrt(       Math.pow((double)(i.getX() - p.getX()),2.0D)    +       Math.pow((double)(i.getY() - p.getY()), 2.0D));
                System.out.println("Distance between " + p.getName() + " and " + i.getName() + "=   " + dis);
                listDataStoreDistances.add(new ManagerPointDistance(i, dis));
            }
        }

        Collections.sort(listDataStoreDistances, new ManagerPointDistance());

        for(int i = 0; i< k; i++) {
            resultList.add(((ManagerPointDistance)listDataStoreDistances.get(i)).getPoint());
        }

        return resultList;
    }

    public void displayKnnNeighborsList(List<Point> list) {
        Iterator<Point> iterator = list.iterator();
        System.out.println("\nK_neighbors points :");

        while(iterator.hasNext()) {
            Point point = (Point)iterator.next();
            System.out.println(point.toString());
        }

        System.out.println("\n");
    }
}
