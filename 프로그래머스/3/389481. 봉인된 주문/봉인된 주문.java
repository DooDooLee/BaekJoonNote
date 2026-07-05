import java.util.Arrays;

class Solution {
    long[] p26 = new long[12];

    public String solution(long n, String[] bans) {
        p26[0] = 1;
        for (int i = 1; i <= 11; i++) {
            p26[i] = p26[i - 1] * 26;
        }

        long[] banNums = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            banNums[i] = stringToIndex(bans[i]);
        }
        Arrays.sort(banNums);

        long target = n;
        for (long ban : banNums) {
            if (ban <= target) {
                target++;
            } else {
                break;
            }
        }

        return indexToString(target);
    }

    private long stringToIndex(String s) {
        long idx = 0;
        
        for (int i = 1; i < s.length(); i++) {
            idx += p26[i];
        }
        
        long offset = 0;
        for (int i = 0; i < s.length(); i++) {
            offset = offset * 26 + (s.charAt(i) - 'a');
        }
        
        return idx + offset + 1;
    }

    private String indexToString(long idx) {
        int len = 1;
        
        while (idx > p26[len]) {
            idx -= p26[len];
            len++;
        }

        idx -= 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            long rem = idx % 26;
            sb.append((char) ('a' + rem));
            idx /= 26;
        }
        
        return sb.reverse().toString();
    }
}