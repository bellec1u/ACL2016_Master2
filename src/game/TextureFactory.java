package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureFactory {

	private BufferedImage spaceShipImg;
	private BufferedImage shootImg;
	private BufferedImage invaderAImg;
	private BufferedImage invaderBImg;
	private BufferedImage invaderCImg;

	/**
	 * Instance unique pré-initialisée
	 */
	private static TextureFactory INSTANCE = new TextureFactory();
	
	/**
	 * Constructeur privé 
	 */
	private TextureFactory() {
		try {
			this.spaceShipImg = ImageIO.read(new File("img/Ship.png"));
			this.shootImg = ImageIO.read(new File("img/tire.png"));
			this.invaderAImg = ImageIO.read(new File("img/InvaderA_00@2x.png"));
			this.invaderBImg = ImageIO.read(new File("img/InvaderB_00@2x.png"));
			this.invaderCImg = ImageIO.read(new File("img/InvaderC_00@2x.png"));
		} catch (IOException e) {
			System.out.println("image loading error");
		}
	}

	/**
	 * Point d'accès pour l'instance unique du singleton 
	 * @return
	 */
	public static TextureFactory getInstance() {	
		return INSTANCE;
	}

	public BufferedImage getSpaceShipImg() {
		return spaceShipImg;
	}

	public BufferedImage getShootImg() {
		return shootImg;
	}

	public BufferedImage getInvaderAImg() {
		return invaderAImg;
	}

	public BufferedImage getInvaderBImg() {
		return invaderBImg;
	}

	public BufferedImage getInvaderCImg() {
		return invaderCImg;
	}
	
}
