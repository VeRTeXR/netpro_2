package browserStuff;


/*import com.teamdev.jxbrowser.chromium.BeforeSendHeadersParams;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.BrowserFactory;*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;


public class browsr {

	private JFrame frame;
	private JTextField txtURL;
	private JEditorPane editorPane,editorPane_1;
	private JTextField txtURL_2;
	private JTextArea txtrHeader;
	private JTextArea txtrHea;
	private JScrollPane scrollPane_3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					browsr window = new browsr();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public browsr() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(169, 169, 169));
		/*final Browser browser = BrowserFactory.create(); 
		final Browser browser_2 = BrowserFactory.create();*/
		
		frame.setResizable(false);
		frame.setTitle("Vasut Pongsattayapipat s5050453@kmitl.ac.th - Java Web Browser (Network Programming Class Assignment #2)");
		frame.setBounds(100, 100, 1280, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton fwdButton = new JButton(">");
		fwdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrHeader.setText("");
				txtrHea.setText("");
				threadDayo a = new threadDayo("Thread I",editorPane,txtURL,txtrHea,txtrHea); //push browser to thread
				threadDayo b = new threadDayo("Thread II",editorPane_1,txtURL_2,txtrHeader,txtrHea); //push browser_2 to thread
				a.start();
				//browser.loadURL(txtURL.getText());
				b.start();
				//browser_2.loadURL(txtURL_2.getText());
			}
		});
		fwdButton.setBounds(1165, 12, 99, 20);
		frame.getContentPane().add(fwdButton);
		
		txtURL = new JTextField("www.google.com");
		txtURL.setBounds(10, 12, 617, 20);
		frame.getContentPane().add(txtURL);
		txtURL.setColumns(10);
		
		txtURL_2 = new JTextField("www.facebook.com");
		txtURL_2.setBounds(647, 12, 508, 20);
		frame.getContentPane().add(txtURL_2);
		txtURL_2.setColumns(10);
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		//browser.loadURL(txtURL.getText());
		//editorPane.add(browser.getView().getComponent());
		//frame.add(editorPane);
		
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setBounds(10, 45, 617, 433);
		frame.getContentPane().add(scrollPane);
		
		editorPane_1 = new JEditorPane();
		editorPane_1.setEditable(false);
		
		//editorPane_1.add(browser_2.getView().getComponent());
		
		
		JScrollPane scrollPane_2 = new JScrollPane(editorPane_1);
		scrollPane_2.setBounds(647, 45, 617, 433);
		frame.getContentPane().add(scrollPane_2);
		
		

		txtrHea = new JTextArea();
		txtrHea.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrHea.setLineWrap(true);
		txtrHea.setForeground(new Color(199, 21, 133));
		txtrHea.setBackground(Color.GRAY);
		txtrHea.setEditable(false);
		txtrHea.setText("Header");
		
		JScrollPane scrollPane_1 = new JScrollPane(txtrHea);
		scrollPane_1.setBounds(10, 489, 617, 162);
		frame.getContentPane().add(scrollPane_1);
		
		txtrHeader = new JTextArea();
		txtrHeader.setLineWrap(true);
		txtrHeader.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrHeader.setForeground(new Color(173, 255, 47));
		txtrHeader.setBackground(Color.GRAY);
		txtrHeader.setEditable(false);
		txtrHeader.setText("Header");
		
		scrollPane_3 = new JScrollPane(txtrHeader);
		scrollPane_3.setBounds(647, 489, 617, 162);
		frame.getContentPane().add(scrollPane_3);
		
		//browser.loadURL(txtURL.getText());
		//browser_2.loadURL(txtURL_2.getText());

	}
}