package fr.polytechunice.knnincan.managercan;

import java.util.List;

import fr.polytechunice.knnincan.managerknn.ManagerDataStore;

public interface IPeer {
    
	void displayPeer();
	
	boolean isPointInThisPeer(Point point);
    
    /*********Methods of ManagerDataStore : ManagerKnn Package*********/
	List<Point> KnnAlgorithm(ManagerDataStore managerDataStore,int k, Point point);

    void displayKnnNeighborsList(ManagerDataStore managerDataStore,List<Point> list);
    
    
   
}
