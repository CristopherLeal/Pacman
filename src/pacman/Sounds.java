/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author lucasmachado
 */
public class Sounds {
    private Clip nomMon;
    private Clip openingsound;
    private Clip eatGhost;
    private Clip pacmandies;
    
    private boolean stopped;
    
    public Sounds() throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        stopped = true;
        URL url;
        AudioInputStream audioIn;
        
        try{
            url = this.getClass().getClassLoader().getResource("src/pacman/sounds/eatGhost.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            eatGhost = AudioSystem.getClip();
            eatGhost.open(audioIn);
            
            url = this.getClass().getClassLoader().getResource("src/pacman/sounds/eat.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            nomMon = AudioSystem.getClip();
            nomMon.open(audioIn);
            
            url = this.getClass().getClassLoader().getResource("src/pacman/sounds/openingsong.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            openingsound = AudioSystem.getClip();
            openingsound.open(audioIn);
            
            url = this.getClass().getClassLoader().getResource("src/pacman/sounds/pac man dies.wav");
            audioIn = AudioSystem.getAudioInputStream(url);
            pacmandies = AudioSystem.getClip();
            pacmandies.open(audioIn);
        } catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){}
    }
    
    public void nomMon(){
        /* If it's already playing, don't start it playing again!*/
        if(!stopped)
            return;
        stopped = false;
        nomMon.stop();
        nomMon.setFramePosition(0);
        nomMon.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    /* Stop pacman eating sound */
    public void nomNomStop(){
        stopped=true;
        nomMon.stop();
        nomMon.setFramePosition(0);
    }
    
     /* Play new game sound */
    public void newGame(){
        openingsound.stop();
        openingsound.setFramePosition(0);
        openingsound.start();
    }
    
    
    /* Play pacman death sound */
    public void death(){
        pacmandies.stop();
        pacmandies.setFramePosition(0);
        pacmandies.start();
    }
}
