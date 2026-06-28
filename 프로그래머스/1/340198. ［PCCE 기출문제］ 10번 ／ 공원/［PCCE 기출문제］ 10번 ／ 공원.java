import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int rows = park.length;
        int cols = park[0].length;

        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            if (canPlace(size, park, rows, cols)) {
                return size;
            }
        }
        return -1;
    }

    private boolean canPlace(int size, String[][] park, int rows, int cols) {
        for (int r = 0; r <= rows - size; r++) {
            for (int c = 0; c <= cols - size; c++) {
                boolean possible = true;
                
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (!park[r + i][c + j].equals("-1")) {
                            possible = false;
                            break;
                        }
                    }
                    if (!possible) {
                        break;
                    }
                }
                
                if (possible) {
                    return true;
                }
            }
        }
        return false;
    }
}