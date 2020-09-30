
/**this is the main menu of the game. JFrame is created as soon as the program starts
 * @author Aryan, Adarsh 
 */
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Start extends JFrame {

	private JPanel contentPane;
	private JFrame current;

	/**
	 * Start's Class Constructor. Requires no parameters.
	 */
	public Start() {
		// current JFrame variable required to return back to this JFrame once you enter
		// other JFrames
		this.current = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// button that takes user to the "Play" JFrame which displays the game board and
		// where the game is played.
		// Player plays against a computer
		JLabel Computer = new JLabel("");
		Computer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Play frame = new Play(false);
				frame.setVisible(true);
				current.dispose();
			}
		});
		Computer.setIcon(new ImageIcon(Start.class.getResource("/images/Computer.png")));
		Computer.setBounds(522, 454, 282, 64);
		contentPane.add(Computer);

		// JLabel button that takes users to the "gameInstruction" JFrame.
		JLabel Instruction = new JLabel("");
		Instruction.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				gameInstructions newFrame = new gameInstructions(current);
				current.setVisible(false);
				newFrame.setVisible(true);
			}
		});

		Instruction.setIcon(new ImageIcon(Start.class.getResource("/images/cooltext325036038343695.png")));
		Instruction.setBounds(3, 412, 357, 148);
		contentPane.add(Instruction);

		// JLabel button that takes users to the "Play" JFrame which displayers the game
		// board and where the game is played.
		// PLayer will play against another player
		JLabel player = new JLabel("");
		player.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Play frame = new Play(true);
				frame.setVisible(true);
				current.dispose();
			}
		});
		player.setIcon(new ImageIcon(Start.class.getResource("/images/P vs p.png")));
		player.setBounds(620, 394, 171, 64);
		contentPane.add(player);

		// sets the background image
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Start.class.getResource("/images/MainBoard.jpg")));
		label.setBounds(-100, 0, 1032, 511);
		contentPane.add(label);
	}

	// when the program starts, it calls this method which creates a "Start" Window
	// builder JFrame and makes it visible to the user
	public void makeFrame() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
