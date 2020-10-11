import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Difficulty extends JFrame {

  private JPanel contentPane;
  private JFrame current;

  /**
   * Create the frame.
   */
  public Difficulty() {
    this.current = this;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 550);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel veryHardDifficulty = new JLabel("Very hard");
    veryHardDifficulty.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Play frame = new Play(false, 6);
        frame.setVisible(true);
        current.setVisible(false);
        current.dispose();
        
      }
    });
    veryHardDifficulty.setBounds(422, 340, 185, 41);
    contentPane.add(veryHardDifficulty);
    
    JLabel hardDifficulty = new JLabel("Hard");
    hardDifficulty.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Play frame = new Play(false, 5);
        frame.setVisible(true);
        current.setVisible(false);
        current.dispose();
        
      }
    });
    hardDifficulty.setBounds(119, 336, 185, 48);
    contentPane.add(hardDifficulty);
    
    JLabel mediumDifficulty = new JLabel("Medium");
    mediumDifficulty.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Play frame = new Play(false, 4);
        frame.setVisible(true);
        current.setVisible(false);
        current.dispose();
        
      }
    });
    mediumDifficulty.setBounds(537, 221, 185, 48);
    contentPane.add(mediumDifficulty);
    
    JLabel easyDifficulty = new JLabel("Easy");
    easyDifficulty.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Play frame = new Play(false, 3);
        frame.setVisible(true);
        current.setVisible(false);
        current.dispose();
        
      }
    });
    easyDifficulty.setBounds(263, 221, 185, 48);
    contentPane.add(easyDifficulty);
    
    JLabel veryEasyDifficulty = new JLabel("Very easy");
    veryEasyDifficulty.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Play frame = new Play(false, 2);
        frame.setVisible(true);
        current.setVisible(false);
        current.dispose();
        
      }
    });
    veryEasyDifficulty.setBounds(36, 210, 149, 48);
    contentPane.add(veryEasyDifficulty);
    
    JLabel title = new JLabel("Choose Your Difficulty!");
    title.setBounds(273, 68, 342, 61);
    contentPane.add(title);
    
    JLabel Background = new JLabel("");
    Background.setIcon(new ImageIcon(Play.class.getResource("/images/BlueBackgronud.jpg")));
    Background.setBounds(0, 0, 784, 512);
    contentPane.add(Background);
    
    
    
    
  }
}
