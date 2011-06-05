package view;
import javax.swing.Timer;
import java.awt.event.*;
public class SettingInfo {
	public static byte mapData[][] = new byte[30][34];
	private static boolean isOnePlayer = true;
	private static byte level = 1;
	private final static byte maxLevel = 99;
	static ActionListener mousePressedAddPerformer = new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			GraphicsClient.clientRef.repaintNumCanvas(SettingInfo.addLevel(), 
					GraphicsClient.clientRef.num1Canvas, GraphicsClient.clientRef.num2Canvas);
			if(level==maxLevel)
				mousePressedAddTimer.stop();
		}
	};
	public static Timer mousePressedAddTimer = new Timer(100, mousePressedAddPerformer);
	static ActionListener mousePressedSubPerformer = new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			GraphicsClient.clientRef.repaintNumCanvas(SettingInfo.subLevel(), 
					GraphicsClient.clientRef.num1Canvas, GraphicsClient.clientRef.num2Canvas);
			if(level==1)
				mousePressedSubTimer.stop();							
		}
	};
	public static Timer mousePressedSubTimer = new Timer(100, mousePressedSubPerformer);
	public static boolean getIsOnePlayer(){
		return isOnePlayer;
	}
	public static void setIsOnePlayer(boolean b){
		isOnePlayer = b;
	}
	public static byte getLevel(){
		return level;
	}
	public static byte setLevel(byte l){
		if(l>0&&l<=maxLevel)
			level = l;
		return level;
	}
	public static void zeroLevel(){
		level = 0;
	}
	public static byte addLevel(){
		if(level+1<=maxLevel)
			level++;
		return level;
	}
	public static byte subLevel(){
		if(level-1>0)
			level--;
		return level;
	}
	public static byte setOffLevel(byte offset){
		return setLevel((byte)(level+offset));
	}
}
