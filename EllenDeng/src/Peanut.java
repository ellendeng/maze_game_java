/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */
public class Peanut extends Nut {
    
    Peanut(int row, int col){
        super(row, col);
        symbol = 'P';
        points = 10;
        name = "Peanut";   
    }
    
    Peanut(){
        symbol = 'P';
        points = 10;
        name = "Peanut";   
    }

    public char getSymbol() {
        return symbol;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public void move(char direction){
        
    }
    
    @Override
    public void create()
    {
        super.create();
        
    }
}
