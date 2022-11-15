package Level1;



public class MakePrimeNumber { // 소수 만들기
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int p = j+1; p< nums.length; p++){
                    if(primeNumber(nums[i]+nums[j]+nums[p])){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static boolean primeNumber(int m){
        if(m%2==0){
            return false;
        }
        for(int j=3;j<=Math.sqrt(m);j=j+2){
            if(m%j==0){
                return false;
            }
        }
        return true;
    }
}
