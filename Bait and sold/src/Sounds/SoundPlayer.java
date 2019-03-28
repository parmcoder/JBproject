package Sounds;

import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
        public static void main(String[] args)
                throws Exception
        {
            String gongFile = "music_lib/gameost.wav";

            // open the sound file as a Java input stream
            try { File file = new File(gongFile);
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(file));
                clip.start(); Thread.sleep(clip.getMicrosecondLength()); }
            catch (Exception e) { System.err.println(e.getMessage()); }

        }
    }


