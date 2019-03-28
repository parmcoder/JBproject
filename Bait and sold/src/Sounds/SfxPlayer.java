package Sounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SfxPlayer implements Runnable{
    private String gongFile;// = "music_lib/gameost.wav";
    Clip clip;
    public SfxPlayer(String s){
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
            clip.start();
            Thread.currentThread().sleep(clip.getMicrosecondLength());
            clip.stop();
        }
                   // Thread.sleep(clip.getMicrosecondLength());
        catch (Exception e) { System.err.println(e.getMessage()); }
    }
    public void stop(){
        clip.stop();
    }
}




