/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import adaptadores.AdaptadorSubject;
import interfaces.Observer;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author LAPTOP
 */
public class Model {

    protected Model() {
        views = new AdaptadorSubject();
    }

    public static Model getInstance() {
        return (instance == null)?new Model():instance;
    }
    
    public void initGame(){
        Random gen = new Random();
        int x = gen.nextInt(platform.getColumns());
        x = (x == 0) ? 1 : x; //Para evitar que al comienzo del juego quede en la misma fila que snake
        int y = gen.nextInt(platform.getRows());
        insertFood(x, y);
    }
    
    public void addView(Observer v){
        views.agregar(v);
    }
    
    public void update(){
        views.notificar();
    }
    
    public void createPlatform(int r,int c){
        platform = new Platform(r,c);
    }
    
    public void insertFood(int r, int c){
        platform.insert(r, c);
    }
    
    public void deleteFood(int r, int c){
        platform.delete(r, c);
    }
    
    public boolean hasFood(int r,int c){
        return platform.hasFood(r, c);
    }
    
    public boolean searchIfHasFood(int r,int c){
        if(hasFood(r,c)){
            deleteFood(r,c);
            Random gen = new Random();
            int x = gen.nextInt(platform.getColumns());
            int y = gen.nextInt(platform.getRows());
            insertFood(x,y);
            update();
            return true;
        }
        update();
        return false;
    }
    
    public int quantityOfRows(){
        return platform.getRows();
    }
    
    public int quantityOfColumns(){
        return platform.getColumns();
    }
    
    private Platform platform = null;
    private AdaptadorSubject views = null;
    private static Model instance = null;
}
