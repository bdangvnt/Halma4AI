package s260429423;

import halma.CCBoard;
import halma.CCMove;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import s260429423.mytools.Algorithm;
import boardgame.Board;
import boardgame.Move;
import boardgame.Player;

/**
 *The ultimate OmniAI.
 */
public class Omni extends Player {
	private boolean verbose = false;
	Random rand = new Random();
	boolean earlyGame = true;
	CCMove move;
	int turn = 0;

	/** Provide a default public constructor */
	public Omni() { super("omni"); }
	public Omni(String s) { super(s); }

	public Board createBoard() { return new CCBoard(); }

	/** Implement the smartest way of picking moves */
	public Move chooseMove(Board theboard) 
	{
		int currDist, minIndex;
		int goalPieces = 0;
		
		// Cast the arguments to the objects we want to work with
		CCBoard board = (CCBoard) theboard;

		// Get the list of legal moves.
		ArrayList<CCMove> moves = board.getLegalMoves();
		ArrayList<CCMove> moves_cpy = new ArrayList<CCMove>();
		for(int i = 0; i < moves.size(); i++) {
			moves_cpy.add(moves.get(i));
		}
		
		//Prints useful stuff
		//Manhattan distance
		System.out.println("Manhattan Distance for Player " + this.playerID + ": " + Algorithm.getShortestManhattanDist(this.playerID, board));
		currDist = Algorithm.getShortestManhattanDist(this.playerID, board);
		
		//Prints number of pieces in goal zone
		goalPieces = Algorithm.numPiecesInGoal(this.playerID, board);
		System.out.println(goalPieces);
		
		//Strategy starts here
		if(earlyGame) {
			move = Algorithm.earlyGameMove(this.playerID, this.turn);
		}
		
		//Mid-game
		//

		Algorithm.filterPointsMovingAway(this.playerID, moves);

		if(moves.size() > 0) {
			minIndex = Algorithm.useManhattanDist(this.playerID, moves, currDist);
			return moves.get(minIndex);
		}
		
		//When there are 10 pieces in the zone, use another Manhattan
		if(goalPieces >= 10) {
			
		}
		
		//When there are 12 pieces in the zone, use another Manhattan
		if(goalPieces == 12) {
			
		}

		// Otherwise, return a randomly selected move.
		if(moves.size() == 0) {
			return (CCMove) moves_cpy.get(rand.nextInt(moves_cpy.size()));
		}
		return (CCMove) moves.get(rand.nextInt(moves.size()));
	}
	
	public void increaseTurn() {
		turn++;
	}
}
