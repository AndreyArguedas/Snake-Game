/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import control.Control;

/**
 *
 * @author LAPTOP
 */
public class Main {
    public static void main(String [] args){
        Control c = new Control();
        c.initGame(8, 8);
        c.showGame();
        c.game();
    }
}
