package Level1;

public class HidePhoneNumber {  //핸드폰 번호 가리기
    public static void main(String[] args) {
        String phone_number = "01033334444";
        System.out.println(solution(phone_number));
    }

    public static String solution(String phone_number) {
        String hide_number = phone_number.replaceAll("[0-9]","*").substring(0,phone_number.length()-4);
        String number = phone_number.substring(phone_number.length()-4);
        return hide_number+number;
    }
}
