/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.net.*;
import java.awt.image.*;
import javax.swing.*;
import sun.audio.*;

public class Home extends JPanel{
    ImageIcon backgroud = new ImageIcon(this.getClass().getResource("back2.png"));
    ImageIcon start = new ImageIcon(this.getClass().getResource("playbutton.png"));
    //สร้างออปเจ็คไปหน้า เพเกม
    playgame gameplay = new playgame();
    int keyX;
    int keyY;
    AudioStream audios;
    Home(){
        setLayout(null);
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
               if(e.getX() >= 0 && e.getX() <= 920 && e.getY() >=0 && e.getY() <= 625){
                    keyX = e.getX();
                    keyY = e.getY();
                }
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (keyX >= 690 && keyX <= 840 && keyY >= 420 && keyY <= 570) {
                    setSize(1000, 800);
                    add(gameplay);
                    gameplay.setBounds(0, 0, 1000, 800);
                    gameplay.requestFocusInWindow();
                    gameplay.timestart = false;
                    gameplay.score = 0;
                    gameplay.HP = 3;
                    gameplay.times = 90;
                    gameplay.startf = false;
                    gameplay.timestart = false;
                    gameplay.pauseg = 1;
                } 
            }
        });

}
    
    public void paintComponent(Graphics g) {
        //
        // TODO code application logic here
        super.paintComponent(g);
        g.drawImage(backgroud.getImage(),0,0,1000,600,this);
        g.drawImage(start.getImage(),690,420,150,150,this);
        
        
    }
    
}
