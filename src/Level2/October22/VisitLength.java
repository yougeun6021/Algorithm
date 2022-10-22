package Level2.October22;

import java.util.HashSet;

public class VisitLength { //방문길이
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));

    }

    public static int solution(String dirs) {
        Coordinate coordinate = new Coordinate(0,0);
        HashSet<Coordinate> hashSet = new HashSet<>();
        for(int i=0; i<dirs.length();i++){
            switch (dirs.charAt(i)){
                case 'U':
                    if(coordinate.getY()+1<=5){
                        coordinate.update(0,1);
                        hashSet.add(new Coordinate(coordinate.getX(), coordinate.getY()-0.5));
                    }
                    break;
                case 'D':
                    if(coordinate.getY()-1>=-5){
                        coordinate.update(0,-1);
                        hashSet.add(new Coordinate(coordinate.getX(), coordinate.getY()+0.5));
                    }
                    break;
                case 'L':
                    if(coordinate.getX()-1>=-5){
                        coordinate.update(-1,0);
                        hashSet.add(new Coordinate(coordinate.getX()+0.5, coordinate.getY()));
                    }
                    break;
                case 'R':
                    if(coordinate.getX()+1<=5){
                        coordinate.update(1,0);
                        hashSet.add(new Coordinate(coordinate.getX()-0.5, coordinate.getY()));
                    }
                    break;
            }

        }
        return hashSet.size();
    }

    static class Coordinate{
        double x;
        double y;

        public Coordinate(double x,double y){
            this.x = x;
            this.y = y;
        }

        public void update(double x, double y){
            this.x+=x;
            this.y+=y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Coordinate){
                Coordinate coordinate = (Coordinate) obj;
                return (this.x ==coordinate.x && this.y == coordinate.y);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (this.x+""+this.y).hashCode();
        }
    }
}
