package Level2;

import java.util.*;

public class MenuRenewal { // 메뉴 리뉴얼
    public static void main(String[] args) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2,3,5};
        System.out.println(Arrays.toString(solution(orders, course)));

    }

    static HashMap<String,Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static String[] solution(String[] orders, int[] course) {
        List<String> menuList = new ArrayList<>();

        for(int i=0; i<orders.length;i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }


        for(int r:course){
            for (String order : orders) {
                int n = order.length();
                if (n >= r) {
                    combination(order,0, n, r,0);
                }
            }

            if(map.size()!=0){
                List<String> list = new ArrayList<>(map.keySet());
                list.sort((o1, o2) -> map.get(o2)-map.get(o1));
                String menu = list.get(0);
                int max = map.get(menu);
                if(max>=2){
                    menuList.add(menu);
                    for(int i=1;i<list.size();i++){
                        String value = list.get(i);
                        if(map.get(value)==max){
                            menuList.add(value);
                        }
                    }
                }
                map.clear();
            }

        }


        Collections.sort(menuList);
        String[] answer = new String[menuList.size()];

        for(int i=0; i<menuList.size();i++){
            answer[i] = menuList.get(i);
        }


        return answer;
    }

    public static void combination(String order, int start, int n , int r, int depth){
        if(depth==r){
            String menu = sb.toString();
            map.put(menu,map.getOrDefault(menu,0)+1);
            return;
        }

        for(int i=start;i<n;i++){
            sb.append(order.charAt(i));
            combination(order,i+1,n,r,depth+1);
            sb.setLength(depth);
        }
    }
}
