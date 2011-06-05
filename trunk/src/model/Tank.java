package model;
import control.*;
import java.util.Random;

public class Tank extends Unit{
	byte moveSpeed;
	byte direction;
	byte tankType;
	byte camp;
	byte shootWaitCount;
	byte maxShootWaitCount;
	byte faceDirection;
	int tankID;
	byte originalType;
	public Tank(int x, int y, byte dir, byte type, int ID){
		super(x, y);
		direction = dir;
		tankType = type;
		tankID = ID;
		width = Constants.BlockSize;
		height = Constants.BlockSize;
		shootWaitCount = 0;
		maxShootWaitCount = 20;
		camp = Constants.CAMP_ENEMY;
		faceDirection = Constants.DOWN;
		originalType = tankType;
		update();
	}
	public Tank(int x, int y){
		super(x, y);
		width = Constants.BlockSize;
		height = Constants.BlockSize;
	}
	public void setDirection(byte dir){
		direction = dir;
	}
	public byte getDirection(){
		return direction;
	}
	public byte getTankType(){
		return tankType;
	}
	public void setTankType(byte t){
		tankType = t;
	}
	public int getTankID(){
		return tankID;
	}
	public byte getCamp(){
		return camp;
	}
	public void minusShootWaitCount(){
		if(shootWaitCount>0)
			shootWaitCount--;			
	}
	public void resetShootWaitCount(){
		shootWaitCount = maxShootWaitCount;;
	}
	public byte getFaceDirection(){
		return faceDirection;
	}
	public void update(){
		if(tankType==Constants.TANK_NORMAL){
			moveSpeed = 1;
			maxShootWaitCount = 15;
		}	
		else if(tankType==Constants.TANK_FAST){
			moveSpeed = 2;
			maxShootWaitCount = 12;
		}
		else{
			moveSpeed = 2;
			maxShootWaitCount = 12;
		}
	}
	public void println(){
		System.out.println("tank"+tankID+": "+ x+" "+y+" "+direction+" "+faceDirection);
	}
	public boolean isAtTurnPoint(){
		if(x%20==0&&y%20==0)
			return true;
		return false;
	}
	public void move(){
		byte nextDirection;
		if(isAtTurnPoint()==false){
			nextDirection = faceDirection;
		}
		else{
			update();
			if(direction==Constants.NO_DIRECTION){
				return;
			}
			else{
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
			direction = (byte)((faceDirection+(new Random().nextInt(4)))%4);
			return;
		}
		tmpTank = new Tank(xn, yn, nextDirection, tankType, tankID);
		if(RunGame.playerOne!=null&&RunGame.playerOne.getIsExist()==true){
			if(tmpTank.isCollided(RunGame.playerOne)){
				shoot();
				if(isAtTurnPoint()==false){
					faceDirection = (byte)((faceDirection+(new Random().nextInt(2))*2)%4);
				}
				return;		
			}
		}
		if(RunGame.playerTwo!=null&&RunGame.playerTwo.getIsExist()==true){
			if(tmpTank.isCollided(RunGame.playerTwo)){
				shoot();
				if(isAtTurnPoint()==false){
					faceDirection = (byte)((faceDirection+(new Random().nextInt(2))*2)%4);
				}
				return;
			}
		}
		for(Tank t : RunGame.tankList){
			if(t.getTankID()==tankID)
				continue;
			if(t.getIsExist()==true&&tmpTank.isCollided(t))
			{
				if(isAtTurnPoint()==false){
					faceDirection = (byte)((faceDirection+(new Random().nextInt(2))*2)%4);
				}
				else{
					direction = (byte)((faceDirection+(new Random().nextInt(4)))%4);
				}
				return;
			}
		}
		for(Unit u : RunGame.itemList){
			if(u.getIsExist()==false)
				continue;
			if(u.getType()==Constants.GRASS||u.getType()==Constants.ICE)
				continue;
			if(tmpTank.isCollided(u)){
				shoot();
				direction = (byte)((faceDirection+RunGame.getRandomDirection())%4);
				return;
			}
		}
		setLocation(xn, yn);
	}
	public void shoot(){
		if(shootWaitCount>0){
			return;
		}
		if(isAtTurnPoint()==false)
			return;
		int xb = -1, yb = -1;
		switch(direction){
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
		Bullet b = new Bullet(xb, yb, direction, camp, tankType, RunGame.bulletID++);
		resetShootWaitCount();		
		if(b.setLocation(xb, yb)){
			RunGame.bulletList.add(b);
		}
		else{
			RunGame.bulletID--;
		}		
	}
}
