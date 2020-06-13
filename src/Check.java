package src;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Check extends JFrame implements ActionListener {
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JButton buttonBack;
	
	public Check()
	{
		this.initializeComponents();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String buttonText = event.getActionCommand();
		if(buttonText.equals("Exit"))
		{
			System.exit(0);
		}
		
		
		else if(buttonText.equals("Back"))
		{
			Frame1 f1=new Frame1();
			f1.setVisible(true);
			this.setVisible(false);
		}
	}
	private void initializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		db context = new db();
		Vector<String> columns = new Vector<String>();
		columns.add("Room_no");
		columns.add("Name");
		columns.add("Phone");
		columns.add("Address");
		columns.add("Date From");
		columns.add("To");
		this.tableModel = new DefaultTableModel(context.getuserinformation(), columns);
		
		this.table = new JTable(this.tableModel);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(80);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(130);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(100);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.setBounds(0, 0, 500, 250);
		this.panel.add(this.scrollPane);
		
		
		this.buttonBack = new JButton("Back");
		this.buttonBack.setBounds(530, 220, 90, 20);
		this.buttonBack.addActionListener(this);
		this.panel.add(this.buttonBack);
		
		this.add(this.panel);
		
		this.setTitle("Check Window");
		this.setSize(650, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
