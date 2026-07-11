import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }
        
        for (String calling : callings) {
            int currentRank = rankMap.get(calling);
            String frontPlayer = players[currentRank - 1];
            
            players[currentRank - 1] = calling;
            players[currentRank] = frontPlayer;
            
            rankMap.put(calling, currentRank - 1);
            rankMap.put(frontPlayer, currentRank);
        }
        
        return players;
    }
}