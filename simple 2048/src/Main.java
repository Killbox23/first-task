import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static int[][] screen = {
            {1, 5, 5, 5, 5, 5, 5, 5, 10},
            {3, 0, 3, 0, 3, 0, 3, 0, 3},
            {3, 5, 5, 5, 5, 5, 5, 5, 3},
            {3, 0, 3, 0, 3, 0, 3, 0, 3},
            {3, 5, 5, 5, 5, 5, 5, 5, 3},
            {3, 0, 3, 0, 3, 0, 3, 0, 3},
            {3, 5, 5, 5, 5, 5, 5, 5, 3},
            {3, 0, 3, 0, 3, 0, 3, 0, 3},
            {20, 5, 5, 5, 5, 5, 5, 5, 30}
    };
    static int tileX;
    static int tileY;
    static Random random= new Random();
    static List<Integer> listFree=new ArrayList<>();

    static boolean UpStuck=false, DownStuck=false, RightStuck=false, LeftStuck=false;
    public static void main(String[] args) throws IOException {
        listFree.add(1);
        listFree.add(3);
        listFree.add(5);
        listFree.add(7);
        tileX= listFree.get(random.nextInt(listFree.size()));
        tileY= listFree.get(random.nextInt(listFree.size()));
        screen[tileY][tileX]=2;
    boolean gameOver=false;
    while(gameOver==false)
    {
        for (int y=0; y<screen.length; y++){
            for (int x=0; x<screen[0].length; x++)
            {
//                if (y ==tileY && x== tileX) {
//                    screen[tileY][tileX]=2;
//                    System.out.print("2");
//                }
                if (listFree.contains(y) && listFree.contains(x))
                    System.out.print(screen[y][x]);
                else
                if (screen[y][x]==1)
                    System.out.print("┍");
                else
                if (screen[y][x]==20)
                    System.out.print("┖");
                else
                if (screen[y][x]==30)
                    System.out.print("┙");
                else
                if (screen[y][x]==10)
                    System.out.print("┓");
                else
                if (screen[y][x]==5)
                    System.out.print("-");
                else
                if (screen[y][x]==3)
                    System.out.print("|");
                if (screen[y][x]==2048) {
                    gameOver = true;
                    System.out.print("game over");
                }
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        byte bytes[]= new byte[10];
        //char input;
        System.in.read(bytes);
        //input= (char) System.in.read();
        switch(bytes[0]) {//input
        case 'q':
            gameOver = true;
            System.out.print("game over");
            break;
        case 'a':
            LeftStuck=true;
            //System.out.print(screen[1][1]);
            for (int y=screen.length-2; y>0; y-=2) {// 16 8 4 4
                if (screen[y][1] == screen[y][3] && screen[y][3]!=0) {
                    screen[y][1] = screen[y][1] * 2;
                    screen[y][3] = 0;
                    LeftStuck = false;
                }
                else if (screen[y][1] == 0 && screen[y][3] != 0) {
                    screen[y][1] = screen[y][3];
                    screen[y][3] = 0;
                    LeftStuck = false;
                }
                if (screen[y][3] == screen[y][5] && screen[y][3]!=0) {
                    screen[y][3] = screen[y][3] * 2;
                    screen[y][5] = 0;
                    LeftStuck = false;
                }
                else if (screen[y][3] == 0 && screen[y][5] != 0) {
                    screen[y][3] = screen[y][5];
                    screen[y][5] = 0;
                    LeftStuck = false;
                }
                if (screen[y][5] == screen[y][7]&& screen[y][5]!=0) {
                    screen[y][5] = screen[y][7] * 2;
                    screen[y][7] = 0;
                    LeftStuck = false;
                }
                else if (screen[y][5] == 0 && screen[y][7] != 0) {
                    screen[y][5] = screen[y][7];
                    screen[y][7] = 0;
                    LeftStuck = false;
                }
            }
            if (!LeftStuck) {
                while(screen[tileY][tileX]!=0) {
                    tileX = listFree.get(random.nextInt(listFree.size()));
                    tileY = listFree.get(random.nextInt(listFree.size()));

                }screen[tileY][tileX]=2;
            }
            break;
        case 'd':
            RightStuck=true;
            for (int y=screen.length-2; y>0; y-=2){// 16 8 4 4
                if (screen[y][7]==screen[y][5] && screen[y][5]!=0)
                {
                    screen[y][7]=screen[y][7]*2;
                    screen[y][5]=0;
                    RightStuck=false;
                }
                else if (screen[y][7]==0 && screen[y][5]!=0)
                {
                    screen[y][7]=screen[y][5];
                    screen[y][5]=0;
                    RightStuck=false;
                }
                if (screen[y][5]==screen[y][3]&& screen[y][3]!=0)
                {
                    screen[y][5]=screen[y][5]*2;
                    screen[y][3]=0;
                    RightStuck=false;
                }
                else if (screen[y][5]==0 && screen[y][3]!=0)
                {
                    screen[y][5]=screen[y][3];
                    screen[y][3]=0;
                    RightStuck=false;
                }
                if (screen[y][3]==screen[y][1]&& screen[y][3]!=0)
                {
                    screen[y][3]=screen[y][3]*2;
                    screen[y][1]=0;
                    RightStuck=false;
                }
                else if (screen[y][3]==0 && screen[y][1]!=0)
                {
                    screen[y][3]=screen[y][1];
                    screen[y][1]=0;
                    RightStuck=false;
                }
            }
            if (!RightStuck) {
                while(screen[tileY][tileX]!=0) {
                    tileX = listFree.get(random.nextInt(listFree.size()));
                    tileY = listFree.get(random.nextInt(listFree.size()));

                }screen[tileY][tileX]=2;
            }
            break;
        case 'w':
            UpStuck=true;
            for (int x=1; x<=screen.length-2; x+=2){// 16 8 4 4
                if (screen[1][x]==screen[3][x]&& screen[1][x]!=0)
                {
                    screen[1][x]=screen[1][x]*2;
                    screen[3][x]=0;
                    UpStuck=false;
                }
                else if (screen[1][x]==0 && screen[3][x]!=0)
                {
                    screen[1][x]=screen[3][x];
                    screen[3][x]=0;
                    UpStuck=false;
                }
                if (screen[3][x]==screen[5][x]&& screen[3][x]!=0)
                {
                    screen[3][x]=screen[3][x]*2;
                    screen[5][x]=0;
                    UpStuck=false;
                }
                else if (screen[3][x]==0 && screen[5][x]!=0)
                {
                    screen[3][x]=screen[5][x];
                    screen[5][x]=0;
                    UpStuck=false;
                }
                if (screen[5][x]==screen[7][x]&& screen[5][x]!=0)
                {
                    screen[5][x]=screen[5][x]*2;
                    screen[7][x]=0;
                    UpStuck=false;
                }
                else if (screen[5][x]==0 && screen[7][x]!=0)
                {
                    screen[5][x]=screen[7][x];
                    screen[7][x]=0;
                    UpStuck=false;
                }
            }
            if (!UpStuck) {
                while(screen[tileY][tileX]!=0) {
                    tileX = listFree.get(random.nextInt(listFree.size()));
                    tileY = listFree.get(random.nextInt(listFree.size()));

                }screen[tileY][tileX]=2;
            }
            break;
        case 's':
            DownStuck=true;
            for (int x=1; x<=screen.length-2; x+=2){// 16 8 4 4
                if (screen[7][x]==screen[5][x])
                {
                    screen[7][x]=screen[7][x]*2;
                    screen[5][x]=0;
                    DownStuck=false;
                }
                else if (screen[7][x]==0 && screen[5][x]!=0)
                {
                    screen[7][x]=screen[5][x];
                    screen[5][x]=0;
                    DownStuck=false;
                }
                if (screen[5][x]==screen[3][x])
                {
                    screen[5][x]=screen[5][x]*2;
                    screen[3][x]=0;
                    DownStuck=false;
                }
                else if (screen[5][x]==0 && screen[3][x]!=0)
                {
                    screen[5][x]=screen[3][x];
                    screen[3][x]=0;
                    DownStuck=false;
                }
                if (screen[3][x]==screen[1][x])
                {
                    screen[3][x]=screen[3][x]*2;
                    screen[1][x]=0;
                    DownStuck=false;
                }
                else if (screen[3][x]==0 && screen[1][x]!=0)
                {
                    screen[3][x]=screen[1][x];
                    screen[1][x]=0;
                    DownStuck=false;
                }
            }
            if (!DownStuck) {
                while(screen[tileY][tileX]!=0) {
                    tileX = listFree.get(random.nextInt(listFree.size()));
                    tileY = listFree.get(random.nextInt(listFree.size()));

                }screen[tileY][tileX]=2;
            }
            break;
    }
    if (UpStuck && DownStuck && LeftStuck && RightStuck)
    {
        gameOver=true;
        System.out.print("game over");
    }
    }
//        System.out.println("Hello world!");
//        //System.out.println("Hello world!");
////        Pacman pacman = new Pacman(5, 5);
////
////        List<Ghost> ghosts = new ArrayList<>();
////        ghosts.add(new Ghost(6, 7, -1, 0));
////        ghosts.add(new Ghost(10, 17, 0, 1));
//        List<Tile> tiles= new ArrayList<>();
//        Screen screen = new Screen();
//
//        Renderer renderer = new Renderer(screen);
//        renderer.renderGame();
////        GameRules rules   = new GameRules(maze, pacman, ghosts);
//
////        while(rules.gameOver == false) {
////
////            renderer.renderGame();
////
////            byte userInput = readUserInput();
////
////            rules.processUserInput(userInput);
////
////            rules.moveElements();
////        }
//
//        //}
//
////    private static byte readUserInput() throws IOException {
////        byte bytes[] = new byte[10];
////        System.in.read(bytes);
////        byte userInput = bytes[0];
////        return userInput;
////    }
    }
}