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
  private JLabel easyDifficulty, easyDifficultySmall;
 

  /**
   * Create the frame.
   */
  public Difficulty() {
    this.current = this;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 551);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel veryHardDifficulty = new JLabel("");
    veryHardDifficulty.setIcon(new ImageIcon(Difficulty.class.getResource("/images/VeryHardBig.png")));
    veryHardDifficulty.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Play frame = new Play(false, 6);
        frame.setVisible(true);
        current.setVisible(false);
        current.dispose();
        
      }
    });
    
    JLabel veryEasyDifficulty = new JLabel("");
    veryEasyDifficulty.setIcon(new ImageIcon(Difficulty.class.getResource("/images/VeryEasyBig.png")));
    veryEasyDifficulty.setVisible(true);
    veryEasyDifficulty.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Play frame = new Play(false, 2);
        frame.setVisible(true);
        current.setVisible(false);
        current.dispose();
        
      }
    });
    
    JLabel easyDifficultySmall = new JLabel("");
    easyDifficultySmall.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            easyDifficulty.setVisible(true);
            easyDifficultySmall.setVisible(false);
        }
        public void mouseExited(MouseEvent e) {
            easyDifficulty.setVisible(false);
            easyDifficultySmall.setVisible(true);
        }
    });
    easyDifficultySmall.setIcon(new ImageIcon(Difficulty.class.getResource("/images/EasySmall.png")));
    easyDifficultySmall.setBounds(105, 186, 112, 92);
    contentPane.add(easyDifficultySmall);
    veryEasyDifficulty.setBounds(201, 322, 137, 111);
    contentPane.add(veryEasyDifficulty);
    veryHardDifficulty.setBounds(412, 322, 158, 111);
    contentPane.add(veryHardDifficulty);
    easyDifficultySmall.setVisible(true);
    
    JLabel hardDifficulty = new JLabel("");
    hardDifficulty.setIcon(new ImageIcon(Difficulty.class.getResource("/images/HardBig.png")));
    hardDifficulty.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Play frame = new Play(false, 5);
        frame.setVisible(true);
        current.setVisible(false);
        current.dispose();
        
      }
    });
    hardDifficulty.setBounds(528, 207, 158, 61);
    contentPane.add(hardDifficulty);
    
    JLabel mediumDifficulty = new JLabel("");
    mediumDifficulty.setIcon(new ImageIcon(Difficulty.class.getResource("/images/MediumBig.png")));
    mediumDifficulty.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Play frame = new Play(false, 4);
        frame.setVisible(true);
        current.setVisible(false);
        current.dispose();
        
      }
    });
    mediumDifficulty.setBounds(278, 207, 218, 61);
    contentPane.add(mediumDifficulty);
    
    easyDifficulty = new JLabel("");
    easyDifficulty.setIcon(new ImageIcon(Difficulty.class.getResource("/images/EasyBig.png")));
    easyDifficulty.setVisible(false);
    easyDifficulty.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        Play frame = new Play(false, 3);
        frame.setVisible(true);
        current.setVisible(false);
        current.dispose();
        
      }
      public void mouseEntered(MouseEvent e) {
          easyDifficulty.setVisible(true);
          easyDifficultySmall.setVisible(false);
      }
      public void mouseExited(MouseEvent e) {
          easyDifficulty.setVisible(false);
          easyDifficultySmall.setVisible(true);
      }
    });
    easyDifficulty.setBounds(95, 207, 137, 61);
    contentPane.add(easyDifficulty);
    
    JLabel title = new JLabel("");
    title.setVisible(true);
    title.setIcon(new ImageIcon(Difficulty.class.getResource("/images/ChooseDifficulty.png")));
    title.setBounds(52, 47, 692, 61);
    contentPane.add(title);
    
    JLabel Background = new JLabel("");
    Background.setIcon(new ImageIcon(Play.class.getResource("/images/BlueBackgronud.jpg")));
    Background.setBounds(0, 0, 784, 512);
    contentPane.add(Background);
    
    JLabel mediumDfficultySmall = new JLabel("");
    mediumDfficultySmall.setIcon(new ImageIcon(Difficulty.class.getResource("/images/MediumSmall.png")));
    mediumDfficultySmall.setBounds(346, 224, 61, 16);
    contentPane.add(mediumDfficultySmall);
    
    JLabel hardDifficultySmall = new JLabel("");
    hardDifficultySmall.setIcon(new ImageIcon(Difficulty.class.getResource("/images/HardSmall.png")));
    hardDifficultySmall.setBounds(564, 224, 61, 16);
    contentPane.add(hardDifficultySmall);
    
    JLabel veryEasyDifficultySmall = new JLabel("");
    veryEasyDifficultySmall.setIcon(new ImageIcon(Difficulty.class.getResource("/images/VeryEasySmall.png")));
    veryEasyDifficultySmall.setBounds(235, 364, 61, 16);
    contentPane.add(veryEasyDifficultySmall);
    
    JLabel veryHardDifficultySmall = new JLabel("");
    veryHardDifficultySmall.setIcon(new ImageIcon(Difficulty.class.getResource("/images/VeryHardSmall.png")));
    veryHardDifficultySmall.setBounds(448, 364, 61, 16);
    contentPane.add(veryHardDifficultySmall);
    
    
    
    
  }
}
