/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ghost extends Thread 
{
    private static final String IMAGE_SOURCE        = "src/pacman/img/";
    private int                 edibleLifetime      = 10;
    private boolean             isRunning           = true;
    private int                 edibleLifeRemaining = edibleLifetime;
    private boolean             deadly              = true;
    private Cell[][]            cells;  
    private Image               ghostPicIcon;
    private String              ghostGraphic;
    private int                 ghostRow, ghostCol;
    private int                 pastRow,pastCol;
    private Movimento           mov;
    private Maze                maze;
    private final int           CELL=20;
    private Inteligencia        stupid;
    private Inteligencia        smart;
    private Inteligencia        intel;
    private boolean             mortal;
    private boolean             dead;
    private int                 sleep;

    public Ghost(Maze startMaze, String ghostGraphic ,Inteligencia smart,Inteligencia stupid) 
    {
        this.smart = smart;
        this.stupid = stupid;
        this.intel = smart;
        mortal = false;
        dead=false;
        mov = new Movimento();
        ghostRow = intel.getX();
        ghostCol = intel.getY();
        sleep = intel.getSleep();
        maze     = startMaze;
        cells        = maze.getCells();
        this.ghostGraphic = ghostGraphic;
        ghostPicIcon = Toolkit.getDefaultToolkit().getImage(IMAGE_SOURCE + ghostGraphic);
    }

    public void drawGhost(Graphics g) 
    {
        g.drawImage(ghostPicIcon, ghostRow * CELL, ghostCol * CELL, maze);
    }

    public int getRow()
    {
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

            try 
            {
                Thread.sleep(intel.getSleep());
            } 
            catch (InterruptedException e) 
            {
                System.err.println(e);
            }
        }
    }
    
    public void changeIntel()
    {
        if(!dead)
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
    }
    
    public void matarFantasma(int x,int y,int codGhost)
    {
        intel = new IntelParado(maze.logica,x,y,codGhost);
        ghostPicIcon=null;
        dead=true;
    }
    public void matarFantasma(int codGhost)
    {
        intel = new IntelParado(maze.logica,codGhost);
        ghostPicIcon=null;
        dead=true;
    }
    protected void endgame() 
    {
        this.isRunning = false;
    }
}
