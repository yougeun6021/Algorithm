package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TravelRoute {


    static List<String> answerList = new ArrayList<>();

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));

    }

    public static String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        StringBuilder sb = new StringBuilder();
        sb.append("ICN");
        dfs(tickets,visited,0,"ICN",sb,3);
        Collections.sort(answerList);

        return answerList.get(0).split(" ") ;
    }


    static void dfs(String[][]tickets,boolean[] visited,int depth,String start,StringBuilder sb,int sbLength){
        if(depth == tickets.length){
            answerList.add(sb.toString());
            return;
        }

        for(int i=0; i<tickets.length;i++){
            String s = tickets[i][0];
            if(!visited[i] && s.equals(start)){
                String e = tickets[i][1];
                sb.append(" ").append(e);
                visited[i] = true;
                dfs(tickets,visited,depth+1,e,sb,sbLength+e.length()+1);
                sb.setLength(sbLength);
                visited[i] = false;
            }
        }
    }
}

