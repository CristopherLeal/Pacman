

package pacman;

//~--- JDK imports ------------------------------------------------------------

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

class PacmanGUI extends JFrame 
{
    private static JTextField gameDisp;
    private static Maze       gameMaze;

    public void startGUI() {

        // Control Button Declarations
     
        JFrame gameBoard = new JFrame("Pacman");
        gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            gameMaze = new Maze();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PacmanGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(PacmanGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PacmanGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        gameBoard.add(gameMaze, BorderLayout.CENTER);
        gameBoard.pack();
        gameBoard.setVisible(true);
    }

    
}
