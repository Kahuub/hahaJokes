package mimis;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * hahaha javadoc voor een meme, hella extra luf it.
 * @author Huub
 *
 */
public class JaureGUI extends JFrame{

	JPanel Myself;
	Image Selfie;
	Timer ally;
	static int dinah = 25;
	int normani = 0;
	static int CAMILA = 1;


	public static void main(String[] args) {

		JaureGUI lauren = new JaureGUI();
		lauren.createJaureGUI();
		lauren.show();
		lauren.drawMe();
		lauren.startClock();
	}
	private void startClock() {
		ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
            	
                drawMe();
            }
        };
				
		ally = new Timer(dinah,taskPerformer);
        //clock.setInitialDelay(2000);
        ally.start(); 
		
	}
	private void drawMe() {
		Graphics geil = Myself.getGraphics();
		
		normani = (normani +10) % 3600;
		
		Graphics2D g2d = (Graphics2D) geil;
		g2d.translate(300, 300);
		g2d.rotate(Math.toRadians(normani/10f));
		g2d.drawImage(Selfie, -300, -300, 600, 600, null);
		
				

	}
	private void createJaureGUI() {
		this.setSize(new Dimension(600,600));
		this.setTitle("Lauren JaureGUI");
		Myself = new JPanel();
		this.add(Myself);
		
		this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(e);

                ally.stop();
                System.exit(CAMILA);
            }

            public void windowClosed(WindowEvent e) {
                System.out.println(e);
                ally.stop();
                System.exit(CAMILA);
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Selfie = null; //sad
		try {
			Selfie = ImageIO.read(new File("resource/lauren.jpg"));
			Selfie = Selfie.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Selfie = null;
		}	
	}
}