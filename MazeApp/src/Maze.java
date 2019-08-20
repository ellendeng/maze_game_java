
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ellen
 */
public class Maze {

    protected static final int maxMazeRow = 20;
    protected static final int maxMazeCol = 50;
    protected static Entity[][] maze;
    protected static String[] mazeRow = new String[maxMazeRow];
    
    public Maze()
    {
        maze = new Entity[maxMazeRow][maxMazeCol]; 
    }
    
    public static void create(String filename){
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
           
            String line = null;
            
            int n = 0;

            while((line = br.readLine()) != null)
            {               
                mazeRow[n] = line;            
                n++;     
            }
            
            br.close();
            
            for(int i = 0; i < mazeRow.length; i++)
            {
                for(int j = 0; j < mazeRow[0].length(); j++)
                {
                    if(mazeRow[i].charAt(j) == '*')
                    {
                        Wall w = new Wall(i, j);
                        maze[i][j] = w;
                    }
                    else
                    {
                        maze[i][j] = null;
                    }
                }
            } 
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        } 
    }
        
    public static void display()
    {
        for (int i = 0; i < maxMazeRow; i++) {
            for (int j = 0; j < maxMazeCol; j++) {
                if (maze[i][j] != null) {
                    System.out.print(maze[i][j].getSymbol());
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    public static boolean available(int row, int col)
    {
        return maze[row][col] == null;
    }
    
    public static boolean addEntity (int row, int col, Entity entity){
        
        if(available(row, col))
        {
            maze[row][col] = entity;
            return true;
        }
        else{
            return false;
        }        
    }
    
    public static Entity getEntity(int row, int col){
        return maze[row][col];
    }

    
     public static void remove (int row, int col){
        maze[row][col] = null;
    }

    public static int getMaxMazeRow() {
        return maxMazeRow;
    }

    public static int getMaxMazeCol() {
        return maxMazeCol;
    }

    public static Entity[][] getMaze() {
        return maze;
    }  
    
}
