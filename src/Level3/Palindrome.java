package Level3;

public class Palindrome { //가장 긴 펠린드롬
    public static void main(String[] args) {
        String s = "abacde";
        System.out.println(solution2(s));

    }

    public static int solution(String s)
    {
        int answer = 1;
        for(int i=0; i<s.length();i++){
            for(int j=s.length()-1; j>i;j--){
                if(s.charAt(i)==s.charAt(j)){
                    String str = s.substring(i,j+1);
                    String reverse = new StringBuilder(str).reverse().toString();
                    if(str.equals(reverse)){
                        answer = Math.max(answer,j+1-i);
                        break;
                    }
                }
            }
        }

        return answer;
    }



    public static int solution2(String s)
    {
        int answer = 1;
        for(int i=0; i<s.length();i++){
            for(int j=s.length()-1; j>i;j--){
                if(s.charAt(i)==s.charAt(j)){
                    String str = s.substring(i,j+1);
                    boolean equal = true;
                    for(int k=0; k<str.length()/2;k++){
                        if(str.charAt(k)!=str.charAt(str.length()-1-k)){
                            equal = false;
                            break;
                        }
                    }
                    if(equal){
                        answer = Math.max(answer,j+1-i);
                        break;
                    }
                }
            }
        }

        return answer;
    }


}
