package Level2.November10;

import java.util.HashSet;

public class NumberOfSequenceSum {// 연속 부분 수열의 개수

    public static void main(String[] args) {
        int[] elements ={7,9,1,1,4};
        System.out.println(solution(elements));

    }

    public static int solution(int[] elements) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[elements.length*2];

        for(int i=0; i<elements.length;i++){
            arr[i] = elements[i];
            arr[i+elements.length]=elements[i];
        }

        for(int i=1;i<=elements.length;i++){
            for(int j=0; j<elements.length; j++){
                for(int k=j; k<j+i;k++){
                    sum+=arr[k];
                }
                set.add(sum);
                sum =0;
            }
        }
        return set.size();
    }


}
