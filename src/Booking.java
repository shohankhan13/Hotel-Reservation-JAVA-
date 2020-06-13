package src;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Booking extends JFrame implements ActionListener {

		private JPanel panel;
		private JButton buttonInsert,buttonUpdate,buttonBack,buttonRoom_status;
		private JLabel labelRoom_no, labelName,labelPhone,labelAddress,labelDate_From,labelDate_to;
		private JTextField textRoom_no, textName,textPhone,textAddress,textDate_From,textDate_to;
		private String stringtxtName="",stringtxtPhone="",stringtxtAddress="",stringtxtDate_From="",stringtxtDate_to="",stringtxtRoom_no="";
		private int inttxtRoom_no;
		private JTable table;
		private JScrollPane scrollPane;
		private DefaultTableModel tableModel;
		
		public Booking()
		{
			this.initializeComponents();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			if(buttonText.equals("Insert"))
			{
				try{
				stringtxtRoom_no=textRoom_no.getText();
				inttxtRoom_no=Integer.parseInt(stringtxtRoom_no);
				stringtxtName=textName.getText();
				stringtxtPhone=textPhone.getText();
				stringtxtAddress=textAddress.getText();
				stringtxtDate_From=textDate_From.getText();
				stringtxtDate_to=textDate_to.getText();
				
				db db=new db();
				db.insertToDB(inttxtRoom_no,stringtxtName,stringtxtPhone,stringtxtAddress,stringtxtDate_From,stringtxtDate_to);
				
				if(stringtxtRoom_no.equals("")){
					if (stringtxtName.equals("") || stringtxtPhone.equals("") ||stringtxtAddress.equals("") ||
							stringtxtDate_From.equals("")|| stringtxtRoom_no.equals(""))
					{
						JOptionPane.showMessageDialog(this, "Invalid text field");
					}
				}
				else if(!stringtxtRoom_no.equals(""))
				{
					if (stringtxtName.equals("") || stringtxtPhone.equals("") ||stringtxtAddress.equals("") ||
							stringtxtDate_From.equals("")|| stringtxtRoom_no.equals(""))
					{
						JOptionPane.showMessageDialog(this, "Fill up all the values");
					}
					else
					{
					JOptionPane.showMessageDialog(this, "Room Added");
					}
				}

				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "Invalid text field");
					
				}
				
			}
			else if (buttonText.equals("Add")) 
				{
				try{
				stringtxtRoom_no=textRoom_no.getText();
				inttxtRoom_no=Integer.parseInt(stringtxtRoom_no);
				stringtxtName=textName.getText();
				stringtxtPhone=textPhone.getText();
				stringtxtAddress=textAddress.getText();
				stringtxtDate_From=textDate_From.getText();
				stringtxtDate_to=textDate_to.getText();
				
					db db=new db();
					db.updateDB(inttxtRoom_no,stringtxtName,stringtxtPhone,stringtxtAddress,stringtxtDate_From,stringtxtDate_to);
					System.out.println(inttxtRoom_no);
					
					JOptionPane.showMessageDialog(this, "Added");
				}
				catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "Invalid text field");
				}
				}
			else if (buttonText.equals("Room Status"))
			{
				db db = new db();
				Vector<String> columns = new Vector<String>();
				columns.add("Room_no");
				columns.add("Name");
				
				this.tableModel = new DefaultTableModel(db.getuserinformation(), columns);
				
				this.table = new JTable(this.tableModel);
				this.table.getColumnModel().getColumn(0).setPreferredWidth(100);
				this.table.getColumnModel().getColumn(1).setPreferredWidth(100);
				this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				
				this.scrollPane = new JScrollPane(this.table);
				this.scrollPane.setBounds(500, 50, 200, 150);
				this.panel.add(this.scrollPane);
				
				
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
			
			
			this.labelRoom_no = new JLabel("Room No.");
			this.labelRoom_no.setBounds(20, 20, 80, 20);
			this.panel.add(this.labelRoom_no);
			
			
			this.textRoom_no = new JTextField();
			this.textRoom_no.setBounds(110, 20, 120, 20);
			this.panel.add(this.textRoom_no);
			
			this.labelName = new JLabel("NAME");
			this.labelName.setBounds(20, 50, 80, 20);
			this.panel.add(this.labelName);
			
			
			this.textName = new JTextField();
			this.textName.setBounds(110, 50, 120, 20);
			this.panel.add(this.textName);
			
			
			this.labelPhone = new JLabel("Phone No.");
			this.labelPhone.setBounds(20, 80, 80, 20);
			this.panel.add(this.labelPhone);
			
			
			this.textPhone = new JTextField();
			this.textPhone.setBounds(110, 80, 120, 20);
			this.panel.add(this.textPhone);
			
			this.labelAddress = new JLabel("Address");
			this.labelAddress.setBounds(20, 110, 80, 20);
			this.panel.add(this.labelAddress);
			
			
			this.textAddress = new JTextField();
			this.textAddress.setBounds(110, 110, 120, 20);
			this.panel.add(this.textAddress);
			
			this.labelDate_From = new JLabel("Date From");
			this.labelDate_From.setBounds(20, 140, 80, 20);
			this.panel.add(this.labelDate_From);
			
			
			this.textDate_From = new JTextField();
			this.textDate_From.setBounds(110, 140, 120, 20);
			this.panel.add(this.textDate_From);
			
			this.labelDate_to = new JLabel("To");
			this.labelDate_to.setBounds(300, 140, 80, 20);
			this.panel.add(this.labelDate_to);
			
			
			this.textDate_to = new JTextField();
			this.textDate_to.setBounds(330, 140, 120, 20);
			this.panel.add(this.textDate_to);
						
			this.buttonInsert = new JButton("Insert");
			this.buttonInsert.setBounds(300, 350, 90, 30);
			this.buttonInsert.addActionListener(this);
			this.panel.add(this.buttonInsert);
			
			this.buttonUpdate = new JButton("Add");
			this.buttonUpdate.setBounds(450, 350, 90, 30);
			this.buttonUpdate.addActionListener(this);
			this.panel.add(this.buttonUpdate);
			
			this.buttonRoom_status = new JButton("Room Status");
			this.buttonRoom_status.setBounds(120, 350, 120, 30);
			this.buttonRoom_status.addActionListener(this);
			this.panel.add(this.buttonRoom_status);
			
			
			
			this.buttonBack = new JButton("Back");
			this.buttonBack.setBounds(600, 350, 90, 30);
			this.buttonBack.addActionListener(this);
			this.panel.add(this.buttonBack);
			
			this.add(this.panel);
			
			this.setTitle("Booking Window");
			this.setSize(750, 450);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}

