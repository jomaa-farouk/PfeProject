
package ManagerKnn;

import ManagerCan.Point;
import ManagerKnn.IFileHandler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileHandler implements IFileHandler {
    public FileHandler() {
    }

    public List<Point> getGlobalDataStorePoints(String fileSource) {
        ArrayList points = new ArrayList();
        String openParenthes = "(";
        String closeParenthes = ")";
        String comma = ",";

        try {
            BufferedReader e = new BufferedReader(new FileReader(fileSource));
            Throwable var13 = null;

            try {
                String sCurrentLine;
                try {
                    while((sCurrentLine = e.readLine()) != null) {
                        int positionOpenParenthes = sCurrentLine.indexOf(openParenthes);
                        int positionCloseParenthes = sCurrentLine.indexOf(closeParenthes);
                        int positionComma = sCurrentLine.indexOf(comma);
                        String pointName = sCurrentLine.substring(0, positionOpenParenthes);
                        float pointX = Float.parseFloat(sCurrentLine.substring(positionOpenParenthes + 1, positionComma));
                        float pointY = Float.parseFloat(sCurrentLine.substring(positionComma + 1, positionCloseParenthes));
                        Point point = new Point(pointName, pointX, pointY);
                        points.add(point);
                    }
                } catch (Throwable var24) {
                    var13 = var24;
                    throw var24;
                }
            } finally {
                if(e != null) {
                    if(var13 != null) {
                        try {
                            e.close();
                        } catch (Throwable var23) {
                            var13.addSuppressed(var23);
                        }
                    } else {
                        e.close();
                    }
                }

            }
        } catch (IOException var26) {
            ;
        }

        return points;
    }

    public List<Point> getAllPointsToBeAppliedByknn(String fileSource) {
        return this.getGlobalDataStorePoints(fileSource);
    }

    public void displayPointsInFile(String sourceFile, List<Point> list) {
        Iterator iterator = list.iterator();
        System.out.println("All points in " + sourceFile + ": ");

        while(iterator.hasNext()) {
            Point point = (Point)iterator.next();
            System.out.println(point.toString());
        }

        System.out.println("\n");
    }
}
