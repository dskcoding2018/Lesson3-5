/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xogame;

import java.util.Scanner;

/**
 *
 * @author Temporary
 */
public class XOGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the O and X game!");
        
        //deal with user input now.
        System.out.println("This game works by the user entering the location of their choice, starting count from 0 not 1.");
        
        
        Board tutorialBoard = new Board();
        tutorialBoard.makeMove("X", 1, 1);
        System.out.println("E.g. in order to play in the middle, type 11 for X's first move to be here:");
        tutorialBoard.printBoard();
        System.out.println("Note that picking a spot occupied by another symbol will void your turn");
        
        Board gameboard = new Board();
        
        //get user input using scanner class
        Scanner input = new Scanner(System.in);
        String userInput;
        
        int moveCounter = 0;
        while(!gameboard.gameOver()){
            if(moveCounter % 2 == 0) {
                System.out.println("X it is your turn: ");
                
            }else {
                System.out.println("O it is your turn: ");
            }
            
            userInput = input.next();
            gameboard.makeMove(moveCounter%2 ==0 ? "X" : "O", Integer.valueOf(userInput.substring(0,1)), Integer.valueOf(userInput.substring(1,2)));
            gameboard.printBoard();
            moveCounter++;
        }
        
    }
    
}
