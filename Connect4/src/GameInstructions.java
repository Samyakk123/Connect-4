import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * Game Instruction JFrame
 * 
 * @author Aryan Patel, Samyak Metha
 *
 */
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
        setBounds(main.x, main.y, 800, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // JLabel button that takes the user back to the "Start" JFrame and disposes
        // current JFrame
        JLabel Back = new JLabel("");
        Back.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                Start Start = new Start();
                Start.setVisible(true);
                current.dispose();

            }
            public void mouseEntered(MouseEvent arg0) {
                Back.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Back40.png")));
            }
            public void mouseExited(MouseEvent arg0) {
                
                Back.setIcon(new ImageIcon(getClass().getClassLoader().getResource("back40Small.png")));
            }
        });

        JLabel InstructionTitle = new JLabel("");
        InstructionTitle.setIcon(new ImageIcon(getClass().getClassLoader().getResource("GameInstruction.png")));
        InstructionTitle.setBounds(208, 37, 632, 107);
        InstructionTitle.setVisible(true);
        contentPane.add(InstructionTitle);

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
        GameInstructions.setHorizontalAlignment(SwingConstants.CENTER);
        GameInstructions.setFont(new Font("Calibri", Font.PLAIN, 20));
        GameInstructions.setBounds(19, 100, 775, 351);
        contentPane.add(GameInstructions);
        Back.setIcon(new ImageIcon(getClass().getClassLoader().getResource("back40Small.png")));
        Back.setBounds(668, 437, 151, 93);
        contentPane.add(Back);

        // sets the background image
        JLabel label = new JLabel("");
        label.setBackground(Color.WHITE);
        label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("BackImage1.jpg")));
        label.setBounds(-1, 0, 786, 513);
        contentPane.add(label);

        // sets title of JFrame
        JLabel GameInstruction = new JLabel("");
        GameInstruction.setIcon(new ImageIcon(getClass().getClassLoader().getResource("GameI.PNG")));
        GameInstruction.setBounds(183, -13, 508, 157);
        contentPane.add(GameInstruction);

        // Check if application moved
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                main.x = getBounds().x;
                main.y = getBounds().y;

                main.setValues(getBounds().x, getBounds().y);
            }
        });
    }
}
