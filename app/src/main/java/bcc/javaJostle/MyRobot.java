package bcc.javaJostle;

import java.util.ArrayList;
public class MyRobot extends Robot{
    public MyRobot(int x, int y){
        super(x, y, 3, 3, 2, 2,"bob", "myRobotImage.png", "defaultProjectileImage.png");
        // Health: 3, Speed: 3, Attack Speed: 2, Projectile Strength: 2
        // Total = 10
        // Image name is "myRobotImage.png"
}

public void shoot(ArrayList<Robot> robots){
    if(canAttack()){
            for(Robot robot : robots) {
                if (robot != this && robot.isAlive() ){
                    shootAtLocation(robot.getX() + Utilities.ROBOT_SIZE/2, robot.getY() + Utilities.ROBOT_SIZE/2);
                    break; // Shoot at the first target found
                }
            }
        }
}


    

    public void think(ArrayList<Robot> robots, ArrayList<Projectile> projectiles, Map map, ArrayList<PowerUp> powerups) {
       /* Implement your robot's logic here
         For example, you can move towards the nearest robot or shoot at a target
         to move, choose a direciton to go
         to move left - use xMovement = -1
         to move right - use xMovement = 1
         to move up - use yMovement = -1
         to move down - use yMovement = 1
         You can ONLY move in one direction at a time, if your output doesn't match the above you will get an error

         to shoot, use shootAtLocation(x, y) where x and y are the coordinates of the target
         only shoot when canAttack() is true!
        */
       // System.out.println("Thinking...");
        Robot enemy = null;
       for(Robot robot : robots){
            if(robot.getName().equals("Rock") || robot.getName().equals("Rando")){
                 enemy = robot;
            }
       }

       while(true){
       int robotCol = this.getX() / Utilities.TILE_SIZE;
       int robotRow = this.getY() / Utilities.TILE_SIZE;
       if(enemy != null){
         if(this.getX()<enemy.getX() && map.getTiles()[robotRow][robotCol+1] != Utilities.WALL){
            xMovement =1;
            shoot(robots);
            break;
         }
        else{
            if(this.getY() < enemy.getY() && map.getTiles()[robotRow+1][robotCol] != Utilities.WALL){
                yMovement =1;
                shoot(robots);
                break;
            }
            else if(this.getY() > enemy.getY() && map.getTiles()[robotRow-1][robotCol] != Utilities.WALL){
                yMovement =-1;
                shoot(robots);
                break;
            }
       }   
      
         
         if(this.getX()>enemy.getX() && map.getTiles()[robotRow][robotCol-1] != Utilities.WALL){
            xMovement =-1;
            shoot(robots);
            break;
         }
         else{
            if(this.getY() < enemy.getY() && map.getTiles()[robotRow+1][robotCol] != Utilities.WALL){
                yMovement =1;
                shoot(robots);
                break;
            }
            else if(this.getY() > enemy.getY() && map.getTiles()[robotRow-1][robotCol] != Utilities.WALL){
                yMovement =-1;
                shoot(robots);
                break;
            }
         }
        }
    }
    }
    }
       
       

