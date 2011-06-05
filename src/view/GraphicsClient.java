package view;
import javax.imageio.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import model.*;
import control.*;
public class GraphicsClient{
	public static GraphicsClient clientRef;
	private final int CLIENT_WIDTH = 800;  		
	private final int CLIENT_HEIGHT = 600;  	
	private final int BATTLE_WIDTH = 680;  		
	private final int BATTLE_HEIGHT = 600;
	int drawX, drawY, remainEnemy;
	byte drawType;
	BufferedImage start;
	BufferedImage startChoosed;
	BufferedImage quit;
	BufferedImage quitChoosed;
	BufferedImage set;
	BufferedImage setChoosed;
	BufferedImage help;
	BufferedImage helpChoosed;
	BufferedImage back;
	BufferedImage backChoosed;
	BufferedImage pause;
	BufferedImage pauseChoosed;
	BufferedImage quitDraw;
	BufferedImage quitDrawChoosed;
	BufferedImage runInfo;
	BufferedImage endRef;
	BufferedImage ok;
	BufferedImage okChoosed;
	BufferedImage go;
	BufferedImage goChoosed;
	BufferedImage mapUnit;
	BufferedImage setBackground;
	BufferedImage okSet;
	BufferedImage okSetChoosed;
	BufferedImage backgroundPic;
	BufferedImage welcome;
	BufferedImage bullet0;
	BufferedImage bullet1;
	BufferedImage bullet2;
	BufferedImage bullet3;
	BufferedImage brick;
	BufferedImage bulletBoom;
	BufferedImage tankBoom;
	BufferedImage brickBoom;
	BufferedImage tuxBoom;
	BufferedImage tank0;
	BufferedImage tank1;
	BufferedImage tank2;
	BufferedImage tank3;
	BufferedImage tux;
	BufferedImage ice;
	BufferedImage grass;
	BufferedImage water;
	BufferedImage customMap;
	BufferedImage customMapChoosed;
	BufferedImage onePlayer;
	BufferedImage onePlayerChoosed;
	BufferedImage twoPlayer;
	BufferedImage twoPlayerChoosed;
	BufferedImage level;
	BufferedImage steel;
	BufferedImage playerOneNormal0;
	BufferedImage playerOneNormal1;
	BufferedImage playerOneNormal2;
	BufferedImage playerOneNormal3;
	BufferedImage playerOneFast0;
	BufferedImage playerOneFast1;
	BufferedImage playerOneFast2;
	BufferedImage playerOneFast3;
	BufferedImage playerOneStrong0;
	BufferedImage playerOneStrong1;
	BufferedImage playerOneStrong2;
	BufferedImage playerOneStrong3;
	BufferedImage playerOneSuper0;
	BufferedImage playerOneSuper1;
	BufferedImage playerOneSuper2;
	BufferedImage playerOneSuper3;
	BufferedImage playerTwoNormal0;
	BufferedImage playerTwoNormal1;
	BufferedImage playerTwoNormal2;
	BufferedImage playerTwoNormal3;
	BufferedImage playerTwoFast0;
	BufferedImage playerTwoFast1;
	BufferedImage playerTwoFast2;
	BufferedImage playerTwoFast3;
	BufferedImage playerTwoStrong0;
	BufferedImage playerTwoStrong1;
	BufferedImage playerTwoStrong2;
	BufferedImage playerTwoStrong3;
	BufferedImage playerTwoSuper0;
	BufferedImage playerTwoSuper1;
	BufferedImage playerTwoSuper2;
	BufferedImage playerTwoSuper3;
	BufferedImage normalTank0;
	BufferedImage normalTank1;
	BufferedImage normalTank2;
	BufferedImage normalTank3;
	BufferedImage fastTank0;
	BufferedImage fastTank1;
	BufferedImage fastTank2;
	BufferedImage fastTank3;
	BufferedImage strongTank0;
	BufferedImage strongTank1;
	BufferedImage strongTank2;
	BufferedImage strongTank3;
	BufferedImage num0;
	BufferedImage num1;
	BufferedImage num2;
	BufferedImage num3;
	BufferedImage num4;
	BufferedImage num5;
	BufferedImage num6;
	BufferedImage num7;
	BufferedImage num8;
	BufferedImage num9;
	BufferedImage bigNum0;
	BufferedImage bigNum1;
	BufferedImage bigNum2;
	BufferedImage bigNum3;
	BufferedImage bigNum4;
	BufferedImage bigNum5;
	BufferedImage bigNum6;
	BufferedImage bigNum7;
	BufferedImage bigNum8;
	BufferedImage bigNum9;	
	BufferedImage plus;
	BufferedImage plusChoosed;
	BufferedImage minus;
	BufferedImage minusChoosed;
	BufferedImage quitSet;
	BufferedImage quitSetChoosed;
	BufferedImage boomBonus;
	BufferedImage tuxBonus;
	BufferedImage godBonus;
	BufferedImage tankBonus;
	BufferedImage starBonus;
	BufferedImage freezeBonus;
	BufferedImage shield;
	BufferedImage mud;
	BufferedImage clear;
	BufferedImage result;
	BufferedImage fourBrick;
	BufferedImage singleSteel;
	ClientFrame mainFrame;
	Panel loadingPanel;
	Panel runningPanel;
	Panel endingPanel;
	Panel controlPanel1;
	Panel welcomePanel;
	Panel drawMapPanel;
	Panel settingPanel;
	BattleCanvas battleCanvas;
	MapCanvas mapCanvas;
	MapUnitCanvas mapUnitCanvas;
	ImageCanvas runInfoCanvas;
	ImageCanvas welcomeCanvas;
	ImageCanvas startCanvas;
	ImageCanvas quitCanvas;
	ImageCanvas setCanvas;
	ImageCanvas helpCanvas;
	ImageCanvas backCanvas;
	ImageCanvas pauseCanvas;
	ImageCanvas endCanvas;
	ImageCanvas okCanvas;
	ImageCanvas goCanvas;
	ImageCanvas quitDrawCanvas;
	ImageCanvas okSetCanvas;
	ImageCanvas setBackgroundCanvas;
	ImageCanvas onePlayerCanvas;
	ImageCanvas twoPlayerCanvas;
	ImageCanvas levelCanvas;
	ImageCanvas num1Canvas;
	ImageCanvas num2Canvas;
	ImageCanvas plusCanvas;
	ImageCanvas minusCanvas;
	ImageCanvas customMapCanvas;
	ImageCanvas quitSetCanvas;
	ImageCanvas sleepingNum1Canvas;
	ImageCanvas sleepingNum2Canvas;
	ImageCanvas runningNum1Canvas;
	ImageCanvas runningNum2Canvas;
	ImageCanvas player1Num1Canvas;
	ImageCanvas player1Num2Canvas;
	ImageCanvas player2Num1Canvas;
	ImageCanvas player2Num2Canvas;
	ImageCanvas normal1Num1Canvas;
	ImageCanvas normal1Num2Canvas;
	ImageCanvas fast1Num1Canvas;
	ImageCanvas fast1Num2Canvas;
	ImageCanvas strong1Num1Canvas;
	ImageCanvas strong1Num2Canvas;
	ImageCanvas normal2Num1Canvas;
	ImageCanvas normal2Num2Canvas;
	ImageCanvas fast2Num1Canvas;
	ImageCanvas fast2Num2Canvas;
	ImageCanvas strong2Num1Canvas;
	ImageCanvas strong2Num2Canvas;
	ImageCanvas stageNum1Canvas;
	ImageCanvas stageNum2Canvas;
	
