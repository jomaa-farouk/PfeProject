
package ManagerMain;

import ManagerCan.Point;
import ManagerKnn.ManagerDataStore;

public class ManagerKnnMain {
    public ManagerKnnMain() {
    }

    public static void main(String[] args) {
        Point A = new Point("A", 1.5F, 2.0F);
        Point B = new Point("B", 2.2F, 1.0F);
        Point C = new Point("C", 7.6F, 0.0F);
        Point D = new Point("D", 1.0F, 0.0F);
        Point E = new Point("E", 8.0F, 2.0F);
        Point F = new Point("F", 15.0F, 4.0F);
        Point G = new Point("G", 9.0F, 2.0F);
        Point H = new Point("H", 1.5F, 8.0F);
        Point I = new Point("I", 5.6F, 9.0F);
        Point J = new Point("J", 2.5F, 5.0F);
        Point K = new Point("K", 3.5F, 0.0F);
        Point L = new Point("L", 5.0F, 2.0F);
        Point M = new Point("M", 8.0F, 0.0F);
        Point N = new Point("N", 6.0F, 1.0F);
        Point O = new Point("O", 3.0F, 2.0F);
        ManagerDataStore managerDataStore = new ManagerDataStore();
        managerDataStore.addPointToDataStore(A);
        managerDataStore.addPointToDataStore(B);
        managerDataStore.addPointToDataStore(C);
        managerDataStore.addPointToDataStore(D);
        managerDataStore.addPointToDataStore(E);
        managerDataStore.addPointToDataStore(F);
        managerDataStore.addPointToDataStore(G);
        managerDataStore.addPointToDataStore(H);
        managerDataStore.addPointToDataStore(I);
        managerDataStore.addPointToDataStore(J);
        managerDataStore.addPointToDataStore(K);
        managerDataStore.addPointToDataStore(L);
        managerDataStore.addPointToDataStore(M);
        managerDataStore.addPointToDataStore(N);
        managerDataStore.addPointToDataStore(O);
        managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(2, A,managerDataStore.getDataStore()));
        managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(4, B,managerDataStore.getDataStore()));
        managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(5, C,managerDataStore.getDataStore()));
        managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(6, D,managerDataStore.getDataStore()));
        managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(7, E,managerDataStore.getDataStore()));
        managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(8, F,managerDataStore.getDataStore()));
        managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(9, G,managerDataStore.getDataStore()));
        managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(2, H,managerDataStore.getDataStore()));
        managerDataStore.displayKnnNeighborsList(managerDataStore.KnnAlgorithm(3, I,managerDataStore.getDataStore()));
    }
}
