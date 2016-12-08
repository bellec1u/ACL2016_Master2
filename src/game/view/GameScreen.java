package game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.TextureFactory;
import game.World;

/**
 * Project "Space Invader"
 * M1 Informatique 2016/2017
 * @author BELLEC Leopold
 * @author DAUZVARDIS Juozas
 * @author JUNGES Pierre-Marie
 * @author LIPSKI Guillaume
 *
 */
@SuppressWarnings("serial")
public class GameScreen extends JPanel {

    private World world;

    /**
     * FPS Management
     */
    private final int frameDuration = 16; //  1000ms / 60fps (ms value)
    private final double delay = ( 1.0 / 60.0 );
    private Timer timer; // use to call repaint() every frameDuration
    private boolean paused = true;

    public GameScreen(World w) {
        super();
        this.world = w;

        this.setBackground(Color.BLACK);

        // calls paintComponent() each 16 ms
        timer = new Timer(frameDuration, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }

        });
        timer.setRepeats(true);
        timer.start();
    }
    
    public void togglePause() {
        paused = !paused;
    }
    
    public World getWorld() {
        return world;
    }

    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);

        /**
         * si gameOver est a true, le jeu est fini
         */
        if (!this.world.getGameOver()) {
            /*
             * Draws the score
             */
            drawScore(g);
            drawSpaceShipLives(g);

            /*
             * Our Timer calls repaint() method every 16 ms which means we have to
             * update the world with a delta Time equals to ( 1 / 60 ) second = 0.16666 second
             */
            if (!paused) {
                world.update(delay);
            }
            world.render(g);
            
            if (paused) {
                drawPauseScreen(g);
            }

        } else {
            drawGameOver(g);	
        }

    }

    /**
     * @return the abscissa of the centered string on sreen
     */
    private int getCenteredStringX(Graphics g, String str) {
        FontMetrics fm = g.getFontMetrics();
        return World.WIDTH/2 - fm.stringWidth(str)/2;
    }

    /**
     * Sets the Graphics g to draw the Score with a custom Font
     * deriveFont in order to increase font's size
     */
    public void drawScore(Graphics g) {
        g.setFont(TextureFactory.getInstance().getFont().deriveFont(20.0f));
        g.setColor(Color.WHITE);

        String txt = "SCORE " + world.getScore();
        g.drawString(txt, getCenteredStringX(g, txt), (World.HEIGHT - 50));
    }

    public void drawGameOver(Graphics g) {
        String txt;
        g.setFont(TextureFactory.getInstance().getFont().deriveFont(40.0f));
        g.setColor(Color.RED);
        txt = "GAME OVER";
        g.drawString(txt, getCenteredStringX(g, txt), (World.HEIGHT/2-25));
        g.setFont(TextureFactory.getInstance().getFont().deriveFont(20.0f));
        g.setColor(Color.WHITE);
        txt = "SCORE  " + world.getScore();
        g.drawString(txt, getCenteredStringX(g, txt), (World.HEIGHT/2));
        txt = "press  R  to  reset";
        g.drawString(txt, getCenteredStringX(g, txt), (World.HEIGHT/2+40));
    }

    public void drawSpaceShipLives(Graphics g) {
        g.setFont(TextureFactory.getInstance().getFont().deriveFont(20.0f));
        g.setColor(Color.WHITE);
        g.drawImage(TextureFactory.getInstance().getSpaceShipColorImg(), 20, World.HEIGHT - 62, null);
        String txt = "x " + world.getSpaceShip().getLives();
        g.drawString(txt, 45, (World.HEIGHT - 50));
    }
    
    public void drawPauseScreen(Graphics g) {
        g.setColor(new Color(.0f, .0f, .0f, .85f));
        g.fillRect(0, 0, World.WIDTH, World.HEIGHT);
        
        g.setColor(Color.GREEN);
        g.setFont(TextureFactory.getInstance().getFont().deriveFont(40.0f));
        String txt = "PAUSE";
        g.drawString(txt, getCenteredStringX(g, txt), 100);
        
        // Draw commands
        g.setColor(Color.WHITE);
        g.setFont(TextureFactory.getInstance().getMonospacedFont());
        String[] texts = {" ESC    pause", 
                          "  q     quit", 
                          "  →     move right", 
                          "  ←     move left", 
                          "SPACE   shoot"};
        int x = getCenteredStringX(g, texts[2]);
        int y = 130;
        
        for (String str : texts) {
            y += 20;
            g.drawString(str, x, y);
        }
    }
}
