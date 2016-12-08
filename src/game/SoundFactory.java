package game;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public class SoundFactory {

	/**
	 * Instance unique pré-initialisée
	 */
	private static SoundFactory INSTANCE = new SoundFactory();
	
	/**
	 * Attributs pour gérer la musique de fond
	 */
	AudioInputStream audio; 
	Clip backgroundSound;
	
	/**
	 * Constructeur privé
	 */
	private SoundFactory() {
		try {
			audio = AudioSystem.getAudioInputStream(new File("sound/Chinatown.wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, audio.getFormat());
			backgroundSound = (Clip)AudioSystem.getLine(info);
			backgroundSound.open(audio);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.println("audio error");
		} 
	}
	
	public static SoundFactory getInstance() {
		return INSTANCE;
	}
	
	public Clip getBackgroundSound() {
		return backgroundSound;
	}
}
