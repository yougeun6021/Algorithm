package Level3;

public class PulseSequence { //연속 펄스 부분 수열의 합
    public static void main(String[] args) {
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        System.out.println(solution(sequence));

    }

    public static long solution(int[] sequence) {
        long[] plusArr = new long[sequence.length];
        long[] minusArr = new long[sequence.length];
        long plusMax = Math.max(sequence[0],-sequence[0]);
        long minusMax = plusMax;
        plusArr[0] = sequence[0];
        minusArr[0] = -sequence[0];

        for(int i=1; i< sequence.length;i++){
            int sign = (i%2)==0 ? 1:-1;
            long value = sign*sequence[i];
            plusArr[i] = Math.max(plusArr[i-1]+value,value);
            minusArr[i] = Math.max(minusArr[i-1]-value,-value);
            plusMax = Math.max(plusMax,plusArr[i]);
            minusMax = Math.max(minusMax,minusArr[i]);
        }


        return Math.max(plusMax,minusMax);
    }
}
