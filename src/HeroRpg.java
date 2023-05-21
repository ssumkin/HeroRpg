import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeroRpg {
    int[] nowLocation(char[][] map) {
        int[] index = new int[2];

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 1) {
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HeroRpg heroRpg = new HeroRpg();
        Random rand = new Random();

        char[][] map = new char[5][5];
        for(int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], '0');
        }
        map[0][0] = '▲';

        int monster1 = rand.nextInt(5) + 1; 
        int monster2 = rand.nextInt(5); 
        int monster3 = rand.nextInt(5); 
        int monster4 = rand.nextInt(5); 
        int monster5 = rand.nextInt(5); 

        
        map[0][monster1] = '■';
        map[1][monster2] = '■';
        map[2][monster3] = '■';
        map[3][monster4] = '■';
        map[4][monster5] = '■';
        
        int[] now;
        int[] after = new int[2];

        while(true) {
            for (char[] is1 : map) {
                for (char is2 : is1) {
                    System.out.print(is2 + " ");
                }
                System.out.println();
            }  
            System.out.print(">> ");
            int moveLocation = sc.nextInt();

            now = heroRpg.nowLocation(map);
            
            if(moveLocation == 6) {
                map[now[0]][now[1]] = 0;
                after[0] = now[0];
                after[1] = now[1]+1 < 5 ? now[1]+1 : now[1];
                map[after[0]][after[1]] = 1;
            } else if(moveLocation == 4) {
                map[now[0]][now[1]] = 0;
                after[0] = now[0];
                after[1] = now[1]-1 > -1 ? now[1]-1 : now[1];
                map[after[0]][after[1]] = 1;
            } else if(moveLocation == 8) {
                map[now[0]][now[1]] = 0;
                after[0] = now[0]-1 > -1 ? now[0]-1 : now[0];
                after[1] = now[1];
                map[after[0]][after[1]] = 1;
            } else if(moveLocation == 2) {
                map[now[0]][now[1]] = 0;
                after[0] = now[0]+1 < 5 ? now[0]+1 : now[0];
                after[1] = now[1];
                map[after[0]][after[1]] = 1;
            } else if(moveLocation == 0) {
                break;
            } else {
                System.out.println("다시 입력해 주세요.");
            } 
        }
    }
}