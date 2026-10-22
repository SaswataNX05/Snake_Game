package snake_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public final class Board extends JPanel implements ActionListener{
    
    private int dots;
    private Image dot;
    private Image head;
    private Image apple;   
    
    private final int All_Dots = 9000;
    private final int size = 10;
    private final int ran = 15;
    
    private int apple_x;
    private int apple_y;
    
    private final int x[] = new int[All_Dots];
    private final int y[] = new int[All_Dots];
    private Timer timer;
    
    private boolean leftdirection = false;
    private boolean rightdirection = true;
    private boolean updirection = false;
    private boolean downdirection = false;
    
    private boolean ingame = true;
    
    Board(){
        addKeyListener(new TAdapter());
        
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(300, 300));
        
        loadimage();
        initGame();
    }
    
    public void loadimage(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/apple.png"));   
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/dot.png"));        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/head.png"));
        
        apple = i1.getImage();
        dot = i2.getImage();
        head = i3.getImage();
    }
    
    
    public void initGame(){
        dots = 3;
        
        for (int i=0; i<dots; i++){
            y[i] = 50;
            x[i] = 50 - i * size;
        }
        
        locateApple();
        
        timer = new Timer(140, this);
        timer.start();
    }
    
    public void locateApple(){
        int r = (int)(Math.random() * ran);
        apple_x = r * size;
        
        r = (int)(Math.random() * ran);
        apple_y = r * size;
    }
      
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        draw(g);
    }
    
    public void draw(Graphics g){
        if(ingame){
            g.drawImage(apple, apple_x, apple_y, this);
        
            for (int i=0; i<dots; i++){
                if(i == 0){
                    g.drawImage(head, x[i], y[i], this);
                }else{
                   g.drawImage(dot, x[i], y[i], this);
                }
            }  
        }else{
            gameOver(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }
    
    public void move(){
        for  (int i=dots; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        
        if(leftdirection){
            x[0] = x[0] - size;
        }
        if(rightdirection){
            x[0] = x[0] + size;
        }
        
        if(updirection){
            y[0] = y[0] - size;
        }
        
        if(downdirection){
            y[0] = y[0] + size;
        }
      
    }
    
    public class TAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && (!rightdirection)){
                leftdirection = true;
                updirection = false;
                downdirection = false;
            }
            
            if(key == KeyEvent.VK_RIGHT && (!leftdirection)){
                rightdirection = true;
                updirection = false;
                downdirection = false;
            }
            
            if(key == KeyEvent.VK_UP && (!downdirection)){
                updirection = true;
                leftdirection = false;
                rightdirection = false;
            }
            
            if(key == KeyEvent.VK_DOWN && (!updirection)){
                downdirection = true;
                leftdirection = false;
                rightdirection = false;
            }
        }
    }
    
    public void checkApple(){
        if((x[0] == apple_x) && (y[0] == apple_y)){
            dots++;
            locateApple();
        }
    }
    
    public void checkCollision(){
        for(int i=dots; i>0; i--){
            if((i>4) && (x[0] == x[i]) && (y[0] == y[i])){
                ingame = false;
            }          
        }
        if(y[0] >= 300){
                ingame = false;
            }
            if(y[0] < 0){
                ingame = false;
            }
            if(x[0] >= 300){
                ingame = false;
            }
            if(x[0] < 0){
                ingame = false;
            }
        if(!ingame){
            timer.stop();
           // JOptionPane.showMessageDialog(null, "Game Over!");
           // System.exit(1);
        }
    }
    
    public void gameOver(Graphics g){
        String msg = "Game Over ! ";
        
        Font font = new Font("SAN_SERIF", Font.BOLD, 24);
        FontMetrics met = getFontMetrics(font);
        g.setColor(Color.WHITE);
        g.setFont(font);        
        g.drawString(msg, (300 - met.stringWidth(msg)) / 2, 300/2);
  
        
    }
    
    public void actionPerformed(ActionEvent ae){
        checkApple();
        checkCollision();
        move();
               
        repaint();
    }
}
