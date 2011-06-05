package model;

import control.*;
import view.*;
	
public class Bullet extends Unit{
	private byte moveSpeed;
	private byte direction;
	private byte camp;
	private int bulletID;
	private byte shootTankType;
	private int playerID;
	public Bullet(int x, int y, byte d, byte c, byte t, int ID){
		super(x, y);
		width = Constants.BULLET_SIZE;
		height = Constants.BULLET_SIZE;
		direction = d;
		camp = c;
		shootTankType = t;
		bulletID = ID;
		moveSpeed = 8;
		if(shootTankType!=Constants.TANK_NORMAL)
			moveSpeed+=2;
	}
	public Bullet(int x, int y, byte d, byte c, byte t, int ID, int playerID){
		super(x, y);
		width = Constants.BULLET_SIZE;
		height = Constants.BULLET_SIZE;
		direction = d;
		camp = c;
		shootTankType = t;
		bulletID = ID;
		moveSpeed = 8;
		if(t!=Constants.TANK_NORMAL)
			moveSpeed += 2; 
		this.playerID = playerID;
	}
	public int getBulletID(){
		return bulletID;
	}
	public byte getShootTankType(){
		return shootTankType;
	}
	public byte getDirection(){
		return direction;
	}
	public void move(){
		if(isExist==false){
			return;
		}
		int xn = -1, yn = -1;
		switch(direction){
		case 0: xn = x+moveSpeed; yn = y;	break;
		case 1:	xn = x; yn = y+moveSpeed; break;
		case 2: xn = x-moveSpeed; yn =y; break;
		case 3: xn = x; yn = y-moveSpeed; break;
		}
		Bullet tmpBullet = new Bullet(xn, yn, direction, camp, shootTankType,  bulletID);
		
		for(Bullet b : RunGame.bulletList){
			if(b.getIsExist()==false)
				continue;
			if(bulletID==b.getBulletID())
				continue;
			if(isCollided(b)==true){
				isExist = false;
				b.setIsExist(false);
				RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
				return;
			}
		}
		if(RunGame.playerOne!=null){
			if(RunGame.playerOne.getIsExist()==true&&tmpBullet.isCollided(RunGame.playerOne)){
				isExist = false;
				if(RunGame.playerOne.getIsShielded()==true){
					RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
					return;
				}
				if(camp==Constants.CAMP_ENEMY){					
					switch(RunGame.playerOne.getTankType()){
					case Constants.TANK_NORMAL:
					case Constants.TANK_FAST:
						RunGame.playerOne.setIsExist(false);
						new Audio("sound/bigBoom.wav");
						RunGame.effectList.add(new Unit(RunGame.playerOne.getX(), RunGame.playerOne.getY(),
								Constants.TANK_BOOM));
						break;
					case Constants.TANK_STRONG:
						new Audio("sound/bulletBoom.wav");
						RunGame.playerOne.setTankType(Constants.TANK_FAST);
						RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
						break;
					case Constants.TANK_SUPER:
						new Audio("sound/bulletBoom.wav");
						RunGame.playerOne.setTankType(Constants.TANK_STRONG);
						RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
						break;
					}					
				}
				else{
					RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
				}
				return;
			}
		}
		if(RunGame.playerTwo!=null){
			if(RunGame.playerTwo.getIsExist()==true&&tmpBullet.isCollided(RunGame.playerTwo)){
				isExist = false;
				if(RunGame.playerTwo.getIsShielded()==true){
					RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
					return;
				}
				if(camp==Constants.CAMP_ENEMY){
					switch(RunGame.playerTwo.getTankType()){
					case Constants.TANK_NORMAL:
					case Constants.TANK_FAST:
						RunGame.playerTwo.setIsExist(false);
						new Audio("sound/bigBoom.wav");
						RunGame.effectList.add(new Unit(RunGame.playerTwo.getX(), RunGame.playerTwo.getY(),
								Constants.TANK_BOOM));
						break;
					case Constants.TANK_STRONG:
						new Audio("sound/bulletBoom.wav");
						RunGame.playerTwo.setTankType(Constants.TANK_FAST);
						RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
						break;
					case Constants.TANK_SUPER:
						new Audio("sound/bulletBoom.wav");
						RunGame.playerTwo.setTankType(Constants.TANK_STRONG);
						RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
						break;
					}					
				}
				else{
					RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
				}
				return;
			}
		}
		for(Tank t : RunGame.tankList){
			if(t.getIsExist()==false)
				continue;
			if(tmpBullet.isCollided(t)==true){
				isExist = false;
				if(camp==Constants.CAMP_USER){
					switch(t.getTankType()){
					case Constants.TANK_NORMAL:
					case Constants.TANK_FAST:
						t.setIsExist(false);
						new Audio("sound/tankBoom.wav");
						RunGame.effectList.add(new Unit(t.getX(), t.getY(), Constants.TANK_BOOM));
						if(playerID==1){
							ControlInfo.playerOneKills[t.originalType] = (byte)(ControlInfo.playerOneKills[t.originalType]+1);
						}
						else if(playerID==2){
							ControlInfo.playerTwoKills[t.originalType] = (byte)(ControlInfo.playerTwoKills[t.originalType]+1);
						}
						break;
					case Constants.TANK_STRONG:
						if(shootTankType==Constants.TANK_SUPER){
							t.setIsExist(false);
							new Audio("sound/tankBoom.wav");
							RunGame.effectList.add(new Unit(t.getX(), t.getY(), Constants.TANK_BOOM));
						}
						else{
							new Audio("sound/bulletBoom.wav");
							RunGame.produceBonus();
							t.setTankType(Constants.TANK_FAST);
							RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
						}
						break;
					}					
				}
				return;
			}
		}
		for(Unit u : RunGame.itemList){
			if(u.getIsExist()==false)
				continue;
			if(tmpBullet.isCollided(u)){
				if(u.getType()==Constants.WATER||u.getType()==Constants.ICE||u.getType()==Constants.GRASS)
					continue;
				isExist = false;
				if(u.getType()==Constants.SINGLE_STEEL){
					if(camp==Constants.CAMP_USER){
						new Audio("sound/bulletBoom.wav");	
					}
					RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
				}
				else if(u.getType()==Constants.BRICK){
					u.setIsExist(false);
					if(camp==Constants.CAMP_USER){
						new Audio("sound/brickBoom.wav");
					}
					RunGame.effectList.add(new Unit(u.getX(), u.getY(), Constants.BRICK_BOOM));
				}
				else if(u.getType()==Constants.TUX){
					u.setIsExist(false);
					new Audio("sound/bigBoom.wav");
					RunGame.effectList.add(new Unit(Constants.BattleWidth/2-30,
							  Constants.BattleHeight-Constants.BlockSize-Constants.BRICK_SIZE,
							  Constants.TUX_BOOM));
				}
			}
		}
		if(isExist==false){
			return;
		}
		if(setLocation(xn, yn)==false){
			isExist = false;
			if(camp==Constants.CAMP_USER){
				new Audio("sound/bulletBoom.wav");
			}
			RunGame.effectList.add(new Unit(xn/2+x/2, yn/2+y/2, Constants.BULLET_BOOM));
			return;
		}
	}
}
