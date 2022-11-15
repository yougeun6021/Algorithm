package Level1;

public class NewId { //신규 아이디 추천
    public static void main(String[] args) {
        String new_id = "z-+.^.";
        System.out.println(solution(new_id));

    }

    public static String solution(String new_id) {
        String answer;
        answer = new_id.toLowerCase(); //1단계

        answer = answer.replaceAll("[^a-z0-9-_.]",""); //2단계

        while(answer.contains("..")){  //3단계
            answer = answer.replace("..",".");
        }

        while(!answer.isEmpty() && answer.charAt(0)=='.'){  //4단계

            answer = answer.substring(1);

        }

        answer = deleteLastdot(answer); //4단계

        if(answer.isEmpty()){  //5단계
            answer ="a";
        }

        if(answer.length()>15){             //6단계
            answer = answer.substring(0,15);
        }

        answer = deleteLastdot(answer); //6단계


        while (answer.length()<3){      //7단계
            answer += answer.charAt(answer.length()-1);
        }

        return answer;
    }

    public static String deleteLastdot(String answer){
        while (!answer.isEmpty() && answer.charAt(answer.length()-1)=='.'){
            answer = answer.substring(0,answer.length()-1);
        }
        return answer;
    }
}
