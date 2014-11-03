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
    // direcao inicial invalida
    private char   direction     = 'x';
    boolean        isRunning     = true;
    int            score         = 0;   
    //Arrays de imagens
    Image[]        pictureUp     = new Image[pacmanSequencesU.length];
    Image[]        pictureRight  = new Image[pacmanSequencesR.length];
    Image[]        pictureLeft   = new Image[pacmanSequencesL.length];
    Image[]        pictureDown   = new Image[pacmanSequencesD.length];
    int            totalPictures = 0;   
    //Celudas do visual
    final int CELL=20;
    Cell[][]       cells;
    int            livesLeft;
    Maze           maze;
    private int    pacmanRow, pacmanCol;
    private int    pastRow,pastCol;
    private Movimento mov;   
    private String score_string;
    Thread         thread;
    Logica logica;

    public Pacman( Maze startMaze, int lives,Logica inte) {
        
        this.logica = inte;
        mov = new Movimento();     
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

    
    public void drawPacman(Graphics g) {
        
        int row = getRow();
        int col = getCol();
       
        if (direction == 'u') {
            if (current > pictureUp.length - 1) {
                current = 0;
            }

            g.drawImage(pictureUp[current], row * CELL, col * CELL, 22, 22, maze);
        }

        if (direction == 'd') {
            if (current > pictureDown.length - 1) {
                current = 0;
            }

            g.drawImage(pictureDown[current], row * CELL, col * CELL, 22, 22, maze);
        }

        if (direction == 'l') {
            if (current > pictureLeft.length - 1) {
                current = 0;
            }

            g.drawImage(pictureLeft[current], row * CELL, col * CELL, 22, 22, maze);
        }

        if (direction == 'r') {
            if (current > pictureRight.length - 1) {
                current = 0;
            }

            g.drawImage(pictureRight[current], row * CELL, col * CELL, 22, 22, maze);
        }
        
        
        current++;
    }

    
    private int getRow() 
    {
        try
        {
            return logica.pacmanX();
        }
        catch(Exception ex)
        {
            System.out.println("pacmanX:" +ex);
            return 1;
        }
    }


    private int getCol() 
    {
        try
        {
        return logica.pacmanY();
        }
        catch(Exception ex)
        {
            System.out.println("pacmanY:"+ex);
            return 1;
        }
    }

    Movimento getMov()
    {
        return mov;
    }
    
    
   
    public void setDirection(char direction) 
    {
        this.direction = direction;
    }

    /*
     * Run method
     */
    @Override
    public void run() {
        
        
        
        while (isRunning) 
       {
           pastRow = logica.pacmanX();
           pastCol = logica.pacmanY();
           
           
            if (direction == 'u') 
            {
                 logica.up();
            }

            if (direction == 'd') 
            {
                logica.down();
            }

            if (direction == 'l') 
            {
                logica.left();
            }

            if (direction == 'r') 
            {
                logica.right();
            }

           direction = logica.pacmanDir();
            
           pacmanRow = logica.pacmanX();
           pacmanCol = logica.pacmanY();
           
           mov.setX1(pastRow);
           mov.setY1(pastCol);
           mov.setX2(pacmanRow);
           mov.setY2(pacmanCol);
           
            eatPellet(getCol(), getRow());
         
           
           
            maze.checkCollision();
            maze.repaint();

            System.out.println("presente:" +pacmanRow+","+pacmanCol);
            System.out.println("passado:" + pastRow+","+pastCol);
            
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
    public void eatPellet(int column, int row) 
    {
        boolean terminou = true;
        if (cells[column][row].getType() == 'd') {
            score                   += 10;
            cells[column][row].type = 'o';
            PacmanGUI.newDisp();
            terminou = false;
        }
        
        if (terminou)
        {
            System.out.println("Win");
        }

        if (cells[column][row].getType() == 'p') {
            score                   += 50;
            cells[column][row].type = 'o';
            PacmanGUI.newDisp();
            maze.setEdible();
        }
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return livesLeft;
    }

    protected void endgame() {
        this.isRunning = false;
    }
}