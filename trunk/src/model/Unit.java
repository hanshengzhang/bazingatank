package model;

public class Unit {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean isExist;
	protected byte type;
	protected int liveCount;
	Unit(){	}
	public Unit(int x, int y, int w, int h, byte t){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.type = t;
		isExist = true;
	}
	public Unit(int x, int y, byte t){
		this.x = x;
		this.y = y;
		this.type = t;
		isExist = true;
	}
	public Unit(int x, int y){
		this.x = x;
		this.y = y;
		isExist = true;
	}
	public Unit(int x, int y, byte t, int liveCount){
		this.x = x;
		this.y = y;
		this.type = t;
		this.liveCount = liveCount;
		isExist = true;
	}
	public boolean isCollided(Unit ref){
		int xt = ref.getX();
		int yt = ref.getY();
		int wt = ref.getWidth();
		int ht = ref.getHeight();
		if(x + width <= xt || x >= xt + wt
		|| y + height <= yt || y >= yt + ht){
			return false;
		}
		return true;
	}
	public boolean setLocation(int x, int y){
		if(x < 0 || x > Constants.BattleWidth - width
		|| y < 0 || y > Constants.BattleHeight - height)
			return false;
		this.x = x;
		this.y = y;
		return true;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void setIsExist(boolean b){
		isExist = b;
	}
	public boolean getIsExist(){
		return isExist;
	}
	public byte getType(){
		return type;
	}
	public boolean isWithinBattleField(int x, int y){
		if(x<0||x>Constants.BattleWidth-width||y<0||y>Constants.BattleHeight-height)
			return false;
		return true;
	}
}
