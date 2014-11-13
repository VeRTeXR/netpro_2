package browserStuff;

import com.teamdev.jxbrowser.chromium.Browser;




import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class threadDayo implements Runnable {
	private Browser browser;
	private JTextField txtURL;
	private JTextArea txtrHeader;
	private Thread thread;
	private String url;
	private String threadName;
	private JTextArea tt;
	private JEditorPane editorPane;

	
	
	public threadDayo(String threadName,JEditorPane editorPane,JTextField txtURL,JTextArea txtrHeader,JTextArea tt){ //accept Browser browser
		this.threadName = threadName;
		//this.browser = browser;
		this.editorPane = editorPane;
		this.txtURL = txtURL;
		this.txtrHeader = txtrHeader;
		this.tt = tt;
		url = "http://"+txtURL.getText();
	}
	
	public void run() {
		getLink();
		getHeader();
	}
	
	public void start ()
	   {
		  tt.append(threadName+" Creating Thread" +  "\n" );
	      if (thread == null)
	      {
	         thread = new Thread (this, threadName);
	         thread.start ();
	         tt.append(thread.getName()+" Starting Thread" +  "\n" );
	      }
	   }
	public void getLink() {
		try{
 		 	thread.sleep(200);
 		 }
 		 catch(InterruptedException e){
 		 }
		 
		tt.append(thread.getName()+" Fetching Web" +"\n" );
		try {
			//browser.loadURL(url);
			editorPane.setPage(url);
		}
		catch (Exception e) {
			//.ignore
		}
		
		 
		
	}
	public void getHeader(){
		tt.append(thread.getName()+" Get Header" +"\n" );
		try{
 		 	thread.sleep(200);
 		 }
 		 catch(InterruptedException e){}
		txtrHeader.append("________________________________________________________________\n");
		 try {
	            URLConnection conn = new URL(url).openConnection();
	            Map<String, List<String>> map = conn.getHeaderFields();
	            txtrHeader.append("Header of: "+url+"\n");

	            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
	            	txtrHeader.append(entry.getKey() + " : " + entry.getValue()+"\n");
	            } 
	 
	        } catch (Exception e) {
	        	txtrHeader.append("Could not load header from "+url);
	        }	
	}
}