package control;

import java.util.Stack;

import view.SettingInfo;
import model.*;

public class ControlInfo {
	private static Direction right = new Direction(Constants.RIGHT);
	private static Direction down = new Direction(Constants.DOWN);
	private static Direction left = new Direction(Constants.LEFT);
	private static Direction up = new Direction(Constants.UP);
	private static Stack<Direction> directionOneStack = new Stack<Direction>();
	private static Stack<Direction> directionTwoStack = new Stack<Direction>();
	private static byte playerOneRebornTimes = 5;
	private static byte playerTwoRebornTimes = 5;
	private static byte sleepingTankNum;
	private static boolean isPaused;
	private static boolean isFreezed;
	private static byte result;
	public static byte[] playerOneKills;
	public static byte[] playerTwoKills;
	public static byte evilCount;
	public static void init(){
		sleepingTankNum = 15;
		isPaused = false;
		isFreezed = false;
		result = Constants.ONGOING;	
		directionOneStack.clear();
		directionTwoStack.clear();
		if(SettingInfo.getLevel()<2){
			playerOneRebornTimes = 5;
			playerTwoRebornTimes = 5;
			if(SettingInfo.getIsOnePlayer()==true){
				 playerTwoRebornTimes = 0;
			}
		}
		evilCount = 0;
		playerOneKills = new byte[3];
		playerTwoKills = new byte[3];
		playerOneKills[0]=0;
		playerOneKills[1]=0;
		playerOneKills[2]=0;
		playerTwoKills[0]=0;
		playerTwoKills[1]=0;
		playerTwoKills[2]=0;

	}
	public static  boolean getIsFreezed(){
		return isFreezed;
	}
	public static void setIsFreezed(boolean b){
		isFreezed = b;
	}
	public static byte getSleepingTankNum(){
		return sleepingTankNum;
	}
	public static void subSleepingTankNum(){
		sleepingTankNum--;
	}
	public static byte getResult(){
		return result;
	}
	public static void setResult(byte r){
		result = r;
	}
	public static boolean getIsPaused(){
		return isPaused;
	}
	public static void setIsPaused(boolean b){
		isPaused = b;
	}
	public static byte getRebornTimes(int playerID){
		if(playerID==1)
			return playerOneRebornTimes;
		else if(playerID==2)
			return playerTwoRebornTimes;
		return 0;
	}
	public static void subRebornTimes(int playerID){
		if(playerID==1){
			if(playerOneRebornTimes>0)
				playerOneRebornTimes--;
		}
		else if(playerID==2){
			if(playerTwoRebornTimes>0)
				playerTwoRebornTimes--;
		}
	}
	public static void addRebornTimes(int playerID){
		if(playerID==1){
			playerOneRebornTimes++;
		}
		else if(playerID==2){
			playerTwoRebornTimes++;
		}
	}
	
	public static void addDirection(int playerID, byte direct){
		if(playerID==1){
			switch(direct){
			case Constants.RIGHT:
				directionOneStack.remove(right);
				directionOneStack.add(right);
				break;
			case Constants.DOWN:
				directionOneStack.remove(down);
				directionOneStack.add(down);	
				break;
			case Constants.LEFT:
				directionOneStack.remove(left);
				directionOneStack.add(left);
				break;
			case Constants.UP:
				directionOneStack.remove(up);
				directionOneStack.add(up);	
				break;
			}
			RunGame.playerOne.setDirection(directionOneStack.peek().getDirection());
		}
		if(playerID==2){
			switch(direct){
			case Constants.RIGHT:
				directionTwoStack.remove(right);
				directionTwoStack.add(right);
				break;
			case Constants.DOWN:
				directionTwoStack.remove(down);
				directionTwoStack.add(down);	
				break;
			case Constants.LEFT:
				directionTwoStack.remove(left);
				directionTwoStack.add(left);
				break;
			case Constants.UP:
				directionTwoStack.remove(up);
				directionTwoStack.add(up);	
				break;
			}
			RunGame.playerTwo.setDirection(directionTwoStack.peek().getDirection());
		}
	}
	public static void removeDirection(int player, byte direct){
		if(player==1){
			switch(direct){
			case Constants.RIGHT:
				directionOneStack.remove(right);
				break;
			case Constants.DOWN:
				directionOneStack.remove(down);
				break;
			case Constants.LEFT:
				directionOneStack.remove(left);
				break;
			case Constants.UP:
				directionOneStack.remove(up);
				break;
			}
			if(directionOneStack.isEmpty()==false){
				RunGame.playerOne.setDirection(directionOneStack.peek().getDirection());
			}
			else{
				RunGame.playerOne.setDirection(Constants.NO_DIRECTION);
			}
		}
		if(player==2){
			switch(direct){
			case Constants.RIGHT:
				directionTwoStack.remove(right);
				break;
			case Constants.DOWN:
				directionTwoStack.remove(down);
				break;
			case Constants.LEFT:
				directionTwoStack.remove(left);
				break;
			case Constants.UP:
				directionTwoStack.remove(up);
				break;
			}
			if(directionTwoStack.isEmpty()==false){
				RunGame.playerTwo.setDirection(directionTwoStack.peek().getDirection());
			}
			else{
				RunGame.playerTwo.setDirection(Constants.NO_DIRECTION);
			}
		}
	}
	public static void printStack(int player){
		if(player==1){
			System.out.print("stack1: ");
			for(Direction d : directionOneStack){
				System.out.print(d.getDirection() + " ");
			}
			System.out.println();
		}
	}	
}
class Direction{
	byte direction;
	public Direction(byte d){
		direction = d;
	}
	public byte getDirection(){
		return direction;
	}
}

