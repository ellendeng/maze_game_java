
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */
public class Squirrel extends Entity {
    private int pointCollected;
    private int totalNutsEaten;
    
    Squirrel(int row, int col){
        super(row, col);
        this.symbol = '@';
    }
    
    Squirrel(){
        this.symbol = '@';
        pointCollected = 0;
        totalNutsEaten = 0;
    }

    public int getPointCollected() {
        return pointCollected;
    }

    public int getTotalNutsEaten() {
        return totalNutsEaten;
    }
    
            
    @Override
    public void create(){
        
        while (true) {
            System.out.println("Please enter the position of the squirrel (row,col) in the maze (The size is " 
                    + Maze.maxMazeRow + " x " + Maze.maxMazeCol + ") or quit: ");
        
            Scanner in = new Scanner(System.in);

            if (in.hasNextLine()) {

                String input = in.nextLine();

                if (input.contains("quit")) 
                {
                    break;
                }

                String[] parsedInput = input.split(",");

                if (parsedInput.length != 2) {
                    System.out.println("The format is invalid.");
                } else {
                    row = Integer.parseInt(input.split(",")[0]);
                    col = Integer.parseInt(input.split(",")[1]);

                    if (row > Maze.getMaxMazeRow() || col > Maze.getMaxMazeCol() || !Maze.available(row, col)) {
                        System.out.println("The position is not available.");
                    }
                    else{
                        System.out.println("User input accepted.");
                        Squirrel s = new Squirrel(row, col);
                        Maze.addEntity(row, col, s);
                        break;
                    }
                }
            }
        }
}
        
    
    @Override
    public void move(char direction)
    {         
        if (direction == 'u') 
        {
            Entity e = Maze.getEntity(row - 1, col);

            if (e instanceof Wall) 
            {
                System.out.println("Can't move squirrel over the wall.");
            } 
            else if (e instanceof Almond)
            {   
                pointCollected = pointCollected + ((Almond) e).getPoints();
                totalNutsEaten = totalNutsEaten + 1;
                
                System.out.println("Squirrel ate Almond and gained " + ((Almond) e).getName()
                        + " and gained " + ((Almond) e).getPoints()
                        + " points (Total " + pointCollected + " points)!!!\n");
                
                Maze.remove(row - 1, col);
                Maze.remove(row, col);
                e = new Squirrel();
                Maze.addEntity(row - 1, col, e);
                row = row - 1;
            }
            else if (e instanceof Peanut) 
            {
                pointCollected = pointCollected + ((Peanut) e).getPoints();
                totalNutsEaten = totalNutsEaten + 1;
                
                System.out.println("Squirrel ate " + ((Peanut) e).getName()
                    + " and gained " + ((Peanut) e).getPoints() 
                            + " points (Total " + pointCollected + " points)!!!\n");
                
                Maze.remove(row - 1, col);
                Maze.remove(row,col);
                e = new Squirrel();
                Maze.addEntity(row - 1, col, e);
                row = row - 1;
            }
            else
            {  
                e = new Squirrel();
                Maze.addEntity(row - 1, col, e);
                Maze.remove(row,col);
                row = row - 1;
            }
        }
            
        if (direction == 'd') 
        {
            Entity e = Maze.getEntity(row + 1, col);

            if (e instanceof Wall) 
            {
                System.out.println("Can't move squirrel over the wall.");
            } 
            else if (e instanceof Almond)
            {   
                pointCollected = pointCollected + ((Almond) e).getPoints();
                totalNutsEaten = totalNutsEaten + 1;
                
                System.out.println("Squirrel ate " + ((Almond) e).getName()
                        + " and gained " + ((Almond) e).getPoints()
                        + " points (Total " + pointCollected + " points)!!!\n");
                
                Maze.remove(row + 1, col);
                Maze.remove(row, col);
                e = new Squirrel();
                Maze.addEntity(row + 1, col, e);
                row = row + 1;
            }
            else if (e instanceof Peanut) 
            {
                pointCollected = pointCollected + ((Peanut) e).getPoints();
                totalNutsEaten = totalNutsEaten + 1;
                
                System.out.println("Squirrel ate " + ((Peanut) e).getName()
                    + " and gained " + ((Peanut) e).getPoints() 
                            + " points (Total " + pointCollected + " points)!!!\n");
                
                Maze.remove(row + 1, col);
                Maze.remove(row, col);
                e = new Squirrel();
                Maze.addEntity(row + 1, col, e);
                row = row + 1;
            }
            else
            {
                e = new Squirrel();
                Maze.addEntity(row + 1, col, e);
                Maze.remove(row, col);
                row = row + 1;
            }
        }
        
        if (direction == 'l') 
        {
            Entity e = Maze.getEntity(row, col - 1);

            if (e instanceof Wall) 
            {
                System.out.println("Can't move squirrel over the wall.");
            } 
            else if (e instanceof Almond)
            {   
                pointCollected = pointCollected + ((Almond) e).getPoints();
                totalNutsEaten = totalNutsEaten + 1;
                
                System.out.println("Squirrel ate " + ((Almond) e).getName()
                        + " and gained " + ((Almond) e).getPoints()
                        + " points (Total " + pointCollected + " points)!!!\n");
                
                Maze.remove(row, col - 1);
                Maze.remove(row, col);
                e = new Squirrel();
                Maze.addEntity(row, col - 1, e);
                col = col - 1;
            }
            else if (e instanceof Peanut) 
            {
                pointCollected = pointCollected + ((Peanut) e).getPoints();
                totalNutsEaten = totalNutsEaten + 1;
                
                System.out.println("Squirrel ate " + ((Peanut) e).getName()
                    + " and gained " + ((Peanut) e).getPoints() 
                            + " points (Total " + pointCollected + " points)!!!\n");
                
                Maze.remove(row, col - 1);
                Maze.remove(row, col);
                e = new Squirrel();
                Maze.addEntity(row, col - 1, e);
                col = col - 1;
            }
            else
            {
                e = new Squirrel();
                Maze.addEntity(row, col - 1, e);
                Maze.remove(row, col);
                col = col - 1;
            }
        }
        
        if (direction == 'r') 
        {
            Entity e = Maze.getEntity(row, col + 1);

            if (e instanceof Wall) 
            {
                System.out.println("Can't move squirrel over the wall.");
            } 
            else if (e instanceof Almond)
            {   
                pointCollected = pointCollected + ((Almond) e).getPoints();
                totalNutsEaten = totalNutsEaten + 1;
                
                System.out.println("Squirrel ate " + ((Almond) e).getName()
                        + " and gained " + ((Almond) e).getPoints()
                        + " points (Total " + pointCollected + " points)!!!\n");
                
                Maze.remove(row, col + 1);
                Maze.remove(row, col);
                e = new Squirrel();
                Maze.addEntity(row, col + 1, e);
                col = col + 1;
            }
            else if (e instanceof Peanut) 
            {
                pointCollected = pointCollected + ((Peanut) e).getPoints();
                totalNutsEaten = totalNutsEaten + 1;

                System.out.println("Squirrel ate " + ((Peanut) e).getName()
                    + " and gained " + ((Peanut) e).getPoints() 
                            + " points (Total " + pointCollected + " points)!!!\n");
                
                Maze.remove(row, col + 1);
                Maze.remove(row, col);
                e = new Squirrel();
                Maze.addEntity(row, col + 1, e);
                col = col + 1;
            }
            else
            {
                e = new Squirrel();
                Maze.addEntity(row, col + 1, e);
                Maze.remove(row, col);
                col = col + 1;
            }
        }          
    } 
}
