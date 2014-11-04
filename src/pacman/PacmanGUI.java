

package pacman;

//~--- JDK imports ------------------------------------------------------------

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.*;

class PacmanGUI extends JFrame 
{
    private static JTextField gameDisp;
    private static Maze       gameMaze;

    public void startGUI() throws IOException {

        // Control Button Declarations
     
        JFrame gameBoard = new JFrame("Pacman");
        gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameMaze = new Maze();
        
        gameBoard.add(gameMaze, BorderLayout.CENTER);
        gameBoard.pack();
        gameBoard.setVisible(true);
    }

    
}
