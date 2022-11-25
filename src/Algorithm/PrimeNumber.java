package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {
    public static void main(String[] args) {
        int e =5000000;
        int[] divisorArr = new int[e+1];
        int[] divisorArr2 = new int[e+1];
        int[] divisorArr3 = new int[e+1];
        long beforeTime = System.currentTimeMillis();
        getDivisorArr(e,divisorArr);
        long afterTime = System.currentTimeMillis();
        System.out.println(afterTime-beforeTime);


        beforeTime = System.currentTimeMillis();
        getDivisorArr2(e,divisorArr2);
        afterTime = System.currentTimeMillis();
        System.out.println(afterTime-beforeTime);

        beforeTime = System.currentTimeMillis();
        getDivisorArr3(e,divisorArr3);
        afterTime = System.currentTimeMillis();
        System.out.println(afterTime-beforeTime);


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
                if(i*prime<=e){
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
    public static void getDivisorArr3(int e,int[] divisorNumber){
        List<Integer> primeList = new ArrayList<>();
        divisorNumber[1] = 1;
        for(int i=2; i<=e;i++){
            if(divisorNumber[i]==0){
                divisorNumber[i] = 2;
                primeList.add(i);
            }
            for (Integer prime : primeList) {
                if(i*prime<=e){
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



}
