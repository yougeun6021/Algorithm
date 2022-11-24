package Level3;

import java.util.*;

public class Memorize { //억억단을 외우자 ->테스트 10 시간초과
    public static void main(String[] args) {
        int e =8;
        int[] starts = {1,3,7};
        System.out.println(Arrays.toString(solution2(e, starts)));

    }

    public static int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divisorArr = new int[e];
        int index = 0;
        for(int i=0; i<starts.length;i++){
            int max = 0;
            for(int j=starts[i];j<=e;j++){

                if(divisorArr[j-1]==0){
                    getDivisorNumber(j,divisorArr);
                }

                int value = divisorArr[j-1];

                if(max<value){
                    index = j;
                    max = value;
                }

                answer[i] = index;
            }


        }
        return answer;
    }

    public static int[] solution2(int e, int[] starts) {
        int[] answer = new int[starts.length];
        TreeSet<Number> set = new TreeSet<>(Comparator.reverseOrder());

        for(int i=1; i<=e;i++){
            set.add(new Number(i,getDivisorNumber(i)));
        }


        for(int i=0; i< starts.length;i++){
            for(Number number:set){
                int num = number.getNumber();
                if(num>=starts[i]){
                    answer[i] = num;
                    break;
                }
            }
        }

        return answer;
    }


    public static void getDivisorNumber(int n,int[] divisorArr){
        int count =0;
        double sqrt = Math.sqrt(n);
        if(sqrt%1==0){
            count++;
            if(n==1){
                divisorArr[n-1] = count;
                return;
            }
        }
        for(int i=1; i<sqrt;i++){
            if(n%i==0){
                count+=2;
            }
        }
        divisorArr[n-1] = count;
    }

    public static int getDivisorNumber(int n){
        int count =0;
        double sqrt = Math.sqrt(n);
        if(sqrt%1==0){
            count++;
            if(n==1){
                return count;
            }
        }
        for(int i=1; i<sqrt;i++){
            if(n%i==0){
                count+=2;
            }
        }
        return count;
    }

    static class Number implements Comparable<Number> {
        int number;
        int divisorCount;

        public Number(int number,int divisorCount){
            this.number = number;
            this.divisorCount = divisorCount;
        }

        public int getDivisorCount() {
            return divisorCount;
        }

        public int getNumber() {
            return number;
        }


        @Override
        public int compareTo(Number o) {
            return this.divisorCount!=o.divisorCount ?this.divisorCount-o.divisorCount:o.number-this.number;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "number=" + number +
                    ", divisorCount=" + divisorCount +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Number){
                Number number = (Number) o;
                return (this.number == number.number && this.divisorCount==number.divisorCount);
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, divisorCount);
        }
    }


}
