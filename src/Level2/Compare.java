package Level2;

import java.util.Arrays;

public class Compare {
    public static void main(String[] args) {
        int[][] arr = {{1,1},{-1,1},{2,3},{4,3},{0,0},{1,2}};
        Coordinate[] coordinates = new Coordinate[arr.length];
        for(int i=0; i<arr.length;i++){
            coordinates[i] = new Coordinate(arr[i][0],arr[i][1]);
        }
        System.out.println(Arrays.toString(coordinates));
        Arrays.sort(coordinates,Coordinate::compareTo);
        System.out.println(Arrays.toString(coordinates));
    }

    static class Coordinate implements Comparable<Coordinate> {
        int x;

        int y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Coordinate o) {
            return (Math.abs(x)<<1+Math.abs(y)<<1)-(Math.abs(o.x)<<1+Math.abs(o.y)<<1);
        }

        @Override
        public String toString() {
            return "x:"+x+" y:"+y;
        }
    }
}





