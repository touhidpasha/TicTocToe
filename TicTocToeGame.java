import java.util.Scanner;

class Game{
    /*here Game class can we used to call methods by 
    creating it's objects*/

    Scanner sc=new Scanner(System.in);
    public char[] board=new char[10];
    char userChoice,machineChoice; 
    int boxNumber;   
    
    public void intialize(){
        for(int i=1;i<board.length;i++)
           { 
               board[i]=' ';        //intializing array with spaces
            }                   
    }

    public char toss()
    {
        if(((int) ((Math.random() * (6 - 1)) + 1))%2==0)
            return 'h';
        else
            return 't';

    }

    public void selectOption()
    {
        System.out.println("Enter x or o as your choice");
        userChoice=sc.next().charAt(0);
        machineChoice=(userChoice=='o'?'x':'o');
        //selectBox();
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
        System.out.println("\n");
        System.out.println("These are current board values ");
        showBoard();
        System.out.println("Choose between 1 to 9 having empty box");
        boxNumber=sc.nextInt();
        if(board[boxNumber]!=' '){
        System.out.println("Already filled choose different one");
        System.out.println("These are current board values ");
        showBoard();
        System.out.println("Choose between 1 to 9 having empty box");
        boxNumber=sc.nextInt();
        }
        System.out.println("you selected "+boxNumber);
        board[boxNumber]=userChoice; //based on user choice of symbol empbty field will be filled
        //machineMove();

        
    }

    public int machineMove(){
        
        //horizontally finding for winning
        for(int i=1;i<4;i++) //these holds good for both blocking opponent to win as well as winning by placing it's own symbol
        {
            if(board[i]==board[i+3])
            if(board[i+6]==' '){
            board[i+6]=(userChoice=='o'?'x':'o');
            //selectBox();
            return(0);}
        }
        for(int i=1;i<4;i++)
        {
            if(board[i]==board[i+6])
            if(board[i+6]==' '){
            board[i+3]=(userChoice=='o'?'x':'o');
            //selectBox();
            return(0);}
        }
        for(int i=4;i<7;i++)
        {
            if(board[i]==board[i+3])
            if(board[i-3]==' '){
            board[i-3]=(userChoice=='o'?'x':'o');
            //selectBox();  
        return(0);}
        }

        //vertically finding for winning
        
        for(int i=1;i<8;i=i+3)
        {
            if(board[i]==board[i+1])
            if(board[i+2]==' '){
            board[i+2]=(userChoice=='o'?'x':'o');
            //selectBox();
            
            return(0);}

        }

         
        for(int i=1;i<8;i=i+3)
        {
            if(board[i]==board[i+2])
            if(board[i+1]==' '){
            board[i+1]=(userChoice=='o'?'x':'o');
            //selectBox();
            return(0);}

        }
        for(int i=2;i<9;i=i+3)
        {
            if(board[i]==board[i+1])
            if(board[i-1]==' '){
            board[i-1]=(userChoice=='o'?'x':'o');
            //selectBox();
            return(0);}

        }

        //cross checking
        if(board[1]==board[5])
        { if(board[0]==' '){
            board[9]=(userChoice=='o'?'x':'o');
            return 0;}
        }
        if(board[1]==board[9])
        {if(board[5]==' '){
            board[5]=(userChoice=='o'?'x':'o');
            return 0;}
        }
        if(board[5]==board[9])
        {if(board[1]==' '){
            board[1]=(userChoice=='o'?'x':'o');
            return 0;}
        }
        if(board[3]==board[7])
        {if(board[5]==' '){
            board[5]=(userChoice=='o'?'x':'o');
            return 0;}
        }
        if(board[3]==board[5])
        {if(board[7]==' '){
            board[7]=(userChoice=='o'?'x':'o');
            return 0;}
        }
        if(board[7]==board[5])
        {if(board[3]==' '){
            board[3]=(userChoice=='o'?'x':'o');
            return 0;}
        }

        //taking corner position in worst case
        for(int i=1;i<board.length;i++)
           { 
               if(board[i]==' ' && i!=5)
               {if(board[i]==' '){
                   board[i]=(userChoice=='o'?'x':'o');  
               return 0;}
                 }  
            }   

        //if above conditions not followed then find empty box and place randamoly
            //if no corner spaces available then will take centre
        for(int i=1;i<board.length;i++)
           { 
               if(board[i]==' ')
               {board[i]=(userChoice=='o'?'x':'o');  
               return 0;
                 }  
            }                   
    return 0;

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
                
                if(flag!='N')
                    {   
                        return flag;
                       // break;
                    }
               }
               
            }

            for(int i=1;i<board.length;i++)
           { 
               if(board[i]!=' ') //code for not tie
               {
                    flag='T';
               }
               else
                flag='N';
            }
        
            return flag;
    }
    
    
    
}

public class TicTocToeGame{
    public static void main(String args[]){
        Game obj=new Game();
        char tossVar,winner,playAgain;
        Scanner sc=new Scanner(System.in);
        obj.intialize();
        tossVar=obj.toss();

        /*if(tossVar=='h')
        {
            obj.selectOption();//choosing symbol of interest for user
            obj.selectBox();//player selection process
        }
        else{
            obj.machineMove(); //calling machine to take decision
        }*/
        obj.selectOption();
        while(true){ 
        
        tossVar=((tossVar=='h')?'t':'h');

        /*
        if(tossVar=='h')
        tossVar='t';
        else
        tossVar='h';*/

        /*if(tossVar=='h')
        {
            //obj.selectOption();//player selection process
            obj.selectBox();
        }
        else{
            obj.machineMove(); //calling machine to take decision
        }*/


        //obj.showBoard();
        obj.selectBox();
        obj.showBoard();
        winner=obj.checkForNextMove();//checking winnig statistics
        
        
        //below code is to continue untill one person win's or match got tied
        if(winner=='T')
        {
            System.out.println("match got tied");
            System.out.println("Do you want play another match,press Y/n");
            playAgain=sc.next().charAt(0);
            if(playAgain=='Y')
            obj.intialize();
            else
             break;
            
        }
            
        else if(winner=='o' || winner=='x')
            {
            if(obj.userChoice==winner)
                System.out.println("you won the match");
            else
                System.out.println("machine won the match");
            System.out.println("Do you want play another match,press Y/n");
            playAgain=sc.next().charAt(0);
            if(playAgain=='Y')
            obj.intialize();
            else
             break;
            
        }
        //else continue;
        
        obj.machineMove();
        obj.showBoard();

        winner=obj.checkForNextMove();//checking winnig statistics
        
        
        //below code is to continue untill one person win's or match got tied
        if(winner=='T')
        {
            System.out.println("match got tied");
            System.out.println("Do you want play another match,press Y/n");
            playAgain=sc.next().charAt(0);
            if(playAgain=='Y')
            obj.intialize();
            else
             break;
            
        }
            
        else if(winner=='o' || winner=='x')
            {
            if(obj.userChoice==winner)
                System.out.println("you won the match");
            else
                System.out.println("machine won the match");
            System.out.println("Do you want play another match,press Y/n");
            playAgain=sc.next().charAt(0);
            if(playAgain=='Y')
            obj.intialize();
            else
             break;
            
        }
        //else continue;
        

        /*if(winner=='x')
        {
            if(obj.userChoice=='x')
                System.out.println("you won the match");
            else
                System.out.println("machine won the match");
        }
        else
        {
            obj.selectOption();
        }
        }*/
    }
        
    }
}