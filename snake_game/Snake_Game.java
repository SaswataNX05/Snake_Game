package snake_game;

import javax.swing.*;

public class Snake_Game extends JFrame{

    Snake_Game(){
        
        super("Snake Game");
        add(new Board());
        pack();
  
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    
    public static void main(String[] args) {
        new Snake_Game().setVisible(true);
    }
    
}
