import java.awt.*;
import java.util.Random;
import javax.swing.*;
 
public class MineSweeper {
    public static void main(String[] args) {

        //Creates Randomiser
        Random rng = new Random();

        //Gets the difficulty
        String difficulty = args[0].toLowerCase();

        //Initilises the dimensions of the board and the number of mines
        int width, height, mines;
        switch (difficulty){
            case "b": width = 9; height = 9; mines = 10; break;
            case "i": width = 16; height = 16; mines = 40; break;
            case "e": width = 30; height = 16; mines = 99; break;
            default: width = 0; height = 0; mines = 0; break;
        }

        int[][] board = new int[height][width];
        for (int i = 0; i < mines; i++){
            int XCoord = rng.nextInt(width);
            int YCoord = rng.nextInt(height);
            while (board[YCoord][XCoord] == -1){
                XCoord = rng.nextInt(width);
                YCoord = rng.nextInt(height);
            }
            board[YCoord][XCoord] = -1;

        }

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                if (board[y][x] != -1){
                    int count = 0;
                    for (int yInc = -1; yInc < 2; yInc++){
                        if (0<= y+yInc && y+yInc < height){
                            for (int xInc = -1; xInc < 2; xInc++){
                                if (0 <= x+xInc && x+xInc < width && (yInc != 0 || xInc !=0) && board[y+yInc][x+xInc] == -1){count++;}
                            }
                        }
                    }
                    board[y][x] = count;
                }
            }
        }
        

        //Creating the window
        JFrame game = new JFrame("Game");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(900, 900); // Width x Height
        game.setLayout(new GridLayout(height, width));

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                game.add(new JButton());
            }
        }

        game.setVisible(true);
    }
}