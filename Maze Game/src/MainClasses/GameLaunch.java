
package MainClasses;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.Scanner;

public class GameLaunch {

	// Title screen variables
	private JFrame frame2;
	private JTextField txtV;
	private JTextField txtByHamzaRaj;
	public static RunNGun game;
	public static long starttimer;
	
	private static String Name="";
	//Instructions
	public void Info() {
		System.out.println("Get through the maze\nFind a key\nOpen the door\nGet the to treasure");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		
		
		//Asks for user to input name before loading gui
		System.out.println("Hello! What's your name?");
		Name=input.next();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//loads gui
					GameLaunch window = new GameLaunch();
					window.frame2.setVisible(true);
					System.out.println("Ok "+Name+" Here are the rules:");
					window.Info();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public GameLaunch() {
		initialize();
	}

	private void initialize() {
		//loads the jframe
		frame2 = new JFrame();
		//sets dimensions of window
		frame2.setBounds(100, 100, 640, 480);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(GameLaunch.class.getResource("/textures/RUN N GUN LOGO (2).gif")));
		lblNewLabel.setBounds(146, -114, 624, 441);
		frame2.getContentPane().add(lblNewLabel);

		JButton btnStart = new JButton("Start");
		btnStart.setForeground(Color.BLACK);
		btnStart.setBounds(189, 350, 232, 80);
		btnStart.setBackground(Color.LIGHT_GRAY);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				game = new RunNGun("Tile Game!", 1000, 720);
				game.start();
				frame2.dispose();
				starttimer = System.currentTimeMillis();


			}

		});
		frame2.getContentPane().add(btnStart);
		Icon imgIcon = new ImageIcon(this.getClass().getResource("/textures/Brandon (Facing Right).gif"));

		JLabel label = new JLabel(imgIcon);
		label.setBounds(92, 157, 425, 256);
		label.setBackground(Color.WHITE);

		frame2.getContentPane().add(label);

		txtByHamzaRaj = new JTextField();
		txtByHamzaRaj.setForeground(Color.WHITE);
		txtByHamzaRaj.setBackground(Color.DARK_GRAY);
		txtByHamzaRaj.setText("By: Hamza, Raj, Maqil");
		txtByHamzaRaj.setBounds(497, 421, 127, 20);
		frame2.getContentPane().add(txtByHamzaRaj);
		txtByHamzaRaj.setColumns(10);

		txtV = new JTextField();
		txtV.setForeground(Color.WHITE);
		txtV.setBackground(Color.DARK_GRAY);
		txtV.setText("V 1.0");
		txtV.setBounds(0, 421, 36, 20);
		frame2.getContentPane().add(txtV);
		txtV.setColumns(10);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(GameLaunch.class.getResource("/textures/parallax-industria2.0l.png")));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(0, 0, 624, 441);
		frame2.getContentPane().add(label_1);
	}

}
