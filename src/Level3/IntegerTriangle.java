package Level3;



public class IntegerTriangle { //정수 삼각형
    public static void main(String[] args) {
        int[][] triangle = {{7},{3, 8},{8, 1, 0},{2, 7, 4, 4},{4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));

    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        for(int i=0; i< triangle.length-1;i++){
            triangle[i+1][0] += triangle[i][0];
            triangle[i+1][triangle[i+1].length-1] += triangle[i][triangle[i].length-1];

            for(int j=1; j< triangle[i+1].length-1;j++){
                triangle[i+1][j] += Math.max(triangle[i][j-1],triangle[i][j]);
            }
        }

        for(int i=0; i< triangle[triangle.length-1].length;i++){
            int value = triangle[triangle.length-1][i];
            if(answer<value){
                answer = value;
            }
        }

        return answer;
    }

}
