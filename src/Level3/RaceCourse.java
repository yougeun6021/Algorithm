package Level3;



public class RaceCourse {  //경주로 건설
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        System.out.println(solution(board));

    }

     static int count = Integer.MAX_VALUE;

    public static int solution(int[][] board) {
        int length = board.length;
        boolean[][] visited = new boolean[length][length];
        int[] arr = {1,-1};
        visited[0][0] = true;
        if(board[1][0]==0){
            visited[1][0] = true;
            dfs(board,arr,visited,new Course(1,0,-1,100));
        }

        if(board[0][1]==0){
            visited[0][1] = true;
            dfs(board,arr,visited,new Course(0,1,1,100));
        }
        return count;
    }

    public static void dfs(int[][]board,int[] arr,boolean[][] visited,Course course){
        int x = course.getX();
        int y = course.getY();
        int before = course.getBefore();
        int price = course.getPrice();
        int length = board.length;

        if(price>=count){
            return;
        }


        if(x==length-1 && y==length-1){
            count = price;
        }

        for(int a :arr){
            int xChange = x+a;
            if(x+xChange>=0 && xChange<=length-1 && board[xChange][y]==0 && !visited[xChange][y]){  // 상,하
                visited[xChange][y] = true;
                if(before==1){
                    dfs(board,arr,visited,new Course(xChange,y,-1,price+600));
                }else{
                    dfs(board,arr,visited,new Course(xChange,y,-1,price+100));
                }
                visited[xChange][y] = false;
            }

        }

        for(int b : arr){
            int yChange = y+b;
            if(yChange>=0 && yChange<=length-1 && board[x][yChange]==0 && !visited[x][yChange]){  // 우,좌
                visited[x][yChange] = true;
                if(before==1){
                    dfs(board,arr,visited,new Course(x,yChange,1,price+100));
                }else{
                    dfs(board,arr,visited,new Course(x,yChange,1,price+600));
                }
                visited[x][yChange] = false;
            }
        }
    }

    public static int solution2(int[][] board) {
        int length = board.length;
        boolean[][] visited = new boolean[length][length];
        int[] arr = {1,-1};
        visited[0][0] = true;
        int[][] pArr = new int[length][length];
        for(int i=0; i< length;i++){
            for(int j=0; j< length;j++){
                pArr[i][j] = Integer.MAX_VALUE;
            }
        }
        if(board[1][0]==0){
            visited[1][0] = true;
            dfs2(board,arr,visited,new Course(1,0,-1,100),pArr);
        }

        if(board[0][1]==0){
            visited[0][1] = true;
            dfs2(board,arr,visited,new Course(0,1,1,100),pArr);
        }
        return pArr[length-1][length-1];
    }

    public static void dfs2(int[][]board,int[] arr,boolean[][] visited,Course course,int[][] pArr){
        int x = course.getX();
        int y = course.getY();
        int before = course.getBefore();
        int price = course.getPrice();
        int length = board.length;
        if(price>pArr[x][y]){
            return;
        }else{
            pArr[x][y] = Math.min(pArr[x][y],price);
        }

        if(x==length-1 && y==length-1){
            return;
        }

        for(int a :arr){
            int xChange = x+a;
            if(x+xChange>=0 && xChange<=length-1 && board[xChange][y]==0 && !visited[xChange][y]){  // 상,하
                visited[xChange][y] = true;
                if(before==1){
                    dfs2(board,arr,visited,new Course(xChange,y,-1,price+600),pArr);
                }else{
                    dfs2(board,arr,visited,new Course(xChange,y,-1,price+100),pArr);
                }
                visited[xChange][y] = false;
            }

        }

        for(int b : arr){
            int yChange = y+b;
            if(yChange>=0 && yChange<=length-1 && board[x][yChange]==0 && !visited[x][yChange]){  // 우,좌
                visited[x][yChange] = true;
                if(before==1){
                    dfs2(board,arr,visited,new Course(x,yChange,1,price+100),pArr);
                }else{
                    dfs2(board,arr,visited,new Course(x,yChange,1,price+600),pArr);
                }
                visited[x][yChange] = false;
            }
        }
    }





    static class Course{
        int x;
        int y;
        int before;    // 좌 ,우 1 상,하 -1
        int price;

        Course(int x,int y,int before,int price){
            this.x = x;
            this.y = y;
            this.before = before;
            this.price = price;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getBefore() {
            return before;
        }

        public int getPrice() {
            return price;
        }
    }

}
