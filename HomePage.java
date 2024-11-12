import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;

class HomePage extends JFrame{
	private JLabel firstLabel;
	private JLabel secondLabel;
	private JLabel thirdLabel;
	
	private JButton btnAdd;	
	private JButton btnUpdate;	
	private JButton btnSearch;	
	private JButton btnDelete;	
	private JButton btnView;	
	private JButton btnExit;
	
	private AddContact addContact;
	private UpdateContact updateContact;
	private SearchContact searchContact;
	private DeleteContact deleteContact;
	private ContactList contactList;
	
	
	HomePage(){
			setSize(800,500);
			setTitle("Home Page");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			
			JPanel panel=new JPanel(new GridLayout(1,2));
			JPanel panel1=new JPanel(new GridLayout(3,1));
			JPanel panelButton=new JPanel(new GridLayout(7,1));
			
			
			
			firstLabel=new JLabel("iFRIEND ");
			firstLabel.setFont(new Font("",1,30));
			firstLabel.setHorizontalAlignment(JLabel.CENTER);

			
			secondLabel=new JLabel("Contact Manager");
			secondLabel.setFont(new Font("",1,30));
			secondLabel.setHorizontalAlignment(JLabel.CENTER);
			
			panel1.add("NORTH",firstLabel);
			panel1.add(secondLabel,BorderLayout.CENTER);
			
			
			thirdLabel=new JLabel("Home Page");
			thirdLabel.setFont(new Font("",1,30));
			thirdLabel.setHorizontalAlignment(JLabel.CENTER);
			
			
			JPanel panelB1=new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnAdd=new JButton("Add New Contact");
			btnAdd.setFont(new Font("",1,15));
			btnAdd.setHorizontalAlignment(JButton.CENTER);
			btnAdd.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					if(addContact==null){
						addContact=new AddContact();
					}
					addContact.setVisible(true);
					
				}
			});	

			panelB1.add("center",btnAdd);
			
			
			JPanel panelB2=new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnUpdate=new JButton("  Update Contact ");
			btnUpdate.setFont(new Font("",1,15));
			btnUpdate.setHorizontalAlignment(JButton.CENTER);
			btnUpdate.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					if(updateContact==null){
						updateContact=new UpdateContact();
					}
					updateContact.setVisible(true);
					
				}
			});	
			
			panelB2.add("Center",btnUpdate);
			
			JPanel panelB3=new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnSearch=new JButton("  Search Contact ");
			btnSearch.setFont(new Font("",1,15));
			btnSearch.setHorizontalAlignment(JButton.CENTER);
			btnSearch.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					if(searchContact==null){
						searchContact=new SearchContact();
					}
					searchContact.setVisible(true);
					
				}
			});	
			panelB3.add("Center",btnSearch);
			
			JPanel panelB4=new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnDelete=new JButton("  Delete Contact  ");
			btnDelete.setFont(new Font("",1,15));
			btnDelete.setHorizontalAlignment(JButton.CENTER);
			btnDelete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					if(deleteContact==null){
						deleteContact=new DeleteContact();
					}
					deleteContact.setVisible(true);
					
				}
			});	
			panelB4.add("Center",btnDelete);
			
			JPanel panelB5=new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnView=new JButton("     View Contact   ");
			btnView.setFont(new Font("",1,15));
			btnView.setHorizontalAlignment(JButton.CENTER);
			
			btnView.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					if(contactList==null){
						contactList=new ContactList();
					}
					contactList.setVisible(true);
					
				}
			});
			panelB5.add("Center",btnView);
				
			
			JPanel panelB6=new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnExit=new JButton("Exit");
			btnExit.setFont(new Font("",1,15));
			btnExit.setHorizontalAlignment(JButton.RIGHT);
			
			btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					HomePage.this.dispose();
				}
			});
			panelB6.add("Center",btnExit);
			
			
			panelButton.add("NORTH",thirdLabel);
			
			
			panelButton.add(panelB1,BorderLayout.CENTER);
			panelButton.add(panelB2,BorderLayout.CENTER);
			panelButton.add(panelB3,BorderLayout.CENTER);
			panelButton.add(panelB4,BorderLayout.CENTER);
			panelButton.add(panelB5,BorderLayout.CENTER);
			panelButton.add(panelB6,BorderLayout.CENTER);
			
			
			panel.add(panel1,BorderLayout.WEST);
			panel.add(panelButton,BorderLayout.EAST);
			
			add("North",panel);
			pack();
			
			
			
			
	}	
	
}
