package game;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
public class TextureFactory {

	private Image[] spaceShipImg = new BufferedImage[1];
	private Image spaceShipColorImg;
	private Image[] shootImg = new BufferedImage[1];
	private Image[] invaderAImg = new BufferedImage[2];
	private Image[] invaderBImg = new BufferedImage[2];
	private Image[] invaderCImg = new BufferedImage[2];
	private Font font;
	private Font monospaced;
	

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
			this.spaceShipColorImg = ImageIO.read(new File("img/Ship_color.png"));
			this.shootImg[0] = ImageIO.read(new File("img/tire.png"));
			this.invaderAImg[0] = ImageIO.read(new File("img/InvaderA_00.png"));
			this.invaderAImg[1] = ImageIO.read(new File("img/InvaderA_01.png"));
			this.invaderBImg[0] = ImageIO.read(new File("img/InvaderB_00.png"));
			this.invaderBImg[1] = ImageIO.read(new File("img/InvaderB_01.png"));
			this.invaderCImg[0] = ImageIO.read(new File("img/InvaderC_00.png"));
			this.invaderCImg[1] = ImageIO.read(new File("img/InvaderC_01.png"));
			this.font = Font.createFont(Font.TRUETYPE_FONT, new File("font/arcade.ttf"));
			this.monospaced = new Font("Monospaced", Font.BOLD, 15);
		} catch (IOException e) {
			System.out.println("image loading error");
		} catch (FontFormatException e) {
			System.out.println("font loading error");
		}
	}

	/**
	 * Point d'accès pour l'instance unique du singleton 
	 * @return
	 */
	public static TextureFactory getInstance() {	
		return INSTANCE;
	}

	public Image[] getSpaceShipImg() {
		return spaceShipImg;
	}
	
	public Image getSpaceShipColorImg() {
        return spaceShipColorImg;
    }

	public Image[] getShootImg() {
		return shootImg;
	}

	public Image[] getInvaderAImg() {
		return invaderAImg;
	}

	public Image[] getInvaderBImg() {
		return invaderBImg;
	}

	public Image[] getInvaderCImg() {
		return invaderCImg;
	}
	
	public Font getFont() {
		return font;
	}
	
	public Font getMonospacedFont() {
	    return monospaced;
	}
	
}
