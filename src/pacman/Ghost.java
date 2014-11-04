package pacman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ghost extends Thread 
{
    private static final String IMAGE_SOURCE        = "src/pacman/img/";
    private final int                 edibleLifetime      = 10;
    private boolean             isRunning           = true;
    private int                 edibleLifeRemaining = edibleLifetime;
    private boolean             deadly              = true;
    private final Cell[][]            cells;  
    private Image               ghostPicIcon;
    private final String              ghostGraphic;
    private int                 ghostRow, ghostCol;
    private int                 pastRow,pastCol;
    private final Movimento           mov;
    private final Maze                maze;
    private final int           CELL=20;
    private final Inteligencia        stupid;
    private final Inteligencia        smart;
    private Inteligencia        intel;
    private boolean             mortal;
    private boolean             dead;
    private final int                 sleep;
    private final int codGhost;

    public Ghost(int ghostCod ,Maze startMaze, String ghostGraphic ,Inteligencia smart,Inteligencia stupid) 
    {
        this.smart = smart;
        this.stupid = stupid;
        this.intel = smart;
       
        this.codGhost=ghostCod;
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

    @Override
    public void run() {
        while (isRunning) {

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

    public void matarFantasma()
    {
        intel = new IntelParado(maze.logica,codGhost);
        ghostPicIcon=null;
        dead=true;
    }
    
    public void recriarFantasma()
    {
        maze.logica.criarFantasma(codGhost);
        dead=false;
        mortal=false;
        intel = smart;
        ghostPicIcon = Toolkit.getDefaultToolkit().getImage(IMAGE_SOURCE + ghostGraphic);
    }
    
    
    protected void endgame() 
    {
        this.isRunning = false;
    }
}
