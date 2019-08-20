/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */
public abstract class Entity implements Movable{
    protected char symbol;
    protected int row;
    protected int col;
    
    
    public Entity(int row, int col){
        this.row = row;
        this.col = col;    
    }
   
    public Entity(){
        
    }
    
    abstract void create();

    public char getSymbol() {
        return symbol;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public Entity put(int newRow, int newCol)
    {     
        return Maze.getEntity(newRow, newCol);
    }

   
    
}
