/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author LAPTOP
 */
public class GraphicCounter {
    
    public GraphicCounter(String g){
        goal = new JLabel(g);
        currentResult = new JLabel("Your current pizzas are 0.");
        goal.setFont(new Font("Serif", Font.PLAIN, 42));
        currentResult.setFont(new Font("Serif", Font.PLAIN, 42));
        currentResult.setForeground(Color.blue);
    }

    public JLabel getGoal() {
        return goal;
    }

    public void setGoal(String g) {
        goal.setText(g);
    }

    public JLabel getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(String g) {
        currentResult.setText(g);
    }
    
    public void setGoalDimensions(int x,int y,int xd,int yd){
        goal.setBounds(x, y, xd, yd);
    }
    
    public void setcurrentResultsDimensions(int x,int y,int xd,int yd){
        currentResult.setBounds(x, y, xd, yd);
    }
    
    private JLabel goal;
    private JLabel currentResult;
}
