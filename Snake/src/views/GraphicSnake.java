/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author LAPTOP
 */
public class GraphicSnake {

    public GraphicSnake(JButton jt, int maximumLength) {
        alive = true;
        head = jt;
        body = new JButton[maximumLength];
        currentBodySize = 0;
    }
    
    public void movement(JButton jt){
        if (jt.getBackground() == Color.white) {
            JButton aux = head;
            JButton previous = null;
            head = jt;
            head.setBackground(Color.green);
            for (int i = 0; i < currentBodySize; i++) {
                aux.setBackground(Color.green);
                previous = body[i];
                body[i] = aux;
                body[i].setBackground(Color.green);
                aux = previous;
            }
            aux.setBackground(Color.white);
        }
        else
            setAlive(false);
    }
    
    public void grow(JButton jt){
        jt.setBackground(Color.green);
        body[currentBodySize++] = jt;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public JButton getHead() {
        return head;
    }

        public void setHead(JButton head) {
        this.head = head;
    }
    
    private JButton head;
    private JButton [] body;
    private int currentBodySize;
    private boolean alive;
}
