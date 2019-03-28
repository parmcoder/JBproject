package Sounds;

import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer implements Runnable{
    private String gongFile;// = "music_lib/gameost.wav";
    Clip clip;
    public SoundPlayer(String s){
        gongFile = s;
    }
    @Override
    public void run() {
                // open the sound file as a Java input stream
        try
        {
            File file = new File(gongFile);
            clip = AudioSystem.getClip();
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip.open(sound);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        }
                   // Thread.sleep(clip.getMicrosecondLength());
        catch (Exception e) { System.err.println(e.getMessage()); }
    }
    public void stop(){
        clip.stop();
    }
}




