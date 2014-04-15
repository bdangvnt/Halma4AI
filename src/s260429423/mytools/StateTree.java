package s260429423.mytools;

import java.util.*;
import halma.CCBoard;
import halma.CCMove;

public class StateTree {
	public CCBoard board;
	public ArrayList<CCMove> moves;
	public StateTree parent;
	public ArrayList<StateTree> children;
	
	//Features
	public int manhattanDist = 358;
	public int secondHalf = 0;
	public int piecesInGoal = 0;
	
	public StateTree(CCBoard board, ArrayList<CCMove> moves, StateTree parent, ArrayList<StateTree> children) {
		this.board = board;
		this.moves = moves;
		this.parent = parent;
		this.children = children;
	}
}
