package view;
import java.awt.Dimension;
import java.io.*;
import javax.swing.*;
public class DocViewer {
	JFrame textFrame = new JFrame("READ ME");
	JEditorPane editorPane = new JEditorPane();
	JScrollPane scrollPane = new JScrollPane(editorPane);
	String text = "";
	public void init(){
		try{
			InputStream is = 
				ClassLoader.getSystemResourceAsStream("doc/README");
			BufferedReader b = new BufferedReader(new InputStreamReader(is));
			String s;
			while((s=b.readLine())!=null){
				text = text + s + "\n";
			}
			b.close();
			is.close();
					
		}
		catch(Exception e){
			e.printStackTrace();
		}	
		editorPane.setPreferredSize(new Dimension(680, 400));
		editorPane.setContentType("text/plain");
		editorPane.setEditable(false);
		editorPane.setText(text);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textFrame.add(scrollPane);
		textFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textFrame.pack();
		textFrame.setVisible(true);	
	}
	/*public static void main(String[] args){
		new DocViewer().init();
	}*/
}
