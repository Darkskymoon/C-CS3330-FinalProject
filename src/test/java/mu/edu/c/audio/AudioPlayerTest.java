package mu.edu.c.audio;

import javax.sound.sampled.Clip;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class AudioPlayerTest {
	@BeforeAll
	static void setUp() {
		new AudioPlayer();
	}

	@Test
	void testPlayAudio() {
		Clip played = AudioPlayer.playAudio("StartGameSound");
		try {
			TimeUnit.MILLISECONDS.sleep(100);
			assertTrue(played.isRunning());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testPlayAudioBadInput() {
		assertNull(AudioPlayer.playAudio("badInput"));
	}
	
	@Test
	void testSetTrack() {
		AudioPlayer.setTrack("MainGameSound");
		try {
			TimeUnit.MILLISECONDS.sleep(100);
			assertNotNull(AudioPlayer.backgroundTrack);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testSetTrack2() {
		AudioPlayer.setTrack("StartGameSound");
		try {
			TimeUnit.MILLISECONDS.sleep(100);
			assertNotNull(AudioPlayer.backgroundTrack);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testSetTrackBadInput() {
		AudioPlayer.setTrack("badInput");
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertNull(AudioPlayer.backgroundTrack);
	}
	
	@Test
	void testStopTrack() {
		AudioPlayer.stopTrack();
		assertTrue(AudioPlayer.backgroundTrack==null);
		
	}
	
	@Test
	void testStopAudio() {
		AudioPlayer.stopAudio();
		assertTrue(AudioPlayer.currentSounds.size()==0);
		
	}

}
