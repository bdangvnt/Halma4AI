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
public class s260429423Player extends Player {
	private boolean verbose = false;
	Random rand = new Random();
	boolean earlyGame = true;
	CCMove move;
	int turn = 0;

	/** Provide a default public constructor */
	public s260429423Player() { super("s260429423Player"); }
	public s260429423Player(String s) { super(s); }

	public Board createBoard() { return new CCBoard(); }

	/** Implement the smartest way of picking moves */
	public Move chooseMove(Board theboard) 
	{
		int currDist, minIndex;
		int goalPieces = 0;
		CCMove moveEndGame;
		
		// Cast the arguments to the objects we want to work with
		CCBoard board = (CCBoard) theboard;
		
		//Array containing the location of the player's pieces
		ArrayList<Point> pts = board.getPieces(playerID);

		// Get the list of legal moves.
		ArrayList<CCMove> moves = board.getLegalMoves();
		ArrayList<CCMove> moves_cpy = new ArrayList<CCMove>();
		for(int i = 0; i < moves.size(); i++) {
			moves_cpy.add(moves.get(i));
		}

		//Prints useful stuff
		//Manhattan distance
		currDist = Algorithm.getShortestManhattanDist(this.playerID, board);
//		System.out.println("Manhattan Distance for Player " + this.playerID + ": " + currDist);

		//Prints number of pieces in goal zone
		goalPieces = Algorithm.numPiecesInGoal(this.playerID, board);
//		System.out.println("Pieces in goal for Player " + this.playerID + ": " + goalPieces);

		//Prints current turn
//		System.out.println("Current turn: " + turn);
		
		//Strategy starts here
		if(turn < 14) {
			move = Algorithm.earlyGameMove(this, this.playerID, board, this.turn);
			if (move != null) {
				return move;
			}
		}
		
		//Mid-game

		if(goalPieces < 10) {
			Algorithm.filterPointsMovingAway(this.playerID, moves);
			if(moves.size() > 0) {
				minIndex = Algorithm.useManhattanDist(this.playerID, moves, currDist);
				return moves.get(minIndex);
			}
			
			else if(currDist <= 60) {
				CCMove moveEarly;
				moves = board.getLegalMoves();
				Algorithm.getMovesOutOfGoal(this.playerID, moves);
				moveEarly = Algorithm.useManhattanDist2(this.playerID, moves);
				if(moveEarly != null) {
					return moveEarly;
				}
				if(board.getLastMoved() != null) {
					return new CCMove(this.playerID, null, null);
				}
				moves = board.getLegalMoves();
				Algorithm.filterPointsMovingAway(this.playerID, moves);
			}
		}
		
		//When there are 10 pieces in the zone, use another Manhattan
		else if(goalPieces == 10 || goalPieces == 11) {
			Algorithm.filterPointsMovingAway(this.playerID, moves, 0);
			if(moves.size() > 0) {
				minIndex = Algorithm.useManhattanDist(this.playerID, moves, currDist);
				return moves.get(minIndex);
			}
			else if(currDist <= 60) {
				CCMove moveEarly;
				moves = board.getLegalMoves();
				Algorithm.getMovesOutOfGoal(this.playerID, moves);
				moveEarly = Algorithm.useManhattanDist2(this.playerID, moves);
				if(moveEarly != null) {
					return moveEarly;
				}
				if(board.getLastMoved() != null) {
					return new CCMove(this.playerID, null, null);
				}
				moves = board.getLegalMoves();
				Algorithm.filterPointsMovingAway(this.playerID, moves);
			}
		}
		
		//When there are 12 pieces in the zone, use another Manhattan
		else if(goalPieces == 12) {
//			System.out.println("*****END GAME*****");
			if(moves.size() > 0) {
				if(!Algorithm.isCorner3DiagonalFilled(this.playerID, board)) {
					Algorithm.filterPointsMovingAway(this.playerID, moves, 0);
					if(moves.size() > 0) {
						minIndex = Algorithm.useManhattanDist(this.playerID, moves, currDist);
						return moves.get(minIndex);
					}
				}
				else {
					if(board.getLastMoved() != null) {
						return new CCMove(this.playerID, null, null);
					}
					
					Point pointOutOfGoal = new Point(0,0);
					Point pointDestination;
					
					for(int i = 0; i < pts.size(); i++) {
						if(!Algorithm.IsPieceInGoal(this.playerID, pts.get(i))) {
							pointOutOfGoal = pts.get(i);
							break;
						}
					}
					
					//Finds the empty spot in the goal
					pointDestination = Algorithm.findEmptyGoal(this.playerID, board);
					
					System.out.println("pointOutOfGoal " + pointOutOfGoal + " - pointDestination " + pointDestination);
					
					//Filters out moves
					Algorithm.filterEndGame(moves, pointOutOfGoal, pointDestination);
					
					if(moves.size() > 0) {
						moveEndGame = Algorithm.getBestMoveEndGame(this.playerID, moves, pointOutOfGoal, pointDestination);
						if(moveEndGame.getFrom() != null && moveEndGame.getTo() != null)
							return moveEndGame;
						if(board.getLastMoved() != null && moveEndGame.getFrom() == null && moveEndGame.getTo() == null) {
							return new CCMove(this.playerID, null, null);
						}
					}
					else if(moves.size() == 0 && board.getLastMoved() != null) {
						return new CCMove(this.playerID, null, null);
					}
				}
			}
		}
		
		if(board.getLastMoved() != null) {
			return new CCMove(this.playerID, null, null);
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
