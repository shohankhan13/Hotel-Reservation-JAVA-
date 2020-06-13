package src;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class Frame1 extends JFrame implements ActionListener{
	private JPanel panel;
	private JButton buttonCheck,buttonBook,buttonExit,buttonLogout;

	public Frame1()
	{
		this.initializeComponents();
	}
	public void actionPerformed(ActionEvent event)
	{
		String buttonText = event.getActionCommand();
		if(buttonText.equals("Check"))
		{
			Check ob=new Check();
			ob.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Book"))
		{
			Booking in=new Booking();
			in.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonText.equals("Logout"))
		{
			LogInFrame lf=new LogInFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Exit"))
		{
			System.exit(0);
		}
	}
	
	private void initializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
					
		this.buttonCheck = new JButton("Check");
		this.buttonCheck.setBounds(150, 20, 120, 50);
		this.buttonCheck.addActionListener(this);
		this.panel.add(this.buttonCheck);
		
	    this.buttonBook = new JButton("Book");
		this.buttonBook.setBounds(150, 90, 120, 50);
		this.buttonBook.addActionListener(this);
		this.panel.add(this.buttonBook);
		
	    this.buttonLogout = new JButton("Logout");
		this.buttonLogout.setBounds(150, 160, 120, 50);
       this.buttonLogout.addActionListener(this);
		this.panel.add(this.buttonLogout);
		
		this.buttonExit = new JButton("Exit");
		this.buttonExit.setBackground(Color.RED);
		this.buttonExit.setBounds(150, 230, 120, 50);
		this.buttonExit.addActionListener(this);
		this.panel.add(this.buttonExit);
		
		this.add(this.panel);
		
		this.setTitle("Reservation Window");
		this.setSize(400, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
