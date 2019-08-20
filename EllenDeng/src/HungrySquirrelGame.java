
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
public class HungrySquirrelGame {
    
    public static void main(String[] args) {
    
        Maze m = new Maze();
        Maze.create("Maze.txt");

        Squirrel s = new Squirrel();
        s.create();
        
        Nut n = new Almond();
        n.create(); 

        Maze.display();

        while (true) 
        {
            System.out.println("Please enter command u, d, l, r to move the squirrel (u = up, d = down, l = left, r = right): ");
            Scanner in = new Scanner(System.in);
            
            if(in.hasNextLine())
            {
                String input = in.nextLine();
                
                if(input.equalsIgnoreCase("u") || input.equalsIgnoreCase("d") 
                        || input.equalsIgnoreCase("l") || input.equalsIgnoreCase("r"))
                {
                    char cmnd = input.charAt(0);
                    s.move(cmnd);  
                }                
            }
            
            Maze.display();
            
            if (s.getTotalNutsEaten() >= 5) 
            {
                System.out.println("\nSquirrel successfully collected all the nuts. Total points "
                        + s.getPointCollected() + ". Thank you for playing this game.");
                break;
            }
        }  
    }
}
