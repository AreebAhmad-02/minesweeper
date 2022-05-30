

//Areeb Ahmad;CMS:393535;BESE 12_B

import java.util.Scanner; // program uses class Scanner

public class minesweper{
    // main method begins execution of Java application
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
         
        
        System.out.print("Enter the rows of game: ");
        float rows_of_game = input.nextFloat();  //reads the number of rows for the game
        System.out.print("Enter the column of game: ");
        float columns_of_game = input.nextFloat();  //reads the number of columns for the game
        System.out.print("Enter probability of mines: ");
        double probability = input.nextDouble(); //reads the probability of mines
        
        String [][] array = new String [(int)rows_of_game][(int)columns_of_game]; // creates an array for game
        mining_array(array, probability); // calling function to mine the bombs
        
        
        for(int i=0;i<rows_of_game;i++){
            for(int j=0;j<columns_of_game;j++){
                System.out.print(array[i][j] + "|");  // prints the array with mined bombs
            }
            System.out.println(); // reaches the next line after every row
        }
        System.out.println();
        number_mine(array); // calling function to assign the numbers to boxes
        
        for(int i=0;i<rows_of_game;i++){
            for(int j=0;j<columns_of_game;j++){
                System.out.print(array[i][j] + "|"); // prints the array with mined bombs as well as numbered safe cell
            }
            System.out.println();
        }
        
        }
        
    
    private static void mining_array(String[][] arra, double probability){ // method for mining the array
        int row = arra.length; // specify the number of rows
        int col = arra[0].length; //the number of columns
        int lengthArray=row*col; // total number of spaces the array has
        
        int minesnumber = Math.round((int)(probability*lengthArray)); // specify the number of bombs to be plotted
        int count=0;
        while (count<minesnumber){
            arra[(int)(Math.random()*row)][(int)(Math.random()*col)]="*";
            count++;} // mining the bombs at random positions
            
                
    
        // iterating over array to plot a period at safe cells    
        for(int c=0;c<row;c++){ 
            for(int d=0;d<col;d++){
                if(arra[c][d]!="*"){
                    arra[c][d]=".";
                }
            }
        }
        }    

     //method to plot the number at safe cells according to bombs at their neighbouring cells
    private static void number_mine(String[][] array) { 
        int row = array.length;   // specify the number of rows
        int col = array[0].length;   //the number of columns
        // iterating over loop and placing "." with "0" at every safe cell 
        for(int x=0;x<row;x++){
            for(int y=0;y<col;y++){
                if (array[x][y]!="*"){
                array[x][y]="0";}
               
            
            }
        }
        for(int x=0;x<row;x++){
            for(int y=0;y<col;y++){
                // condition to check if cell contains bomb
                if(array[x][y]=="*"){
                    int r_start=Math.max(0,x-1); // condition to check if box in which bomb is placed has any box to its left or not
                    int r_end;  // specify where the row ends
                    if(x+1>=row) // condition to check if box in which bomb is placed has any box towards its bottom or not
                    // checks if any box or safe place even exists below the specific bomb place if x+1 is greater than the number of rows then it means that no row exist below the bomb place
                         r_end=x; 
                    else
                        r_end=x+1;
                       
                    
                    int c_start=Math.max(0,y-1); // condition to check if box in which bomb is placed has any box to its up or not
                    int c_end; // specify where the column for the loop ends
                    // checks if any box or safe place even exists to the right of the specific bomb place if y+1 is greater than the number of columns then it means that no column exists to the right of bomb place
                    if(y+1>=col)
                         c_end=y;
                    else
                        c_end=y+1;
                    
                    for(int a=r_start;a<=r_end;a++){
                        for(int b=c_start;b<=c_end;b++){
                            if(array[a][b]!="*"){  //condition to not change or add 1 to the index of position where bomb exist
                                // the below function first converts the element that is initially zero to integer increments "1" then converts back to String
                                array[a][b]=Integer.toString((Integer.parseInt(array[a][b])+1));
                                }
                            }
                        }
                    }
                }   
            }
        }
    }