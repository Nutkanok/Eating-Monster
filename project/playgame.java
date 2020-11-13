package project;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class playgame extends JPanel {
    int keyX;
    int keyY;
    int form = 1;
    int state = 1;
    ImageIcon play = new ImageIcon(this.getClass().getResource("playbutton.png"));
    ImageIcon imglevel1 = new ImageIcon(this.getClass().getResource("bg1.png"));
    ImageIcon imglevel2 = new ImageIcon(this.getClass().getResource("bg2.png"));
    ImageIcon imglevel3 = new ImageIcon(this.getClass().getResource("bg3.png"));
    ImageIcon imgwin = new ImageIcon(this.getClass().getResource("winn.png"));
    ImageIcon pause = new ImageIcon(this.getClass().getResource("pausebutton.png"));
    ImageIcon resume = new ImageIcon(this.getClass().getResource("playbutton.png"));
    ImageIcon heart = new ImageIcon(this.getClass().getResource("heart1.png"));
    ImageIcon win = new ImageIcon(this.getClass().getResource("winn.png"));
    ImageIcon imgover = new ImageIcon(this.getClass().getResource("GAME OVER.png"));
    ImageIcon restart = new ImageIcon(this.getClass().getResource("playagainbutton.png"));
    ImageIcon  close = new ImageIcon(this.getClass().getResource("exit1.png"));
    Image[] hart=new Image[3];
    
    public int random = 0;
    public int score = 0;
    
    Monster aa = new Monster();
    
    JLabel Tscore = new JLabel();
    ArrayList<hotdog> hotdogl = new ArrayList<hotdog>();//+10
    ArrayList<hamburger> hamburgerl = new ArrayList<hamburger>();//+50
    ArrayList<pizza> pizzal = new ArrayList<pizza>();//+20
    ArrayList<cheese> cheesel = new ArrayList<cheese>();//+20
    ArrayList<donut> donutl = new ArrayList<donut>();//+20
    ArrayList<unji> unjil = new ArrayList<unji>(); //-1 ชีวิต
    ArrayList<chili> chilil = new ArrayList<chili>();
    ArrayList<mold> moldl = new ArrayList<mold>(); // -20score,-1ชีวิต
    ArrayList<coinplus> coinplusl = new ArrayList<coinplus>(); //นาฬิกา +time
    
    //unji u = new unji();
    int times;
    int HP;
    boolean timestart;
    boolean startf;
    int scores = 0;
    int pauseg;
    Thread all = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                    }
                    repaint();
                }
            }
        }
    });
    Thread thotdog = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (pauseg == 0) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        hotdogl.add(new hotdog());
                    }
                }
            }
        }
    });
    Thread thamburger = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        hamburgerl.add(new hamburger());
                    }
                }
            }
        }
    });
    Thread tpizza = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        pizzal.add(new pizza());
                    }
                }
            }
        }
    });
    Thread tcheese = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        cheesel.add(new cheese());
                    }
                }
            }
        }
    });
    Thread tdonut = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        donutl.add(new donut());
                    }
                }
            }
        }
    });
    Thread tchili = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        chilil.add(new chili());
                    }
                }
            }
        }
    });
    Thread tunji = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        unjil.add(new unji());
                    }
                }
            }
        }
    });
    Thread tmold = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 20000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        moldl.add(new mold());
                    }
                }
            }
        }
    });
    Thread tcoinplus = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 200);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        coinplusl.add(new coinplus());
                    }
                }
            }
        }
    });
    Thread t = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    if (timestart == false) {
                        times = (times - 1);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });
    //คอนสตัคเจอร์
    playgame() {
        this.setFocusable(true);
        this.setLayout(null);
        this.add(Tscore);
        
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();
                if (score >= 0 && score < 200) {
                
                    if(pauseg == 1){
                        System.out.println(pauseg);
                    if (a == KeyEvent.VK_LEFT) {
                        aa.x -= 10;
                        form = 1;
                    } else if (a == KeyEvent.VK_RIGHT) {
                        aa.x += 10;
                        form = 0;
                    }
                    if (aa.count > 3) {
                        aa.count = 0;
                    }
                    }
                }
                else{
                    if(pauseg == 1){
                        System.out.println(pauseg);
                    if (a == KeyEvent.VK_UP) {
                        aa.y -= 10;
                        form = 1;
                    } else if (a == KeyEvent.VK_DOWN) {
                        aa.y += 10;
                        form = 0;
                    }
                    if (aa.count > 3) {
                        aa.count = 0;                                                    
                    }
                    }
                }
            }
        
            public void keyReleased(KeyEvent e) {
                aa.count = 0;
            }
        });
        
