package model;

public class Constants {
	public static final int BattleWidth = 680;
	public static final int BattleHeight = 600;
	public static final int BlockSize = 40;
	public static final int BRICK_SIZE = 20;
	public static final int BULLET_SIZE = 10;
	
	public static final byte TANK_NORMAL = 0;
	public static final byte TANK_FAST = 1;
	public static final byte TANK_STRONG = 2;
	public static final byte TANK_SUPER = 3;
	
	public static final byte RIGHT = 0;
	public static final byte DOWN = 1;
	public static final byte LEFT = 2;
	public static final byte UP = 3;
	public static final byte NO_DIRECTION = 4;
	
	public static final byte CAMP_ENEMY = 0;
	public static final byte CAMP_USER = 1;
	
	public static final byte TUX = 1;
	public static final byte TANK = 2;
	public static final byte BRICK = 3;
	public static final byte GRASS = 4;
	public static final byte ICE = 5;
	public static final byte WATER = 6;
	public static final byte STEEL = 7; //never exist in battleField
	public static final byte FOUR_BRICK = 8; //never exist in battleField
	public static final byte SINGLE_STEEL = 9;
	public static final byte BULLET_BOOM = 10;
	public static final byte TANK_BOOM = 11;
	public static final byte BRICK_BOOM = 12;
	public static final byte TUX_BOOM = 13;
	
	
	
	public static final byte BONUS_TANK = 0;
	public static final byte BONUS_TUX = 1;
	public static final byte BONUS_STAR = 2;
	public static final byte BONUS_SHIELD = 3;
	public static final byte BONUS_FREEZE = 4;
	public static final byte BONUS_BOOM = 5;
	public static final byte BONUS_MAX = 6;
	
	public static final byte ONGOING = 0;
	public static final byte WIN = 1;
	public static final byte LOSE = 2;	
}
