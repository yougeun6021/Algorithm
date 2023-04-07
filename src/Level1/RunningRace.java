package Level1;

import java.util.Arrays;
import java.util.HashMap;

public class RunningRace { //달리기 경주
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution(players, callings)));
    }

    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<Integer,String> rankingMap = new HashMap<>();
        HashMap<String,Integer> playerMap = new HashMap<>();

        for(int i=0; i< players.length;i++){
            playerMap.put(players[i],i);
            rankingMap.put(i,players[i]);
        }


        for (String calling : callings) {
            int ranking = playerMap.get(calling);
            String leadingPlayer = rankingMap.get(ranking-1);
            playerMap.put(calling,ranking-1);
            playerMap.put(leadingPlayer ,ranking);
            rankingMap.put(ranking-1,calling);
            rankingMap.put(ranking,leadingPlayer);
        }


        for (Integer ranking : rankingMap.keySet()) {
            answer[ranking] = rankingMap.get(ranking);
        }

        return answer;
    }
}
