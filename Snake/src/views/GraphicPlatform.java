/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import control.Control;
import model.Model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author LAPTOP
 */
public class GraphicPlatform {

    public GraphicPlatform(Control c,JPanel panel) {
        control = c;
        this.rows = control.quantityOfRows();
        this.columns = control.quantityOfColumns();
        graphicPlatform = new JButton[rows][columns];
        mainPanel = panel;
        initialize();
        futureMovement = VK_RIGHT;
    }
    
    public void initialize(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                graphicPlatform[i][j] = new JButton();
                setProperties(graphicPlatform[i][j],i,j);
                setListeners(graphicPlatform[i][j]);
                if(i == 0 && j == 0){
                    graphicPlatform[i][j].setBackground(Color.green);
                    graphicPlatform[i][j].requestFocus();
                    graphicSnake = new GraphicSnake(graphicPlatform[i][j],rows * columns);
                }
                mainPanel.add(graphicPlatform[i][j]);
            }
        }
       //mainPanel.revalidate();
       mainPanel.repaint();
    }
    
    public void setProperties(JButton jt,int x,int y){
        jt.setBounds(x * dimension, y * dimension,dimension,dimension);
        jt.setBackground(Color.white);
        jt.setRequestFocusEnabled(false);
        if(control.hasFood(x, y))
            jt.setIcon(new ImageIcon("funny-pizza.jpg"));
    }
    
    public void setListeners(JButton jt){
        jt.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke){
                possibleMovement(ke.getKeyCode(),jt);  
            }
        });
    }
    
    public boolean possibleMovement(int keyCode,JButton jt){
        JButton destiny = null;
        switch (keyCode) {
            case VK_RIGHT:
                if(mainPanel.getComponentAt(jt.getX() + dimension,jt.getY()) != null){
                    if(mainPanel.getComponentAt(jt.getX() + dimension,jt.getY()) instanceof JButton){
                        destiny = (JButton) mainPanel.getComponentAt(jt.getX() + dimension,jt.getY());
                        destiny.requestFocus();
                        if(control.searchIfHasFood(destiny.getX()/dimension, destiny.getY()/dimension)){
                            graphicSnake.grow(new JButton());
                            control.setCurrentPoints(control.getCurrentPoints()+5);
                        }
                        graphicSnake.movement(destiny);
                        futureMovement = VK_RIGHT;
                    return true;
                    }
                graphicSnake.setAlive(false);
                return false;
                }
                else{
                   graphicSnake.setAlive(false);
                   return false;
               }
            case VK_LEFT:
                if(mainPanel.getComponentAt(jt.getX() - dimension,jt.getY()) != null){
                    if(mainPanel.getComponentAt(jt.getX() - dimension,jt.getY()) instanceof JButton){
                        destiny = (JButton) mainPanel.getComponentAt(jt.getX() - dimension,jt.getY());
                        destiny.requestFocus();
                        if(control.searchIfHasFood(destiny.getX()/dimension, destiny.getY()/dimension)){
                            graphicSnake.grow(new JButton());
                            control.setCurrentPoints(control.getCurrentPoints()+5);
                        }
                        graphicSnake.movement(destiny);
                        futureMovement = VK_LEFT;
                    return true;
                    }
                graphicSnake.setAlive(false);    
                return false;
                }
                else{
                   graphicSnake.setAlive(false);
                   return false;
               }
            case VK_DOWN:
                if(mainPanel.getComponentAt(jt.getX(),jt.getY()+ dimension) != null){
                    if(mainPanel.getComponentAt(jt.getX(),jt.getY() + dimension) instanceof JButton){
                        destiny = (JButton) mainPanel.getComponentAt(jt.getX(),jt.getY() + dimension);
                        destiny.requestFocus();
                        if(control.searchIfHasFood(destiny.getX()/dimension, destiny.getY()/dimension)){
                            graphicSnake.grow(new JButton());
                            control.setCurrentPoints(control.getCurrentPoints()+5);
                        }
                        graphicSnake.movement(destiny);
                        futureMovement = VK_DOWN;
                    return true;
                    }
                graphicSnake.setAlive(false);    
                return false;
                }
                else{
                   graphicSnake.setAlive(false);
                   return false;
               }
            case VK_UP:
               if(mainPanel.getComponentAt(jt.getX(),jt.getY() - dimension) != null){
                    if(mainPanel.getComponentAt(jt.getX(),jt.getY() - dimension) instanceof JButton){
                        destiny = (JButton) mainPanel.getComponentAt(jt.getX(),jt.getY() - dimension);
                        destiny.requestFocus();
                        if(control.searchIfHasFood(destiny.getX()/dimension, destiny.getY()/dimension)){
                            graphicSnake.grow(new JButton());
                            control.setCurrentPoints(control.getCurrentPoints()+5);
                        }
                        graphicSnake.movement(destiny);
                        futureMovement = VK_UP;
                    return true;
                    }
                graphicSnake.setAlive(false);
                return false;
                }
                else{
                   graphicSnake.setAlive(false);
                   return false;
               }  
        }
        return false;
    }
    
    public void game(){
        while(graphicSnake.isAlive()){
            if(control.getCurrentPoints() < control.getGoalPoints()){
                possibleMovement(futureMovement,graphicSnake.getHead());
                control.pauseGame(815);
            }
            else
                break;
        }
    }
    
    public void removeAll(){
        mainPanel.removeAll();
    }
    
    public void renderPlatform(JPanel pan){
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++){
                if(control.hasFood(i, j))
                  graphicPlatform[i][j].setIcon(new ImageIcon("funny-pizza.jpg"));
                else
                    graphicPlatform[i][j].setIcon(null);
            }
     
    }
    
    private static int dimension = 60;
    private Control control; 
    private GraphicSnake graphicSnake;
    private JPanel mainPanel;
    private JButton [][] graphicPlatform;
    private int futureMovement;
    private int rows;
    private int columns;
}
