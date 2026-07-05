class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        int r = 0;
        int c = 0;
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        
        for (String route : routes) {
            String[] parts = route.split(" ");
            String op = parts[0];
            int n = Integer.parseInt(parts[1]);
            
            int nr = r;
            int nc = c;
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                if (op.equals("N")) nr--;
                else if (op.equals("S")) nr++;
                else if (op.equals("W")) nc--;
                else if (op.equals("E")) nc++;
                
                if (nr < 0 || nr >= h || nc < 0 || nc >= w || park[nr].charAt(nc) == 'X') {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                r = nr;
                c = nc;
            }
        }
        
        return new int[]{r, c};
    }
}