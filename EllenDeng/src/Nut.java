
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */
public abstract class Nut extends Entity{
    protected static final int totalNuts = 5;
    protected int points;
    protected String name;
    
    Nut(int row, int col){
        
        super(row, col);
    }
    
    Nut(){
        
    }

    public int getTotalNuts() {
        return totalNuts;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
    
    
    @Override
    public void create()
    {
        int i = 0;
        
        while(true)
        {
            Random random = new Random();

            int randomRow = random.nextInt(Maze.getMaxMazeRow());
            int randomCol = random.nextInt(Maze.getMaxMazeCol());

            if(Maze.available(randomRow, randomCol)){
                
                Random r = new Random();
                int n = r.nextInt(2);
                switch(n)
                {
                    case 0:
                        Maze.addEntity(randomRow, randomCol, new Almond());
                        break;
                    case 1:
                        Maze.addEntity(randomRow,randomCol, new Peanut());
                }
                
                i++;
            }

            if(i >= totalNuts){
                break;
            }
        }
    }
}
