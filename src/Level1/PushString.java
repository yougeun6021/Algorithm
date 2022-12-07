package Level1;

public class PushString { //문자열 밀기
    public static void main(String[] args) {
        String A = "hello";
        String B = "hello";
        System.out.println(solution(A,B));
    }

    public static int solution(String A, String B) {
        if(A.equals(B)){
            return 0;
        }
        int answer = -1;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i=0; i<A.length();i++){
            sb.append(A.charAt(i));
            if(!B.contains(sb.toString())){
                index = i;
                sb.setLength(i);
                break;
            }
        }
        if((A.substring(index)+sb).equals(B)){
            answer = A.length()-index;
        }

        return answer;
    }
}
