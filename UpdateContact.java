import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;

class UpdateContact extends JFrame{
	int index=-1;
	private JLabel labUpdate;
	
	
	private JLabel labId;
	private JTextField txtId;
	
	
	private JLabel labName;
	private JTextField txtName;
	
	private JLabel labContact;
	private JTextField txtContact;
		
	private JLabel labSalary;
	private JTextField txtSalary;
	
	private JLabel labCompany;
	private JTextField txtCompany;
	
	private JLabel labBirthday;
	private JTextField txtBirthday;
	
	private JTextField txt01;
	
	private JButton btnSearch;	
	private JButton btnUpdate;	
	private JButton btnCancel;
	private JButton btnBackToHomepage;	
	
	UpdateContact(){
		setSize(600,900);
		setTitle("Update Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panelTop=new JPanel(new GridLayout(2,1));
		JPanel panelBottom=new JPanel(new GridLayout(2,1));
		JPanel panel1=new JPanel(new GridLayout(1,1));
		JPanel panel2=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panel3=new JPanel(new GridLayout(6,2));
		JPanel panel4=new JPanel(new FlowLayout(FlowLayout.CENTER));	
		JPanel panel5=new JPanel(new FlowLayout(FlowLayout.CENTER));	
		
			labUpdate=new JLabel("UPDATE CONTACT ");
			labUpdate.setFont(new Font("",1,30));
			labUpdate.setHorizontalAlignment(JLabel.CENTER);
			
			panel1.add("North",labUpdate);
			
			txt01=new JTextField(30);
			
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
			
			txtId=new JTextField(10);
			txtId.setFont(new Font("",1,25));
			txtId.setEnabled(false);
			
			
			
			labName=new JLabel("Name ");
			labName.setFont(new Font("",1,25));
			labName.setHorizontalAlignment(JLabel.LEFT);
			
			txtName=new JTextField(10);
			txtName.setFont(new Font("",1,25));
			
			
			
			
			labContact=new JLabel("Contact Number");
			labContact.setFont(new Font("",1,25));
			labContact.setHorizontalAlignment(JLabel.LEFT);
			
			txtContact=new JTextField(10);
			txtContact.setFont(new Font("",1,25));
			
			
			
			
			labCompany=new JLabel("Company ");
			labCompany.setFont(new Font("",1,25));
			labCompany.setHorizontalAlignment(JLabel.LEFT);
			
			txtCompany=new JTextField(10);
			txtCompany.setFont(new Font("",1,25));
			
			
			
			
			labSalary=new JLabel("Salary");
			labSalary.setFont(new Font("",1,25));
			labSalary.setHorizontalAlignment(JLabel.LEFT);
			
			txtSalary=new JTextField(10);
			txtSalary.setFont(new Font("",1,25));
			
			
			
			labBirthday=new JLabel("Birthday ");
			labBirthday.setFont(new Font("",1,25));
			labBirthday.setHorizontalAlignment(JLabel.LEFT);
			
			txtBirthday=new JTextField(10);
			txtBirthday.setFont(new Font("",1,25));
			txtBirthday.setEnabled(false);
			
			
			
			
			panel3.add(labId,BorderLayout.CENTER);
			panel3.add(txtId,BorderLayout.CENTER);
			
			
			panel3.add(labName,BorderLayout.CENTER);
			panel3.add(txtName,BorderLayout.CENTER);
			
			panel3.add(labContact,BorderLayout.CENTER);
			panel3.add(txtContact,BorderLayout.CENTER);
			
			panel3.add(labCompany,BorderLayout.CENTER);
			panel3.add(txtCompany,BorderLayout.CENTER);
			
			panel3.add(labSalary,BorderLayout.CENTER);
			panel3.add(txtSalary,BorderLayout.CENTER);
			
			panel3.add(labBirthday,BorderLayout.CENTER);
			panel3.add(txtBirthday,BorderLayout.CENTER);
			
			add("Center",panel3);
			
			
		    btnUpdate=new JButton("Update");
			btnUpdate.setFont(new Font("",1,15));
			btnUpdate.setHorizontalAlignment(JLabel.CENTER);
			
			btnUpdate.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					boolean y=validateText();
					
					if(y==true){
						JOptionPane.showMessageDialog(null,"Some fields are empty","Error",JOptionPane.ERROR_MESSAGE);
					}
					else{
						String name=txtName.getText();
						String contactNumber=txtContact.getText();
						String company=txtCompany.getText();
						double salary=Double.parseDouble(txtSalary.getText());
						
						update(name,contactNumber,company,salary);
						
					}
				}
				
			});
			
			btnCancel=new JButton("Cancel");
			btnCancel.setFont(new Font("",1,15));
			btnCancel.setHorizontalAlignment(JLabel.CENTER);
			
			btnCancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					clear();
				}
			});
			
			panel4.add(new JLabel(""));
			panel4.add(new JLabel(""));
			panel4.add(btnUpdate,BorderLayout.CENTER);
			panel4.add(btnCancel,BorderLayout.CENTER);
			
			panelBottom.add("Center",panel4);
			
			
			btnBackToHomepage=new JButton("Back To HomePge");
			btnBackToHomepage.setFont(new Font("",1,15));
			btnBackToHomepage.setHorizontalAlignment(JLabel.CENTER);
			
			btnBackToHomepage.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					UpdateContact.this.dispose();
				}
			});
			
			panel5.add(btnBackToHomepage);
			
			panelBottom.add("Center",panel5);
			
			add("South",panelBottom);
			
			pack();
			
	
	}
	private void clear(){
			txtId.setText("");
			txtName.setText("");
			txtContact.setText("");
			txtCompany.setText("");
			txtSalary.setText("");
			txtBirthday.setText("");
	}
	
	private void search(){
		String nameOrPhoneNumber=txt01.getText();
		 index=Example.con.search(nameOrPhoneNumber);
		
		if(index==-1){
			JOptionPane.showMessageDialog(null,"Invalid Name or Phonenumber","Error",JOptionPane.ERROR_MESSAGE);
		}else{
			Contact data=Example.con.get(index);
			
			txtId.setText(data.getId());
			txtName.setText(data.getName());
			txtContact.setText(data.getPhoneNumber());
			txtCompany.setText(data.getCompanyName());
			txtSalary.setText(String.valueOf(data.getSalary()));
			txtBirthday.setText(data.getBirthday());
		}
		
		
	}
	private boolean validateText(){
		return txtName.getText().isEmpty() || txtContact.getText().isEmpty() || txtCompany.getText().isEmpty() || txtSalary.getText().isEmpty() || txtBirthday.getText().isEmpty();
		
	}
	
	private void update(String name,String phoneNumber,String companyName,double salary){
		
		if(!Example.isValidPhoneNumber(phoneNumber)){
                   System.out.println("\n\tInvalid phone number...");
                   JOptionPane.showMessageDialog(null,"Invalid phone number","Error",JOptionPane.ERROR_MESSAGE);
        }

        else if(!Example.isValidSalary(salary)){
                    System.out.println("\n\tInvalid salary...");
                   JOptionPane.showMessageDialog(null,"Invalid Salary","Error",JOptionPane.ERROR_MESSAGE);
        }

        
        else{
				Contact data=Example.con.get(index);
		
				data.setName(name);
				data.setPhoneNumber(phoneNumber);
				data.setCompanyName(companyName);
				data.setSalary(salary);
				
				clear();
	   }
	}
	
	
}


