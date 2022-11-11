package Level2.November11;

public class DivideNumberCard { //숫자카드나누기
    public static void main(String[] args) {
        int[] arrayA = {10, 17};
        int[] arrayB = {5, 20};
        System.out.println(solution(arrayA,arrayB));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int aGcd = gcd(arrayA);
        int bGcd = gcd(arrayB);
        boolean aDivide = false;
        boolean bDivide = false;

        for (int a : arrayA) {
            if (a % bGcd == 0) {
                aDivide = true;
                break;
            }
        }

        for(int b:arrayB){
            if(b%aGcd==0){
                bDivide =true;
                break;
            }
        }

        if(aDivide && bDivide){
            return 0;
        } else if (aDivide) {
            return aGcd;
        } else if (bDivide) {
            return bGcd;
        }else{
            return Math.max(aGcd,bGcd);
        }

    }

    public static int gcd(int[] arr){
        int a = arr[0];
        for(int i=1;i<arr.length;i++){
            int b = arr[i];
            while (b!=0){
                int r = a%b;
                a = b;
                b = r;
            }
        }
        return a;
    }


}
