package s260429423.mytools;

import halma.CCBoard;
import halma.CCMove;
import s260429423.Omni;

import java.awt.Point;
import java.util.ArrayList;

public class Algorithm {
	public static int getShortestManhattanDist(int playerID, CCBoard board) {
		int result = 0;
		ArrayList<Point> pts = board.getPieces(playerID);

		for(int i = 0; i < pts.size(); i++) {
			//Top left player
			if(playerID == 0)
				result += (15 - pts.get(i).x + 15 - pts.get(i).y);

			//Top right player
			else if(playerID == 1)
				result += (pts.get(i).x + 15 - pts.get(i).y);

			//Bottom left player
			else if(playerID == 2)
				result += (15 - pts.get(i).x + pts.get(i).y);

			else if(playerID == 3)
				result += (pts.get(i).x + pts.get(i).y);
		}
		return result;
	}

	public static int getManhattanDist(int xFrom, int yFrom, int xTo, int yTo) {
		return Math.abs(xTo - xFrom) + Math.abs(yTo - yFrom);
	}
	
	public static void filterPointsMovingAway(int playerID, ArrayList<CCMove> moves) {
		int xFrom, xTo, yFrom, yTo;

		//Top left player
		if(playerID == 0) {
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

		//Top right player
		if(playerID == 1) {
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

		//Bottom left player
		if(playerID == 2) {
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

		//Bottom right player
		if(playerID == 3) {
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
	}

	public static int useManhattanDist(int playerID, ArrayList<CCMove> moves, int currDist) {
		int minDist;
		int dist = 0;
		int xFrom, xTo, yFrom, yTo;
		int minIndex = 0;

		minDist = currDist;

		for(int i = 0; i < moves.size(); i++) {
			if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
				xFrom = moves.get(i).getFrom().x;
				yFrom = moves.get(i).getFrom().y;
				xTo = moves.get(i).getTo().x;
				yTo = moves.get(i).getTo().y;

				if(playerID == 0)
					dist = currDist - ((xTo - xFrom) + (yTo - yFrom));
				else if(playerID == 1)
					dist = currDist - ((xFrom - xTo) + (yTo - yFrom));
				else if(playerID == 2)
					dist = currDist - ((xTo - xFrom) + (yFrom - yTo));
				else if(playerID == 3)
					dist = currDist - ((xFrom - xTo) + (yFrom - yTo));
				
				if(dist <= minDist) {
					minDist = dist;
					minIndex = i;
				}
			}
		}

		return minIndex;
	}
	
	public static CCMove earlyGameMove(int playerID, int turn) {
		
	return null;
	}
	
	public static int numPiecesInGoal(int playerID, CCBoard board) {
		int result = 0;
		
		//Top left player
		if(playerID == 0) {
			if(board.getPieceAt(new Point(15,15)) != null && board.getPieceAt(new Point(15,15)) == playerID)
				result++;
			if(board.getPieceAt(new Point(14,15)) != null && board.getPieceAt(new Point(14,15)) == playerID)
				result++;
			if(board.getPieceAt(new Point(13,15)) != null && board.getPieceAt(new Point(13,15)) == playerID)
				result++;
			if(board.getPieceAt(new Point(12,15)) != null && board.getPieceAt(new Point(12,15)) == playerID)
				result++;
			if(board.getPieceAt(new Point(15,14)) != null && board.getPieceAt(new Point(15,14)) == playerID)
				result++;
			if(board.getPieceAt(new Point(14,14)) != null && board.getPieceAt(new Point(14,14)) == playerID)
				result++;
			if(board.getPieceAt(new Point(13,14)) != null && board.getPieceAt(new Point(13,14)) == playerID)
				result++;
			if(board.getPieceAt(new Point(12,14)) != null && board.getPieceAt(new Point(12,14)) == playerID)
				result++;
			if(board.getPieceAt(new Point(15,13)) != null && board.getPieceAt(new Point(15,13)) == playerID)
				result++;
			if(board.getPieceAt(new Point(14,13)) != null && board.getPieceAt(new Point(14,13)) == playerID)
				result++;
			if(board.getPieceAt(new Point(13,13)) != null && board.getPieceAt(new Point(13,13)) == playerID)
				result++;
			if(board.getPieceAt(new Point(15,12)) != null && board.getPieceAt(new Point(15,12)) == playerID)
				result++;
			if(board.getPieceAt(new Point(14,12)) != null && board.getPieceAt(new Point(14,12)) == playerID)
				result++;
		}
		
		//Top right player
		else if(playerID == 1) {
			if(board.getPieceAt(new Point(0,15)) != null && board.getPieceAt(new Point(0,15)) == playerID)
				result++;
			if(board.getPieceAt(new Point(1,15)) != null && board.getPieceAt(new Point(1,15)) == playerID)
				result++;
			if(board.getPieceAt(new Point(2,15)) != null && board.getPieceAt(new Point(2,15)) == playerID)
				result++;
			if(board.getPieceAt(new Point(3,15)) != null && board.getPieceAt(new Point(3,15)) == playerID)
				result++;
			if(board.getPieceAt(new Point(0,14)) != null && board.getPieceAt(new Point(0,14)) == playerID)
				result++;
			if(board.getPieceAt(new Point(1,14)) != null && board.getPieceAt(new Point(1,14)) == playerID)
				result++;
			if(board.getPieceAt(new Point(2,14)) != null && board.getPieceAt(new Point(2,14)) == playerID)
				result++;
			if(board.getPieceAt(new Point(3,14)) != null && board.getPieceAt(new Point(3,14)) == playerID)
				result++;
			if(board.getPieceAt(new Point(0,13)) != null && board.getPieceAt(new Point(0,13)) == playerID)
				result++;
			if(board.getPieceAt(new Point(1,13)) != null && board.getPieceAt(new Point(1,13)) == playerID)
				result++;
			if(board.getPieceAt(new Point(2,13)) != null && board.getPieceAt(new Point(2,13)) == playerID)
				result++;
			if(board.getPieceAt(new Point(0,12)) != null && board.getPieceAt(new Point(0,12)) == playerID)
				result++;
			if(board.getPieceAt(new Point(1,12)) != null && board.getPieceAt(new Point(1,12)) == playerID)
				result++;
		}
		
		//Bottom left player
		else if(playerID == 2) {
			if(board.getPieceAt(new Point(15,0)) != null && board.getPieceAt(new Point(15,0)) == playerID)
				result++;
			if(board.getPieceAt(new Point(14,0)) != null && board.getPieceAt(new Point(14,0)) == playerID)
				result++;
			if(board.getPieceAt(new Point(13,0)) != null && board.getPieceAt(new Point(13,0)) == playerID)
				result++;
			if(board.getPieceAt(new Point(12,0)) != null && board.getPieceAt(new Point(12,0)) == playerID)
				result++;
			if(board.getPieceAt(new Point(15,1)) != null && board.getPieceAt(new Point(15,1)) == playerID)
				result++;
			if(board.getPieceAt(new Point(14,1)) != null && board.getPieceAt(new Point(14,1)) == playerID)
				result++;
			if(board.getPieceAt(new Point(13,1)) != null && board.getPieceAt(new Point(13,1)) == playerID)
				result++;
			if(board.getPieceAt(new Point(12,1)) != null && board.getPieceAt(new Point(12,1)) == playerID)
				result++;
			if(board.getPieceAt(new Point(15,2)) != null && board.getPieceAt(new Point(15,2)) == playerID)
				result++;
			if(board.getPieceAt(new Point(14,2)) != null && board.getPieceAt(new Point(14,2)) == playerID)
				result++;
			if(board.getPieceAt(new Point(13,2)) != null && board.getPieceAt(new Point(13,2)) == playerID)
				result++;
			if(board.getPieceAt(new Point(15,3)) != null && board.getPieceAt(new Point(15,3)) == playerID)
				result++;
			if(board.getPieceAt(new Point(14,3)) != null && board.getPieceAt(new Point(14,3)) == playerID)
				result++;
		}
		
		//Bottom right player
		else if(playerID == 3) {
			if(board.getPieceAt(new Point(0,0)) != null && board.getPieceAt(new Point(0,0)) == playerID)
				result++;
			if(board.getPieceAt(new Point(1,0)) != null && board.getPieceAt(new Point(1,0)) == playerID)
				result++;
			if(board.getPieceAt(new Point(2,0)) != null && board.getPieceAt(new Point(2,0)) == playerID)
				result++;
			if(board.getPieceAt(new Point(3,0)) != null && board.getPieceAt(new Point(3,0)) == playerID)
				result++;
			if(board.getPieceAt(new Point(0,1)) != null && board.getPieceAt(new Point(0,1)) == playerID)
				result++;
			if(board.getPieceAt(new Point(1,1)) != null && board.getPieceAt(new Point(1,1)) == playerID)
				result++;
			if(board.getPieceAt(new Point(2,1)) != null && board.getPieceAt(new Point(2,1)) == playerID)
				result++;
			if(board.getPieceAt(new Point(3,1)) != null && board.getPieceAt(new Point(3,1)) == playerID)
				result++;
			if(board.getPieceAt(new Point(0,2)) != null && board.getPieceAt(new Point(0,2)) == playerID)
				result++;
			if(board.getPieceAt(new Point(1,2)) != null && board.getPieceAt(new Point(1,2)) == playerID)
				result++;
			if(board.getPieceAt(new Point(2,2)) != null && board.getPieceAt(new Point(2,2)) == playerID)
				result++;
			if(board.getPieceAt(new Point(0,3)) != null && board.getPieceAt(new Point(0,3)) == playerID)
				result++;
			if(board.getPieceAt(new Point(1,3)) != null && board.getPieceAt(new Point(1,3)) == playerID)
				result++;
		}
		return result;
	}
}