
package ManagerKnn;

import ManagerCan.Point;
import ManagerKnn.IManagerDataStore;
import ManagerKnn.ManagerPointDistance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ManagerDataStore implements IManagerDataStore {
    private List<Point> dataStore = new ArrayList();

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

    public List<Point> KnnAlgorithm(int k, Point p) {
        ArrayList resultList = new ArrayList();
        ArrayList listDataStoreDistances = new ArrayList();
        Iterator iterator = this.dataStore.iterator();

        while(iterator.hasNext()) {
            Point i = (Point)iterator.next();
            if(!i.getName().equals(p.getName())) {
                float add = (float)Math.sqrt(Math.pow((double)(i.getX() - p.getX() + (i.getY() - p.getY())), 2.0D));
                System.out.println("Distance between " + p.getName() + " and " + i.getName() + "=   " + add);
                listDataStoreDistances.add(new ManagerPointDistance(i, add));
            }
        }

        Collections.sort(listDataStoreDistances, new ManagerPointDistance());

        for(int var8 = 0; var8 < k; ++var8) {
            resultList.add(((ManagerPointDistance)listDataStoreDistances.get(var8)).getPoint());
        }

        return resultList;
    }

    public void displayKnnNeighborsList(List<Point> list) {
        Iterator iterator = list.iterator();
        System.out.println("\nK_neighbors points :");

        while(iterator.hasNext()) {
            Point point = (Point)iterator.next();
            System.out.println(point.toString());
        }

        System.out.println("\n");
    }
}