	CardLayout cardLayoutMain = new CardLayout();
	public GraphicsClient(){
		try{
			bullet0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bullet0.png"));
			bullet1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bullet1.png"));
			bullet2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bullet2.png"));
			bullet3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bullet3.png"));
			brick = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/brick.png"));
			bulletBoom = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bulletBoom.png"));
			tankBoom = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/tankBoom.png"));
			brickBoom = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/brickBoom.png"));
			tuxBoom = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/tuxBoom.png"));
			tank0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/grey0.gif"));
			tank1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/grey1.gif"));
			tank2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/grey2.gif"));
			tank3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/grey3.gif"));
			tux = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/tux.png"));
			ice = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/ice.png"));
			grass = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/grass.png"));
			water = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/water.png"));
			steel = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/steel.png"));
			welcome = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/welcome.png"));
			start = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/start.png"));
			startChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/startChoosed.png"));
			quit = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/quit.png"));
			quitChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/quitChoosed.png"));
			set = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/set.png"));
			setChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/setChoosed.png"));
			help = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/help.png"));
			helpChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/helpChoosed.png"));
			back = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/back.png"));
			backChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/backChoosed.png"));
			pause = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/pause.png"));
			pauseChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/pauseChoosed.png"));
			runInfo = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/runInfo.png"));
			ok = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/ok.png"));
			okChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/okChoosed.png"));
			go = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/go.png"));
			goChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/goChoosed.png"));
			mapUnit = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/mapUnit.png"));
			setBackground = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/setBackground.png"));	
			okSet = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/okSet.png"));
			okSetChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/okSetChoosed.png"));
			customMap = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/customMap.png"));
			customMapChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/customMapChoosed.png"));
			onePlayer = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/onePlayer.png"));
			onePlayerChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/onePlayerChoosed.png"));
			twoPlayer = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/twoPlayer.png"));
			twoPlayerChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/twoPlayerChoosed.png"));
			level = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/level.png"));
			num0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/num0.png"));
			num1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/num1.png"));
			num2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/num2.png"));
			num3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/num3.png"));
			num4 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/num4.png"));
			num5 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/num5.png"));
			num6 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/num6.png"));
			num7 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/num7.png"));
			num8 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/num8.png"));
			num9 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/num9.png"));	
			bigNum0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bigNum0.png"));
			bigNum1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bigNum1.png"));
			bigNum2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bigNum2.png"));
			bigNum3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bigNum3.png"));
			bigNum4 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bigNum4.png"));
			bigNum5 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bigNum5.png"));
			bigNum6 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bigNum6.png"));
			bigNum7 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bigNum7.png"));
			bigNum8 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bigNum8.png"));
			bigNum9 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/bigNum9.png"));			
			plus = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/plus.png"));
			plusChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/plusChoosed.png"));
			minus = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/minus.png"));
			minusChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/minusChoosed.png"));
			quitDraw = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/quitDraw.png"));
			quitDrawChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/quitDrawChoosed.png"));
			quitSet = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/quitSet.png"));
			quitSetChoosed = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/quitSetChoosed.png"));
			playerOneNormal0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneNormal0.png"));
			playerOneNormal1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneNormal1.png"));
			playerOneNormal2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneNormal2.png"));
			playerOneNormal3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneNormal3.png"));
			playerOneFast0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneFast0.png"));
			playerOneFast1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneFast1.png"));
			playerOneFast2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneFast2.png"));
			playerOneFast3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneFast3.png"));
			playerOneStrong0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneStrong0.png"));
			playerOneStrong1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneStrong1.png"));
			playerOneStrong2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneStrong2.png"));
			playerOneStrong3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneStrong3.png"));
			playerOneSuper0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneSuper0.png"));
			playerOneSuper1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneSuper1.png"));
			playerOneSuper2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneSuper2.png"));
			playerOneSuper3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerOneSuper3.png"));
			playerTwoNormal0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoNormal0.png"));
			playerTwoNormal1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoNormal1.png"));
			playerTwoNormal2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoNormal2.png"));
			playerTwoNormal3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoNormal3.png"));
			playerTwoFast0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoFast0.png"));
			playerTwoFast1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoFast1.png"));
			playerTwoFast2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoFast2.png"));
			playerTwoFast3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoFast3.png"));
			playerTwoStrong0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoStrong0.png"));
			playerTwoStrong1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoStrong1.png"));
			playerTwoStrong2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoStrong2.png"));
			playerTwoStrong3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoStrong3.png"));
			playerTwoSuper0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoSuper0.png"));
			playerTwoSuper1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoSuper1.png"));
			playerTwoSuper2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoSuper2.png"));
			playerTwoSuper3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/playerTwoSuper3.png"));
			normalTank0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/normalTank0.png"));
			normalTank1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/normalTank1.png"));
			normalTank2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/normalTank2.png"));
			normalTank3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/normalTank3.png"));
			fastTank0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/fastTank0.png"));
			fastTank1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/fastTank1.png"));
			fastTank2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/fastTank2.png"));
			fastTank3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/fastTank3.png"));
			strongTank0 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/strongTank0.png"));
			strongTank1 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/strongTank1.png"));
			strongTank2 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/strongTank2.png"));
			strongTank3 = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/strongTank3.png"));
			boomBonus = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/boomBonus.png"));
			tuxBonus = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/tuxBonus.png"));
			godBonus = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/godBonus.png"));
			freezeBonus = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/freezeBonus.png"));
			starBonus = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/starBonus.png"));
			tankBonus = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/tankBonus.png"));
			shield = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/shield.png"));
			mud = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/mud.png"));
			result = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/result.png"));
			clear = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/clear.png"));
			fourBrick = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/fourBrick.png"));
			singleSteel = ImageIO.read(ClassLoader.getSystemResourceAsStream("image/singleSteel.png"));
		}
		catch(Exception e){
			System.out.println("faliure in getting image files");
			System.out.println(e);
		}
	}
	public static void main(String[] args){
			System.out.print("Initializing graphics client...");
			clientRef = new GraphicsClient();
			clientRef.loadingGame();
			clientRef.runningGame();
			clientRef.setting();
			clientRef.drawingMap();
			clientRef.endingGame();			
			System.out.println("success");
			clientRef.load();
			clientRef.mainFrame.setVisible(true);
	}
	public void load(){
		welcomeCanvas.repaint();
		startCanvas.repaint();
		quitCanvas.repaint();
		helpCanvas.repaint();
		setCanvas.repaint();
		cardLayoutMain.show(mainFrame, "loadingPanel");
	}
	public void run(){
		battleCanvas.requestFocus();
		cardLayoutMain.show(mainFrame, "runningPanel");
		battleCanvas.requestFocus();
	}
	public void drawMap(){
		for(int i=0; i<30; i++){
			for(int j=0;j<34; j++)
				SettingInfo.mapData[i][j] = 0;
		}
		SettingInfo.mapData[28][16] = 1;
		SettingInfo.mapData[28][17] = 0;
		SettingInfo.mapData[29][16] = 0;
		SettingInfo.mapData[29][17] = 0;
		drawType = (byte)0;		
		cardLayoutMain.show(mainFrame, "drawMapPanel");		
	}
	public void repaint(){
		repaintNumCanvas(ControlInfo.getSleepingTankNum(), sleepingNum1Canvas, sleepingNum2Canvas);
		repaintNumCanvas((byte)RunGame.tankList.size(), runningNum1Canvas, runningNum2Canvas);
		repaintNumCanvas(ControlInfo.getRebornTimes(1), player1Num1Canvas, player1Num2Canvas);
		repaintNumCanvas(ControlInfo.getRebornTimes(2), player2Num1Canvas, player2Num2Canvas);
		battleCanvas.repaint();		
	}
	public void setup(){		
		cardLayoutMain.show(mainFrame, "settingPanel");
	}
	public void help(){
		new DocViewer().init();
	}
	public void end(){
		new Audio("sound/ding.wav");
		repaintNumCanvas(ControlInfo.playerOneKills[0], normal1Num1Canvas, normal1Num2Canvas);
		repaintNumCanvas(ControlInfo.playerOneKills[1], fast1Num1Canvas, fast1Num2Canvas);
		repaintNumCanvas(ControlInfo.playerOneKills[2], strong1Num1Canvas, strong1Num2Canvas);
		repaintNumCanvas(ControlInfo.playerTwoKills[0], normal2Num1Canvas, normal2Num2Canvas);
		repaintNumCanvas(ControlInfo.playerTwoKills[1], fast2Num1Canvas, fast2Num2Canvas);
		repaintNumCanvas(ControlInfo.playerTwoKills[2], strong2Num1Canvas, strong2Num2Canvas);
		
		repaintBigNumCanvas(SettingInfo.getLevel(), stageNum1Canvas, stageNum2Canvas);
		cardLayoutMain.show(mainFrame, "endingPanel");		
	}
	public void loadingGame(){
		mainFrame = new ClientFrame();
		loadingPanel = new Panel();
		controlPanel1 = new Panel();
		welcomeCanvas = new ImageCanvas(800, 600, welcome);
		startCanvas = new ImageCanvas(80, 40, start);
		quitCanvas = new ImageCanvas(80, 40, quit);
		setCanvas = new ImageCanvas(80, 40, set);
		helpCanvas = new ImageCanvas(80, 40, help);
		mainFrame.setLayout(cardLayoutMain);
		loadingPanel.setLayout(null);
		loadingPanel.setPreferredSize(new Dimension(CLIENT_WIDTH, CLIENT_HEIGHT));
		welcomeCanvas.setBounds(0, 0, CLIENT_WIDTH, CLIENT_HEIGHT);
		startCanvas.setBounds(600, 400, 80, 40);
		quitCanvas.setBounds(600, 520, 80, 40);
		setCanvas.setBounds(500, 460, 80, 40);
		helpCanvas.setBounds(700, 460, 80, 40);
		loadingPanel.add(startCanvas);		
		loadingPanel.add(quitCanvas);
		loadingPanel.add(setCanvas);
		loadingPanel.add(helpCanvas);
		loadingPanel.add(welcomeCanvas);	
		mainFrame.add("loadingPanel", loadingPanel);
		mainFrame.pack();
		startCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){	
			}
			public void mouseClicked(MouseEvent e){
				new RunGame();
			}
			public void mouseEntered(MouseEvent e){
				startCanvas.imageRef = startChoosed;
				startCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				startCanvas.imageRef = start;
				startCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){	
			}
		});
		quitCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){	
			}
			public void mouseClicked(MouseEvent e){
				System.out.println("Quit");
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e){
				quitCanvas.imageRef = quitChoosed;
				quitCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				quitCanvas.imageRef = quit;
				quitCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){	
			}
		});
		setCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){	
			}
			public void mouseClicked(MouseEvent e){
				setup();
				
			}
			public void mouseEntered(MouseEvent e){
				setCanvas.imageRef = setChoosed;
				setCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				setCanvas.imageRef = set;
				setCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){	
			}
		});
		helpCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){	
			}
			public void mouseClicked(MouseEvent e){
				System.out.println("help");
				help();
			}
			public void mouseEntered(MouseEvent e){
				helpCanvas.imageRef = helpChoosed;
				helpCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				helpCanvas.imageRef = help;
				helpCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){	
			}
		});
	}
	public void runningGame(){
		runningPanel = new Panel();
		battleCanvas = new BattleCanvas();
		runInfoCanvas = new ImageCanvas(120, 600, runInfo);
		sleepingNum1Canvas = new ImageCanvas(20, 40, num0);
		sleepingNum2Canvas = new ImageCanvas(20, 40, num0);
		runningNum1Canvas = new ImageCanvas(20, 40, num0);
		runningNum2Canvas = new ImageCanvas(20, 40, num0);
		player1Num1Canvas = new ImageCanvas(20, 40, num0);
		player1Num2Canvas = new ImageCanvas(20, 40, num0);
		player2Num1Canvas = new ImageCanvas(20, 40, num0);
		player2Num2Canvas = new ImageCanvas(20, 40, num0);
		backCanvas = new ImageCanvas(80, 40, back);
		pauseCanvas = new ImageCanvas(80, 40, pause);
		runningPanel.setLayout(null);
		runningPanel.setPreferredSize(new Dimension(CLIENT_WIDTH, CLIENT_HEIGHT));
		battleCanvas.setBounds(0, 0, BATTLE_WIDTH, BATTLE_HEIGHT);
		backCanvas.setBounds(680, 540, 80, 40);
		pauseCanvas.setBounds(680, 480, 80, 40);
		runInfoCanvas.setBounds(680, 0, 120, 600);
		sleepingNum1Canvas.setBounds(755, 40, 20, 40);
		sleepingNum2Canvas.setBounds(780, 40, 20, 40);
		runningNum1Canvas.setBounds(755, 95, 20, 40);
		runningNum2Canvas.setBounds(780, 95, 20, 40);
		player1Num1Canvas.setBounds(755, 285, 20, 40);
		player1Num2Canvas.setBounds(780, 285, 20, 40);
		player2Num1Canvas.setBounds(755, 340, 20, 40);
		player2Num2Canvas.setBounds(780, 340, 20, 40);
		runningPanel.add(sleepingNum1Canvas);
		runningPanel.add(sleepingNum2Canvas);
		runningPanel.add(runningNum1Canvas);
		runningPanel.add(runningNum2Canvas);
		runningPanel.add(player1Num1Canvas);
		runningPanel.add(player1Num2Canvas);
		runningPanel.add(player2Num1Canvas);
		runningPanel.add(player2Num2Canvas);
		runningPanel.add(backCanvas);
		runningPanel.add(pauseCanvas);
		runningPanel.add(runInfoCanvas);
		runningPanel.add(battleCanvas);	
		mainFrame.add("runningPanel", runningPanel);	
		backCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){	
			}
			public void mouseClicked(MouseEvent e){
				RunGame.stopTimer();
				load();
			}
			public void mouseEntered(MouseEvent e){
				backCanvas.imageRef = backChoosed;
				backCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				backCanvas.imageRef = back;
				backCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){	
			}
		});
		pauseCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){	
			}
			public void mouseClicked(MouseEvent e){
				new Audio("sound/pause.wav");
				if(ControlInfo.getIsPaused()==false){
					RunGame.stopTimer();
					ControlInfo.setIsPaused(true);
				}					
				else{
					battleCanvas.requestFocus();
					RunGame.startTimer();
					ControlInfo.setIsPaused(false);
				}
				
			}
			public void mouseEntered(MouseEvent e){
				pauseCanvas.imageRef = pauseChoosed;
				pauseCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				pauseCanvas.imageRef = pause;
				pauseCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){	
			}
		});		
		battleCanvas.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent evt){
				if(evt.getKeyCode()==KeyEvent.VK_CAPS_LOCK){
					ControlInfo.evilCount++;
					if(ControlInfo.evilCount==5)
						ControlInfo.setResult(Constants.WIN);
				}
				if(RunGame.playerOne!=null){
					if(evt.getKeyCode()==KeyEvent.VK_D){	
						ControlInfo.addDirection(1, Constants.RIGHT);
					}
					if(evt.getKeyCode()==KeyEvent.VK_S){
						ControlInfo.addDirection(1, Constants.DOWN);
					}
					if(evt.getKeyCode()==KeyEvent.VK_A){
						ControlInfo.addDirection(1, Constants.LEFT);
					}
					if(evt.getKeyCode()==KeyEvent.VK_W){
						ControlInfo.addDirection(1, Constants.UP);
					}
					if(evt.getKeyCode()==KeyEvent.VK_SPACE){
						RunGame.playerOne.setIsShooting(true);
					}
				}
				if(RunGame.playerTwo!=null){
					if(evt.getKeyCode()==KeyEvent.VK_RIGHT){	
						ControlInfo.addDirection(2, Constants.RIGHT);
					}
					if(evt.getKeyCode()==KeyEvent.VK_DOWN){
						ControlInfo.addDirection(2, Constants.DOWN);
					}
					if(evt.getKeyCode()==KeyEvent.VK_LEFT){
						ControlInfo.addDirection(2, Constants.LEFT);
					}
					if(evt.getKeyCode()==KeyEvent.VK_UP){
						ControlInfo.addDirection(2, Constants.UP);
					}
					if(evt.getKeyCode()==KeyEvent.VK_ENTER){
						RunGame.playerTwo.setIsShooting(true);
					}
				}
			}
			public void keyReleased(KeyEvent evt){
				if(RunGame.playerOne!=null){
					if(evt.getKeyCode()==KeyEvent.VK_D){
						ControlInfo.removeDirection(1, Constants.RIGHT);
					}
					if(evt.getKeyCode()==KeyEvent.VK_S){
						ControlInfo.removeDirection(1, Constants.DOWN);
					}
					if(evt.getKeyCode()==KeyEvent.VK_A){
						ControlInfo.removeDirection(1, Constants.LEFT);
					}
					if(evt.getKeyCode()==KeyEvent.VK_W){
						ControlInfo.removeDirection(1, Constants.UP);
					}
					if(evt.getKeyCode()==KeyEvent.VK_SPACE){
						RunGame.playerOne.setIsShooting(false);
					}
				}
				if(RunGame.playerTwo!=null){
					if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
						ControlInfo.removeDirection(2, Constants.RIGHT);
					}
					if(evt.getKeyCode()==KeyEvent.VK_DOWN){
						ControlInfo.removeDirection(2, Constants.DOWN);
					}
					if(evt.getKeyCode()==KeyEvent.VK_LEFT){
						ControlInfo.removeDirection(2, Constants.LEFT);
					}
					if(evt.getKeyCode()==KeyEvent.VK_UP){
						ControlInfo.removeDirection(2, Constants.UP);
					}
					if(evt.getKeyCode()==KeyEvent.VK_ENTER){
						RunGame.playerTwo.setIsShooting(false);
					}
				}
			}
			public void keyTyped(KeyEvent evt){	}
		});
	}
	public void endingGame(){
		endingPanel = new Panel();
		endCanvas = new ImageCanvas(800, 600, result);
		okCanvas = new ImageCanvas(80, 40, ok);
		normal1Num1Canvas = new ImageCanvas(20, 40, num0);
		normal1Num2Canvas = new ImageCanvas(20, 40, num0);
		fast1Num1Canvas = new ImageCanvas(20, 40, num0);
		fast1Num2Canvas = new ImageCanvas(20, 40, num0);
		strong1Num1Canvas = new ImageCanvas(20, 40, num0);
		strong1Num2Canvas = new ImageCanvas(20, 40, num0);
		normal2Num1Canvas = new ImageCanvas(20, 40, num0);
		normal2Num2Canvas = new ImageCanvas(20, 40, num0);
		fast2Num1Canvas = new ImageCanvas(20, 40, num0);
		fast2Num2Canvas = new ImageCanvas(20, 40, num0);
		strong2Num1Canvas = new ImageCanvas(20, 40, num0);
		strong2Num2Canvas = new ImageCanvas(20, 40, num0);
		stageNum1Canvas = new ImageCanvas(80, 160, bigNum0);
		stageNum2Canvas = new ImageCanvas(80, 160, bigNum0);
		endingPanel.setLayout(null);
		endingPanel.setPreferredSize(new Dimension(CLIENT_WIDTH, CLIENT_HEIGHT));
		endCanvas.setBounds(0, 0, 800, 600);
		okCanvas.setBounds(700, 540, 80, 40);
		stageNum1Canvas.setBounds(50, 80, 80, 160);
		stageNum2Canvas.setBounds(130, 80, 80, 160);
		normal1Num1Canvas.setBounds(450, 80, 20, 40);
		normal1Num2Canvas.setBounds(480, 80, 20, 40);
		fast1Num1Canvas.setBounds(450, 160, 20, 40);
		fast1Num2Canvas.setBounds(480, 160, 20, 40);
		strong1Num1Canvas.setBounds(450, 240, 20, 40);
		strong1Num2Canvas.setBounds(480, 240, 20, 40);
		normal2Num1Canvas.setBounds(660, 80, 20, 40);
		normal2Num2Canvas.setBounds(690, 80, 20, 40);
		fast2Num1Canvas.setBounds(660, 160, 20, 40);
		fast2Num2Canvas.setBounds(690, 160, 20, 40);
		strong2Num1Canvas.setBounds(660, 240, 20, 40);
		strong2Num2Canvas.setBounds(690, 240, 20, 40);
		
		
		endingPanel.add(stageNum1Canvas);
		endingPanel.add(stageNum2Canvas);
		endingPanel.add(normal1Num1Canvas);
		endingPanel.add(normal1Num2Canvas);
		endingPanel.add(fast1Num1Canvas);
		endingPanel.add(fast1Num2Canvas);
		endingPanel.add(strong1Num1Canvas);
		endingPanel.add(strong1Num2Canvas);
		endingPanel.add(normal2Num1Canvas);
		endingPanel.add(normal2Num2Canvas);
		endingPanel.add(fast2Num1Canvas);
		endingPanel.add(fast2Num2Canvas);
		endingPanel.add(strong2Num1Canvas);
		endingPanel.add(strong2Num2Canvas);
		endingPanel.add(okCanvas);
		endingPanel.add(endCanvas);
		mainFrame.add("endingPanel", endingPanel);
		okCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){	
			}
			public void mouseClicked(MouseEvent e){
				if(ControlInfo.getResult()==Constants.WIN){
					SettingInfo.addLevel();
					new RunGame();
				}					
				else{
					SettingInfo.setLevel((byte)1);
					load();
				}
					
			}
			public void mouseEntered(MouseEvent e){
				okCanvas.imageRef = okChoosed;
				okCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				okCanvas.imageRef = ok;
				okCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){	
			}
		});
	}
	public void drawingMap(){
		drawMapPanel = new Panel();
		mapCanvas = new MapCanvas();
		mapUnitCanvas = new MapUnitCanvas();
		goCanvas = new ImageCanvas(80, 40, go);
		quitDrawCanvas = new ImageCanvas(80, 40, quitDraw);
		drawMapPanel.setLayout(null);
		drawMapPanel.setPreferredSize(new Dimension(CLIENT_WIDTH, CLIENT_HEIGHT));
		mapCanvas.setBounds(0, 0, BATTLE_WIDTH, BATTLE_HEIGHT);
		mapUnitCanvas.setBounds(680, 0, 120, 600);
		goCanvas.setBounds(680, 370, 80, 40);
		quitDrawCanvas.setBounds(680, 310, 80, 40);
		drawMapPanel.add(quitDrawCanvas);
		drawMapPanel.add(goCanvas);
		drawMapPanel.add(mapCanvas);
		drawMapPanel.add(mapUnitCanvas);
		
		mapCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){
				drawX = e.getX();
				drawY = e.getY();
				drawX /= Constants.BRICK_SIZE;
				drawY /= Constants.BRICK_SIZE;
				if(e.getButton()==MouseEvent.BUTTON1){
					if(drawX%2!=0)
						drawX--;
					if(drawY%2!=0)
						drawY--;
					if(drawType == Constants.BRICK||drawType == Constants.SINGLE_STEEL){
						if(SettingInfo.mapData[drawY][drawX]!=Constants.BRICK&&
								SettingInfo.mapData[drawY][drawX]!=Constants.SINGLE_STEEL){
							SettingInfo.mapData[drawY][drawX] = 0;
						}
						drawX = e.getX();
						drawY = e.getY();
						drawX /= Constants.BRICK_SIZE;
						drawY /= Constants.BRICK_SIZE;
						SettingInfo.mapData[drawY][drawX] = drawType;
					}
					else{
						SettingInfo.mapData[drawY][drawX] = drawType;
						SettingInfo.mapData[drawY+1][drawX] = 0;
						SettingInfo.mapData[drawY][drawX+1] = 0;
						SettingInfo.mapData[drawY+1][drawX+1] = 0;
					}
				}
				else if(e.getButton()==MouseEvent.BUTTON3){
					if(SettingInfo.mapData[drawY][drawX] == Constants.BRICK||
							SettingInfo.mapData[drawY][drawX] == Constants.SINGLE_STEEL){
						SettingInfo.mapData[drawY][drawX] = 0;
					}
					else{
						if(drawX%2!=0)
							drawX--;
						if(drawY%2!=0)
							drawY--;
						SettingInfo.mapData[drawY][drawX] = 0;
					}					
				}
				mapCanvas.repaint();
				
			}
			public void mouseClicked(MouseEvent e){
		
			}
			public void mouseEntered(MouseEvent e){
				
			}
			public void mouseExited(MouseEvent e){
				
			}
			public void mouseReleased(MouseEvent e){
				
			}			
		});
		mapUnitCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){
				
			}
			public void mouseClicked(MouseEvent e){
				drawX = e.getX();
				drawY = e.getY();
				if(drawX>=0&&drawX<20&&drawY>=0&&drawY<20){
					drawType = Constants.BRICK;
				}
				else if(drawX>=60&&drawX<100&&drawY>=0&&drawY<40){
					drawType = Constants.FOUR_BRICK;
				}
				else if(drawX>=0&&drawX<40&&drawY>=60&&drawY<100){
					drawType = Constants.WATER;
				}
				else if(drawX>=60&&drawX<100&&drawY>=60&&drawY<100){
					drawType = Constants.ICE;			
				}				
				else if(drawX>=0&&drawX<40&&drawY>=120&&drawY<160){
					drawType = Constants.SINGLE_STEEL;
				}
				else if(drawX>=60&&drawX<100&&drawY>=120&&drawY<160){
					drawType = Constants.STEEL;
				}
				else if(drawX>=0&&drawX<40&&drawY>=180&&drawY<220){
					drawType = Constants.GRASS;
				}
			}
			public void mouseEntered(MouseEvent e){
				
			}
			public void mouseExited(MouseEvent e){
				
			}
			public void mouseReleased(MouseEvent e){
				
			}			
		});
		goCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){	
			}
			public void mouseClicked(MouseEvent e){
				SettingInfo.zeroLevel();
				new RunGame();
				//ImATempClass.writeMapData();
			}
			public void mouseEntered(MouseEvent e){
				goCanvas.imageRef = goChoosed;
				goCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				goCanvas.imageRef = go;
				goCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){	
			}
		});
		quitDrawCanvas.addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){	
			}
			public void mouseClicked(MouseEvent e){
				setup();
			}
			public void mouseEntered(MouseEvent e){
				quitDrawCanvas.imageRef = quitDrawChoosed;
				quitDrawCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				quitDrawCanvas.imageRef = quitDraw;
				quitDrawCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){	
			}
		});
		mainFrame.add("drawMapPanel", drawMapPanel);
	}
	public void setting(){
		settingPanel = new Panel();
		setBackgroundCanvas = new ImageCanvas(800, 600, setBackground);
		onePlayerCanvas = new ImageCanvas(200, 40, onePlayerChoosed);
		twoPlayerCanvas = new ImageCanvas(200, 40, twoPlayer);
		levelCanvas = new ImageCanvas(100, 40, level);
		customMapCanvas = new ImageCanvas(200, 40, customMap);
		okSetCanvas = new ImageCanvas(80, 40, ok);
		plusCanvas = new ImageCanvas(20, 20, plus);
		minusCanvas = new ImageCanvas(20, 20, minus);
		num1Canvas = new ImageCanvas(20, 40, num0);
		num2Canvas = new ImageCanvas(20, 40, num1);
		quitSetCanvas = new ImageCanvas(80, 40, quitSet);
		settingPanel.setLayout(null);
		settingPanel.setPreferredSize(new Dimension(CLIENT_WIDTH, CLIENT_HEIGHT));
		setBackgroundCanvas.setBounds(0, 0, 800, 600);
		onePlayerCanvas.setBounds(100, 100, 200, 40);
		twoPlayerCanvas.setBounds(300, 100, 200, 40);
		levelCanvas.setBounds(150, 150, 100, 40);
		num1Canvas.setBounds(250, 150, 20, 40);
		num2Canvas.setBounds(270, 150, 20, 40);
		plusCanvas.setBounds(300, 140, 20, 20);
		minusCanvas.setBounds(300, 180, 20, 20);
		customMapCanvas.setBounds(200, 200, 200, 40);
		okSetCanvas.setBounds(700, 540, 80, 40);
		quitSetCanvas.setBounds(700, 480, 80, 40);
		settingPanel.add(onePlayerCanvas);
		settingPanel.add(twoPlayerCanvas);
		settingPanel.add(levelCanvas);
		settingPanel.add(num1Canvas);
		settingPanel.add(num2Canvas);
		settingPanel.add(customMapCanvas);
		settingPanel.add(okSetCanvas);
		settingPanel.add(plusCanvas);
		settingPanel.add(minusCanvas);
		settingPanel.add(quitSetCanvas);
		settingPanel.add(setBackgroundCanvas);
		mainFrame.add("settingPanel", settingPanel);
		
		onePlayerCanvas.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){
				new Audio("sound/ding.wav");
				SettingInfo.setIsOnePlayer(true);				
			}
			public void mouseEntered(MouseEvent e){
				onePlayerCanvas.imageRef = onePlayerChoosed;
				twoPlayerCanvas.imageRef = twoPlayer;
				onePlayerCanvas.repaint();
				twoPlayerCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				if(SettingInfo.getIsOnePlayer()==false){
					onePlayerCanvas.imageRef = onePlayer;
					twoPlayerCanvas.imageRef = twoPlayerChoosed;
					onePlayerCanvas.repaint();
					twoPlayerCanvas.repaint();
				}
			}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		twoPlayerCanvas.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){
				new Audio("sound/ding.wav");
				SettingInfo.setIsOnePlayer(false);
			}
			public void mouseEntered(MouseEvent e){
				onePlayerCanvas.imageRef = onePlayer;
				twoPlayerCanvas.imageRef = twoPlayerChoosed;
				onePlayerCanvas.repaint();
				twoPlayerCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				if(SettingInfo.getIsOnePlayer()==true){
					onePlayerCanvas.imageRef = onePlayerChoosed;
					twoPlayerCanvas.imageRef = twoPlayer;
					onePlayerCanvas.repaint();
					twoPlayerCanvas.repaint();
				}
			}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		plusCanvas.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){
							
			}
			public void mouseEntered(MouseEvent e){
				plusCanvas.imageRef = plusChoosed;
				plusCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				plusCanvas.imageRef = plus;
				plusCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){
				SettingInfo.mousePressedAddTimer.stop();
				repaintNumCanvas(SettingInfo.addLevel(), num1Canvas, num2Canvas);				
			}
			public void mousePressed(MouseEvent e){
				new Audio("sound/ding.wav");
				SettingInfo.mousePressedAddTimer.start();
			}
		});
		minusCanvas.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){
				minusCanvas.imageRef = minusChoosed;
				minusCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				minusCanvas.imageRef = minus;
				minusCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){
				SettingInfo.mousePressedSubTimer.stop();
				repaintNumCanvas(SettingInfo.subLevel(), num1Canvas, num2Canvas);				
			}
			public void mousePressed(MouseEvent e){
				new Audio("sound/ding.wav");
				SettingInfo.mousePressedSubTimer.start();
			}
		});
		customMapCanvas.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){
				new Audio("sound/ding.wav");
				drawMap();
			}
			public void mouseEntered(MouseEvent e){
				customMapCanvas.imageRef = customMapChoosed;
				customMapCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				customMapCanvas.imageRef = customMap;
				customMapCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		quitSetCanvas.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){
				SettingInfo.setLevel((byte)1);
				SettingInfo.setIsOnePlayer(true);
				load();
			}
			public void mouseEntered(MouseEvent e){
				quitSetCanvas.imageRef = quitSetChoosed;
				quitSetCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				quitSetCanvas.imageRef = quitSet;
				quitSetCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
		okSetCanvas.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){
				load();
			}
			public void mouseEntered(MouseEvent e){
				okSetCanvas.imageRef = okSetChoosed;
				okSetCanvas.repaint();
			}
			public void mouseExited(MouseEvent e){
				okSetCanvas.imageRef = okSet;
				okSetCanvas.repaint();
			}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
		});
	}
	class ClientFrame extends Frame{
		ClientFrame(){
			super("Bazinga Tank");
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){ 
					System.exit(0); 
				} 
			});
			setResizable(false);
		}		
	}
	class MapCanvas extends Canvas{
		BufferedImage bufferedImage;
		public void update(Graphics g){
			bufferedImage = new BufferedImage(BATTLE_WIDTH,BATTLE_HEIGHT,
	                BufferedImage.TYPE_INT_RGB);
			this.paint(bufferedImage.getGraphics());
	        g.drawImage(bufferedImage,0,0,null);
		}
		public void paint(Graphics g){
			for(int i=0; i<30; i++){
				for(int j=0; j<34; j++){
					switch(SettingInfo.mapData[i][j]){
					case Constants.TUX:
						g.drawImage(tux, j*20, i*20, null);
						break;
					case Constants.GRASS:
						g.drawImage(grass, j*20, i*20, null);
						break;
					case Constants.BRICK:
						g.drawImage(brick, j*20, i*20, null);
						break;
					case Constants.ICE:
						g.drawImage(ice, j*20, i*20, null);
						break;
					case Constants.WATER:
						g.drawImage(water, j*20, i*20, null);
						break;
					case Constants.STEEL:
						g.drawImage(steel, j*20, i*20, null);
						break;
					case Constants.SINGLE_STEEL:
						g.drawImage(singleSteel, j*20, i*20, null);
						break;
					case Constants.FOUR_BRICK:
						g.drawImage(fourBrick, j*20, i*20, null);
						break;
					}
				}
			}
		}
	}
	class MapUnitCanvas extends Canvas{
		public void paint(Graphics g){
			g.drawImage(mapUnit, 0, 0, null);
			g.drawImage(brick, 0, 0, null);
			g.drawImage(fourBrick, 60, 0, null);
			g.drawImage(water, 0, 60, null);
			g.drawImage(ice, 60, 60, null);
			g.drawImage(singleSteel, 0, 120, null);
			g.drawImage(steel, 60, 120, null);
			g.drawImage(grass, 0, 180, null);
		}
	}		
	class ImageCanvas extends Canvas{
		public ImageCanvas(int w, int h, BufferedImage img){
			width = w;
			height = h;
			imageRef = img;
		}
		BufferedImage imageRef;
		BufferedImage bufferedImage;
		int width, height;
		public void update(Graphics g){
			bufferedImage = new BufferedImage(width, height,
	                BufferedImage.TYPE_INT_RGB);
			this.paint(bufferedImage.getGraphics());
	        g.drawImage(bufferedImage,0,0,null);
		}
		public void paint(Graphics g){
			g.drawImage(imageRef, 0, 0, null);
		}
	}
	class BattleCanvas extends Canvas{
		BufferedImage bufferedImage;
		public void update(Graphics g){
			bufferedImage = new BufferedImage(BATTLE_WIDTH,BATTLE_HEIGHT,
	                BufferedImage.TYPE_INT_RGB);
			this.paint(bufferedImage.getGraphics());
	        g.drawImage(bufferedImage,0,0,null);
		}
		public void paint(Graphics g){
			byte tmpD, tmpT;
			for(Unit u : RunGame.itemList){
				tmpT = u.getType();
				switch(tmpT){
				case Constants.SINGLE_STEEL:
					g.drawImage(singleSteel, u.getX(), u.getY(), null);
					break;
				case Constants.BRICK:
					g.drawImage(brick, u.getX(), u.getY(), null);
					break;
				case Constants.TUX:
					g.drawImage(tux, u.getX(), u.getY(), null);
					break;
				case Constants.ICE:
					g.drawImage(ice, u.getX(), u.getY(), null);
					break;
				case Constants.WATER:
					g.drawImage(water, u.getX(), u.getY(), null);
					break;
				}
			}	
			for(Bullet b : RunGame.bulletList){
				tmpD = b.getDirection();
				switch(tmpD){
				case Constants.RIGHT:
					g.drawImage(bullet0, b.getX(), b.getY(), null);
					break;
				case Constants.DOWN:
					g.drawImage(bullet1, b.getX(), b.getY(), null);
					break;
				case Constants.LEFT:
					g.drawImage(bullet2, b.getX(), b.getY(), null);
					break;
				case Constants.UP:
					g.drawImage(bullet3, b.getX(), b.getY(), null);
					break;
				}
			}
			if(RunGame.playerOne!=null){
				tmpD = RunGame.playerOne.getFaceDirection();
				tmpT = RunGame.playerOne.getTankType();
				switch(tmpD){
				case Constants.RIGHT:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(playerOneNormal0, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(playerOneFast0, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(playerOneStrong0, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_SUPER)
						g.drawImage(playerOneSuper0, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					break;
				case Constants.DOWN:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(playerOneNormal1, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(playerOneFast1, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(playerOneStrong1, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_SUPER)
						g.drawImage(playerOneSuper1, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					break;
				case Constants.LEFT:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(playerOneNormal2, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(playerOneFast2, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(playerOneStrong2, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_SUPER)
						g.drawImage(playerOneSuper2, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					break;
				case Constants.UP:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(playerOneNormal3, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(playerOneFast3, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(playerOneStrong3, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					else if(tmpT==Constants.TANK_SUPER)
						g.drawImage(playerOneSuper3, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
					break;
				}	
				if(RunGame.playerOne.getIsShielded()==true)
					g.drawImage(shield, RunGame.playerOne.getX(), RunGame.playerOne.getY(), null);
			}
			if(RunGame.playerTwo!=null){
				tmpD = RunGame.playerTwo.getFaceDirection();
				tmpT = RunGame.playerTwo.getTankType();
				switch(tmpD){
				case Constants.RIGHT:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(playerTwoNormal0, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(playerTwoFast0, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(playerTwoStrong0, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_SUPER)
						g.drawImage(playerTwoSuper0, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					break;
				case Constants.DOWN:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(playerTwoNormal1, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(playerTwoFast1, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(playerTwoStrong1, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_SUPER)
						g.drawImage(playerTwoSuper1, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					break;
				case Constants.LEFT:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(playerTwoNormal2, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(playerTwoFast2, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(playerTwoStrong2, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_SUPER)
						g.drawImage(playerTwoSuper2, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					break;
				case Constants.UP:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(playerTwoNormal3, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(playerTwoFast3, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(playerTwoStrong3, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					else if(tmpT==Constants.TANK_SUPER)
						g.drawImage(playerTwoSuper3, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
					break;
				}	
				if(RunGame.playerTwo.getIsShielded()==true)
					g.drawImage(shield, RunGame.playerTwo.getX(), RunGame.playerTwo.getY(), null);
			}
			
			for(Tank t : RunGame.tankList){
				tmpD = t.getFaceDirection();
				tmpT = t.getTankType();
				switch(tmpD){
				case Constants.RIGHT:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(normalTank0, t.getX(), t.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(fastTank0, t.getX(), t.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(strongTank0, t.getX(), t.getY(), null);
					break;
				case Constants.DOWN:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(normalTank1, t.getX(), t.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(fastTank1, t.getX(), t.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(strongTank1, t.getX(), t.getY(), null);
					break;
				case Constants.LEFT:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(normalTank2, t.getX(), t.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(fastTank2, t.getX(), t.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(strongTank2, t.getX(), t.getY(), null);
					break;
				case Constants.UP:
					if(tmpT==Constants.TANK_NORMAL)
						g.drawImage(normalTank3, t.getX(), t.getY(), null);
					else if(tmpT==Constants.TANK_FAST)
						g.drawImage(fastTank3, t.getX(), t.getY(), null);
					else if(tmpT==Constants.TANK_STRONG)
						g.drawImage(strongTank3, t.getX(), t.getY(), null);
					break;
				default:
					System.out.println("tank direction error");
					break;
				}		
			}
			for(Unit u : RunGame.itemList){
				tmpT = u.getType();
				switch(tmpT){
				case Constants.GRASS:
					g.drawImage(grass, u.getX(), u.getY(), null);
					break;					
				}
			}		
			
			for(Bonus b : RunGame.bonusList){
				tmpT = b.getType();
				switch(tmpT){
				case Constants.BONUS_FREEZE:
					g.drawImage(freezeBonus, b.getX(), b.getY(), null);
					break;
				case Constants.BONUS_SHIELD:
					g.drawImage(godBonus, b.getX(), b.getY(), null);
					break;
				case Constants.BONUS_STAR:
					g.drawImage(starBonus, b.getX(), b.getY(), null);
					break;
				case Constants.BONUS_TANK:
					g.drawImage(tankBonus, b.getX(), b.getY(), null);
					break;
				case Constants.BONUS_TUX:
					g.drawImage(tuxBonus, b.getX(), b.getY(), null);
					break;
				case Constants.BONUS_BOOM:
					g.drawImage(boomBonus, b.getX(), b.getY(), null);
					break;
				}
			}
			for(Unit u : RunGame.effectList){
				tmpT = u.getType();
				switch(tmpT){
				case Constants.BULLET_BOOM:
					g.drawImage(bulletBoom, u.getX(), u.getY(), null);
					break;
				case Constants.TANK_BOOM:
					g.drawImage(tankBoom, u.getX(), u.getY(), null);
					break;				
				case Constants.BRICK_BOOM:
					g.drawImage(brickBoom, u.getX(), u.getY(), null);
					break;
				case Constants.TUX_BOOM:
					g.drawImage(tuxBoom, u.getX(), u.getY(), null);
					break;
				}
			}
			RunGame.effectList.clear();
			if(ControlInfo.getResult()==Constants.LOSE){
				int x = 0, y = 0;
				try{
					InputStream is = ClassLoader.getSystemResourceAsStream("data/gameOver");
					BufferedReader b = new BufferedReader(new InputStreamReader(is));
					int l=0;
					String s;
					while((s=b.readLine())!=null){
						l = s.length();
						x = 0;
						for(int i=0; i<l; i+=2){
							if((s.charAt(i)-48)!=0){
								g.drawImage(mud, x, y, null);
							}
							x += Constants.BRICK_SIZE;
							if(i==l-1){
								y += Constants.BRICK_SIZE;
							}
						}
					}
				}
				catch(Exception e){
						System.out.println("Draw game over error: "+e);
				}
			}
		}
	}
	public void repaintNumCanvas(byte x, ImageCanvas num1Canvas, ImageCanvas num2Canvas){
		byte x1, x2;
		x1 = (byte)(x/10);
		x2 = (byte)(x%10);
		switch(x1){
		case 0: num1Canvas.imageRef = num0; break;
		case 1: num1Canvas.imageRef = num1; break;
		case 2: num1Canvas.imageRef = num2; break;
		case 3: num1Canvas.imageRef = num3; break;
		case 4: num1Canvas.imageRef = num4; break;
		case 5: num1Canvas.imageRef = num5; break;
		case 6: num1Canvas.imageRef = num6; break;
		case 7: num1Canvas.imageRef = num7; break;
		case 8: num1Canvas.imageRef = num8; break;
		case 9: num1Canvas.imageRef = num9; break;
		}
		switch(x2){
		case 0: num2Canvas.imageRef = num0; break;
		case 1: num2Canvas.imageRef = num1; break;
		case 2: num2Canvas.imageRef = num2; break;
		case 3: num2Canvas.imageRef = num3; break;
		case 4: num2Canvas.imageRef = num4; break;
		case 5: num2Canvas.imageRef = num5; break;
		case 6: num2Canvas.imageRef = num6; break;
		case 7: num2Canvas.imageRef = num7; break;
		case 8: num2Canvas.imageRef = num8; break;
		case 9: num2Canvas.imageRef = num9; break;
		}
		num1Canvas.repaint();
		num2Canvas.repaint();
	}
	public void repaintBigNumCanvas(byte x, ImageCanvas num1Canvas, ImageCanvas num2Canvas){
		byte x1, x2;
		x1 = (byte)(x/10);
		x2 = (byte)(x%10);
		switch(x1){
		case 0: num1Canvas.imageRef = bigNum0; break;
		case 1: num1Canvas.imageRef = bigNum1; break;
		case 2: num1Canvas.imageRef = bigNum2; break;
		case 3: num1Canvas.imageRef = bigNum3; break;
		case 4: num1Canvas.imageRef = bigNum4; break;
		case 5: num1Canvas.imageRef = bigNum5; break;
		case 6: num1Canvas.imageRef = bigNum6; break;
		case 7: num1Canvas.imageRef = bigNum7; break;
		case 8: num1Canvas.imageRef = bigNum8; break;
		case 9: num1Canvas.imageRef = bigNum9; break;
		}
		switch(x2){
		case 0: num2Canvas.imageRef = bigNum0; break;
		case 1: num2Canvas.imageRef = bigNum1; break;
		case 2: num2Canvas.imageRef = bigNum2; break;
		case 3: num2Canvas.imageRef = bigNum3; break;
		case 4: num2Canvas.imageRef = bigNum4; break;
		case 5: num2Canvas.imageRef = bigNum5; break;
		case 6: num2Canvas.imageRef = bigNum6; break;
		case 7: num2Canvas.imageRef = bigNum7; break;
		case 8: num2Canvas.imageRef = bigNum8; break;
		case 9: num2Canvas.imageRef = bigNum9; break;
		}
		num1Canvas.repaint();
		num2Canvas.repaint();
	}
}
