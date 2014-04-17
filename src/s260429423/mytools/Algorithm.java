package s260429423.mytools;

import halma.CCBoard;
import halma.CCMove;
import s260429423.s260429423Player;

import java.awt.Point;
import java.util.ArrayList;

import boardgame.Player;

//Algorithm class: helper class that is used by the Player to execute moves
public class Algorithm {
	
	//Gets the shortest Manhattan distance to the goal corner from a list of moves
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

	//Gets the distance from a point A to a point B
	public static int getManhattanDist(int xFrom, int yFrom, int xTo, int yTo) {
		return Math.abs(xTo - xFrom) + Math.abs(yTo - yFrom);
	}

	//Filters points moving away from the goal zone
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

		//Bottom left player
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

		//Top right player
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

	//Doesn't remove points that aren't diagonals compared to the previous method
	public static void filterPointsMovingAway(int playerID, ArrayList<CCMove> moves, int in) {
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

						if(xTo >= xFrom && yTo >= yFrom)
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

		//Bottom left
		if(playerID == 1) {
			for(int i = 0; i < moves.size(); i++) {
				while(i < moves.size()) {
					if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
						xFrom = moves.get(i).getFrom().x;
						yFrom = moves.get(i).getFrom().y;
						xTo = moves.get(i).getTo().x;
						yTo = moves.get(i).getTo().y;

						if(xTo <= xFrom && yTo >= yFrom)
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
		if(playerID == 2) {
			for(int i = 0; i < moves.size(); i++) {
				while(i < moves.size()) {
					if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
						xFrom = moves.get(i).getFrom().x;
						yFrom = moves.get(i).getFrom().y;
						xTo = moves.get(i).getTo().x;
						yTo = moves.get(i).getTo().y;

						if(xTo >= xFrom && yTo <= yFrom)
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

						if(xTo <= xFrom && yTo <= yFrom)
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

	//From a list of moves, find the biggest change using Manhattan distance
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

	//Gets a piece outside the goal and tries to make it go towards the center of the goal zone
	public static CCMove useManhattanDist2(int playerID, ArrayList<CCMove> moves) {
		Point pointDestination = new Point(0,0);
		int currManhattan;
		int newManhattan;
		int index = -1;
		int bestManhattan = 0;

		if(playerID == 0)
			pointDestination = new Point(13,13);
		else if(playerID == 1)
			pointDestination = new Point(2,13);
		else if(playerID == 2)
			pointDestination = new Point(13,2);
		else if(playerID == 3)
			pointDestination = new Point(2,2);

		for(int i = 0; i < moves.size(); i++) {
			if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
				currManhattan = Algorithm.getManhattanDist(moves.get(i).getFrom().x, moves.get(i).getFrom().y, pointDestination.x, pointDestination.y);
				newManhattan = Algorithm.getManhattanDist(moves.get(i).getTo().x, moves.get(i).getTo().y, pointDestination.x, pointDestination.y);

				if(currManhattan - newManhattan > bestManhattan) {
					bestManhattan = currManhattan - newManhattan;
					index = i;
				}

			}
		}
		if(index != -1) {
			moves.get(index).toPrettyString();
			return moves.get(index);
		}
		return null;
	}

	//From a list of moves, get rid of the ones that contain pieces in the goal
	public static void getMovesOutOfGoal(int playerID, ArrayList<CCMove> moves) {
		int i = 0;
		while(i < moves.size()) {
			if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
				if(Algorithm.IsPieceInGoal(playerID, moves.get(i).getFrom())) {
					moves.remove(i);
				}
				else {
					i++;
				}
			}
			else {
				moves.remove(i);
			}
		}
	}

	//Early game moves
	public static CCMove earlyGameMove(s260429423Player player, int playerID, CCBoard board, int turn) {
		CCMove move = null;

		//Top left player
		if(playerID == 0) {
			//Turn 0
			if(turn == 0) {
				if(board.isLegal(new CCMove(playerID, new Point(2,2), new Point(3,3)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(2,2), new Point(3,3));
				}
			}

			//Turn 1
			else if(turn == 1) {
				if(board.isLegal(new CCMove(playerID, new Point(0,0), new Point(2,2)))) {
					return new CCMove(playerID, new Point(0,0), new Point(2,2));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(2,2), new Point(4,4)))) {
					return new CCMove(playerID, new Point(2,2), new Point(4,4));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}

			//Turn 2
			else if(turn == 2) {
				if(board.isLegal(new CCMove(playerID, new Point(0,1), new Point(2,3)))) {
					return new CCMove(playerID, new Point(0,1), new Point(2,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(2,3), new Point(4,3)))) {
					return new CCMove(playerID, new Point(2,3), new Point(4,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(4,3), new Point(4,5)))) {
					return new CCMove(playerID, new Point(4,3), new Point(4,5));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}

			//Turn 3
			else if(turn == 3) {
				if(board.isLegal(new CCMove(playerID, new Point(1,0), new Point(3,2)))) {
					return new CCMove(playerID, new Point(1,0), new Point(3,2));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,2), new Point(3,4)))) {
					return new CCMove(playerID, new Point(3,2), new Point(3,4));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,4), new Point(5,4)))) {
					return new CCMove(playerID, new Point(3,4), new Point(5,4));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 4
			else if(turn == 4) {
				if(board.isLegal(new CCMove(playerID, new Point(0,3), new Point(2,3)))) {
					return new CCMove(playerID, new Point(0,3), new Point(2,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(2,3), new Point(4,3)))) {
					return new CCMove(playerID, new Point(2,3), new Point(4,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(4,3), new Point(6,5)))) {
					return new CCMove(playerID, new Point(4,3), new Point(6,5));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 5
			else if(turn == 5) {
				if(board.isLegal(new CCMove(playerID, new Point(3,0), new Point(3,2)))) {
					return new CCMove(playerID, new Point(3,0), new Point(3,2));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,2), new Point(3,4)))) {
					return new CCMove(playerID, new Point(3,2), new Point(3,4));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,4), new Point(5,6)))) {
					return new CCMove(playerID, new Point(3,4), new Point(5,6));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 6
			else if(turn == 6) {
				if(board.isLegal(new CCMove(playerID, new Point(0,2), new Point(2,4)))) {
					return new CCMove(playerID, new Point(0,2), new Point(2,4));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 7
			else if(turn == 7) {
				if(board.isLegal(new CCMove(playerID, new Point(2,0), new Point(4,2)))) {
					return new CCMove(playerID, new Point(2,0), new Point(4,2));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 8
			else if(turn == 8) {
				if(board.isLegal(new CCMove(playerID, new Point(1,3), new Point(3,5)))) {
					return new CCMove(playerID, new Point(1,3), new Point(3,5));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,5), new Point(5,5)))) {
					return new CCMove(playerID, new Point(3,5), new Point(5,5));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(5,5), new Point(5,7)))) {
					return new CCMove(playerID, new Point(5,5), new Point(5,7));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 9
			else if(turn == 9) {
				if(board.isLegal(new CCMove(playerID, new Point(3,1), new Point(5,3)))) {
					return new CCMove(playerID, new Point(3,1), new Point(5,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(5,3), new Point(5,5)))) {
					return new CCMove(playerID, new Point(5,3), new Point(5,5));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(5,5), new Point(7,5)))) {
					return new CCMove(playerID, new Point(5,5), new Point(7,5));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 10
			else if(turn == 10) {
				if(board.isLegal(new CCMove(playerID, new Point(1,1), new Point(2,2)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(1,1), new Point(2,2));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 11
			else if(turn == 11) {
				if(board.isLegal(new CCMove(playerID, new Point(1,2), new Point(3,2)))) {
					return new CCMove(playerID, new Point(1,2), new Point(3,2));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,2), new Point(3,4)))) {
					return new CCMove(playerID, new Point(3,2), new Point(3,4));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 12
			else if(turn == 12) {
				if(board.isLegal(new CCMove(playerID, new Point(2,1), new Point(2,3)))) {
					return new CCMove(playerID, new Point(2,1), new Point(2,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(2,3), new Point(4,3)))) {
					return new CCMove(playerID, new Point(2,3), new Point(4,3));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 13
			else if(turn == 13) {
				if(board.isLegal(new CCMove(playerID, new Point(2,2), new Point(2,3)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(2,2), new Point(2,3));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
		}
		
		//Bottom left player
		else if(playerID == 1) {
			//Turn 0
			if(turn == 0) {
				if(board.isLegal(new CCMove(playerID, new Point(13,2), new Point(12,3)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(13,2), new Point(12,3));
				}
			}

			//Turn 1
			else if(turn == 1) {
				if(board.isLegal(new CCMove(playerID, new Point(15,0), new Point(13,2)))) {
					return new CCMove(playerID, new Point(15,0), new Point(13,2));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(13,2), new Point(11,4)))) {
					return new CCMove(playerID, new Point(13,2), new Point(11,4));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}

			//Turn 2
			else if(turn == 2) {
				if(board.isLegal(new CCMove(playerID, new Point(15,1), new Point(13,3)))) {
					return new CCMove(playerID, new Point(15,1), new Point(13,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(13,3), new Point(11,3)))) {
					return new CCMove(playerID, new Point(13,3), new Point(11,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(11,3), new Point(11,5)))) {
					return new CCMove(playerID, new Point(11,3), new Point(11,5));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}

			//Turn 3
			else if(turn == 3) {
				if(board.isLegal(new CCMove(playerID, new Point(14,0), new Point(12,2)))) {
					return new CCMove(playerID, new Point(14,0), new Point(12,2));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,2), new Point(12,4)))) {
					return new CCMove(playerID, new Point(12,2), new Point(12,4));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,4), new Point(10,4)))) {
					return new CCMove(playerID, new Point(12,4), new Point(10,4));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 4
			else if(turn == 4) {
				if(board.isLegal(new CCMove(playerID, new Point(15,3), new Point(13,3)))) {
					return new CCMove(playerID, new Point(15,3), new Point(13,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(13,3), new Point(11,3)))) {
					return new CCMove(playerID, new Point(13,3), new Point(11,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(11,3), new Point(9,5)))) {
					return new CCMove(playerID, new Point(11,3), new Point(9,5));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 5
			else if(turn == 5) {
				if(board.isLegal(new CCMove(playerID, new Point(12,0), new Point(12,2)))) {
					return new CCMove(playerID, new Point(12,0), new Point(12,2));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,2), new Point(12,4)))) {
					return new CCMove(playerID, new Point(12,2), new Point(12,4));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,4), new Point(10,6)))) {
					return new CCMove(playerID, new Point(12,4), new Point(10,6));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 6
			else if(turn == 6) {
				if(board.isLegal(new CCMove(playerID, new Point(15,2), new Point(13,4)))) {
					return new CCMove(playerID, new Point(15,2), new Point(13,4));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 7
			else if(turn == 7) {
				if(board.isLegal(new CCMove(playerID, new Point(13,0), new Point(11,2)))) {
					return new CCMove(playerID, new Point(13,0), new Point(11,2));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 8
			else if(turn == 8) {
				if(board.isLegal(new CCMove(playerID, new Point(14,3), new Point(12,5)))) {
					return new CCMove(playerID, new Point(14,3), new Point(12,5));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,5), new Point(10,5)))) {
					return new CCMove(playerID, new Point(12,5), new Point(10,5));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(10,5), new Point(10,7)))) {
					return new CCMove(playerID, new Point(10,5), new Point(10,7));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 9
			else if(turn == 9) {
				if(board.isLegal(new CCMove(playerID, new Point(12,1), new Point(10,3)))) {
					return new CCMove(playerID, new Point(12,1), new Point(10,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(10,3), new Point(10,5)))) {
					return new CCMove(playerID, new Point(10,3), new Point(10,5));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(10,5), new Point(8,5)))) {
					return new CCMove(playerID, new Point(10,5), new Point(8,5));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 10
			else if(turn == 10) {
				if(board.isLegal(new CCMove(playerID, new Point(14,1), new Point(13,2)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(14,1), new Point(13,2));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 11
			else if(turn == 11) {
				if(board.isLegal(new CCMove(playerID, new Point(14,2), new Point(12,2)))) {
					return new CCMove(playerID, new Point(14,2), new Point(12,2));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,2), new Point(12,4)))) {
					return new CCMove(playerID, new Point(12,2), new Point(12,4));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 12
			else if(turn == 12) {
				if(board.isLegal(new CCMove(playerID, new Point(13,1), new Point(13,3)))) {
					return new CCMove(playerID, new Point(13,1), new Point(13,3));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(13,3), new Point(11,3)))) {
					return new CCMove(playerID, new Point(13,3), new Point(11,3));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 13
			else if(turn == 13) {
				if(board.isLegal(new CCMove(playerID, new Point(13,2), new Point(13,3)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(13,2), new Point(14,3));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
		}
		
		//Top right player
		else if(playerID == 2) {
			//Turn 0
			if(turn == 0) {
				if(board.isLegal(new CCMove(playerID, new Point(2,13), new Point(3,12)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(2,13), new Point(3,12));
				}
			}

			//Turn 1
			else if(turn == 1) {
				if(board.isLegal(new CCMove(playerID, new Point(0,15), new Point(2,13)))) {
					return new CCMove(playerID, new Point(0,15), new Point(2,13));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(2,13), new Point(4,11)))) {
					return new CCMove(playerID, new Point(2,13), new Point(4,11));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}

			//Turn 2
			else if(turn == 2) {
				if(board.isLegal(new CCMove(playerID, new Point(0,14), new Point(2,12)))) {
					return new CCMove(playerID, new Point(0,14), new Point(2,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(2,12), new Point(4,12)))) {
					return new CCMove(playerID, new Point(2,12), new Point(4,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(4,12), new Point(4,10)))) {
					return new CCMove(playerID, new Point(4,12), new Point(4,10));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}

			//Turn 3
			else if(turn == 3) {
				if(board.isLegal(new CCMove(playerID, new Point(1,15), new Point(3,13)))) {
					return new CCMove(playerID, new Point(1,15), new Point(3,13));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,13), new Point(3,11)))) {
					return new CCMove(playerID, new Point(3,13), new Point(3,11));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,11), new Point(5,11)))) {
					return new CCMove(playerID, new Point(3,11), new Point(5,11));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 4
			else if(turn == 4) {
				if(board.isLegal(new CCMove(playerID, new Point(0,12), new Point(2,12)))) {
					return new CCMove(playerID, new Point(0,12), new Point(2,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(2,12), new Point(4,12)))) {
					return new CCMove(playerID, new Point(2,12), new Point(4,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(4,12), new Point(6,10)))) {
					return new CCMove(playerID, new Point(4,12), new Point(6,10));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 5
			else if(turn == 5) {
				if(board.isLegal(new CCMove(playerID, new Point(3,15), new Point(3,13)))) {
					return new CCMove(playerID, new Point(3,15), new Point(3,13));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,13), new Point(3,11)))) {
					return new CCMove(playerID, new Point(3,13), new Point(3,11));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,11), new Point(5,9)))) {
					return new CCMove(playerID, new Point(3,11), new Point(5,9));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 6
			else if(turn == 6) {
				if(board.isLegal(new CCMove(playerID, new Point(0,13), new Point(2,11)))) {
					return new CCMove(playerID, new Point(0,13), new Point(2,11));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 7
			else if(turn == 7) {
				if(board.isLegal(new CCMove(playerID, new Point(2,15), new Point(4,13)))) {
					return new CCMove(playerID, new Point(2,15), new Point(4,13));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 8
			else if(turn == 8) {
				if(board.isLegal(new CCMove(playerID, new Point(1,12), new Point(3,10)))) {
					return new CCMove(playerID, new Point(1,12), new Point(3,10));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,10), new Point(5,10)))) {
					return new CCMove(playerID, new Point(3,10), new Point(5,10));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(5,10), new Point(5,8)))) {
					return new CCMove(playerID, new Point(5,10), new Point(5,8));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 9
			else if(turn == 9) {
				if(board.isLegal(new CCMove(playerID, new Point(3,14), new Point(5,12)))) {
					return new CCMove(playerID, new Point(3,14), new Point(5,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(5,12), new Point(5,10)))) {
					return new CCMove(playerID, new Point(5,12), new Point(5,10));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(5,10), new Point(7,10)))) {
					return new CCMove(playerID, new Point(5,10), new Point(7,10));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 10
			else if(turn == 10) {
				if(board.isLegal(new CCMove(playerID, new Point(1,14), new Point(2,13)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(1,14), new Point(2,13));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 11
			else if(turn == 11) {
				if(board.isLegal(new CCMove(playerID, new Point(1,13), new Point(3,13)))) {
					return new CCMove(playerID, new Point(1,13), new Point(3,13));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(3,13), new Point(3,11)))) {
					return new CCMove(playerID, new Point(3,13), new Point(3,11));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 12
			else if(turn == 12) {
				if(board.isLegal(new CCMove(playerID, new Point(2,14), new Point(2,12)))) {
					return new CCMove(playerID, new Point(2,14), new Point(2,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(2,12), new Point(4,12)))) {
					return new CCMove(playerID, new Point(2,12), new Point(4,12));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 13
			else if(turn == 13) {
				if(board.isLegal(new CCMove(playerID, new Point(2,13), new Point(2,12)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(2,13), new Point(2,12));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
		}
		
		//Bottom right player
		else if(playerID == 3) {
			//Turn 0
			if(turn == 0) {
				if(board.isLegal(new CCMove(playerID, new Point(13,13), new Point(12,12)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(13,13), new Point(12,12));
				}
			}

			//Turn 1
			else if(turn == 1) {
				if(board.isLegal(new CCMove(playerID, new Point(15,15), new Point(13,13)))) {
					return new CCMove(playerID, new Point(15,15), new Point(13,13));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(13,13), new Point(11,11)))) {
					return new CCMove(playerID, new Point(13,13), new Point(11,11));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}

			//Turn 2
			else if(turn == 2) {
				if(board.isLegal(new CCMove(playerID, new Point(15,14), new Point(13,12)))) {
					return new CCMove(playerID, new Point(15,14), new Point(13,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(13,12), new Point(11,12)))) {
					return new CCMove(playerID, new Point(13,12), new Point(11,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(11,12), new Point(11,10)))) {
					return new CCMove(playerID, new Point(11,12), new Point(11,10));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}

			//Turn 3
			else if(turn == 3) {
				if(board.isLegal(new CCMove(playerID, new Point(14,15), new Point(12,13)))) {
					return new CCMove(playerID, new Point(14,15), new Point(12,13));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,13), new Point(12,11)))) {
					return new CCMove(playerID, new Point(12,13), new Point(12,11));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,11), new Point(10,11)))) {
					return new CCMove(playerID, new Point(12,11), new Point(10,11));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 4
			else if(turn == 4) {
				if(board.isLegal(new CCMove(playerID, new Point(15,12), new Point(13,12)))) {
					return new CCMove(playerID, new Point(15,12), new Point(13,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(13,12), new Point(11,12)))) {
					return new CCMove(playerID, new Point(13,12), new Point(11,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(11,12), new Point(9,10)))) {
					return new CCMove(playerID, new Point(11,12), new Point(9,10));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 5
			else if(turn == 5) {
				if(board.isLegal(new CCMove(playerID, new Point(12,15), new Point(12,13)))) {
					return new CCMove(playerID, new Point(12,15), new Point(12,13));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,13), new Point(12,11)))) {
					return new CCMove(playerID, new Point(12,13), new Point(12,11));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,11), new Point(10,9)))) {
					return new CCMove(playerID, new Point(12,11), new Point(10,9));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 6
			else if(turn == 6) {
				if(board.isLegal(new CCMove(playerID, new Point(15,13), new Point(13,11)))) {
					return new CCMove(playerID, new Point(15,13), new Point(13,11));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 7
			else if(turn == 7) {
				if(board.isLegal(new CCMove(playerID, new Point(13,15), new Point(11,13)))) {
					return new CCMove(playerID, new Point(13,15), new Point(11,13));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 8
			else if(turn == 8) {
				if(board.isLegal(new CCMove(playerID, new Point(14,12), new Point(12,10)))) {
					return new CCMove(playerID, new Point(14,12), new Point(12,10));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,10), new Point(10,10)))) {
					return new CCMove(playerID, new Point(12,10), new Point(10,10));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(10,10), new Point(10,8)))) {
					return new CCMove(playerID, new Point(10,10), new Point(10,8));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 9
			else if(turn == 9) {
				if(board.isLegal(new CCMove(playerID, new Point(12,14), new Point(10,12)))) {
					return new CCMove(playerID, new Point(12,14), new Point(10,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(10,12), new Point(10,10)))) {
					return new CCMove(playerID, new Point(10,12), new Point(10,10));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(10,10), new Point(8,10)))) {
					return new CCMove(playerID, new Point(10,10), new Point(8,10));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 10
			else if(turn == 10) {
				if(board.isLegal(new CCMove(playerID, new Point(14,14), new Point(13,13)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(14,14), new Point(13,13));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 11
			else if(turn == 11) {
				if(board.isLegal(new CCMove(playerID, new Point(14,13), new Point(12,13)))) {
					return new CCMove(playerID, new Point(14,13), new Point(12,13));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(12,13), new Point(12,11)))) {
					return new CCMove(playerID, new Point(12,13), new Point(12,11));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 12
			else if(turn == 12) {
				if(board.isLegal(new CCMove(playerID, new Point(13,14), new Point(13,12)))) {
					return new CCMove(playerID, new Point(13,14), new Point(13,12));
				}
				else if(board.isLegal(new CCMove(playerID, new Point(13,12), new Point(11,12)))) {
					return new CCMove(playerID, new Point(13,12), new Point(11,12));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
			
			//Turn 13
			else if(turn == 13) {
				if(board.isLegal(new CCMove(playerID, new Point(13,13), new Point(13,12)))) {
					player.increaseTurn();
					return new CCMove(playerID, new Point(13,13), new Point(13,12));
				}
				else {
					player.increaseTurn();
					return new CCMove(playerID, null, null);
				}
			}
		}

		player.increaseTurn();
		return null;
	}

	//Returns the number of pieces that the player has in the goal zone
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

		//Bottom left player
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

		//Top right player
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

	//Checks if the 3 deepest diagonals of the goal are occupied
	public static boolean isCorner3DiagonalFilled(int playerID, CCBoard board) {
		//Top left player
		if(playerID == 0) {
			if(board.getPieceAt(new Point(15,15)) == null || board.getPieceAt(new Point(15,15)) != playerID)
				return false;
			if(board.getPieceAt(new Point(14,15)) == null || board.getPieceAt(new Point(14,15)) != playerID)
				return false;
			if(board.getPieceAt(new Point(13,15)) == null || board.getPieceAt(new Point(13,15)) != playerID)
				return false;
			if(board.getPieceAt(new Point(15,14)) == null || board.getPieceAt(new Point(15,14)) != playerID)
				return false;
			if(board.getPieceAt(new Point(14,14)) == null || board.getPieceAt(new Point(14,14)) != playerID)
				return false;;
				if(board.getPieceAt(new Point(15,13)) == null || board.getPieceAt(new Point(15,13)) != playerID)
					return false;
		}

		//Bottom left player
		if(playerID == 1) {
			if(board.getPieceAt(new Point(0,15)) == null || board.getPieceAt(new Point(0,15)) != playerID)
				return false;
			if(board.getPieceAt(new Point(1,15)) == null || board.getPieceAt(new Point(1,15)) != playerID)
				return false;
			if(board.getPieceAt(new Point(2,15)) == null || board.getPieceAt(new Point(2,15)) != playerID)
				return false;
			if(board.getPieceAt(new Point(0,14)) == null || board.getPieceAt(new Point(0,14)) != playerID)
				return false;
			if(board.getPieceAt(new Point(1,14)) == null || board.getPieceAt(new Point(1,14)) != playerID)
				return false;;
				if(board.getPieceAt(new Point(0,13)) == null || board.getPieceAt(new Point(0,13)) != playerID)
					return false;
		}

		//Top right player
		if(playerID == 2) {
			if(board.getPieceAt(new Point(15,0)) == null || board.getPieceAt(new Point(15,0)) != playerID)
				return false;
			if(board.getPieceAt(new Point(14,0)) == null || board.getPieceAt(new Point(14,0)) != playerID)
				return false;
			if(board.getPieceAt(new Point(13,0)) == null || board.getPieceAt(new Point(13,0)) != playerID)
				return false;
			if(board.getPieceAt(new Point(15,1)) == null || board.getPieceAt(new Point(15,1)) != playerID)
				return false;
			if(board.getPieceAt(new Point(14,1)) == null || board.getPieceAt(new Point(14,1)) != playerID)
				return false;;
				if(board.getPieceAt(new Point(15,2)) == null || board.getPieceAt(new Point(15,2)) != playerID)
					return false;
		}

		//Bottom right player
		if(playerID == 3) {
			if(board.getPieceAt(new Point(0,0)) == null || board.getPieceAt(new Point(0,0)) != playerID)
				return false;
			if(board.getPieceAt(new Point(1,0)) == null || board.getPieceAt(new Point(1,0)) != playerID)
				return false;
			if(board.getPieceAt(new Point(2,0)) == null || board.getPieceAt(new Point(2,0)) != playerID)
				return false;
			if(board.getPieceAt(new Point(0,1)) == null || board.getPieceAt(new Point(0,1)) != playerID)
				return false;
			if(board.getPieceAt(new Point(1,1)) == null || board.getPieceAt(new Point(1,1)) != playerID)
				return false;;
				if(board.getPieceAt(new Point(0,2)) == null || board.getPieceAt(new Point(0,2)) != playerID)
					return false;
		}

		return true;
	}

	//Find an empty space in the goal zone
	public static Point findEmptyGoal(int playerID, CCBoard board) {

		//Top left player
		if(playerID == 0) {
			if(board.getPieceAt(new Point(12,15)) == null)
				return new Point(12,15);
			if(board.getPieceAt(new Point(13,14)) == null)
				return new Point(13,14);
			if(board.getPieceAt(new Point(12,14)) == null)
				return new Point(12,14);
			if(board.getPieceAt(new Point(14,13)) == null)
				return new Point(14,13);
			if(board.getPieceAt(new Point(13,13)) == null)
				return new Point(13,13);
			if(board.getPieceAt(new Point(15,12)) == null)
				return new Point(15,12);
			if(board.getPieceAt(new Point(14,12)) == null)
				return new Point(14,12);
		}

		//Bottom left player
		if(playerID == 1) {
			if(board.getPieceAt(new Point(3,15)) == null)
				return new Point(2,15);
			if(board.getPieceAt(new Point(3,14)) == null)
				return new Point(2,14);
			if(board.getPieceAt(new Point(2,14)) == null)
				return new Point(3,14);
			if(board.getPieceAt(new Point(2,13)) == null)
				return new Point(1,13);
			if(board.getPieceAt(new Point(1,13)) == null)
				return new Point(2,13);
			if(board.getPieceAt(new Point(1,12)) == null)
				return new Point(0,12);
			if(board.getPieceAt(new Point(0,12)) == null)
				return new Point(1,12);
		}

		//Top right player
		if(playerID == 2) {
			if(board.getPieceAt(new Point(12,0)) == null)
				return new Point(12,0);
			if(board.getPieceAt(new Point(13,1)) == null)
				return new Point(13,1);
			if(board.getPieceAt(new Point(12,1)) == null)
				return new Point(12,1);
			if(board.getPieceAt(new Point(14,2)) == null)
				return new Point(14,2);
			if(board.getPieceAt(new Point(13,2)) == null)
				return new Point(13,2);
			if(board.getPieceAt(new Point(15,3)) == null)
				return new Point(15,3);
			if(board.getPieceAt(new Point(14,3)) == null)
				return new Point(14,3);
		}

		//Bottom right player
		if(playerID == 3) {
			if(board.getPieceAt(new Point(3,0)) == null)
				return new Point(3,0);
			if(board.getPieceAt(new Point(2,1)) == null)
				return new Point(2,1);
			if(board.getPieceAt(new Point(3,1)) == null)
				return new Point(3,1);
			if(board.getPieceAt(new Point(1,2)) == null)
				return new Point(1,2);
			if(board.getPieceAt(new Point(2,2)) == null)
				return new Point(2,2);
			if(board.getPieceAt(new Point(0,3)) == null)
				return new Point(0,3);
			if(board.getPieceAt(new Point(1,3)) == null)
				return new Point(1,3);
		}

		return null;
	}

	//Given a piece, returns if it is in the player's goal
	public static boolean IsPieceInGoal(int playerID, Point p) {

		//Top left player
		if(playerID == 0) {
			if(p.equals(new Point(15,15)))
				return true;
			if(p.equals(new Point(14,15)))
				return true;
			if(p.equals(new Point(13,15)))
				return true;
			if(p.equals(new Point(12,15)))
				return true;
			if(p.equals(new Point(15,14)))
				return true;
			if(p.equals(new Point(14,14)))
				return true;
			if(p.equals(new Point(13,14)))
				return true;
			if(p.equals(new Point(12,14)))
				return true;
			if(p.equals(new Point(15,13)))
				return true;
			if(p.equals(new Point(14,13)))
				return true;
			if(p.equals(new Point(13,13)))
				return true;
			if(p.equals(new Point(15,12)))
				return true;
			if(p.equals(new Point(14,12)))
				return true;
		}

		//Bottom left player
		if(playerID == 1) {
			if(p.equals(new Point(0,15)))
				return true;
			if(p.equals(new Point(1,15)))
				return true;
			if(p.equals(new Point(2,15)))
				return true;
			if(p.equals(new Point(3,15)))
				return true;
			if(p.equals(new Point(0,14)))
				return true;
			if(p.equals(new Point(1,14)))
				return true;
			if(p.equals(new Point(2,14)))
				return true;
			if(p.equals(new Point(3,14)))
				return true;
			if(p.equals(new Point(0,13)))
				return true;
			if(p.equals(new Point(1,13)))
				return true;
			if(p.equals(new Point(2,13)))
				return true;
			if(p.equals(new Point(0,12)))
				return true;
			if(p.equals(new Point(1,12)))
				return true;
		}

		//Top right player
		if(playerID == 2) {
			if(p.equals(new Point(15,0)))
				return true;
			if(p.equals(new Point(14,0)))
				return true;
			if(p.equals(new Point(13,0)))
				return true;
			if(p.equals(new Point(12,0)))
				return true;
			if(p.equals(new Point(15,1)))
				return true;
			if(p.equals(new Point(14,1)))
				return true;
			if(p.equals(new Point(13,1)))
				return true;
			if(p.equals(new Point(12,1)))
				return true;
			if(p.equals(new Point(15,2)))
				return true;
			if(p.equals(new Point(14,2)))
				return true;
			if(p.equals(new Point(13,2)))
				return true;
			if(p.equals(new Point(15,3)))
				return true;
			if(p.equals(new Point(14,3)))
				return true;
		}

		//Bottom right
		if(playerID == 3) {
			if(p.equals(new Point(0,0)))
				return true;
			if(p.equals(new Point(1,0)))
				return true;
			if(p.equals(new Point(2,0)))
				return true;
			if(p.equals(new Point(3,0)))
				return true;
			if(p.equals(new Point(0,1)))
				return true;
			if(p.equals(new Point(1,1)))
				return true;
			if(p.equals(new Point(2,1)))
				return true;
			if(p.equals(new Point(3,1)))
				return true;
			if(p.equals(new Point(0,2)))
				return true;
			if(p.equals(new Point(1,2)))
				return true;
			if(p.equals(new Point(2,2)))
				return true;
			if(p.equals(new Point(0,3)))
				return true;
			if(p.equals(new Point(1,3)))
				return true;
		}

		return false;
	}

	//Filters moves to allow the last piece to get to the end
	public static void filterEndGame(ArrayList<CCMove> moves, Point pointOutOfGoal, Point pointDestination) {
		int manhattan = Algorithm.getManhattanDist(pointOutOfGoal.x, pointOutOfGoal.y, pointDestination.x, pointDestination.y);
		if(moves.size() > 0) {
			int i = 0;
			while(i < moves.size()) {
				if(moves.get(i).getFrom() != null &&  moves.get(i).getTo() != null) {
					if(moves.get(i).getFrom().equals(pointOutOfGoal)) {
						if(Algorithm.getManhattanDist(moves.get(i).getTo().x, moves.get(i).getTo().y, pointDestination.x, pointDestination.y) > manhattan) {
							moves.remove(i);
						}
						else
							i++;
					}
					else {
						moves.remove(i);
					}
				}
				else {
					i++;
				}
			}
		}
	}

	//From a list of move, given a token and a final destination, it'll try to get that piece into its spot
	public static CCMove getBestMoveEndGame(int playerID, ArrayList<CCMove> moves, Point pointOutOfGoal, Point pointDestination) {
		int manhattan = Algorithm.getManhattanDist(pointOutOfGoal.x, pointOutOfGoal.y, pointDestination.x, pointDestination.y);
		CCMove move = new CCMove(playerID, null, null);
		int newManhattan;

		if(moves.size() > 0) {
			for(int i = 0; i < moves.size(); i++) {
				if(moves.get(i).getFrom() != null && moves.get(i).getTo() != null) {
					newManhattan = Algorithm.getManhattanDist(moves.get(i).getTo().x, moves.get(i).getTo().y, pointDestination.x, pointDestination.y);
					if(newManhattan < manhattan) {
						manhattan = newManhattan;
						move = moves.get(i);
						//return moves.get(i);
					}
				}
			}
		}

		return move;
	}
}