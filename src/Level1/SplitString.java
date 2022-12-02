package Level1;

public class SplitString {
    public static void main(String[] args) {
        String s = "aaabbaccccabba";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 1;
        char ch = s.charAt(0);
        int count =1;
        for(int i=1; i<s.length();i++){
            count += ch==s.charAt(i)? 1:-1;
            if(count==0 && i!=s.length()-1){
                answer++;
                count= 1;
                ch = s.charAt(i+1);
                i++;
            }
        }
        return answer;
    }
}
