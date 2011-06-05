package control;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;
import javax.swing.Timer;
import model.*;
import view.*;
public class RunGame{
	private GraphicsClient clientRef;
	public static List<Tank> tankList = new ArrayList<Tank>();
	public static List<Bullet> bulletList = new ArrayList<Bullet>();
	public static List<Unit> effectList = new ArrayList<Unit>();
	public static List<Unit> itemList = new ArrayList<Unit>();
	public static List<Bonus> bonusList = new ArrayList<Bonus>();
	public static List<Unit> tuxGuardList = new ArrayList<Unit>();
	public static UserTank playerOne = null;
	public static UserTank playerTwo = null;
	public static int bulletID = 0;
	public static int tankID = 0;
	public static Timer runTimer;
	public static Timer produceTankTimer;
	public static Timer moveEnemyTimer;
	public static Timer moveUserTimer;
	public static Timer freezeTimer;
	public static Timer shield1Timer;
	public static Timer shield2Timer;
	public static Timer tuxGuardTimer;
	public static Timer endTimer;
	public static ActionListener freeze;
	public static ActionListener shield1;
	public static ActionListener shield2;
	public static ActionListener tuxGuard;
	
	public int timerCount;
	public RunGame(){
		clientRef = GraphicsClient.clientRef;
		tankList.clear();
		bulletList.clear();
		effectList.clear();
		itemList.clear();
		bonusList.clear();
		tuxGuardList.clear();
		bulletID = 0;
		timerCount = 0;
		ControlInfo.init();
		initBonusAction();
		initialLandscape();
		run();
		new Audio("sound/start.wav");
		clientRef.run();
	}
	public void initBonusAction(){
		freeze = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ControlInfo.setIsFreezed(false);
				freezeTimer.stop();				
			}
		};
		shield1 = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(playerOne!=null)
					playerOne.setIsShielded(false);
				shield1Timer.stop();				
			}
		};
		shield2 = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(playerTwo!=null)
					playerTwo.setIsShielded(false);
				shield2Timer.stop();				
			}
		};
		tuxGuard = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				removeTuxGuard();
				tuxGuardTimer.stop();
			}
		};
	}
	public void run(){
		ActionListener produceTank = new ActionListener(){
			public void actionPerformed(ActionEvent e){
					produceEnemyTank();
					if(ControlInfo.getSleepingTankNum()==0){
						produceTankTimer.stop();
					}
			}
		};
		ActionListener oneStep = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(Bullet b: bulletList){
					b.move();
				}
				if(playerOne!=null&&playerOne.getIsExist()==true){
					playerOne.move();					
				}
				if(playerTwo!=null&&playerTwo.getIsExist()==true){
					playerTwo.move();
				}
				if(ControlInfo.getIsFreezed()==false){			
					for(Tank t : tankList)
						t.move();					
				}
				if(timerCount==0){
					if(ControlInfo.getResult()!=Constants.ONGOING)
						endTimer.start();
					for(Bonus b : bonusList){
						b.subSurviveTime();
					}
					produceRandomBonus();
					if(ControlInfo.getIsFreezed()==false){
						for(Tank t : tankList){
							t.minusShootWaitCount();
							tankShoot(t);
						}
					}
					if(playerOne!=null){
						if(playerOne.getIsExist()==false){
							if(ControlInfo.getRebornTimes(1)>0){
								playerOne = null;
								ControlInfo.subRebornTimes(1);
								produceUserTank(1);
							}
							else if(ControlInfo.getRebornTimes(2)>0){
								playerOne = null;
								ControlInfo.subRebornTimes(2);
								produceUserTank(1);
							}		
							else
								playerOne = null;
						}
						else{
							playerOne.minusShootWaitCount();
							playerOne.shoot();	
						}										
					}
					if(playerTwo!=null){
						if(playerTwo.getIsExist()==false){
							if(ControlInfo.getRebornTimes(2)>0){
								playerTwo = null;
								ControlInfo.subRebornTimes(2);
								produceUserTank(2);
							}
							else if(ControlInfo.getRebornTimes(1)>0){
								playerTwo = null;
								ControlInfo.subRebornTimes(1);
								produceUserTank(2);
							}		
							else
								playerTwo = null;
						}	
						else{
							playerTwo.minusShootWaitCount();
							playerTwo.shoot();
						}						
					}					
					List<Bullet> tmpBulletList = new ArrayList<Bullet>();
					for(Bullet b : bulletList){
						if(b.getIsExist()==false){
							tmpBulletList.add(b);
						}
					}
					bulletList.removeAll(tmpBulletList);
					
					List<Tank> tmpTankList = new ArrayList<Tank>();
					for(Tank t : tankList){
						if(t.getIsExist()==false)
							tmpTankList.add(t);
					}
					tankList.removeAll(tmpTankList);
					
					List<Unit> tmpItemList = new ArrayList<Unit>();
					for(Unit u : itemList){
						if(u.getIsExist()==false)
							tmpItemList.add(u);
					}
					itemList.removeAll(tmpItemList);
					
					List<Bonus> tmpBonusList = new ArrayList<Bonus>();
					for(Bonus b : bonusList){
						if(b.getIsExist()==false)
							tmpBonusList.add(b);
					}
					bonusList.removeAll(tmpBonusList);

					clientRef.repaint();
					
					if(RunGame.itemList.isEmpty()||RunGame.itemList.get(0).getType()!=Constants.TUX){
						ControlInfo.setResult(Constants.LOSE);
					}
					else if(playerOne==null&&playerTwo==null)
						ControlInfo.setResult(Constants.LOSE);
					else if(ControlInfo.getSleepingTankNum()==0&&tankList.isEmpty()==true)
						ControlInfo.setResult(Constants.WIN);
				}
				timerCount = (timerCount+1)%3;
			}				
		};
		ActionListener end = new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				stopTimer();
				endTimer.stop();
				clientRef.end();				
			}
		};
		endTimer = new Timer(4000, end);
		runTimer = new Timer(15, oneStep);
		produceTankTimer = new Timer(10000, produceTank);
		runTimer.start();
		produceTankTimer.start();		
	}
	public static void stopTimer(){
		runTimer.stop();
		produceTankTimer.stop();
	}
	public static void startTimer(){
		runTimer.restart();
		produceTankTimer.restart();
	}
	
	public static byte getRandomDirection(){
		return ((byte)new Random().nextInt(4));
	}
	public byte getRandomTankType(){
		return (byte)(new Random().nextInt(3));
	}
	public boolean getRandomPermission(int l){
		if(new Random().nextInt(l)==0)
			return true;
		return false;
	}
	public void tankShoot(Tank t){
		if(getRandomPermission(2))
			t.shoot();
	}
	public void produceRandomBonus(){
		if(new Random().nextInt(400)==0){
			produceBonus();
		}
	}
	public static void produceBonus(){
		int x = new Random().nextInt(33);
		int y = new Random().nextInt(29);
		byte bonusType = (byte)(new Random().nextInt((int)Constants.BONUS_MAX));
		int surviveTime = new Random().nextInt(200) + 100;
		bonusList.add(new Bonus(x*20, y*20, surviveTime, bonusType));
	}
	public boolean isAreaClear(Unit u){
		for(Tank t : tankList){
			if(u.isCollided(t))
				return false;
		}
		for(Bullet b : bulletList){
			if(u.isCollided(b))
				return false;
		}
		return true;
	}
	public static void produceUserTank(int playerID){
		if(playerID==1){
			if(playerOne==null){
				playerOne = new UserTank(Constants.BattleWidth/2-Constants.BlockSize*2, Constants.BattleHeight-Constants.BlockSize, 
						Constants.NO_DIRECTION, Constants.TANK_NORMAL, tankID++, 1);
				shield1Timer = new Timer(5000, shield1);
				shield1Timer.start();
			}
		}
		else if(playerID==2){
			if(playerTwo==null){
				playerTwo = new UserTank(Constants.BattleWidth/2+Constants.BlockSize, Constants.BattleHeight-Constants.BlockSize, 
						Constants.NO_DIRECTION, Constants.TANK_NORMAL, tankID++, 2);
				shield2Timer = new Timer(5000, shield2);
				shield2Timer.start();
			}
		}
	}
	public void produceEnemyTank(){
		if(RunGame.tankList.size() >= 6)
			return;
		
		if(isAreaClear(new Tank(0, 0))&&ControlInfo.getSleepingTankNum()>0){
			RunGame.tankList.add(new Tank(0, 0, Constants.DOWN, getRandomTankType(), tankID++));
			ControlInfo.subSleepingTankNum();
			System.out.println("producing tank at place 1:");
		}
		if(isAreaClear(new Tank(Constants.BattleWidth/2-Constants.BlockSize/2, 0))&&ControlInfo.getSleepingTankNum()>0){
		RunGame.tankList.add(new Tank(Constants.BattleWidth/2-Constants.BlockSize/2, 0, 
					Constants.DOWN, getRandomTankType(), tankID++));
			ControlInfo.subSleepingTankNum();
			System.out.println("producing tank at place 2:");
		}
		if(isAreaClear(new Tank(Constants.BattleWidth-Constants.BlockSize, 0))&&ControlInfo.getSleepingTankNum()>0){
			RunGame.tankList.add(new Tank(Constants.BattleWidth-Constants.BlockSize, 0,
					Constants.DOWN, getRandomTankType(), tankID++));		
			ControlInfo.subSleepingTankNum();
			System.out.println("producing tank at place 3:");
		}
	}
	public void initialLandscape(){
		itemList.add(new Unit(Constants.BattleWidth/2-Constants.BlockSize/2,
							  Constants.BattleHeight-Constants.BlockSize, Constants.BlockSize, Constants.BRICK_SIZE, 
							  Constants.TUX));
		produceUserTank(1);
		if(SettingInfo.getIsOnePlayer()==false){
			produceUserTank(2);
		}
		if(playerOne!=null){
			playerOne.reborn();
		}
		if(playerTwo!=null){
			playerTwo.reborn();
		}
		
		tankList.add(new Tank(0, 0, Constants.DOWN, Constants.TANK_FAST, tankID++));
		tankList.add(new Tank(Constants.BattleWidth/2-Constants.BlockSize/2, 0, 
				Constants.DOWN, Constants.TANK_NORMAL, tankID++));
		tankList.add(new Tank(Constants.BattleWidth-Constants.BlockSize, 0, 
				Constants.DOWN, Constants.TANK_STRONG, tankID++));	
		ControlInfo.subSleepingTankNum();
		ControlInfo.subSleepingTankNum();
		ControlInfo.subSleepingTankNum();
		
		readMap();
	}
	public void readMap(){
		if(SettingInfo.getLevel() == 0){
			readCustomMap();
		}
		else{
			int x = 0, y = 0;
			byte t;
			try{
				InputStream is = 
					ClassLoader.getSystemResourceAsStream("data/Map"+Byte.toString(SettingInfo.getLevel()));
				BufferedReader b = new BufferedReader(new InputStreamReader(is));
				int l=0;
				String s;
				while((s=b.readLine())!=null){
					l = s.length();
					x = 0;
					for(int i=0; i<l; i+=2){
						t = (byte)(s.charAt(i)-48);
						if(t!=0){
							if(t==Constants.BRICK||t==Constants.SINGLE_STEEL)
								itemList.add(new Unit(x, y, Constants.BRICK_SIZE, Constants.BRICK_SIZE, t));
							else
								itemList.add(new Unit(x, y, Constants.BlockSize, Constants.BlockSize, t));
						}
						x += Constants.BRICK_SIZE;
						if(i==l-1)
							y += Constants.BRICK_SIZE;			
					}
				}
			}
			catch(Exception e){
				System.out.println("data error");
				System.out.println(e);
			}
		}
	}
	public void readCustomMap(){
		int x = 0, y = 0;
		byte t;
		for(int i=0;i <30; i+=2)
			for(int j=0;j<34;j+=2){
				if(SettingInfo.mapData[i][j]==Constants.FOUR_BRICK){
					SettingInfo.mapData[i][j]=Constants.BRICK;
					SettingInfo.mapData[i+1][j]=Constants.BRICK;
					SettingInfo.mapData[i][j+1]=Constants.BRICK;
					SettingInfo.mapData[i+1][j+1]=Constants.BRICK;
				}
				else if(SettingInfo.mapData[i][j]==Constants.STEEL){
					SettingInfo.mapData[i][j]=Constants.SINGLE_STEEL;
					SettingInfo.mapData[i+1][j]=Constants.SINGLE_STEEL;
					SettingInfo.mapData[i][j+1]=Constants.SINGLE_STEEL;
					SettingInfo.mapData[i+1][j+1]=Constants.SINGLE_STEEL;
				}
			}
		SettingInfo.mapData[28][16] = 1;
		SettingInfo.mapData[28][17] = 0;
		SettingInfo.mapData[29][16] = 0;
		SettingInfo.mapData[29][17] = 0;
		
		SettingInfo.mapData[28][13] = 0;
		SettingInfo.mapData[28][14] = 0;
		SettingInfo.mapData[29][13] = 0;
		SettingInfo.mapData[29][14] = 0;
		
		SettingInfo.mapData[28][19] = 0;
		SettingInfo.mapData[28][20] = 0;
		SettingInfo.mapData[29][19] = 0;
		SettingInfo.mapData[29][20] = 0;
		
		SettingInfo.mapData[0][0] = 0;
		SettingInfo.mapData[0][1] = 0;
		SettingInfo.mapData[1][0] = 0;
		SettingInfo.mapData[1][1] = 0;
		
		SettingInfo.mapData[0][16] = 0;
		SettingInfo.mapData[0][17] = 0;
		SettingInfo.mapData[1][16] = 0;
		SettingInfo.mapData[1][17] = 0;
		
		SettingInfo.mapData[0][32] = 0;
		SettingInfo.mapData[0][33] = 0;
		SettingInfo.mapData[1][32] = 0;
		SettingInfo.mapData[1][33] = 0;
		for(int i=0; i<30; i++){
			for(int j=0; j<34; j++){
				t = SettingInfo.mapData[i][j];
				System.out.print(t+" ");
				if(t!=0){
					if(t==Constants.BRICK||t==Constants.SINGLE_STEEL)
						itemList.add(new Unit(x, y, Constants.BRICK_SIZE, Constants.BRICK_SIZE, t));
					else{
						itemList.add(new Unit(x, y, Constants.BlockSize, Constants.BlockSize, t));
					}
				}
				x += Constants.BRICK_SIZE;
				if(j>=33){
					y += Constants.BRICK_SIZE;
					x = 0;
					System.out.println();
				}
			}
		}
	}
	public static void addTuxGuard(){
		List<Unit> tmpItemList = new ArrayList<Unit>();
		for(Unit u : itemList){
			if(u.getX()==300&&u.getY()==540)
				tmpItemList.add(u);
			else if(u.getX()==300&&u.getY()==560)
				tmpItemList.add(u);
			else if(u.getX()==300&&u.getY()==580)
				tmpItemList.add(u);
			else if(u.getX()==320&&u.getY()==540)
				tmpItemList.add(u);
			else if(u.getX()==340&&u.getY()==540)
				tmpItemList.add(u);
			else if(u.getX()==360&&u.getY()==540)
				tmpItemList.add(u);
			else if(u.getX()==360&&u.getY()==560)
				tmpItemList.add(u);
			else if(u.getX()==360&&u.getY()==580)
				tmpItemList.add(u);
		}
		itemList.removeAll(tmpItemList);
		itemList.add(new Unit(300, 540, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.SINGLE_STEEL));
		itemList.add(new Unit(300, 560, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.SINGLE_STEEL));
		itemList.add(new Unit(300, 580, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.SINGLE_STEEL));
		itemList.add(new Unit(320, 540, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.SINGLE_STEEL));
		itemList.add(new Unit(340, 540, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.SINGLE_STEEL));
		itemList.add(new Unit(360, 540, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.SINGLE_STEEL));
		itemList.add(new Unit(360, 560, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.SINGLE_STEEL));
		itemList.add(new Unit(360, 580, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.SINGLE_STEEL));	
		
	}
	public void removeTuxGuard(){
		List<Unit> tmpItemList = new ArrayList<Unit>();
		for(Unit u : itemList){
			if(u.getX()==300&&u.getY()==540)
				tmpItemList.add(u);
			else if(u.getX()==300&&u.getY()==560)
				tmpItemList.add(u);
			else if(u.getX()==300&&u.getY()==580)
				tmpItemList.add(u);
			else if(u.getX()==320&&u.getY()==540)
				tmpItemList.add(u);
			else if(u.getX()==340&&u.getY()==540)
				tmpItemList.add(u);
			else if(u.getX()==360&&u.getY()==540)
				tmpItemList.add(u);
			else if(u.getX()==360&&u.getY()==560)
				tmpItemList.add(u);
			else if(u.getX()==360&&u.getY()==580)
				tmpItemList.add(u);
		}
		itemList.removeAll(tmpItemList);
		itemList.add(new Unit(300, 540, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.BRICK));
		itemList.add(new Unit(300, 560, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.BRICK));
		itemList.add(new Unit(300, 580, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.BRICK));
		itemList.add(new Unit(320, 540, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.BRICK));
		itemList.add(new Unit(340, 540, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.BRICK));
		itemList.add(new Unit(360, 540, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.BRICK));
		itemList.add(new Unit(360, 560, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.BRICK));
		itemList.add(new Unit(360, 580, Constants.BRICK_SIZE, Constants.BRICK_SIZE, Constants.BRICK));		
	}	
}
