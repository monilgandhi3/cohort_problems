class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<FlightInfo>> map = new HashMap<>();
        
        for (int[] flight : flights) {
            int sourceFlight = flight[0];
            int destinationFlight = flight[1];
            int cost = flight[2];
            if (!map.containsKey(sourceFlight)) {
                map.put(sourceFlight, new ArrayList<>());
            }
            map.get(sourceFlight).add(new FlightInfo(destinationFlight, cost, 0));
        }
        Map<Integer, FlightInfo> cost = new HashMap<>();
        
        PriorityQueue<FlightInfo> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        queue.add(new FlightInfo(src, 0, 0));
        
        while(!queue.isEmpty()) {
            FlightInfo flightInfo = queue.poll();
            int price = flightInfo.cost;
            int currentStops = flightInfo.stops;
            if (currentStops <= k + 1 && flightInfo.flightNumber == dst) {
                return flightInfo.cost;
            }
            if (cost.containsKey(flightInfo.flightNumber)) {
                if (flightInfo.stops >= cost.get(flightInfo.flightNumber).stops) {
                    continue;
                }
            }
            
            cost.put(flightInfo.flightNumber, flightInfo);
            List<FlightInfo> children = map.get(flightInfo.flightNumber);
            if (children == null) continue;
            for (FlightInfo child : children) {
                FlightInfo next = new FlightInfo(child.flightNumber, child.cost + price, currentStops + 1);
                queue.add(next);
            }
            
        }
        return -1;
       
        
    }
}

class FlightInfo {
    int flightNumber;
    int cost;
    int stops;
    
    public FlightInfo(int flightNumber, int cost, int stops) {
        this.flightNumber = flightNumber;
        this.cost = cost;
        this.stops = stops;
    } 
}