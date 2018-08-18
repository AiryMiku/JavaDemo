package interview.thoughtworks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Airy on 2018/7/27
 */

class Maze{

    static class Road{
        int x1;
        int y1;
        int x2;
        int y2;
        int row;
        int col;

        public Road(int x1, int y1, int x2, int y2, int row, int col) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.row = row;
            this.col = col;
        }

        /**
         * 判断参数是否合法
         * @return
         */
        public boolean isFormat(int row,int col){
            if (this.x1<0 || this.x1>col || this.x2<0 || this.x2>col ||
                    this.y1<0 || this.y1>row || this.y2<0 || this.y2>row ) // 边界判断
                return false;
            else if (this.x1 == this.x2 || this.y1 == this.y2){
                if (Math.abs(this.x1-this.x2) == 1 || Math.abs(this.y1-this.y2) == 1){ // 判断是否正向相邻
                    return true;
                }
            }
            return false;
        }
    }

    private boolean map[][];

    public Maze(int row, int col, ArrayList<Road> roads){
        initMap(row,col);
        for (Road r : roads){
            if (r.x1 == r.x2) {
                if(r.y1 < r.y2){
                    map[2*r.x1+1][2*r.y2] = true;
                }else{
                    map[2*r.x1+1][2*r.y1] = true;
                }
            }
            if(r.y1 == r.y2){
                if(r.x1 < r.x2){
                    map[2*r.x2][2*r.y1+1] = true;
                }else{
                    map[2*r.x1][2*r.y1+1] = true;
                }
            }
        }
    }

    private void initMap(int row, int col){
        map = new boolean[2*row+1][2*col+1];
        for (int i=0;i<row;++i){
            for (int j=0;j<col;++j){
                map[2*i+1][2*j+1] = true;
            }
        }
    }

    public String render(){
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                if(map[i][j]){
                    System.out.print("[R]");
                    builder.append("[R]");
                } else {
                    System.out.print("[W]");
                    builder.append("[W]");
                }
                if(j!=map[0].length){
                    System.out.print(" ");
                    builder.append(" ");
                }
            }
            System.out.println();
            builder.append("\n");
        }
        return builder.toString();
    }

}

class MazeFactory{

    private static int row = 0;
    private static int col = 0;
    private static String sizePattern = "-?\\S+\\s-?\\S+";
    private static String connectPattern = "^(-?\\S+\\,-?\\S+-?\\s-?\\S+\\,-?\\S+;)*(-?\\S+\\,-?\\S+-?\\s-?\\S+\\,-?\\S+)$";

    public static Maze Create(String command) {
        try {
            String args[] = command.split("\n");
            boolean isMatch = Pattern.matches(sizePattern,args[0]);
            if (!isMatch) {
                throw new Exception("command");
            }
            isMatch = Pattern.matches(connectPattern,args[1]);
            if(!isMatch){
                throw new Exception("command");
            }
            String sizes[] = args[0].split("\\s");
            String connects[] = args[1].split(";");
            ArrayList<Maze.Road> roads = new ArrayList<>();

            row = stringToInt(sizes[0]);
            col = stringToInt(sizes[1]);
            for (String s : connects){
                String points[] = s.split(" ");
                String first[] = points[0].split(",");
                String second[] = points[1].split(",");
                int x1 = stringToInt(first[0]);
                int y1 = stringToInt(first[1]);
                int x2 = stringToInt(second[0]);
                int y2 = stringToInt(second[1]);
                Maze.Road road = new Maze.Road(x1,y1,x2,y2,row,col);
                if(road.isFormat(row,col)){
                    roads.add(road);
                }else{
                    throw new Exception("format");
                }
            }
            return new Maze(row,col,roads);

        }catch (Exception e){
            switch (e.toString()){
                case "java.lang.Exception: command":
                    System.out.println("Incorrect command format.");
                    break;
                case "java.lang.Exception: range":
                    System.out.println("Number out of range.");
                    break;
                case "java.lang.Exception: format":
                    System.out.println("Maze format error");
                    break;
                case "java.lang.Exception: number":
                    System.out.println("Invalid number format");
                    break;

                default:
                    break;
            }
            return null;
        }
    }

    private static int stringToInt(String s) throws Exception {
        try {
            int result = Integer.valueOf(s);
            if (result < 0){
                throw new Exception("range");
            }
            return result;
        }catch (NumberFormatException e){
            throw new Exception("number");
        }
    }
}

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String size = in.nextLine();
        String connect = in.nextLine();
        String command = size+"\n"+connect;
        Maze maze = MazeFactory.Create(command);
        if (maze!=null){
            System.out.println(maze.render());
        } else {
//            System.out.println("null maze");
        }
    }
}
