package mu.edu.c.audio;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;


public class AudioPlayer {
	static Clip backgroundTrack;
	static float sysVolume = -80;
	static ArrayList<Clip> currentSounds;
	
	/**
	 * Initializes the AudioPlayer. 
	 * Only needs to be ran once across the program.
	 */
	public AudioPlayer() {
		if (currentSounds == null) {
			currentSounds = new ArrayList<Clip>();
		}
	}

	/**
	 * Takes the name of the wav audioFile to play and plays it once.
	 * @param audioFile
	 * @return Clip
	 */
	public static Clip playAudio(String audioFile) {
		try {
            File file = new File("./src/main/resources/audio/"+audioFile+".wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            
            FloatControl gainControl = 
    			    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    		gainControl.setValue(sysVolume);
    		currentSounds.addFirst(clip);
            clip.start();
            return clip;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
	
	/**
	 * Takes the name of the wav audioFile to play and loops it continuously.
	 * @param audioFile
	 */
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
	
	/**
	 * Takes float volume (in decibels) and sets the track volume.
	 * @param volume
	 */
	public static void setTrackVolume(float volume) {
		
		sysVolume = volume;
		FloatControl gainControl = 
			    (FloatControl) backgroundTrack.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume); // Change volume by offset decibels.
	}
	
	/**
	 * Stops the current track
	 */
	public static void stopTrack() {
			
		if(backgroundTrack != null) {
			backgroundTrack.close();
		}
	}
	
	/**
	 * Stops any audio played with playAudio.
	 */
	public static void stopAudio() {
		for(int i=currentSounds.size()-1; i>=0; i--){ 
			if (currentSounds.get(i).isRunning()) {
				currentSounds.get(i).stop();
			}
			currentSounds.remove(i);
		}

	}

	/**
	 * Stops any audio played with playAudio and stops the current track.
	 */
	public static void stopAllAudio() {
		stopTrack();
		stopAudio();
	}
}
