package interfaces;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jl.player.Player;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30];

	public Sound() {
		soundURL[0] = getClass().getResource("./songs/selector.wav");
	}

	public void setFile(File sonido) {

		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(sonido);
			clip = AudioSystem.getClip();
			clip.open(ais);

		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void play() {
		clip.start();

	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		clip.stop();
	}

}
