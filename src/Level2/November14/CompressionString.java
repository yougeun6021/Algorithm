package Level2.November14;


import java.util.TreeSet;

public class CompressionString { //문자열 압축
    public static void main(String[] args) {
        String s = "a";
        System.out.println(solution(s));

    }

    public static int solution(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        if(s.length()==1){
            return 1;
        }

        for(int i=1; i<=s.length()/2;i++){
            String[] arr = new String[s.length()%i==0? s.length()/i:s.length()/i+1];
            int index =0;

            for(int j=0; j<s.length();j=j+i){

                arr[index++] = j+i>=s.length()? s.substring(j): s.substring(j,j+i);

            }

            String str = arr[0];
            int length =0;
            int count = 1;

            for(int p=1;p<arr.length;p++){

                String value = arr[p];

                if(value.equals(str)){
                    count++;

                }else{
                    if(count==1){
                        length +=str.length();
                    }else{
                        length +=str.length()+Math.log10(count)+1;
                    }
                    str =arr[p];
                    count =1;

                }
            }

            length+= count==1? str.length():str.length()+Math.log10(count)+1;


            set.add(length);

        }

        return set.first();
    }


}
