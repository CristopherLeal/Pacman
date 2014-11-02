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
    Random                      randGen             = new Random();
    int                         edibleLifeRemaining = edibleLifetime;
    boolean                     deadly              = true;
    Cell[][]                    cells;
    private char                direction;
    private Image               ghostPicIcon;
    private int                 ghostRow, ghostCol;
    Maze                        maze;
    final int CELL=20;
    
    Inteligencia intel;

    public Ghost(int initialRow, int initialColumn, Maze startMaze, String ghostGraphic ,Inteligencia intel) {
        
        this.intel = intel;
        
        ghostRow = initialRow;
        ghostCol = initialColumn;
        maze     = startMaze;

        // livesLeft = lives;
        cells        = maze.getCells();
        ghostPicIcon = Toolkit.getDefaultToolkit().getImage(IMAGE_SOURCE + ghostGraphic);
    }

    public void drawGhost(Graphics g) {
        g.drawImage(ghostPicIcon, ghostRow * CELL, ghostCol * CELL, maze);
    }

    /*
     * Get the current row
     *
     */
    public int getRow() {
        return ghostRow;
    }

    /*
     * Get the current column
     *
     */
    public int getCol() {
        return ghostCol;
    }

    /*
     * Move horizontally
     *
     */
    protected void moveRow(int x) {
        if (isCellNavigable(ghostCol, ghostRow + x)) {
            ghostRow = ghostRow + x;
        }
    }

    /*
     * Move vertically
     *
     */
    protected void moveCol(int y) {
        if (isCellNavigable(ghostCol + y, ghostRow)) {
            ghostCol = ghostCol + y;
        }
    }

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

            // Edible processing
            if (this.deadly == false) {
                this.edibleLifeRemaining--;

                if (this.edibleLifeRemaining <= 0) {
                    this.deadly = true;
                }
            }

            
            intel.proximoMovimento();
            ghostRow = intel.getX();
            ghostCol = intel.getY();

            maze.repaint();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }

    /*
     * Check whether a cell is navigable
     *
     */
    public boolean isCellNavigable(int column, int row) {
        return ((cells[column][row].getType() == 'o') || (cells[column][row].getType() == 'd')
                || (cells[column][row].getType() == 'p'));
    }

    protected void endgame() {
        this.isRunning = false;
    }
}
