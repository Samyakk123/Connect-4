
/**this is the instruction guide. JFrame is created once the "Guide" button is selected in the Start JFrame.
 * @author Aryan, Adarsh 
 */
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameInstructions extends JFrame {

	private JPanel contentPane;
	private JFrame originator;
	private JFrame current;

	/**
	 * gameInstrction's Class Constructor
	 * 
	 * @param originator - JFrame type of the frame it originated from
	 * 
	 */
	public GameInstructions(JFrame originator) {
		this.originator = originator;
		this.current = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// JLabel button that takes the user back to the "Start" JFrame and disposes
		// current JFrame
		JLabel Back = new JLabel("");
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				originator.setVisible(true);
				current.dispose();
			}
		});

		// information embedded with HTML in order to create a multiple line JLabel
		JLabel GameInstructions = new JLabel(
				"<html><p><strong>1</strong>. Game consist of 7 column in which the Player/AI can place a piece&nbsp;in</p>\r\n"
						+ "<p><strong>2</strong>. Each player takes turns in placing pieces</p>\r\n"
						+ "<p>&nbsp;</p>\r\n"
						+ "<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; -<strong>Human Player</strong> must choose the button on top of the board according</p>\r\n"
						+ "<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;to the column they wish to place</p>\r\n"
						+ "<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; -<strong>AI</strong> moves automaically after Human Player's move</p>\r\n"
						+ "<p>&nbsp;</p>\r\n"
						+ "<p><strong>3</strong>. The winner is determined after having 4 consectutive pieces either</p>\r\n"
						+ "<p>&nbsp; &nbsp; horizontally, vertically, or diagonally.&nbsp;</p>");
		GameInstructions.setFont(new Font("Calibri", Font.PLAIN, 23));
		GameInstructions.setBounds(47, 93, 775, 351);
		contentPane.add(GameInstructions);
		Back.setIcon(new ImageIcon(GameInstructions.class.getResource("/images/Back40.png")));
		Back.setBounds(16, 426, 295, 93);
		contentPane.add(Back);

		// sets the background image
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GameInstructions.class.getResource("/images/AnotherBackground.PNG")));
		label.setBounds(-1, 0, 786, 513);
		contentPane.add(label);

		// sets title of JFrame
		JLabel GameInstruction = new JLabel("");
		GameInstruction.setIcon(new ImageIcon(GameInstructions.class.getResource("/images/GameI.PNG")));
		GameInstruction.setBounds(183, -13, 508, 157);
		contentPane.add(GameInstruction);
	}
}
