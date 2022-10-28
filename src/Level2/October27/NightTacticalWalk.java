package Level2.October27;



public class NightTacticalWalk { //야간전술보행
    public static void main(String[] args) {
        int distance =12;
        int[][] scope = {{3, 5},{10, 11}};
        int[][] times = {{3, 5},{2, 3}};
        System.out.println(solution(distance,scope,times));

    }

    public static int solution(int distance, int[][] scope, int[][] times) {
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<scope.length;i++){
            int scopeMin = Math.min(scope[i][0],scope[i][1]);
            int scopeMax =Math.max(scope[i][0],scope[i][1]);
            for(int j= scopeMin; j<=scopeMax; j++){
                int period = times[i][0]+times[i][1];
                if(j%period<=times[i][0] && j%period>=1 ){
                    if(answer>j){
                        answer =j;
                    }
                }
            }
        }

        if(answer==Integer.MAX_VALUE){
            return distance;
        }

        return answer;
    }
}
