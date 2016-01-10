
package ManagerMain;

import ManagerCan.ManagerCan;
import ManagerCan.Peer;
import ManagerCan.Point;
import ManagerCan.Zone;

public class ManagerCanMain {
	public ManagerCanMain() {
	}

	public static void main(String[] args) {
		Zone globalZone = new Zone(0.0F, 0.0F, 10000.0F, 10000.0F);
		
		ManagerCan managerCan = new ManagerCan(globalZone, 40);
		
		managerCan.devideGlobalZoneTo_N_ZonesAndPeers();
		
		System.out.println("All peers :");
		managerCan.displayAllPeers();
		System.out.println("All zones :");
		managerCan.displayAllZones();
		
		Point point1 = new Point(125.2F, 122.0F);
		Point point2 = new Point(5525.2F, 162.0F);
		
		
		
		Zone zone = managerCan.inWhichZoneIsthePoint(point1);
		System.out.println(point1.toString() + "is in " + zone.toString());
		
		zone = managerCan.inWhichZoneIsthePoint(point2);
		System.out.println(point2.toString() + "is in " + zone.toString());
		
		
		Peer peer = managerCan.inWhichPeerIsThePoint(point1);
		peer.displayPeer();
		peer = managerCan.inWhichPeerIsThePoint(point2);
		peer.displayPeer();
	}
}
