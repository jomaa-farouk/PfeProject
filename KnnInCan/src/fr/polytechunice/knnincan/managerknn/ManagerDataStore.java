
package fr.polytechunice.knnincan.managerknn;

import fr.polytechunice.knnincan.managercan.Point;
import fr.polytechunice.knnincan.managerknn.IManagerDataStore;
import fr.polytechunice.knnincan.managerknn.ManagerPointDistance;

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
                
            	// si vous travaillez dans un repère cartésien décommenter la ligne suivante et commenter la ligne après 
            	
                //float dis = (float)Math.sqrt(Math.pow((double)(i.getX() - p.getX()),2.0D) +  Math.pow((double)(i.getY() - p.getY()), 2.0D));
                float dis = distFrom (i.getX(), i.getY(), p.getX(), p.getY());
            	
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
    
    public static float distFrom(float lat1, float lng1, float lat2, float lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
        }

}
