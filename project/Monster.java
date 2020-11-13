/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class Monster {
    public ImageIcon[] immonster = new ImageIcon[1];
    public int y=375;
    public int x=695;
    public int count = 0;
    Monster() {
        for (int i = 0; i < immonster.length; i++) {
            String imageLocation ="monster1.png";
            immonster[i] = new ImageIcon(this.getClass().getResource(imageLocation));
        }
    }
    public int getX() {
        return x;

    }
    public int getY() {
        return y;

    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(this.x+100,this.y+100,120,120));
    }
    
}
