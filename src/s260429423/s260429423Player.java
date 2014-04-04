package s260429423;

import halma.CCBoard;
import halma.CCMove;

import java.util.ArrayList;
import java.util.Random;

import s260429423.mytools.MyTools;


import boardgame.Board;
import boardgame.Move;
import boardgame.Player;

/**
 *A random Halma player.
 */
public class s260429423Player extends Player {
    Random rand = new Random();
    
    /** Provide a default public constructor */
    public s260429423Player() { super("260429423"); }
    public s260429423Player(String s) { super(s); }
    
    public Board createBoard() { return new CCBoard(); }

    /** Implement a very stupid way of picking moves */
    public Move chooseMove(Board theboard) 
    {
        // Cast the arguments to the objects we want to work with
        CCBoard board = (CCBoard) theboard;

        // Get the list of legal moves.
        ArrayList<CCMove> moves = board.getLegalMoves();

        // Use my tool for nothing
        MyTools.getSomething();
        
        // Return a randomly selected move.
        return (CCMove) moves.get(rand.nextInt(moves.size()));
    }
    
}