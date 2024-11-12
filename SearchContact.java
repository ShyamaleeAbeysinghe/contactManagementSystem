import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;

class SearchContact extends JFrame{
	private JLabel labUpdate;
	
	
	private JLabel labId;
	private JLabel labId1;
	
	
	private JLabel labName;
	private JLabel labName1;
	
	private JLabel labContact;
	private JLabel labContact1;
		
	private JLabel labSalary;
	private JLabel labSalary1;
	
	private JLabel labCompany;
	private JLabel labCompany1;
	
	private JLabel labBirthday;
	private JLabel labBirthday1;
	
	private JTextField txt01;
	
	private JButton btnSearch;	
	private JButton btnDelete;	
	private JButton btnCancel;
	private JButton btnBackToHomepage;	
	
	SearchContact(){
		setSize(600,900);
		setTitle("Search Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panelTop=new JPanel(new GridLayout(2,1));
		JPanel panelBottom=new JPanel(new GridLayout(2,1));
		JPanel panel1=new JPanel(new GridLayout(1,1));
		JPanel panel2=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panel3=new JPanel(new GridLayout(6,2));
			
		JPanel panel5=new JPanel(new FlowLayout(FlowLayout.CENTER));	
		
			labUpdate=new JLabel("SEARCH CONTACT ");
			labUpdate.setFont(new Font("",1,30));
			labUpdate.setHorizontalAlignment(JLabel.CENTER);
			
			panel1.add("North",labUpdate);
			
			txt01=new JTextField(30);
			//labUpdate.setHorizontalAlignment(JTextField.CENTER);
			
			btnSearch=new JButton("Search");
			btnSearch.setFont(new Font("",1,25));
			btnSearch.setHorizontalAlignment(JButton.CENTER);
			
			btnSearch.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					search();
				}
			});
			
			panel2.add(txt01,BorderLayout.CENTER);
			panel2.add(btnSearch,BorderLayout.CENTER);
			
			panelTop.add("North",panel1);
			panelTop.add("South",panel2);
			
			add("North",panelTop);
			
			labId=new JLabel("Contact ID ");
			labId.setFont(new Font("",1,25));
			labId.setHorizontalAlignment(JLabel.LEFT);
			
			labId1=new JLabel("");
			labId1.setFont(new Font("",1,25));
			labId1.setHorizontalAlignment(JLabel.LEFT);
			
			
			
			labName=new JLabel("Name ");
			labName.setFont(new Font("",1,25));
			labName.setHorizontalAlignment(JLabel.LEFT);
			
			labName1=new JLabel("");
			labName1.setFont(new Font("",1,25));
			labName1.setHorizontalAlignment(JLabel.LEFT);
			
			
			
			labContact=new JLabel("Contact Number");
			labContact.setFont(new Font("",1,25));
			labContact.setHorizontalAlignment(JLabel.LEFT);
			
			labContact1=new JLabel("");
			labContact1.setFont(new Font("",1,25));
			labContact1.setHorizontalAlignment(JLabel.LEFT);
			
			
			
			labCompany=new JLabel("Company ");
			labCompany.setFont(new Font("",1,25));
			labCompany.setHorizontalAlignment(JLabel.LEFT);
			
			labCompany1=new JLabel("");
			labCompany1.setFont(new Font("",1,25));
			labCompany1.setHorizontalAlignment(JLabel.LEFT);
			
			
			
			labSalary=new JLabel("Salary");
			labSalary.setFont(new Font("",1,25));
			labSalary.setHorizontalAlignment(JLabel.LEFT);
			
			labSalary1=new JLabel("");
			labSalary1.setFont(new Font("",1,25));
			labSalary1.setHorizontalAlignment(JLabel.LEFT);
			
			
			labBirthday=new JLabel("Birthday ");
			labBirthday.setFont(new Font("",1,25));
			labBirthday.setHorizontalAlignment(JLabel.LEFT);
			
			labBirthday1=new JLabel("");
			labBirthday1.setFont(new Font("",1,25));
			labBirthday1.setHorizontalAlignment(JLabel.LEFT);
			
			
			
			panel3.add(labId,BorderLayout.CENTER);
			panel3.add(labId1,BorderLayout.CENTER);
			
			
			panel3.add(labName,BorderLayout.CENTER);
			panel3.add(labName1,BorderLayout.CENTER);
			
			panel3.add(labContact,BorderLayout.CENTER);
			panel3.add(labContact1,BorderLayout.CENTER);
			
			panel3.add(labCompany,BorderLayout.CENTER);
			panel3.add(labCompany1,BorderLayout.CENTER);
			
			panel3.add(labSalary,BorderLayout.CENTER);
			panel3.add(labSalary1,BorderLayout.CENTER);
			
			panel3.add(labBirthday,BorderLayout.CENTER);
			panel3.add(labBirthday1,BorderLayout.CENTER);
			
			add("Center",panel3);
			
			
		    
			
			
			
			btnBackToHomepage=new JButton("Back To HomePge");
			btnBackToHomepage.setFont(new Font("",1,15));
			btnBackToHomepage.setHorizontalAlignment(JLabel.CENTER);
			
			btnBackToHomepage.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					SearchContact.this.dispose();
				}
			});

			
			panel5.add(btnBackToHomepage);
			
			panelBottom.add("Center",panel5);
			
			add("South",panelBottom);
			
			pack();
				
		
	}	
	
	private void search(){
		String phoneNumberOrName=txt01.getText();
		int index=Example.con.search(phoneNumberOrName);
		
		if(index==-1){
			JOptionPane.showMessageDialog(null,"Invalid Name or Phonenumber","Error",JOptionPane.ERROR_MESSAGE);
		}
		else{
			Contact data=Example.con.get(index);
			
			labId1.setText(data.getId());
			labName1.setText(data.getName());
			labContact1.setText(data.getPhoneNumber());
			labCompany1.setText(data.getCompanyName());
			labSalary1.setText(String.valueOf(data.getSalary()));
			labBirthday1.setText(data.getBirthday());
			
			
			
			
			
		}
		
		
		
	}
	
}
