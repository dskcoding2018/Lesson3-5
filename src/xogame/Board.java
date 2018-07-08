/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xogame;

/**
 *
 * @author Temporary
 */
public class Board {
    private int[][] board;
    
    private boolean gameWon;
    
    public Board () {
        createBoard();
    }
    
    private void createBoard() {
        this.board = new int[3][3];
        //set each value to 0, meaning no peace there.
        for(int row = 0; row < this.board.length; row++) {
            for(int column = 0; column < this.board[row].length; column++){
                this.board[row][column] = 0;
            }
        }
    }
    
    public void printBoard() {
        for(int row = 0; row < this.board.length; row++) {
            for(int column = 0; column < this.board[row].length; column++){
                System.out.print(convertValueToSymbol(this.board[row][column]));
                if(column != 2){
                    System.out.print("|");
                }else {//move to new line as new row.
                    System.out.println("");
                }
            }
        }
    }
    
    private String convertValueToSymbol(int value){
        switch (value) {
            case 0:
                return "-";
            case 1:
                return "X";
            default:
                return "O";
        }
    }
    
    public void makeMove(String symbol, int row, int column) {
        System.out.println("Row: " + row + " Column" + column);
        if(this.board[row][column] == 0){ 
            this.board[row][column] = this.convertSymbolToValue(symbol);
            if(isGameWon()) this.gameWon = true;
        }
    }
    
    private int convertSymbolToValue(String symbol){
        //return exits instantly, therefore no need to do else.
        if(symbol.equalsIgnoreCase("X"))
            return 1;
        if(symbol.equalsIgnoreCase("0") || symbol.equalsIgnoreCase("O"))
            return 2;
        else return 0; //empty field/null value.
    }
    
    //need to check if the game has been won by getting three in a row. First check next to each other in straight line fashion.
    private boolean isGameWon(){
        //first check if row has matching.
        for(int row = 0; row < this.board.length; row++) {
            if(this.board[row][0] == this.board[row][1] && this.board[row][1] == this.board[row][2] && this.board[row][0] != 0){
                System.out.println(convertValueToSymbol(this.board[row][1]) + " has won the game!");
                return true;
            }
        }
        //check columns.
        for(int column = 0; column < this.board.length; column++) {
            if(this.board[0][column] == this.board[1][column] && this.board[1][column] == this.board[2][column] && this.board[0][column] != 0){
                System.out.println(convertValueToSymbol(this.board[0][column]) + " has won the game!");
                return true;
            }
        }
        
        //check diagonally - always have middle check first so if can be evaluated quickly, if X middle O has no chance of being correct
        if(this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2] && this.board[1][1] != 0 //check \
                || this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0] && this.board[1][1] != 0) {//check /
            System.out.println(convertValueToSymbol(this.board[1][1]) + " has won the game!");
                return true;
        }
        return false;
    }
    
    public boolean gameOver() {
        return gameWon;
    }
    
}
