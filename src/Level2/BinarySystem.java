package Level2;

import java.util.Arrays;

public class BinarySystem { // 이진법변환하기
    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(Arrays.toString(solution(s)));

    }

    public static int[] solution(String s) {
        int zeroCount =0;
        int count = 0;
        while (!s.equals("1")){
            int beforeLength = s.length();
            s = s.replace("0","");
            zeroCount = zeroCount+beforeLength-s.length();
            s = Integer.toString(s.length(),2);
            count++;
        }

        return new int[]{count,zeroCount} ;
    }
}
