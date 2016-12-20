/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import control.Control;
import interfaces.Observer;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author LAPTOP
 */
public class Game extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form Game
     */
    public Game(Control c) {
        initComponents();
        control = c;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        setSize(width,height);
        setResizable(false);
        setTitle("SNAKE GAME");
        startGraphicGame();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void update() {
        renderPlatform();
        graphicCounter.setCurrentResult("Your current pizzas are " + control.getCurrentPoints() + ".");
    }
    
    public void renderPlatform(){
        graphicPlatform.renderPlatform(mainPanel);
    }
    
    public void startGame(){
        graphicPlatform.game();
    }
    
    public void startGraphicGame(){
        mainPanel.removeAll();
        graphicCounter = new GraphicCounter("You need to eat " + control.getGoalPoints() + " pizzas.");
        mainPanel.setSize(getSize());
        graphicCounter.setGoalDimensions(mainPanel.getWidth() - 660,mainPanel.getHeight()/2 - 400, 560, 100);
        graphicCounter.setcurrentResultsDimensions(mainPanel.getWidth() - 660, mainPanel.getHeight()/2 - 200, 560, 100);
        mainPanel.add(graphicCounter.getGoal());
        mainPanel.add(graphicCounter.getCurrentResult());
        graphicPlatform = new GraphicPlatform(control,mainPanel);
        renderPlatform();
    }
    
    private Control control;
    private GraphicPlatform graphicPlatform;
    private GraphicCounter graphicCounter;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
