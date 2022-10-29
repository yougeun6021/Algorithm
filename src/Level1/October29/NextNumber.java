package Level1.October29;

public class NextNumber { // 다음에 올 숫자
    public static void main(String[] args) {

    }

    public int solution(int[] common) {
        int d1 = common[2]-common[1];
        int d2 = common[1]-common[0];

        if(common[0] ==0 || d1 == d2){
            return common[common.length-1]+d1;
        }else{
            return (int) (common[common.length-1]*(double)common[2]/common[1]);
        }
    }
}
