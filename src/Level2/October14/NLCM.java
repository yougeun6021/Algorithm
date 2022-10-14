package Level2.October14;

public class NLCM { // N개의 최소공배수
    public static void main(String[] args) {
        int[] arr={2,6,8,14};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        if(arr.length==1){
            return arr[0];
        }
        int a =arr[0];
        int b =arr[1];
        for(int i=0; i<=arr.length-2;i++){
            int gcd =gcd(a,b);
            a= a*b/gcd;
            if(i==arr.length-2){
                break;
            }
            b=arr[i+2];
        }
        return a;
    }

    public static int gcd (int a,int b){
        while (b!=0){
            int r = a%b;
            a=b;
            b=r;
        }
        return a;
    }
}
