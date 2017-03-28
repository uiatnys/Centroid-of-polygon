package com.wzh;

public class Algorithm {

    public static LatLng polygonCenterOfMass(List<LatLng> pointLists) {
        if (pointLists == null || pointLists.size() <= 0) {
            return null;
        }
        double cx = 0, cy = 0;
        double factor = 0,a = PolygonArea(pointLists);
        int j;
        for (int i = 0; i < pointLists.size(); i++) {
            j = (i + 1) % pointLists.size();
            factor = Double.valueOf (pointLists.get(i).latitude * pointLists.get(j).longitude - pointLists.get(j).latitude * pointLists.get(i).longitude);
            cx += Double.valueOf ((pointLists.get(i).latitude + pointLists.get(j).latitude) * factor);
            cy += Double.valueOf ((pointLists.get(i).longitude + pointLists.get(j).longitude) * factor);
        }
        factor = 1.0 / (6.0 * a);
        cx = Double.valueOf(cx*factor);
        cy = Double.valueOf(cy*factor);
        return new LatLng(Math.abs(cx),Math.abs(cy));
    }

    public static double PolygonArea(List<LatLng> pointLists) {

        int j;
        double area = 0;

        for (int i = 0; i < pointLists.size(); i++) {
            j = (i + 1) % pointLists.size();
            area += Double.valueOf(pointLists.get(i).latitude * pointLists.get(j).longitude);
            area -= Double.valueOf(pointLists.get(i).longitude * pointLists.get(j).latitude);
        }
        area /= 2.0;
        return (Math.abs(area));
    }
}
