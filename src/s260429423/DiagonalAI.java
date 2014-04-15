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
 *A random diagonal AI.
 */
public class DiagonalAI extends Player {
    private boolean verbose = false;
    Random rand = new Random();
    
    /** Provide a default public constructor */
    public DiagonalAI() { super("omni"); }
    public DiagonalAI(String s) { super(s); }
    
    public Board createBoard() { return new CCBoard(); }

    /** Implement the smartest way of picking moves */
    public Move chooseMove(Board theboard) 
    {
    	int xFrom, xTo, yFrom, yTo;
    	int dist, minDist, minIndex;
    	int currDist;
    	
        // Cast the arguments to the objects we want to work with
        CCBoard board = (CCBoard) theboard;

        // Get the list of legal moves.
        ArrayList<CCMove> moves = board.getLegalMoves();
        ArrayList<CCMove> moves_cpy = new ArrayList<CCMove>();
        for(int i = 0; i < moves.size(); i++) {
        	moves_cpy.add(moves.get(i));
        }
        
        //Starting top left
        if(this.getColor() == 0) {
        	for(int i = 0; i < moves.size(); i++) {
        		while(i < moves.size()) {
        			if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
        				xFrom = moves.get(i).getFrom().x;
        				yFrom = moves.get(i).getFrom().y;
        				xTo = moves.get(i).getTo().x;
        				yTo = moves.get(i).getTo().y;

        				if(xTo > xFrom && yTo > yFrom)
        					break;
        				else {
        					moves.remove(i);
        				}
        			}
        			else
        				i++;
        		}
        	}
        }
        //Starting top right
        else if(this.getColor() == 1) {
        	for(int i = 0; i < moves.size(); i++) {
        		while(i < moves.size()) {
        			if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
        				xFrom = moves.get(i).getFrom().x;
        				yFrom = moves.get(i).getFrom().y;
        				xTo = moves.get(i).getTo().x;
        				yTo = moves.get(i).getTo().y;

        				if(xTo < xFrom && yTo > yFrom)
        					break;
        				else {
        					moves.remove(i);
        				}
        			}
        			else
        				i++;
        		}
        	}
        }
        //Starting bottom left
        else if(this.getColor() == 2) {
        	for(int i = 0; i < moves.size(); i++) {
        		while(i < moves.size()) {
        			if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
        				xFrom = moves.get(i).getFrom().x;
        				yFrom = moves.get(i).getFrom().y;
        				xTo = moves.get(i).getTo().x;
        				yTo = moves.get(i).getTo().y;

        				if(xTo > xFrom && yTo < yFrom)
        					break;
        				else {
        					moves.remove(i);
        				}
        			}
        			else
        				i++;
        		}
        	}
        }
        //Starting bottom right
        else {
        	for(int i = 0; i < moves.size(); i++) {
        		while(i < moves.size()) {
        			if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
        				xFrom = moves.get(i).getFrom().x;
        				yFrom = moves.get(i).getFrom().y;
        				xTo = moves.get(i).getTo().x;
        				yTo = moves.get(i).getTo().y;

        				if(xTo < xFrom && yTo < yFrom)
        					break;
        				else {
        					moves.remove(i);
        				}
        			}
        			else
        				i++;
        		}
        	}
        }
        
        // Otherwise, return a randomly selected move.
        if(moves.size() == 0) {
        	return (CCMove) moves_cpy.get(rand.nextInt(moves_cpy.size()));
        }
        return (CCMove) moves.get(rand.nextInt(moves.size()));
    }
}
