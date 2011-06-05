package view;

import java.io.FileOutputStream;
import java.io.PrintStream;

import model.Constants;

public class ImATempClass {
	public static void writeMapData(){
		PrintStream ps = null;
		try{
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
			
			String out;
			String filename = "customMap"+System.currentTimeMillis();
			System.out.println("filename: " + filename);
			ps = new PrintStream(new FileOutputStream(filename));
			System.setOut(ps);
			for(int i=0; i<30; i++){
				out = "";
				for(int j=0; j<34; j++){
					out = out + Byte.toString(SettingInfo.mapData[i][j]);
					if(j<33)
						out = out + " ";
				}
				System.out.println(out);
			}
		}
		catch(Exception e){
		}
		finally{
			if(ps != null)
				ps.close();
		}
	}
}
