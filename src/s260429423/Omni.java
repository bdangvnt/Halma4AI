package s260429423;

import halma.CCBoard;
import halma.CCMove;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import boardgame.Board;
import boardgame.Move;
import boardgame.Player;

/**
 *The ultimate OmniAI.
 */
public class Omni extends Player {
    private boolean verbose = false;
    Random rand = new Random();
    
    /** Provide a default public constructor */
    public Omni() { super("omni"); }
    public Omni(String s) { super(s); }
    
    public Board createBoard() { return new CCBoard(); }

    /** Implement a very stupid way of picking moves */
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
        	System.out.println("Manhattan Distance: " + getManhattanDist(board));
        	currDist = getManhattanDist(board);
        	minDist = currDist;
        	minIndex = 0;
        	
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
        	
        	minDist = currDist;
        	for(int i = 0; i < moves.size(); i++) {
        		if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
    				xFrom = moves.get(i).getFrom().x;
    				yFrom = moves.get(i).getFrom().y;
    				xTo = moves.get(i).getTo().x;
    				yTo = moves.get(i).getTo().y;

        			dist = currDist - ((xTo - xFrom) + (yTo - yFrom));
        			if(dist <= minDist) {
        				minDist = dist;
        				minIndex = i;
        			}
        		}
        	}
        	if(moves.size() > 0)
        		return moves.get(minIndex);
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
    
    int getManhattanDist(CCBoard board) {
    	int result = 0;
    	ArrayList<Point> pts = board.getPieces(this.playerID);
    	
    	for(int i = 0; i < pts.size(); i++) {
    		if(this.playerID == 0) {
    			result += (15 - pts.get(i).x + 15 - pts.get(i).y);
    		}
    	}
    	
    	return result;
    }
}
