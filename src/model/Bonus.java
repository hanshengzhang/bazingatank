package model;

public class Bonus extends Unit{
	private int surviveTime;
	public Bonus(int x, int y, int time, byte type){
		super(x, y);
		width = Constants.BlockSize;
		height = Constants.BlockSize;
		surviveTime = time;
		this.type = type;
		
	}
	public void subSurviveTime(){
		if(surviveTime>0)
			surviveTime--;
		else
			isExist = false;
	}
	public void print(){
		System.out.println("bonus picked up, bonusType: " + type);
	}
}
