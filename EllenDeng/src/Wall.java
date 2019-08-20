/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */
public class Wall extends Entity {
    
    Wall(int row, int col){      
        super(row, col);  
        this.symbol = '*';
    }
    
    Wall(){
      this.symbol = '*';
    }
    
    @Override
    public void move(char direction){
        
    }
    
    public void create(){
        
    }
}
