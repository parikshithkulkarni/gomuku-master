package com.five.beans;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FiveRow {
	 public static void main (String[] args)throws Exception
     {
         BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
          char[][] B =new char[5][5];       // B is forBoard

          boolean win= false;
          int players;
         System.out.print("How many players are there? ");
            players = Integer.parseInt(keyIn.readLine());

          char[] c =new char[players];
            for(int i=0;i<players;i++)
                   {System.out.print("enter symbol for player "+(i+1));
                    c[i]=keyIn.readLine().charAt(0);
                       }



         System.out.println("\n");
         System.out.println("   ~~~~~~~~ 5 IN A ROW GAME~~~~~~~~");
         System.out.println("\n");

          //initializeour board
          for(int i=0;i<5; i++)
             for(int j=0; j<5; j++)
                 B[i][j] = '-';       
       
          //displayour board
          for (int i=0; i<5; i++)
          {
              for(int j=0; j<5; j++)
                   System.out.print("\t" +B[i][j]);

              System.out.println();
           }

          for(int t=0; (t<25) && !win ; t++)
          {
            System.out.println("Player "+(t%players+1));
             System.out.print("row =");
             int row = Integer.parseInt(keyIn.readLine());
             System.out.print("column = ");
             int col = Integer.parseInt(keyIn.readLine());
             
             B[row][col] = c[t%players];   //alternates betweenplayers

             //display board
              for(int i=0; i<5; i++)
              {
                   for (int j=0;j<5;j++)
                   System.out.print("\t" + B[i][j]);

                   System.out.println();


              }                
          }
}

}
