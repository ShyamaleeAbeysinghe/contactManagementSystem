import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;

class ContactList extends JFrame{
		private JLabel labelList;
		
		private JButton btnName;
		private JButton btnSalary;
		private JButton btnBirthday;
		private JButton btnCancel;
		
		private ListContactByName listContactByName;
		private ListContactBySalary listContactBysSalary;
		private ListContactByBirthday listContactByBirthday;
		
		
		ContactList(){
			setSize(800,500);
			setTitle("Contact List");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			
			JPanel panel=new JPanel(new GridLayout(2,1));
			JPanel panel1=new JPanel(new GridLayout(1,1));
			JPanel panelButton=new JPanel(new GridLayout(4,1));
			
			labelList=new JLabel("CONTACT LIST");
			labelList.setFont(new Font("",1,35));
			labelList.setHorizontalAlignment(JLabel.CENTER);
			
			panel1.add("NORTH",labelList);
			
			JPanel panelBt1=new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnName=new JButton("                  List By Name                      ");
			btnName.setFont(new Font("",1,20));
			btnName.setHorizontalAlignment(JButton.CENTER);
			
			btnName.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					if(listContactByName==null){
						listContactByName=new ListContactByName();
					}
					listContactByName.setVisible(true);
					
				}
			});	
			
			panelBt1.add("center",btnName);
			
			JPanel panelBt2=new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnSalary=new JButton("                   List By Salary                    ");
			btnSalary.setFont(new Font("",1,20));
			btnSalary.setHorizontalAlignment(JButton.CENTER);
			
			btnSalary.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					if(listContactBysSalary==null){
						listContactBysSalary=new ListContactBySalary();
					}
					listContactBysSalary.setVisible(true);
					
				}
			});	
			
			panelBt2.add("center",btnSalary);
			
			JPanel panelBt3=new JPanel(new FlowLayout(FlowLayout.CENTER));
			btnBirthday=new JButton("                  List By Birthday                 ");
			btnBirthday.setFont(new Font("",1,20)); 
			btnBirthday.setHorizontalAlignment(JButton.CENTER);
			
			btnBirthday.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					if(listContactByBirthday==null){
						listContactByBirthday=new ListContactByBirthday();
					}
					listContactByBirthday.setVisible(true);
					
				}
			});
			panelBt3.add("center",btnBirthday);
			
			
			
			JPanel panelBt4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			btnCancel=new JButton("Cancel");
			btnCancel.setFont(new Font("",1,20));
			btnCancel.setHorizontalAlignment(JButton.CENTER);
			
			
			btnCancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					ContactList.this.dispose();
				}
			});
			panelBt4.add("Esat",btnCancel);
			
			panelButton.add(panelBt1,BorderLayout.CENTER);
			panelButton.add(panelBt2,BorderLayout.CENTER);
			panelButton.add(panelBt3,BorderLayout.CENTER);
			panelButton.add(panelBt4,BorderLayout.CENTER);
			
			
			panel.add(panel1,BorderLayout.NORTH);
			panel.add(panelButton,BorderLayout.SOUTH);
			
			
			
			
			add("North",panel);
			pack();
			
			
			
		}
	
}
