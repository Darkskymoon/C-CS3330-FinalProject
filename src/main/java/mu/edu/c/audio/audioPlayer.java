package mu.edu.c.audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;


public class audioPlayer {
	static Clip backgroundTrack;
	static float sysVolume = -20;
	
	public static void playAudio(String audioFile) {
        try {
            File file = new File("./src/main/resources/audio/"+audioFile+".wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            
            FloatControl gainControl = 
    			    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    		gainControl.setValue(sysVolume);
   
            clip.start();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
	
	public static void setTrack(String audioFile) {
        try {
        	if(backgroundTrack != null) {
        		backgroundTrack.close();
        	}
            File file = new File("./src/main/resources/audio/"+audioFile+".wav");
            backgroundTrack = AudioSystem.getClip();
            backgroundTrack.open(AudioSystem.getAudioInputStream(file));
            backgroundTrack.loop(Clip.LOOP_CONTINUOUSLY);
            setTrackVolume(sysVolume);
            backgroundTrack.start();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
	
	public static void setTrackVolume(float volume) {
		
		sysVolume = volume;
		FloatControl gainControl = 
			    (FloatControl) backgroundTrack.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume); // Change volume by offset decibels.
	}
	
	public static void stopTrack() {
			
		if(backgroundTrack != null) {
			backgroundTrack.close();
		}
	}
}
