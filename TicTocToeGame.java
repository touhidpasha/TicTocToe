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
        System.out.println("##############");
        while(i<board.length)
           { 
               for( int j=0;j<3;j++)
                    System.out.print(" "+board[i++]);
                System.out.println();
                
           }
           System.out.println("##############");
        
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

    public char toss()
    {
        if(((int) ((Math.random() * (6 - 1)) + 1))%2==0)
            return 'h';
        else
            return 't';

    }

    public char checkWinner()
    {
        if(board[1]==board[2] && board[2]==board[3] )
            return board[1];
        else if(board[4]==board[5] && board[5]==board[6] )
            return board[6];
        else if(board[7]==board[8] && board[7]==board[9] )
            return board[7];
        else if(board[1]==board[4] && board[4]==board[7] )
            return board[1];
        else if(board[2]==board[5] && board[5]==board[8] )
            return board[2];
        else if(board[3]==board[6] && board[6]==board[9] )
            return board[3];
        else if(board[1]==board[5] && board[5]==board[9] )
            return board[1];
        else if(board[3]==board[5] && board[5]==board[7] )
            return board[3];
        else
        return 'N';
    }
    public char checkForNextMove(){
        char flag='N';
        for(int i=1;i<board.length;i++)
           { 
               if(board[i]==' ') //code for not tie
               {
                //flag='N';
                flag=checkWinner();
                break;
               }
                else
                    flag='T'; //var gfor tie
            }


            return flag;
    }
    
    
}

public class TicTocToeGame{
    public static void main(String args[]){
        Game obj=new Game();
        char tossVar,winner;
        obj.intialize();
        obj.selectOption();
        obj.showBoard();
        obj.selectBox();
        tossVar=obj.toss();
        winner=obj.checkForNextMove();
        if(winner=='T')
        {
            System.out.println("match got tied");
        }
        else if(winner=='o')
        {
            System.out.println("machine won the match");
        }
        else if(winner=='x')
        {
            System.out.println("you won the match");
        }
        else
        {
            obj.selectOption();
        }
    }
}