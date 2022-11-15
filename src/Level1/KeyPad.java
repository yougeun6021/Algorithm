package Level1;

public class KeyPad { //키패드 누르기
    public static void main(String[] args) {
        int[] numbers ={1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers,hand));

    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int [][] coordinate = {{0,0},{-1,3},{0,3},{1,3},{-1,2},{0,2},{1,2},{-1,1},{0,1},{-1,1},{-1,0},{1,0}};
        int rightIndex = 11;
        int leftIndex = 10;
        int leftdistance ;
        int rightdistance ;
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftIndex = number;
            }
            if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightIndex = number;
            }
            if (number == 2 || number == 5 || number == 8 || number == 0) {
                leftdistance = Math.abs(coordinate[leftIndex][0] - coordinate[number][0])+Math.abs(coordinate[leftIndex][1] - coordinate[number][1]);
                rightdistance = Math.abs(coordinate[rightIndex][0] - coordinate[number][0]) + Math.abs(coordinate[rightIndex][1] - coordinate[number][1]);
                if (leftdistance > rightdistance) {
                    answer.append("R");
                    rightIndex = number;
                } else if (leftdistance == rightdistance) {
                    if(hand.equals("right")){
                        answer.append("R");
                        rightIndex = number;
                    }else{
                        answer.append("L");
                        leftIndex = number;
                    }

                } else {
                    answer.append("L");
                    leftIndex = number;
                }

            }
        }
        return answer.toString();
    }
}
