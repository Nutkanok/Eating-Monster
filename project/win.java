package project;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class win extends JPanel {

    ImageIcon bover = new ImageIcon("winn.png");
    ImageIcon exitover = new ImageIcon("close.png");
    ImageIcon restart = new ImageIcon("playagainbutton.png");
    public JButton BStartover = new JButton(restart);
    public JButton BExitover = new JButton(exitover);
    win() {
        this.setLayout(null);
        add(BExitover);
        add(BStartover);
        BExitover.setBounds(480, 250, 95, 90);
        BStartover.setBounds(320, 240, 130, 110);
    }
    
    @Override
	public void paintComponent(Graphics g){
		  super.paintComponent(g);
		  g.drawImage(bover.getImage(),0,0,1000, 600,this);  
	  }
}
