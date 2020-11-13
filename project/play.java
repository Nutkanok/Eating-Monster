package project;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
public class play extends JFrame implements ActionListener{
    public Home home = new Home();
    public playgame game  = new playgame();
    public int letplaystatus = 0;
    play(){
        ImageIcon icon = new ImageIcon(this.getClass().getResource("icon1.png"));
        this.setIconImage(icon.getImage());
        this.add(home);
    }
    public static void main(String[] args) throws IOException{
        play jframe = new play();
        jframe.setSize(920, 625);
        jframe.setTitle("Eating Monster");
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
