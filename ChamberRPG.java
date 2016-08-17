import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;

public class ChamberRPG {

	public static void main(String[] args){
		int fps = 30;
		int speed = 5;
		int height = 600;
		int width = 800;

		JFrame f = new JFrame("ChamberRPG");
		GameModel model = new GameModel();
		GamePanel panel = new GamePanel(width, height, model);
		PlayerControler keyControler = new PlayerControler(model);
		panel.addKeyListener(keyControler);
		panel.setFocusTraversalKeysEnabled(false);
		model.addObserver(panel);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(width, height);
		f.setBackground(Color.black); // Panel already has so we might be able to remove this
		f.setLocation(70, 70);
		f.setResizable(false);
		f.setContentPane(panel);
		f.setVisible(true);

		panel.repaint();

		TimerTask paintTask = new TimerTask(){
			public void run(){
				panel.repaint();
			}
		};
		Timer paintTimer = new Timer();
		paintTimer.scheduleAtFixedRate(paintTask, 0, 1000/fps);

		TimerTask modelTask = new TimerTask(){
			public void run(){
				model.step();
			}
		};
		Timer modelTimer = new Timer();
		modelTimer.scheduleAtFixedRate(modelTask, 0, 100/speed);
	}
}
