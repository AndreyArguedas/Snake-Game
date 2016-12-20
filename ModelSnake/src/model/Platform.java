/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LAPTOP
 */
public class Platform {

    public Platform(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        platform = new Food [rows][columns];
        initialize();
    }
    
    public void initialize(){
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                platform[i][j] = null;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
    
    public void insert(int r,int c){
        platform[r][c] = new Food(5); //Five is the points the user will win
    }
    
    public void delete(int r,int c){
        if(platform[r][c] != null)
            platform[r][c] = null;
    }
    
    public boolean hasFood(int r, int c){
        return platform[r][c] != null;
    }
    
    
    private Food [][] platform;
    private int rows;
    private int columns;
}
