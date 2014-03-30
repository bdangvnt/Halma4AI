package s2011831;

import halma.CCBoard;
import halma.CCMove;

import java.util.ArrayList;
import java.util.Random;

import s2011831.mytools.MyTools;


import boardgame.Board;
import boardgame.Move;
import boardgame.Player;

/**
 *A random Halma player.
 */
public class s2011831Player extends Player {
    Random rand = new Random();
    
    /** Provide a default public constructor */
    public s2011831Player() { super("2011831"); }
    public s2011831Player(String s) { super(s); }
    
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
