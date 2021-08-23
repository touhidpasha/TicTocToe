import java.util.Scanner;

class Game{
    /*here Game class can we used to call methods by 
    creating it's objects*/

    Scanner sc=new Scanner(System.in);
    public char[] board=new char[10];
    char userChoice; 
    int boxNumber;   
    
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

    public void showBoard(){
        int i=1;
        while(i<board.length)
           { 
               for( int j=0;j<3;j++)
                    System.out.print(" "+board[i++]);
                System.out.println();
                
           }
        
    }
    public void selectBox(){
        System.out.print("These are current board values ");
        showBoard();
        System.out.print("Choose between 1 to 9 having empty box");
        boxNumber=sc.nextInt();
        if(board[boxNumber]!=' '){
        System.out.print("Already filled choose different one");
        System.out.print("These are current board values ");
        showBoard();
        System.out.println("Choose between 1 to 9 having empty box");
        boxNumber=sc.nextInt();
        }
        

    }
    
    
}

public class TicTocToeGame{
    public static void main(String args[]){
        Game obj=new Game();
        obj.intialize();
        obj.selectOption();
        obj.showBoard();
        obj.selectBox();
    }
}