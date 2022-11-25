package Level3;

import java.util.*;

public class Memorize { //억억단을 외우자 ->테스트 10 시간초과
    public static void main(String[] args) {
        int e =8;
        int[] starts = {1,3,7};
        System.out.println(Arrays.toString(solution3(e, starts)));
    }

    public static int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divisorArr = new int[e+1];

        getDivisorArr2(e,divisorArr);

        int index = 0;
        for(int i=0; i<starts.length;i++){
            int max = 0;
            for(int j=starts[i];j<=e;j++){

                int value = divisorArr[j];

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

    public static int[] solution3(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divisorArr = new int[e+1];
        TreeSet<Number> set = new TreeSet<>(Comparator.reverseOrder());

        getDivisorArr3(e,divisorArr,set);


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


    public static void getDivisorArr(int e,int[] divisorArr){
        for(int i=1; i<=e;i++){
            divisorArr[i] = getDivisorNumber2(i);
        }
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



    public static void getDivisorArr2(int e,int[] divisorNumber){
        List<Integer> primeList = new ArrayList<>();
        for(int i=1; i<=e;i++){
            if(divisorNumber[i]==0){
                divisorNumber[i] = getDivisorNumber2(i);
                primeList.add(i);
            }
            for (Integer prime : primeList) {
                if(i*prime<e){
                    if(divisorNumber[i*prime]!=0){
                        continue;
                    }
                    if(i%prime==0){
                        int num = i;
                        int count = 0;
                        while(num%prime==0){
                            num = num/prime;
                            count++;
                        }
                        divisorNumber[i * prime] = divisorNumber[i]/(count+1)*(count+2);
                    }else{
                        divisorNumber[i * prime] = divisorNumber[i] * 2;
                    }
                }else{
                    break;
                }
            }
        }
    }

    public static int getDivisorNumber2(int n){
        int count =0;
        double sqrt = Math.sqrt(n);
        if(sqrt%1==0){
            count++;
            if(n==1){
                return count;
            }
        }
        if(n%2==0){
            for(int i=1; i<sqrt;i++){
                if(n%i==0){
                    count+=2;
                }
            }
        }else{
            for(int i=1; i<sqrt;i=i+2){
                if(n%i==0){
                    count+=2;
                }
            }
        }
        return count;
    }

    public static void getDivisorArr3(int e,int[] divisorNumber,TreeSet<Number> set){
        List<Integer> primeList = new ArrayList<>();
        for(int i=1; i<=e;i++){
            if(divisorNumber[i]==0){
                divisorNumber[i] = getDivisorNumber2(i);
                primeList.add(i);
                set.add(new Number(i,divisorNumber[i]));
            }
            for (Integer prime : primeList) {
                if(i*prime<e){
                    if(divisorNumber[i*prime]!=0){
                        continue;
                    }
                    if(i%prime==0){
                        int num = i;
                        int count = 0;
                        while(num%prime==0){
                            num = num/prime;
                            count++;
                        }
                        divisorNumber[i * prime] = divisorNumber[i]/(count+1)*(count+2);
                    }else{
                        divisorNumber[i * prime] = divisorNumber[i] * 2;
                    }
                    set.add(new Number(i*prime,divisorNumber[i*prime]));
                }else{
                    break;
                }
            }
        }
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
