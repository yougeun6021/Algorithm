package Level1;

public class CaesarCipher { // 시저 암호
    public static void main(String[] args) {
        String s ="AB";
        int n = 1;
        System.out.println(solution(s,n));

    }

    public static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isLowerCase(ch)){
                ch = (char)((ch-'a'+n)%26 + 'a');
            }
            else if(Character.isUpperCase(ch)){
                ch = (char)((ch-'A'+n)%26 + 'A');
            }
            answer.append(ch);
        }
        return answer.toString();
    }
}
