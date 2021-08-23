import java.util.Scanner;

class Game{
    /*here Game class can we used to call methods by 
    creating it's objects*/

    Scanner sc=new Scanner(System.in);
    public char[] board=new char[10];
    char userChoice;    
    
    public void intialize(){
        for(int i=1;i<board.length;i++)
           { 
               board[i]=' ';        //intializing array with spaces
            }                   
    }

    public void selectOption()
    {
        System.out.println("Enter x or o as your choice");
        userChoice=sc.next().charAt(0);
        
    }
    
    
}

public class TicTocToeGame{
    public static void main(String args[]){
        Game obj=new Game();
        obj.intialize();
        obj.selectOption();
    }
}