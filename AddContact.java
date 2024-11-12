import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;

class AddContact extends JFrame{
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	
	private JTextField txtName;
	private JTextField txtContactNumber;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	private JButton btnAddContact;	
	private JButton btnCancel;	
	private JButton btnBack;
	
	String id,name,contactNumber,company,birthday;
	double salary;
	
	
	
	AddContact(){
			setSize(600,800);
			setTitle("Add Contact");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			
			JPanel panel=new JPanel(new GridLayout(4,1));
			JPanel panel1=new JPanel(new GridLayout(1,1));
			JPanel panel2=new JPanel(new GridLayout(6,2));
			JPanel panel3=new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel panel4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
			
			
			
			label1=new JLabel("ADD CONTACT");
			label1.setFont(new Font("",1,30));
			label1.setHorizontalAlignment(JLabel.CENTER);
			
			panel1.add("NORTH",label1);
			
			id=Example.con.generateId();
			label2=new JLabel("Contact ID - "+id);
			label2.setFont(new Font("",1,20));
			label2.setHorizontalAlignment(JLabel.CENTER);
			
			label3=new JLabel("Name ");
			label3.setFont(new Font("",1,15));
			label3.setHorizontalAlignment(JLabel.CENTER);
			
			label4=new JLabel("Contact Number ");
			label4.setFont(new Font("",1,15));
			label4.setHorizontalAlignment(JLabel.CENTER);
			
			label5=new JLabel("Company ");
			label5.setFont(new Font("",1,15));
			label5.setHorizontalAlignment(JLabel.CENTER);
			
			label6=new JLabel("Salary ");
			label6.setFont(new Font("",1,15));
			label6.setHorizontalAlignment(JLabel.CENTER);
			
			
			label7=new JLabel("Birthday ");
			label7.setFont(new Font("",1,15));
			label7.setHorizontalAlignment(JLabel.CENTER);
			
			txtName=new JTextField();
			txtName.setHorizontalAlignment(JLabel.CENTER);
			
			txtContactNumber=new JTextField();
			txtContactNumber.setHorizontalAlignment(JLabel.CENTER);
			
			txtCompany=new JTextField();
			txtCompany.setHorizontalAlignment(JLabel.CENTER);
			
			txtSalary=new JTextField();
			txtSalary.setHorizontalAlignment(JLabel.CENTER);
			
			txtBirthday=new JTextField();
			txtBirthday.setHorizontalAlignment(JLabel.CENTER);
			
			
			panel2.add(label2,BorderLayout.CENTER);
			panel2.add(new JLabel(""));
			
			panel2.add(label3,BorderLayout.CENTER);
			panel2.add(txtName,BorderLayout.CENTER);
			
			panel2.add(label4,BorderLayout.CENTER);
			panel2.add(txtContactNumber,BorderLayout.CENTER);
			
			panel2.add(label5,BorderLayout.CENTER);
			panel2.add(txtCompany,BorderLayout.CENTER);
			
			panel2.add(label6,BorderLayout.CENTER);
			panel2.add(txtSalary,BorderLayout.CENTER);
			
			panel2.add(label7,BorderLayout.CENTER);
			panel2.add(txtBirthday,BorderLayout.CENTER);
			
		    btnAddContact=new JButton("Add Contact");
			btnAddContact.setFont(new Font("",1,15));
			btnAddContact.setHorizontalAlignment(JLabel.CENTER);
			
			btnAddContact.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					
					boolean x=validateText();
					
					
					
						if(x==true){
							JOptionPane.showMessageDialog(null,"Some fields are empty","Error",JOptionPane.ERROR_MESSAGE);
						}
						else{
							String name=txtName.getText();
							String contactNumber=txtContactNumber.getText();
							String company=txtCompany.getText();
							double salary=Double.parseDouble(txtSalary.getText());
							String birthday=txtBirthday.getText();
							addContacts(id,name,contactNumber,company,salary,birthday);
				
							
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

			
			
			panel3.add(new JLabel(""));
			panel3.add(new JLabel(""));
			panel3.add(btnAddContact,BorderLayout.CENTER);
			panel3.add(btnCancel,BorderLayout.CENTER);
			
			btnBack=new JButton("Back To HomePge");
			btnBack.setFont(new Font("",1,15));
			btnBack.setHorizontalAlignment(JLabel.CENTER);
			
			btnBack.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					AddContact.this.dispose();
				}
			});

			
			panel4.add(new JLabel(""));
			panel4.add(btnBack,BorderLayout.CENTER);
			
			
			
			
			
			panel.add(panel1,BorderLayout.NORTH);
			panel.add(panel2,BorderLayout.CENTER);
			panel.add(panel3);
			panel.add(panel4);
			
			
			
			
			
			add("North",panel);
			pack();
			
			
	}	
	
	private void clear(){
		txtName.setText("");
		txtContactNumber.setText("");
		txtCompany.setText("");
		txtSalary.setText("");
		txtBirthday.setText("");
		
		id=Example.con.generateId();
		label2.setText("Contact ID - "+id);
		
	}
	private boolean validateText(){
		return txtName.getText().isEmpty() || txtContactNumber.getText().isEmpty() || txtCompany.getText().isEmpty() || txtSalary.getText().isEmpty() || txtBirthday.getText().isEmpty();
		
	}
	 public  void addContacts(String id,String name,String phoneNumber,String companyName,double salary,String birthday){
 
                if(!Example.isValidPhoneNumber(phoneNumber)){
                   System.out.println("\n\tInvalid phone number...");
                   JOptionPane.showMessageDialog(null,"Invalid phone number","Error",JOptionPane.ERROR_MESSAGE);
                 }

               else if(!Example.isValidSalary(salary)){
                    System.out.println("\n\tInvalid salary...");
                   JOptionPane.showMessageDialog(null,"Invalid Salary","Error",JOptionPane.ERROR_MESSAGE);
                }

                else if(!Example.isValidBirthday(birthday)){
                    System.out.println("\n\tInvalid birthday...");
                    JOptionPane.showMessageDialog(null,"Invalid Bithday","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{

					Contact c=new Contact(id,name,phoneNumber,companyName,salary,birthday);
            
					Example.con.add(c);
           
					System.out.println("\n\tContact has been added successfully...");
					 JOptionPane.showMessageDialog(null,"Add Contacts Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
					clear();
            
				}
           
    }
       public static void main(String[] args){
			new AddContact().setVisible(true); 
	} 
	  
}

