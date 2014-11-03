/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

public class Ghost extends Thread {
    private static final String IMAGE_SOURCE        = "src/pacman/img/";
    int                         edibleLifetime      = 10;
    boolean                     isRunning           = true;
    int                         edibleLifeRemaining = edibleLifetime;
    boolean                     deadly              = true;
    Cell[][]                    cells;  
    private Image               ghostPicIcon;
    String ghostGraphic;
    private int                 ghostRow, ghostCol;
    private int                 pastRow,pastCol;
    Movimento mov;
    Maze                        maze;
    final int CELL=20;
    Inteligencia stupid;
    Inteligencia smart;
    Inteligencia intel;
    boolean mortal;
    int sleep;

    public Ghost(Maze startMaze, String ghostGraphic ,Inteligencia smart,Inteligencia stupid) 
    {
        this.smart = smart;
        this.stupid = stupid;
        this.intel = smart;
        mortal = false;
        mov = new Movimento();
        ghostRow = intel.getX();
        ghostCol = intel.getY();
        sleep = intel.getSleep();
        maze     = startMaze;
        cells        = maze.getCells();
        this.ghostGraphic = ghostGraphic;
        ghostPicIcon = Toolkit.getDefaultToolkit().getImage(IMAGE_SOURCE + ghostGraphic);
    }

    public void drawGhost(Graphics g) {
        g.drawImage(ghostPicIcon, ghostRow * CELL, ghostCol * CELL, maze);
    }

    
    public int getRow() {
        return intel.getX();
    }

   
    public int getCol() {
        return intel.getY();
    }
    
    public Movimento getMov()
    {
        return mov;
    }

    
    /*
     * Run method
     */
    @Override
    public void run() {
        while (isRunning) {

            // Edible processing
            if (this.deadly == false) {
                this.edibleLifeRemaining--;

                if (this.edibleLifeRemaining <= 0) {
                    this.deadly = true;
                }
            }

            pastRow = ghostRow;
            pastCol = ghostCol;
            intel.proximoMovimento();
            ghostRow = intel.getX();
            ghostCol = intel.getY();
            
            mov.setX1(pastRow);
            mov.setY1(pastCol);
            mov.setX2(ghostRow);
            mov.setY2(ghostCol);
            
            
            maze.repaint();

            try {
                Thread.sleep(intel.getSleep());
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
    
    public void changeIntel()
    {
        if(mortal)
        {
            intel = smart;
            mortal = false;
            ghostPicIcon = Toolkit.getDefaultToolkit().getImage(IMAGE_SOURCE + ghostGraphic);
        }
        else
        {
            intel = stupid;
            mortal = true;
            ghostPicIcon = Toolkit.getDefaultToolkit().getImage(IMAGE_SOURCE + "ghost32.png");
        }
    }
    
    public void matarFantasma(int x,int y,int codGhost)
    {
        intel = new IntelParado(maze.logica,x,y,codGhost);
        ghostPicIcon=null;
    }

    protected void endgame() {
        this.isRunning = false;
    }
}
