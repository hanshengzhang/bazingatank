package model;

import javax.swing.Timer;

import view.Audio;
import control.*;

public class UserTank extends Tank{
	boolean isShooting;
	int playerID;
	boolean isShielded;
	public UserTank(int x, int y, byte dir, byte type, int tankID, int playerID){
		super(x, y, dir, type, tankID);
		this.playerID = playerID;
		camp = Constants.CAMP_USER;
		faceDirection = Constants.UP;
		isShooting = false;
		isShielded = true;
		update();
	}
	public void update(){
		if(tankType==Constants.TANK_NORMAL){
			moveSpeed = 2;
			maxShootWaitCount = 15;
		}	
		else if(tankType==Constants.TANK_FAST){
			moveSpeed = 2;
			maxShootWaitCount = 10;
		}
		else{
			moveSpeed = 2;
			maxShootWaitCount = 8;
		}
	}
	public void setIsShielded(boolean b){
		isShielded = b;
	}
	public boolean getIsShielded(){
		return isShielded;
	}
	public void setIsShooting(boolean b){
		isShooting = b;
	}
	public void upgrade(){
		if(tankType == Constants.TANK_NORMAL){
			setTankType(Constants.TANK_FAST);
		}
		else if(tankType == Constants.TANK_FAST)
			setTankType(Constants.TANK_STRONG);
		else if(tankType == Constants.TANK_STRONG)
			setTankType(Constants.TANK_SUPER);
	}
	public void reborn(){
		faceDirection = Constants.UP;
		direction = Constants.NO_DIRECTION;
		isShooting = false;
		if(playerID==1){
			setLocation(Constants.BattleWidth/2-Constants.BlockSize*2, Constants.BattleHeight-Constants.BlockSize);
			tankID = 0;
		}
		else if(playerID==2){
			setLocation(Constants.BattleWidth/2+Constants.BlockSize, Constants.BattleHeight-Constants.BlockSize);
			tankID = 1;
		}
	}
	public void setFaceDirection(byte d){
		faceDirection = d;
	}
	public void println(){
		System.out.println("player"+playerID+": "+getX()+" "+getY()+" type: "+ tankType+" dir: "+direction);
	}
	public void shoot(){
		if(isShooting==false)
			return;
		if(shootWaitCount>0){
			return;
		}
		int xb = -1, yb = -1;
		switch(faceDirection){
		case 0:
			xb = x+width;
			yb = y+height/2-Constants.BULLET_SIZE/2;
			break;
		case 1:
			xb = x+width/2-Constants.BULLET_SIZE/2;
			yb = y+height;
			break;
		case 2:
			xb = x-Constants.BULLET_SIZE;
			yb = y+height/2-Constants.BULLET_SIZE/2;
			break;
		case 3:
			xb = x+width/2-Constants.BULLET_SIZE/2;
			yb = y-Constants.BULLET_SIZE;
			break;
		}
		Bullet b = new Bullet(xb, yb, faceDirection, camp, tankType, RunGame.bulletID++, playerID);
		new Audio("sound/shoot.wav");
		resetShootWaitCount();
		if(b.setLocation(xb, yb)){
			RunGame.bulletList.add(b);
		}
		else{
			RunGame.bulletID--;
		}		
	}
	public void move(){
		byte nextDirection = direction;
		if(isAtTurnPoint()==false){
			nextDirection = faceDirection;
		}
		else{
			if(direction==Constants.NO_DIRECTION){
				return;
			}
			else{
				update();
				nextDirection = direction;
				faceDirection = direction;
			}
		}
		int xn = -1, yn = -1;
		Tank tmpTank;
		switch(nextDirection){
		case 0:
			xn = x+moveSpeed;
			yn = y;
			break;
		case 1:
			xn = x;
			yn = y+moveSpeed;
			break;
		case 2:
			xn = x-moveSpeed;
			yn = y;
			break;
		case 3:
			xn = x;
			yn = y-moveSpeed;
			break;
		}
		if(isWithinBattleField(xn, yn)==false){
			return;
		}
		tmpTank = new Tank(xn, yn, nextDirection, tankType, tankID);
	/*	if(RunGame.playerOne!=null&&RunGame.playerOne.getTankID()!=tankID&&RunGame.playerTwo.getIsExist()==true){
			if(tmpTank.isCollided(RunGame.playerOne))
			{
				return;		
			}
		}
		if(RunGame.playerTwo!=null&&RunGame.playerTwo.getTankID()!=tankID&&RunGame.playerTwo.getIsExist()==true){
			if(tmpTank.isCollided(RunGame.playerTwo))
			{
				return;
			}
		}*/
		for(Tank t : RunGame.tankList){
			if(t.getIsExist()==false)
				continue;
			if(t.getTankID()==tankID)
				continue;
			if(tmpTank.isCollided(t))
			{
				return;
			}
		}
		for(Unit u : RunGame.itemList){
			if(u.getIsExist()==false)
				continue;
			if(u.getType()==Constants.GRASS||u.getType()==Constants.ICE)
				continue;
			if(tmpTank.isCollided(u)){
				return;
			}
		}
		for(Bonus b : RunGame.bonusList){
			if(b.getIsExist()==false)
				continue;
			if(tmpTank.isCollided(b)){
				b.setIsExist(false);
				new Audio("sound/bonus.wav");
				b.print();
				switch(b.getType()){
				case Constants.BONUS_BOOM:
					for(Tank t : RunGame.tankList){
						t.setIsExist(false);
						new Audio("sound/tankBoom.wav");
						RunGame.effectList.add(new Unit(t.getX(), t.getY(), Constants.TANK_BOOM));
					}
					break;
				case Constants.BONUS_FREEZE:
					ControlInfo.setIsFreezed(true);
					RunGame.freezeTimer = new Timer(8000, RunGame.freeze);
					RunGame.freezeTimer.start();
					break;
				case Constants.BONUS_SHIELD:
					if(playerID == 1){
						RunGame.playerOne.setIsShielded(true);
						RunGame.shield1Timer = new Timer(8000, RunGame.shield1);
						RunGame.shield1Timer.start();
					}
					else if(playerID ==2){
						RunGame.playerTwo.setIsShielded(true);
						RunGame.shield2Timer = new Timer(8000, RunGame.shield2);
						RunGame.shield2Timer.start();
					}
					break;
				case Constants.BONUS_STAR:
					upgrade();
					break;
				case Constants.BONUS_TANK:
					ControlInfo.addRebornTimes(playerID);
					break;
				case Constants.BONUS_TUX:
					RunGame.addTuxGuard();
					RunGame.tuxGuardTimer = new Timer(8000, RunGame.tuxGuard);
					RunGame.tuxGuardTimer.start();
					break;
				}
			}
		}
		if(setLocation(xn, yn)){
			return;
		}
		return;		
	}
}
