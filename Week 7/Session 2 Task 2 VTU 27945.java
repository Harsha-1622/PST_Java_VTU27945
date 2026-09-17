import java.util.*;

class UndergroundSystem {

    // Stores check-in information for each customer
    private Map<Integer, CheckIn> checkIns;

    // Stores total travel time and number of trips for each route
    private Map<String, double[]> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.get(id);

        String route = checkIn.station + "->" + stationName;
        double travelTime = t - checkIn.time;

        if (!routes.containsKey(route)) {
            routes.put(route, new double[]{0, 0});
        }

        routes.get(route)[0] += travelTime; // total time
        routes.get(route)[1]++;              // number of trips

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;

        double[] data = routes.get(route);

        return data[0] / data[1];
    }

    // Helper class for check-in information
    static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}

Input :
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
Output :
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
