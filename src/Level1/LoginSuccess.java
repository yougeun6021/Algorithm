package Level1;

public class LoginSuccess { //로그인 성공
    public static void main(String[] args) {
        String[] id_pw = {"meosseugi", "1234"};
        String[][] db = {{"rardss", "123"},{"yyoom", "1234"},{"meosseugi", "1234"}};

    }

    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        String id = id_pw[0];
        String pw = id_pw[1];
        for (String[] str : db) {
            if (id.equals(str[0])) {
                if (pw.equals(str[1])) {
                    answer = "login";
                    break;
                }
                answer = "wrong pw";
            }
        }
        return answer;
    }
}
