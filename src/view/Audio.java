package view;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine;
import java.io.BufferedInputStream;

public class Audio extends Thread{
	String fileName;
	public Audio(String s){
		fileName = s;
		setPriority(Thread.MAX_PRIORITY);
		start();
	}
	public void run(){
		play(fileName);
	}
    public void play(String fileurl){
    	try{
    		AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(ClassLoader.getSystemResourceAsStream(fileurl)));
    		AudioFormat aif = ais.getFormat();
    		SourceDataLine sdl = null;
    		DataLine.Info info = new DataLine.Info(SourceDataLine.class, aif);
    		sdl = (SourceDataLine) AudioSystem.getLine(info);
    		sdl.open(aif);
    		sdl.start();
    		byte[] myData = new byte[128];
    		int numBytesRead = 0;
    		long total = 0;
    		long totalToRead = ais.getFrameLength()*aif.getFrameSize();
    		while (total < totalToRead){
    		    numBytesRead = ais.read(myData, 0, 128);
    		    if (numBytesRead == -1) break;
    		    total += numBytesRead; 
    		    sdl.write(myData, 0, numBytesRead);
    		}
    		sleep(5000);
    		sdl.stop();
    		sdl.close();
    		sdl = null;
    	}
    	catch (Exception e){
    		System.out.println("Play " + fileName + " error: " + e);
    	}
    }
}

