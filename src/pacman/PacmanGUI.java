

package pacman;

//~--- JDK imports ------------------------------------------------------------

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class PacmanGUI extends JFrame 
{
    private static JTextField gameDisp;
    private static Maze       gameMaze;

    public void startGUI() {

        // Control Button Declarations
     
        JFrame gameBoard = new JFrame("Pacman");
        gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameMaze = new Maze(this);
        gameBoard.add(gameMaze, BorderLayout.CENTER);
        gameBoard.pack();
        gameBoard.setVisible(true);
    }

    
}
