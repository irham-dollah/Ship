/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication7;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Am
 */
public class SimpleShipTestDrive1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String result;
        result = "hit";
        // TODO code application logic here
        SimpleShip [] ship = new SimpleShip[3];
        ship[0]=new SimpleShip();
        ship[1]=new SimpleShip();
        ship[2]=new SimpleShip();
        Scanner input=new Scanner (System.in);
        
        int[] loc1={2,3,4};
        int[] loc2={4,5,6};
        int[] loc3={2,7,9};
        
        ArrayList<Integer> location1= new ArrayList<>();
        ArrayList<Integer> location2= new ArrayList<>();
        ArrayList<Integer> location3= new ArrayList<>();

        //int[] location = new location();
        for (int i : loc1)
        {
            location1.add(i);
            //System.out.print(i);
        }
        for (int i : loc2)
        {
            location2.add(i);
            //System.out.print(i);
        }
        for (int i : loc3)
        {
            location3.add(i);
            //System.out.print(i);
        }
        ship[0].setLocationCells(location1);
        ship[1].setLocationCells(location2);
        ship[2].setLocationCells(location3);

    while (!result.equals("-1")){ 
        
        System.out.print("Enter ship to shoot: ");
        String shipNo = input.next();
        System.out.println(shipNo);
        System.out.print("Enter the location: ");
        String userGuess = input.next();
        
        if (shipNo.equals('0')){
            result = ship[0].checkYourself(userGuess);
            System.out.println("Test 1");
        }else if (shipNo.equals('1')){
            result = ship[1].checkYourself(userGuess);
        }else if (shipNo.equals('2')){
            result = ship[2].checkYourself(userGuess);
        }else if (shipNo.equals('3')){ 
            System.out.println("No ship like that");
            return;
        }
        
        String testResult="failed";
        if (result.equals("hit")){
            testResult="passed";
        }else if (result.equals("kill")){
            testResult="victory";
        }
        
        System.out.println(testResult);
        }
    } 
}

class SimpleShip{
    
    //int[] locationCells;
    int numOfHits;
    int[] checkNumber;
    int i=0;
    
    private ArrayList<Integer> locationCells;
    
    public void setLocationCells(ArrayList<Integer> location){
        locationCells=location;
    }
    
    String checkYourself(String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        String result="miss";
        
        for (int x:locationCells){  
            if (guess == x){
                int index=locationCells.indexOf(guess);
                System.out.println(index);
                if (index>=0){
                    locationCells.remove(index);
                    if (locationCells.isEmpty())
                    {
                        result="kill"; 
                        System.out.println(result);
                        break;
                    }
                    else{
                        result="hit";
                        System.out.println(result);
                        break;
                    }
                }
            }
        }
    System.out.println(locationCells);
    return result;
    }
}
          
//class Ship{
//    
//    //int[] locationCells;
//    int numOfHits;
//    int[] checkNumber;
//    int i=0;
//    
//    private ArrayList<Ship> shipList=newArrayList<Ship>();
//    private final int numOfGuess= 0;
//    
//    private void setUpGame(){
//        Ship one = new Ship();
//        one.setName("One");
//        Ship two = new Ship();
//        two.setName("Two");
//        Ship three = new Ship();
//        three.setName("Three");
//        shipList.add(one);
//        shipList.add(two);
//        shipList.add(three);
//        
//        System.out.println("Your goal is to soink three ships.");
//        System.out.println("One, two, three");
//        System.out.println("Try to sink them all in the fewest number of guesses");
//    }
//}
