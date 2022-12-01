package Level2;

public class VowelDictionary { //모음사전
    public static void main(String[] args) {
        String word = "I";
        System.out.println(solution(word));
    }

    public static int solution(String word) {
        int answer = 0;
        int[] mul = {781,156,31,6,1};
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            switch (ch){
                case 'A':
                    answer+= 1;
                    break;
                case 'E':
                    answer+= mul[i]+1;
                    break;
                case 'I':
                    answer+= mul[i]*2+1;
                    break;
                case 'O':
                    answer+= mul[i]*3+1;
                    break;
                case 'U':
                    answer+= mul[i]*4+1;
                    break;
            }
        }
        return answer;
    }
}
