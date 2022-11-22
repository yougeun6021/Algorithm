package Level3;


public class Network { //네트워크
    public static void main(String[] args) {
        int n =3;
        int[][] computers = {{1, 1, 0},{1, 1, 1},{0, 1, 1}};
        System.out.println(solution(n,computers));

    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visited[] = new boolean[n];
        for(int i=0; i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                getNetwork(n,i,computers,visited);
                answer++;
            }
        }
        return answer;
    }

    public static void getNetwork(int n,int computer,int[][] computers,boolean[] visited){
        for(int i=0;i<n;i++){
            if(computers[computer][i]==1 && !visited[i]){
                visited[i] = true;
                getNetwork(n,i,computers,visited);
            }
        }
    }
}
