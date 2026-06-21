import java.util.*;

class Solution {
    class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int[] solution(int[][] city, int[][] road) {
        Set<Point> poiSet = new HashSet<>();
        List<int[]> hRoads = new ArrayList<>();
        List<int[]> vRoads = new ArrayList<>();
        
        for (int[] r : road) {
            // 도로의 양 끝점을 무조건 Set에 추가 (끊어진 일직선 도로 연결용)
            poiSet.add(new Point(r[0], r[1]));
            poiSet.add(new Point(r[2], r[3]));
            
            if (r[1] == r[3]) hRoads.add(r);
            else vRoads.add(r);
            
            // 도로 정중앙의 카메라 좌표 추가
            int camX = (r[0] + r[2]) / 2;
            int camY = (r[1] + r[3]) / 2;
            poiSet.add(new Point(camX, camY));
        }
        
        for (int[] c : city) {
            poiSet.add(new Point(c[0], c[1]));
        }
        
        for (int[] h : hRoads) {
            for (int[] v : vRoads) {
                if (v[0] >= h[0] && v[0] <= h[2] && h[1] >= v[1] && h[1] <= v[3]) {
                    poiSet.add(new Point(v[0], h[1]));
                }
            }
        }
        
        List<Point> pointList = new ArrayList<>(poiSet);
        Map<Point, Integer> pointToId = new HashMap<>();
        int nNodes = pointList.size();
        
        int[] nodeLimits = new int[nNodes];
        Arrays.fill(nodeLimits, Integer.MAX_VALUE);
        
        for (int i = 0; i < nNodes; i++) {
            pointToId.put(pointList.get(i), i);
        }
        
        for (int[] r : road) {
            int camX = (r[0] + r[2]) / 2;
            int camY = (r[1] + r[3]) / 2;
            int limit = r[4];
            int camId = pointToId.get(new Point(camX, camY));
            nodeLimits[camId] = Math.min(nodeLimits[camId], limit);
        }
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nNodes; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            List<Point> pointsOnRoad = new ArrayList<>();
            boolean isHorizontal = (r[1] == r[3]);
            
            for (Point p : pointList) {
                if (isHorizontal) {
                    // 수평 도로인 경우
                    int minX = Math.min(r[0], r[2]);
                    int maxX = Math.max(r[0], r[2]);
                    if (p.y == r[1] && p.x >= minX && p.x <= maxX) pointsOnRoad.add(p);
                } else {
                    // 수직 도로인 경우
                    int minY = Math.min(r[1], r[3]);
                    int maxY = Math.max(r[1], r[3]);
                    if (p.x == r[0] && p.y >= minY && p.y <= maxY) pointsOnRoad.add(p);
                }
            }
            
            if (isHorizontal) {
                pointsOnRoad.sort((a, b) -> Integer.compare(a.x, b.x));
            } else {
                pointsOnRoad.sort((a, b) -> Integer.compare(a.y, b.y));
            }
            
            for (int i = 0; i < pointsOnRoad.size() - 1; i++) {
                int u = pointToId.get(pointsOnRoad.get(i));
                int v = pointToId.get(pointsOnRoad.get(i + 1));
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
        }
        
        int[] maxSpeed = new int[nNodes];
        Arrays.fill(maxSpeed, -1);
        
        int startCityId = pointToId.get(new Point(city[0][0], city[0][1]));
        maxSpeed[startCityId] = Integer.MAX_VALUE;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        pq.add(new int[]{startCityId, Integer.MAX_VALUE});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currSpeed = curr[1];
            
            if (currSpeed < maxSpeed[currNode]) continue;
            
            for (int nextNode : graph.get(currNode)) {
                int nextSpeed = Math.min(currSpeed, nodeLimits[nextNode]);
                
                if (nextSpeed > maxSpeed[nextNode]) {
                    maxSpeed[nextNode] = nextSpeed;
                    pq.add(new int[]{nextNode, nextSpeed});
                }
            }
        }
        
        int[] result = new int[city.length - 1];
        for (int i = 1; i < city.length; i++) {
            int targetCityId = pointToId.get(new Point(city[i][0], city[i][1]));
            int finalSpeed= maxSpeed[targetCityId];
            
            result[i - 1 ] = (finalSpeed == Integer.MAX_VALUE) ? 0 : finalSpeed;
        }
        
        return  result;
    }
}