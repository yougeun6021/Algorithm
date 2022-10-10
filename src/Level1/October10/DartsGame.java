package Level1.October10;


import java.util.Arrays;

public class DartsGame { // 다트게임
    public static void main(String[] args) {
        String dartResult = "1S*2T*3S";
        System.out.println(solution(dartResult));

    }

    public static int solution(String dartResult) {
        int [] num = new int[3];
        int numIndex = 0;
        String[] result = dartResult.split("");
        for (String s : result) {
            switch (s) {
                case "S":
                    numIndex++;
                    break;
                case "D":
                    num[numIndex] = (int) Math.pow(num[numIndex], 2.0);
                    numIndex++;
                    break;
                case "T":
                    num[numIndex] = (int) Math.pow(num[numIndex], 3.0);
                    numIndex++;
                    break;
                case "*":
                    if (numIndex == 1) {
                        num[numIndex - 1] *= 2;
                    } else {
                        num[numIndex - 1] *= 2;
                        num[numIndex - 2] *= 2;
                    }
                    break;
                case "#":
                    num[numIndex - 1] *= -1;
                    break;
                case "0":
                    if (num[numIndex] == 1) {
                        num[numIndex] = 10;
                    } else {
                        num[numIndex] = 0;
                    }
                    break;
                default:
                    num[numIndex] = Integer.parseInt(s);

            }
        }
        return Arrays.stream(num).sum();
    }
}
