/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import prolog.Logica;

public class Pacman extends Thread {
    
    private static final String IMAGE_SOURCE     = "src/pacman/img/";
    static String[]             pacmanSequencesL = {IMAGE_SOURCE + "pacman.gif", IMAGE_SOURCE + "pacman-l 1.gif",
            IMAGE_SOURCE + "pacman-l 2.gif", IMAGE_SOURCE + "pacman-l 3.gif",IMAGE_SOURCE + "pacman-l 4.gif",
    IMAGE_SOURCE + "pacman-l 5.gif",IMAGE_SOURCE + "pacman-l 6.gif",IMAGE_SOURCE + "pacman-l 7.gif",IMAGE_SOURCE + "pacman-l 8.gif"};
    static String[] pacmanSequencesR = { IMAGE_SOURCE + "pacman.gif", IMAGE_SOURCE + "pacman-r 1.gif",
            IMAGE_SOURCE + "pacman-r 2.gif", IMAGE_SOURCE + "pacman-r 3.gif",IMAGE_SOURCE + "pacman-r 4.gif",
    IMAGE_SOURCE + "pacman-r 5.gif",IMAGE_SOURCE + "pacman-r 6.gif",IMAGE_SOURCE + "pacman-r 7.gif",IMAGE_SOURCE + "pacman-r 8.gif"};
    static String[] pacmanSequencesU = { IMAGE_SOURCE + "pacman.gif", IMAGE_SOURCE + "pacman-u 1.gif",
            IMAGE_SOURCE + "pacman-u 2.gif", IMAGE_SOURCE + "pacman-u 3.gif",IMAGE_SOURCE + "pacman-u 4.gif",
    IMAGE_SOURCE + "pacman-u 5.gif",IMAGE_SOURCE + "pacman-u 6.gif",IMAGE_SOURCE + "pacman-u 7.gif",IMAGE_SOURCE + "pacman-u 8.gif"};
    static String[] pacmanSequencesD = { IMAGE_SOURCE + "pacman.gif", IMAGE_SOURCE + "pacman-d 1.gif",
            IMAGE_SOURCE + "pacman-d 2.gif", IMAGE_SOURCE + "pacman-d 3.gif",IMAGE_SOURCE + "pacman-d 4.gif",
    IMAGE_SOURCE + "pacman-d 5.gif",IMAGE_SOURCE + "pacman-d 6.gif",IMAGE_SOURCE + "pacman-d 7.gif",IMAGE_SOURCE + "pacman-d 8.gif"};
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
    private final Movimento mov;   
    private String score_string;
    Thread         thread;
    Logica logica;
    private int timer=0;
    private final int intervaloMortal = 50;
    private int sleep;
    
    
    public Pacman( Maze startMaze, int lives,Logica inte) {

        sleep=100;
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

    public void setSleep(int sleep)
    {
        this.sleep=sleep;
    }
    
    /*
     * Run method
     */
    @Override
    public void run() {
        
        
        
        while (isRunning) 
       {
           if(maze.mortal && timer <intervaloMortal)   
                 timer++;
           if(maze.mortal && timer >=intervaloMortal)
           {
               timer=0;
               maze.changeMortal();
           }
           
          
           
            try {
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
                
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Pacman.class.getName()).log(Level.SEVERE, null,ex);
            }
        }
    }

//  TODO - implement audio

    /**
     * Check if next move will be pellet Detect Collision and "eat pellet"
     *
     */
    public void eatPellet(int column, int row) throws InterruptedException 
    {
  
        if (cells[column][row].getType() == 'd') {
            score                   += 10;
            cells[column][row].type = 'o';
              
        }
        
        if (cells[column][row].getType() == 'p' || cells[column][row].getType() == 'b') {
           
            score                   += 50;
            cells[column][row].type = 'o';
            if(!maze.mortal) 
                maze.changeMortal();
            else
                timer=0;
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