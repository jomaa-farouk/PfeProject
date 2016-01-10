package ManagerCan;

import java.util.List;

import ManagerKnn.ManagerDataStore;

public interface IPeer {
    
	void displayPeer();
	
	boolean isPointInThisPeer(Point point);
    
    /*********Methods of ManagerDataStore : ManagerKnn Package*********/
	List<Point> KnnAlgorithm(ManagerDataStore managerDataStore,int k, Point point);

    void displayKnnNeighborsList(ManagerDataStore managerDataStore,List<Point> list);
    
    
   
}
