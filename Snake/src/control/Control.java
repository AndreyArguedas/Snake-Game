/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import model.Model;
import views.Game;

/**
 *
 * @author LAPTOP
 */
public class Control {

    public Control() {
        mod = Model.getInstance();
    }
    
    public void initGame(int r, int c){
        goalPoints = 120;
        currentPoints = 0;
        mod.createPlatform(r, c);
        mod.initGame();
    }
    
    public int quantityOfRows(){
        return mod.quantityOfRows();
    }
    
    public int quantityOfColumns(){
        return mod.quantityOfColumns();
    }
    
    public void insertFood(int r, int c){
        mod.insertFood(r, c);
    }
    
    public void deleteFood(int r, int c){
        mod.deleteFood(r, c);
    }
    
    public boolean hasFood(int r,int c){
        return mod.hasFood(r, c);
    }
    
    public boolean searchIfHasFood(int r,int c){
        return mod.searchIfHasFood(r, c);
    }
    
    public void showGame(){
        if(game == null){
            game = new Game(this);
            mod.addView(game);
        }
        game.show();
    }

    public int getGoalPoints() {
        return goalPoints;
    }

    public void setGoalPoints(int goalPoints) {
        this.goalPoints = goalPoints;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }
    
    public void game(){
        game.startGame(); //A loop that breaks if snake dies or the goal has been reached
        int result = 0;
        if(currentPoints < goalPoints)
            result = JOptionPane.showConfirmDialog(null,"Do you want to play again?", "YOU LOSE :(", JOptionPane.OK_CANCEL_OPTION,QUESTION_MESSAGE, new ImageIcon("funny-pizza.jpg"));
        else
            result = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "YOU WIN :)", JOptionPane.OK_CANCEL_OPTION,QUESTION_MESSAGE, new ImageIcon("funny-pizza.jpg"));
        
        if(result == JOptionPane.OK_OPTION){
            initGame(8,8);
            game.startGraphicGame();
            game();
        }
        else{
            System.exit(0);
        }
            
    }
    
    public void pauseGame(int x){
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int goalPoints;
    private int currentPoints;
    private Game game = null;
    private Model mod = null;
}