//        else{
//             this.addKeyListener(new KeyAdapter() {
//            public void keyPressed(KeyEvent e) {
//                int a = e.getKeyCode();
//                if(pauseg == 1){
//                    System.out.println(pauseg);
//                if (a == KeyEvent.VK_LEFT) {
//                    aa.x -= 10;
//                    form = 1;
//                } else if (a == KeyEvent.VK_RIGHT) {
//                    aa.x += 10;
//                    form = 0;
//                }
//                if (aa.count > 3) {
//                    aa.count = 0;
//                }
//                }
//            }
//        
//            public void keyReleased(KeyEvent e) {
//                aa.count = 0;
//            }
//        });
//            
//        }
        for(int i=0;i<hart.length;i++){
            String heart = "heart"+(i+1)+".png";
            URL imageURL = this.getClass().getResource(heart);
            hart[i]= Toolkit.getDefaultToolkit().getImage(imageURL);
        }
        HP=3;
        aa.x = 400; 
        all.start();
        t.start();
        thotdog.start();
        thamburger.start();
        tpizza.start();
        tcheese.start();
        tdonut.start();
        tchili.start();
        tunji.start();
        tmold.start();
        tcoinplus.start();
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                keyX = e.getX();
                keyY = e.getY();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
           
            @SuppressWarnings("empty-statement")
            //ปุ่มควบคุม พวก play stop 
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); 
                if (keyX >= 850 && keyX <= 890 && keyY >= 30 && keyY <= 70) {
                    System.exit(0);
                } 
                else if (keyX >= 850 && keyX <= 890 && keyY >= 100 && keyY <= 140) {
                    pauseg = 0;
                    setSize(1000, 800);
                    requestFocusInWindow();
                    System.out.println(pauseg);
                    t.suspend();
                    all.suspend();
                    thotdog.suspend();
                    thamburger.suspend();
                    tpizza.suspend();
                    tcheese.suspend();
                    tdonut.suspend();
                    tunji.suspend();
                    tchili.suspend();
                    tmold.suspend();
                    tcoinplus.suspend();
                    if (!hotdogl.isEmpty()) {
                        for (int i = 0; i < hotdogl.size(); i++) {
                            hotdogl.get(i).runner.suspend();
                        }
                    }
                    if (!hamburgerl.isEmpty()) {
                        for (int i = 0; i < hamburgerl.size(); i++) {
                            hamburgerl.get(i).runner.suspend();
                        }
                    }
                    if (!cheesel.isEmpty()) {
                        for (int i = 0; i < cheesel.size(); i++) {
                            cheesel.get(i).runner.suspend();
                        }
                    }
                    if (!pizzal.isEmpty()) {
                        for (int i = 0; i < pizzal.size(); i++) {
                            pizzal.get(i).runner.suspend();
                        }
                    }
             
                    if (!chilil.isEmpty()) {
                        for (int i = 0; i < chilil.size(); i++) {
                           chilil.get(i).runner.suspend();
                        }
                    }
                    if (!donutl.isEmpty()) {
                        for (int i = 0; i < donutl.size(); i++) {
                            donutl.get(i).runner.suspend();
                        }
                    }
                    if (!unjil.isEmpty()) {
                        for (int i = 0; i < unjil.size(); i++) {
                            unjil.get(i).runner.suspend();
                        }
                    }
                    if (!moldl.isEmpty()) {
                        for (int i = 0; i < moldl.size(); i++) {
                            moldl.get(i).runner.suspend();
                        }
                    }
                    if (!coinplusl.isEmpty()) {
                        for (int i = 0; i < coinplusl.size(); i++) {
                            coinplusl.get(i).runner.suspend();
                        }
                    }
                } else if (keyX >= 850 && keyX <= 890 && keyY >= 165 && keyY <= 210) {
                    setSize(1000, 800);
                    requestFocusInWindow();
                    pauseg = 1;
                    System.out.println(pauseg);
                    t.resume();
                    all.resume();
                    thotdog.resume();
                    t.resume();
                    thamburger.resume();
                    tpizza.resume();
                    tcheese.resume();
                    tdonut.resume();
                    tunji.resume();
                    tchili.resume();
                    tmold.resume();
                    tcoinplus.resume();
                    if (!hotdogl.isEmpty()) {
                        for (int i = 0; i < hotdogl.size(); i++) {
                            hotdogl.get(i).runner.resume();;
                        }
                    }
                    if (!hamburgerl.isEmpty()) {
                        for (int i = 0; i < hamburgerl.size(); i++) {
                            hamburgerl.get(i).runner.resume();;
                        }
                    }
                    if (!pizzal.isEmpty()) {
                        for (int i = 0; i < pizzal.size(); i++) {
                           pizzal.get(i).runner.resume();;
                        }
                    }
                    if (!cheesel.isEmpty()) {
                        for (int i = 0; i < cheesel.size(); i++) {
                            cheesel.get(i).runner.resume();;
                        }
                    }
                    if (!donutl.isEmpty()) {
                        for (int i = 0; i < donutl.size(); i++) {
                            donutl.get(i).runner.resume();;
                        }
                    }
                    if (!unjil.isEmpty()) {
                        for (int i = 0; i < unjil.size(); i++) {
                            unjil.get(i).runner.resume();;
                        }
                    }
                    if (!moldl.isEmpty()) {
                        for (int i = 0; i < moldl.size(); i++) {
                            moldl.get(i).runner.resume();;
                        }
                    }
                    if (!coinplusl.isEmpty()) {
                        for (int i = 0; i < coinplusl.size(); i++) {
                            coinplusl.get(i).runner.resume();;
                        }
                    }
                    if (!chilil.isEmpty()) {
                        for (int i = 0; i < chilil.size(); i++) {
                            chilil.get(i).runner.resume();;
                        }
                    }
                } else if (keyX >= 330 && keyX <= 470 && keyY >= 322 && keyY <= 422) {
                    Home bb = new Home();
                    add(bb);
                    bb.setBounds(0, 0, 1000, 800);
                    bb.setFocusable(true);
                    bb.requestFocusInWindow();
                }
                  else if (keyX >= 550 && keyX <=630 && keyY >= 322 && keyY <= 422) {
                    System.exit(0);
                }
            }
        });
    }
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //LOSE
        if (times <= 0 || HP <= 0) {
            this.setLayout(null);
            g.drawImage(imgover.getImage(), 0, 0, 1000, 600, this);
            g.setColor(Color.WHITE);
        }
        //WIN
        else if (score >= 500) {
            this.setLayout(null);
            t.stop();
            g.drawImage(win.getImage(), 0, 0, 920, 625, this);
        }
        //=================level2===============//
        else if (score >= 200 && score < 400) {
            state = 2;
            g.drawImage(imglevel2.getImage(), 0, 0, 1000, 600, this);
            g.drawImage(pause.getImage(), 830, 100, 60, 60, this);
            g.drawImage(resume.getImage(), 830, 170, 60, 60, this);
            g.drawImage(close.getImage(), 830, 30, 60, 60, this);
            g.drawImage(aa.immonster[0].getImage(), aa.x, aa.y, 350, 300, this);
            if(HP==3){
                g.drawImage(hart[2], 30, 0,250,70, this);
            }
            else if(HP==2){
                g.drawImage(hart[1], 30, 0,250,70, this);
            }
            else if(HP==1){
                g.drawImage(hart[0], 30, 0,250,70, this);
            }
            
            if (aa.x <= -200) {
                aa.x = this.getWidth() - 20;
            }
            if (aa.x > this.getWidth() + 20) {
                aa.x = -100;
            }
            //------------hotdog-----------------//
            for (int i = 0; i < hotdogl.size(); i++) {
                hotdogl.get(i).state = 2;
                g.drawImage(hotdogl.get(i).getImage(), hotdogl.get(i).getX(), hotdogl.get(i).getY(), 120, 120, this);
            }
            for (int i = 0; i < hotdogl.size(); i++) {
                if (Intersect(aa.getbound(), hotdogl.get(i).getbound())) {
                    hotdogl.remove(i);
                    score += 10;
                    g.drawString("+10", aa.x + 100, 650);
                }
                if(hotdogl.get(i).getX() > 800){
                    hotdogl.remove(i);
                }
            }
            // ------------hamburger--------------------//
            for (int i = 0; i < hamburgerl.size(); i++) {
                hamburgerl.get(i).state = 2;
                g.drawImage(hamburgerl.get(i).getImage(), hamburgerl.get(i).getX(), hamburgerl.get(i).getY(), 150, 150, this);
            }
            for (int i = 0; i < hamburgerl.size(); i++) {
                if (Intersect(aa.getbound(), hamburgerl.get(i).getbound())) {
                    hamburgerl.remove(i);
                    score += 50;
                    g.drawString("+50", aa.x + 10, 650);
                }
                if(hamburgerl.get(i).getX() > 800){
                    hamburgerl.remove(i);
                }
            }
            //--------pizza--------//
            for (int i = 0; i < pizzal.size(); i++) {
                pizzal.get(i).state = 2;
                g.drawImage(pizzal.get(i).getImage(), pizzal.get(i).getX(), pizzal.get(i).getY(), 200, 200, this);
            }
            for (int j = 0; j < pizzal.size(); j++) {
                if (Intersect(aa.getbound(), pizzal.get(j).getbound())) {
                    pizzal.remove(j);
                    score += 20;
                    g.drawString("+20", aa.x + 100, 650);
                }
                if(pizzal.get(j).getX() > 800){
                    pizzal.remove(j);
                }
            }
            //---------cheese------------//
            for (int i = 0; i < cheesel.size(); i++) {
                cheesel.get(i).state = 2;
                g.drawImage(cheesel.get(i).getImage(), cheesel.get(i).getX(), cheesel.get(i).getY(), 150,150, this);
            }
            for (int j = 0; j < cheesel.size(); j++) {
                if (Intersect(aa.getbound(),cheesel.get(j).getbound())) {
                    cheesel.remove(j);
                    score += 30;
                    g.drawString("+30", aa.x + 100, 650);
                }
                if(cheesel.get(j).getX() > 800){
                    cheesel.remove(j);
                }
            }
            //-------donut-------//
            for (int i = 0; i < donutl.size(); i++) {
                donutl.get(i).state = 2;
                g.drawImage(donutl.get(i).getImage(), donutl.get(i).getX(), donutl.get(i).getY(), 200, 200, this);
            }
            for (int j = 0; j < donutl.size(); j++) {
                if (Intersect(aa.getbound(), donutl.get(j).getbound())) {
                    donutl.remove(j);
                    score += 30;
                    g.drawString("+30", aa.x + 100, 650);
                }
                if(donutl.get(j).getX() > 800){
                    donutl.remove(j);
                }
            }
            //-----chili--------//
            for (int i = 0; i <chilil.size(); i++) {
                chilil.get(i).state = 2;
                g.drawImage(chilil.get(i).getImage(), chilil.get(i).getX(), chilil.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < chilil.size(); j++) {
                if (Intersect(aa.getbound(), chilil.get(j).getbound())) {
                    chilil.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                    g.drawString("-20", aa.x + 100, 650);
                }
                if(chilil.get(j).getX() > 800){
                    chilil.remove(j);
                }
            }
            //-------mold-----//
            for (int i = 0; i < moldl.size(); i++) {
                moldl.get(i).state = 2;
                g.drawImage(moldl.get(i).getImage(), moldl.get(i).getX(), moldl.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < moldl.size(); j++) {
                if (Intersect(aa.getbound(), moldl.get(j).getbound())) {
                    moldl.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                    g.drawString("-20", aa.x + 100, 650);
                }
                if(moldl.get(j).getX() > 800){
                    moldl.remove(j);
                }
            }
            // ----------------unji-------------//
            for (int i = 0; i < unjil.size(); i++) {
                unjil.get(i).state = 2;
                g.drawImage(unjil.get(i).getImage(), unjil.get(i).getX(), unjil.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < unjil.size(); j++) {
                if (Intersect(aa.getbound(), unjil.get(j).getbound())) {
                    unjil.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                    
                }
                if(unjil.get(j).getX() > 800){
                    unjil.remove(j);
                }
            }
            //------coinplus-------//
            for (int i = 0; i < coinplusl.size(); i++) {
                coinplusl.get(i).state = 2;
                g.drawImage(coinplusl.get(i).getImage(), coinplusl.get(i).getX(), coinplusl.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < coinplusl.size(); j++) {
                if (Intersect(aa.getbound(), coinplusl.get(j).getbound())) {
                    coinplusl.remove(j);
                    times += 5;
                }
                if(coinplusl.get(j).getX() > 800){
                    coinplusl.remove(j);
                }
            }
            g.setFont(new Font("Cooper Black", Font.HANGING_BASELINE, 30));
            g.setColor(Color.gray);
            g.drawString("SCORE :  " + score, 110, 155);
            g.setFont(new Font("Cooper Black", Font.HANGING_BASELINE, 30));
            g.drawString("Time " + times, 130, 249);
            //g.drawString("HP  " + HP, 100, 200);
//            g.drawImage(aa.immonster[form].getImage(), aa.x, aa.y, 300, 240, this);
        }
            //=============level3============//
        else if (score >= 400 && score < 500) {
            state = 3;
            g.drawImage(imglevel3.getImage(), 0, 0, 1000, 600, this);
            g.drawImage(pause.getImage(), 830, 100, 60, 60, this);
            g.drawImage(resume.getImage(), 830, 170, 60, 60, this);
            g.drawImage(close.getImage(), 830, 30, 60, 60, this);
            g.drawImage(aa.immonster[0].getImage(),aa.x, aa.y, 350, 300, this);
            if(HP==3){
                g.drawImage(hart[2], 30, 0,250,70, this);
            }
            else if(HP==2){
                g.drawImage(hart[1], 30, 0,250,70, this);
            }
            else if(HP==1){
                g.drawImage(hart[0], 30, 0,250,70, this);
            }
            if (aa.x <= -200) {
                aa.x = this.getWidth() - 20;
            }
            if (aa.x > this.getWidth() + 20) {
                aa.x = -100;
            }
            //-------hotdog-------//
           for (int i = 0; i < hotdogl.size(); i++) {
                hotdogl.get(i).state = 3;
                g.drawImage(hotdogl.get(i).getImage(), hotdogl.get(i).getX(), hotdogl.get(i).getY(), 120, 120, this);
            }
            for (int i = 0; i < hotdogl.size(); i++) {
                if (Intersect(aa.getbound(), hotdogl.get(i).getbound())) {
                    hotdogl.remove(i);
                    score += 10;
                    g.drawString("+10", aa.x + 10, 650);
                }
                if(hotdogl.get(i).getX() > 800){
                    hotdogl.remove(i);
                }
            }
            //------hamburger-----//
            for (int i = 0; i < hamburgerl.size(); i++) {
                hamburgerl.get(i).state = 3;
                g.drawImage(hamburgerl.get(i).getImage(), hamburgerl.get(i).getX(), hamburgerl.get(i).getY(), 150, 150, this);
            }
            for (int i = 0; i < hamburgerl.size(); i++) {
                if (Intersect(aa.getbound(), hamburgerl.get(i).getbound())) {
                    hamburgerl.remove(i);
                    score += 50;
                    g.drawString("+50", aa.x + 10, 650);
                }
                if(hamburgerl.get(i).getX() > 800){
                    hamburgerl.remove(i);
                }
            }
            //-------pizza------//
            for (int i = 0; i < pizzal.size(); i++) {
                pizzal.get(i).state = 3;
                g.drawImage(pizzal.get(i).getImage(), pizzal.get(i).getX(), pizzal.get(i).getY(), 200, 200, this);
            }
            for (int j = 0; j < pizzal.size(); j++) {
                if (Intersect(aa.getbound(), pizzal.get(j).getbound())) {
                    pizzal.remove(j);
                    score += 20;
                    g.drawString("+20", aa.x + 100, 650);
                }
                if(pizzal.get(j).getX() > 800){
                    pizzal.remove(j);
                }
            }
            //----cheese----//
            for (int i = 0; i < cheesel.size(); i++) {
                cheesel.get(i).state = 3;
                g.drawImage(cheesel.get(i).getImage(),cheesel.get(i).getX(), cheesel.get(i).getY(), 150, 150, this);
            }
            for (int j = 0; j < cheesel.size(); j++) {
                if (Intersect(aa.getbound(), cheesel.get(j).getbound())) {
                    cheesel.remove(j);
                    score += 30;
                    g.drawString("+30", aa.x + 100, 650);
                }
                if(cheesel.get(j).getX() > 800){
                    cheesel.remove(j);
                }
            }
            //-----donut------//
            for (int i = 0; i < donutl.size(); i++) {
                donutl.get(i).state = 3;
                g.drawImage(donutl.get(i).getImage(),donutl.get(i).getX(), donutl.get(i).getY(), 150, 150, this);
            }
            for (int j = 0; j < donutl.size(); j++) {
                if (Intersect(aa.getbound(), donutl.get(j).getbound())) {
                    donutl.remove(j);
                    score += 30;
                    g.drawString("+30", aa.x + 100, 650);
                }
                if(donutl.get(j).getX() > 800){
                    donutl.remove(j);
                }
            }
            //---mold----//
            for (int i = 0; i < moldl.size(); i++) {
                moldl.get(i).state = 3;
                g.drawImage(moldl.get(i).getImage(), moldl.get(i).getX(), unjil.get(i).getY(), 200, 200, this);
            }
            for (int j = 0; j < moldl.size(); j++) {
                if (Intersect(aa.getbound(), moldl.get(j).getbound())) {
                    moldl.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                    g.drawString("-20", aa.x + 100, 650);
                }
                if(moldl.get(j).getX() > 800){
                    moldl.remove(j);
                }
            }
            //----unji-----//
            for (int i = 0; i < unjil.size(); i++) {
                unjil.get(i).state = 2;
                g.drawImage(unjil.get(i).getImage(), unjil.get(i).getX(), unjil.get(i).getY(), 100, 100, this);
            }
            for (int j = 0; j < unjil.size(); j++) {
                if (Intersect(aa.getbound(), unjil.get(j).getbound())) {
                    unjil.remove(j);
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                    
                }
                if(unjil.get(j).getX() > 800){
                    unjil.remove(j);
                }
            }
            
            //-----coinplus-----//
            for (int i = 0; i < coinplusl.size(); i++) {
                coinplusl.get(i).state = 3;
                g.drawImage(coinplusl.get(i).getImage(), coinplusl.get(i).getX(), coinplusl.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < coinplusl.size(); j++) {
                if (Intersect(aa.getbound(), coinplusl.get(j).getbound())) {
                    coinplusl.remove(j);
                    times += 5;
                }
                if(coinplusl.get(j).getX() > 800){
                    coinplusl.remove(j);
                }
            }
            g.setFont(new Font("Cooper Black", Font.HANGING_BASELINE, 30));
            g.setColor(Color.white);
            g.drawString("SCORE :  " + score, 83, 140);
            g.setFont(new Font("Cooper Black", Font.HANGING_BASELINE, 28));
            g.drawString("Time " + times, 83, 215);
          }
        else {
            //===================level 1==================== //
            g.drawImage(imglevel1.getImage(), 0, 0, 1000, 600, this);
            g.drawImage(pause.getImage(), 830, 100, 60, 60, this);
            g.drawImage(resume.getImage(), 830, 170, 60, 60, this);
            g.drawImage(close.getImage(), 830, 30, 60, 60, this);
            g.drawImage(aa.immonster[0].getImage(), aa.x,aa.y, 350, 300, this);
            if(HP==3){
                g.drawImage(hart[2], 30, 0,250,70, this);
            }
            else if(HP==2){
                g.drawImage(hart[1], 30, 0,250,70, this);
            }
            else if(HP==1){
                g.drawImage(hart[0], 30, 0,250,70, this);
            }
            if (aa.x <= -200) {
                aa.x = this.getWidth() - 20;
            }
            if (aa.x > this.getWidth() + 20) {
                aa.x = -100;
            }
            //===========hotdog================
            for (int i = 0; i < hotdogl.size(); i++) {
                g.drawImage(hotdogl.get(i).getImage(), hotdogl.get(i).getX(), hotdogl.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < hotdogl.size(); j++) {
                if (Intersect(aa.getbound(), hotdogl.get(j).getbound())) {
                    hotdogl.remove(j);
                    score += 10;
                    g.drawString("+10", aa.x + 100, 650);
                }
            }
            //===========hamburger================
            for (int i = 0; i < hamburgerl.size(); i++) {
                hamburgerl.get(i).state = 1;
                g.drawImage(hamburgerl.get(i).getImage(), hamburgerl.get(i).getX(), hamburgerl.get(i).getY(), 150, 150, this);
            }
            for (int i = 0; i < hamburgerl.size(); i++) {
                if (Intersect(aa.getbound(), hamburgerl.get(i).getbound())) {
                    hamburgerl.remove(i);
                    score += 50;
                    g.drawString("+50", aa.x + 10, 650);
                }
            }
            //===========pizza================
            for (int i = 0; i < pizzal.size(); i++) {
                g.drawImage(pizzal.get(i).getImage(), pizzal.get(i).getX(), pizzal.get(i).getY(), 200, 200, this);
            }
            for (int j = 0; j < pizzal.size(); j++) {
                if (Intersect(aa.getbound(), pizzal.get(j).getbound())) {
                    pizzal.remove(j);
                    score += 20;
                    g.drawString("+20", aa.x + 100, 650);
                }
            }
            //======donut=======//
            for (int i = 0; i < donutl.size(); i++) {
                g.drawImage(donutl.get(i).getImage(), donutl.get(i).getX(), donutl.get(i).getY(), 200, 200, this);
            }
            for (int j = 0; j < donutl.size(); j++) {
                if (Intersect(aa.getbound(), donutl.get(j).getbound())) {
                    donutl.remove(j);
                    score += 30;
                    g.drawString("+30", aa.x + 100, 650);
                }
            }
            //=====cheese=======//
            for (int i = 0; i < cheesel.size(); i++) {
                g.drawImage(cheesel.get(i).getImage(), cheesel.get(i).getX(), cheesel.get(i).getY(), 150, 150, this);
            }
            for (int j = 0; j < cheesel.size(); j++) {
                if (Intersect(aa.getbound(), cheesel.get(j).getbound())) {
                    cheesel.remove(j);
                    score += 30;
                    g.drawString("+30", aa.x + 100, 650);
                }
            }
 
            //========mold======
            for (int i = 0; i < moldl.size(); i++) {
                //g.drawRect(missile.get(i).getX(),missile.get(i).getY(),65,175);
                g.drawImage(moldl.get(i).getImage(), moldl.get(i).getX(), moldl.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < moldl.size(); j++) {
                if (Intersect(aa.getbound(), moldl.get(j).getbound())) {
                    moldl.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                    g.drawString("-20", aa.x + 100, 650);
                }
            }
            //======unji====//
            for (int i = 0; i < unjil.size(); i++) {
                g.drawImage(unjil.get(i).getImage(), unjil.get(i).getX(), unjil.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < unjil.size(); j++) {
            if (Intersect(aa.getbound(), unjil.get(j).getbound())) {
                    unjil.remove(j);
                    HP -= 1;
                    //u.x = 0;
                    g.drawString("-1HP", aa.x + 100, 580);
                    
                }
            }
            //======chili======/
            for (int i = 0; i < chilil.size(); i++) {
                //g.drawRect(missile.get(i).getX(),missile.get(i).getY(),65,175);
                g.drawImage(chilil.get(i).getImage(), chilil.get(i).getX(), chilil.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < chilil.size(); j++) {
                if (Intersect(aa.getbound(), chilil.get(j).getbound())) {
                    chilil.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                    g.drawString("-20", aa.x + 100, 650);
                }
            }
            //======coinplus=====//
            for (int i = 0; i < coinplusl.size(); i++) {
                g.drawImage(coinplusl.get(i).getImage(), coinplusl.get(i).getX(), coinplusl.get(i).getY(), 120, 120, this);
            }
            for (int j = 0; j < coinplusl.size(); j++) {
                if (Intersect(aa.getbound(), coinplusl.get(j).getbound())) {
                    coinplusl.remove(j);
                    times += 5;
                }
            }
            g.setFont(new Font("Cooper Black", Font.HANGING_BASELINE, 30));
            g.setColor(Color.PINK);
            g.drawString("SCORE :  " + score, 125, 158);
            g.setFont(new Font("Cooper Black", Font.HANGING_BASELINE, 30));
            g.drawString("Time " + times, 125, 235);
        }
    }
      //
    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}