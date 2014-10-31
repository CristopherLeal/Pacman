/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import prolog.Logica;

public class Pacman extends Thread {
    
    //path das imagens
    
    private static final String IMAGE_SOURCE     = "src/pacman/img/";
    static String[]             pacmanSequencesL = { IMAGE_SOURCE + "pac32_left.png", IMAGE_SOURCE + "pac32_left_wide.png",
            IMAGE_SOURCE + "pac32_left_widest.png", IMAGE_SOURCE + "pacman_closed.png" };
    static String[] pacmanSequencesR = { IMAGE_SOURCE + "pac32_right.png", IMAGE_SOURCE + "pac32_right_widest.png",
            IMAGE_SOURCE + "pac32_right_wide.png", IMAGE_SOURCE + "pacman_closed.png" };
    static String[] pacmanSequencesU = { IMAGE_SOURCE + "pac32_up.png", IMAGE_SOURCE + "pac32_up_wide.png",
            IMAGE_SOURCE + "pac32_up_widest.png", IMAGE_SOURCE + "pacman_closed.png" };
    static String[] pacmanSequencesD = { IMAGE_SOURCE + "pac32_down.png", IMAGE_SOURCE + "pac32_down_wide.png",
            IMAGE_SOURCE + "pac32_down_widest.png", IMAGE_SOURCE + "pacman_closed.png" };
    int current = 0;

    // don't move until told
    private char   direction     = 'x';
    boolean        isRunning     = true;
    int            score         = 0;
    
    //Arrays de imagens
    Image[]        pictureUp     = new Image[pacmanSequencesU.length];
    Image[]        pictureRight  = new Image[pacmanSequencesR.length];
    Image[]        pictureLeft   = new Image[pacmanSequencesL.length];
    Image[]        pictureDown   = new Image[pacmanSequencesD.length];
    
    //?
    int            totalPictures = 0;
    
    //Celudas do visual
    Cell[][]       cells;
    int            livesLeft;
    
    //labirinto
    Maze           maze;
    private int    pacmanRow, pacmanCol;
    private String score_string;
    Thread         thread;
    
    //inteligencia
    Logica logica;

    // int pause = 200;
    public Pacman( Maze startMaze, int lives,Logica inte) {
        
        this.logica = inte;
//        pacmanRow = initialRow;
//        pacmanCol = initialColumn;
        
   
        
        maze      = startMaze;
        livesLeft = lives;
        cells     = maze.getCells();

        Toolkit kit = Toolkit.getDefaultToolkit();

        for (int i = 0; i < pacmanSequencesL.length; i++) {
            pictureLeft[i] = kit.getImage(pacmanSequencesL[i]);
        }

        for (int i = 0; i < pacmanSequencesR.length; i++) {
            pictureRight[i] = kit.getImage(pacmanSequencesR[i]);
        }

        for (int i = 0; i < pacmanSequencesU.length; i++) {
            pictureUp[i] = kit.getImage(pacmanSequencesU[i]);
        }

        for (int i = 0; i < pacmanSequencesD.length; i++) {
            pictureDown[i] = kit.getImage(pacmanSequencesD[i]);
        }
    }

    /*
     * Draw Pacman
     *
     */
    public void drawPacman(Graphics g) {
       
        if (direction == 'u') {
            if (current > pictureUp.length - 1) {
                current = 0;
            }

            g.drawImage(pictureUp[current], getRow() * 20, getCol() * 20, 22, 22, maze);
        }

        if (direction == 'd') {
            if (current > pictureDown.length - 1) {
                current = 0;
            }

            g.drawImage(pictureDown[current], getRow() * 20, getCol() * 20, 22, 22, maze);
        }

        if (direction == 'l') {
            if (current > pictureLeft.length - 1) {
                current = 0;
            }

            g.drawImage(pictureLeft[current], getRow() * 20, getCol() * 20, 22, 22, maze);
        }

        if (direction == 'r') {
            if (current > pictureRight.length - 1) {
                current = 0;
            }

            g.drawImage(pictureRight[current], getRow() * 20, getCol() * 20, 22, 22, maze);
        }
        
        
        //current++;
    }

    /*
     * Get the current row
     *
     */
    protected int getRow() {
        return logica.pacmanX();
    }

    /*
     * Get the current column
     *
     */
    protected int getCol() {
        return logica.pacmanY();
    }

    /*
     * Move horizontally
     *
     */
//    protected void moveRow(int x) {
//       if (isCellNavigable(pacmanCol, pacmanRow + x)) {
//            pacmanRow = pacmanRow + x;
//        }
//    }

    /*
     * Move vertically
     *
     */
//    protected void moveCol(int y) {
//        if (isCellNavigable(pacmanCol + y, pacmanRow)) {
//            pacmanCol = pacmanCol + y;
//        }
//    }

    /*
     * Set direction
     *
     */
    public void setDirection(char direction) {
        this.direction = direction;
    }

    /*
     * Run method
     */
    @Override
    public void run() {
        
         
        
        while (isRunning) {
            if (direction == 'u') {
                //moveCol(-1);
               System.out.println(logica.up());
            }

            if (direction == 'd') {
                //moveCol(1);
                System.out.println(logica.down());
            }

            if (direction == 'l') {
                //moveRow(-1);
                System.out.println(logica.left());
            }

            if (direction == 'r') {
                //moveRow(1);
                System.out.println(logica.right());
            }

           direction = logica.pacmanDir();
            
            eatPellet(getCol(), getRow());
            maze.checkCollision();
            maze.repaint();

            try {
                Thread.sleep(135);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }

//  TODO - implement audio

    /**
     * Check if next move will be pellet Detect Collision and "eat pellet"
     *
     */
    public void eatPellet(int column, int row) {
        if (cells[column][row].getType() == 'd') {
            score                   += 10;
            cells[column][row].type = 'o';
            PacmanGUI.newDisp();
        }

        if (cells[column][row].getType() == 'p') {
            score                   += 50;
            cells[column][row].type = 'o';
            PacmanGUI.newDisp();
            maze.setEdible();
        }
    }

    /*
     * Move Pacman
     *
     */
//    public void movePacman(int x, int y) {
//        pacmanRow = pacmanRow + x;
//        pacmanCol = pacmanCol + y;
//        current++;
//        System.out.println("ROW " + pacmanRow + ", COL " + pacmanCol);    // print out current row and column to console
//    }

    /*
     * Check whether a cell is navigable
     *
     */
//    public boolean isCellNavigable(int column, int row) {
////        return ((cells[column][row].getType() == 'o') || (cells[column][row].getType() == 'd')
////                || (cells[column][row].getType() == 'p'));
//        
//        return i.posicao(row,column);
//    }

    /*
     * Get the current score
     *
     */
    public int getScore() {
        return score;
    }

    /*
     * Get number of lives left
     *
     */
    public int getLives() {
        return livesLeft;
    }

    protected void endgame() {
        this.isRunning = false;
    }
}