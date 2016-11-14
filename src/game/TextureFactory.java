package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureFactory {

	private BufferedImage[] spaceShipImg = new BufferedImage[1];
	private BufferedImage[] shootImg = new BufferedImage[1];
	private BufferedImage[] invaderAImg = new BufferedImage[2];
	private BufferedImage[] invaderBImg = new BufferedImage[2];
	private BufferedImage[] invaderCImg = new BufferedImage[2];

	/**
	 * Instance unique pré-initialisée
	 */
	private static TextureFactory INSTANCE = new TextureFactory();
	
	/**
	 * Constructeur privé 
	 */
	private TextureFactory() {
		try {
			this.spaceShipImg[0] = ImageIO.read(new File("img/Ship.png"));
			this.shootImg[0] = ImageIO.read(new File("img/tire.png"));
			this.invaderAImg[0] = ImageIO.read(new File("img/InvaderA_00.png"));
			this.invaderAImg[1] = ImageIO.read(new File("img/InvaderA_01.png"));
			this.invaderBImg[0] = ImageIO.read(new File("img/InvaderB_00.png"));
			this.invaderBImg[1] = ImageIO.read(new File("img/InvaderB_01.png"));
			this.invaderCImg[0] = ImageIO.read(new File("img/InvaderC_00.png"));
			this.invaderCImg[1] = ImageIO.read(new File("img/InvaderC_01.png"));
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

	public BufferedImage[] getSpaceShipImg() {
		return spaceShipImg;
	}

	public BufferedImage[] getShootImg() {
		return shootImg;
	}

	public BufferedImage[] getInvaderAImg() {
		return invaderAImg;
	}

	public BufferedImage[] getInvaderBImg() {
		return invaderBImg;
	}

	public BufferedImage[] getInvaderCImg() {
		return invaderCImg;
	}
	
}
