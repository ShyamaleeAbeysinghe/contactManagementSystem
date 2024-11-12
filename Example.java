import java.util.*;
import java.time.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class Node{
		Contact data;
		Node next;
		
		Node(Contact data){
			this.data=data;
		}
		
	}
class ContactRegistry{
	Node start;
	
	
	
	
	private boolean isValidIndex(int index){
		return index>=0 && index<size();
	}
		
	public void add(Contact data){
	 	Node n1=new Node(data);
	 	if(start==null){
			start=n1;
		}
		else{
			Node temp=start;
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=n1;
		}
	}
	public void add(int index,Contact data){
		Node n1=new Node(data);
		if(index>=0 && index<=size()){
			if(index==0){
				n1.next=start;
				start=n1;
			}else{
				int count=0;
				Node temp=start;
				while(count<index-1){
					temp=temp.next;
					count++;
				}
				n1.next=temp.next;
				temp.next=n1;
			}
		}

	}
	public int size(){
		Node temp=start;
		int count=0;
		while(temp!=null){
			temp=temp.next;
			count++;
		}
		return count;
	}
	public Contact get(int index){
		if(isValidIndex(index)){
			Node temp=start;
			int count=0;
			while(count<index){
					count++;
					temp=temp.next;
			}
			return temp.data;
		}
		return null;
	}
	
	public void remove(int index){
		if(index>=0 && index<size()){
			if(index==0){
				start=start.next;
			}else{
				int count=0;
				Node temp=start;
				while(count<index-1){
					temp=temp.next;
					count++;
				}
				temp.next=temp.next.next;
			}
		}

	}
	public int search(String nameOrPhoneNumber){
		Node temp=start;
		int index=-1;
		while(temp!=null){
			index++;
			if(temp.data.getName().equals(nameOrPhoneNumber) || temp.data.getPhoneNumber().equals(nameOrPhoneNumber)){
					return index;
			}
			temp=temp.next;

		}
		return -1;
		
	}
	
   public void replace(int index, Contact before, Contact after){
		Node n1=new Node(before);
		Node n2=new Node(after);
		if(index>=0 && index<=size()){
			if(index==0){
				n2.next=start.next.next;
				n1.next=n2;
				start=n1;
			}else{
				int count=0;
				Node temp=start;
				while(count<index-1){
					temp=temp.next;
					count++;
				}
				n2.next=temp.next.next.next;
				n1.next=n2;
				temp.next=n1;
				
			}
		}
	}
	
	

    public  String generateId(){
		if(size()==0){
			return "C0001";
		}
		Node temp=start;
		String lastId="";
		
		while(temp.next!=null){
				temp=temp.next;
		}
		lastId=temp.data.getId();
		
		int lastNo=Integer.parseInt(lastId.substring(1));
		return String.format("C%04d",lastNo+1);
	}
}
class Contact{
		private String id;
		private String name;
		private String phoneNumber;
		private String companyName;
		private double salary;
		private String birthday;
		
		Contact(){
			
		}
		
		Contact(String i,String n,String p,String c,double s,String b){
			this.id=i;
			this.name=n;
			this.phoneNumber=p;
			this.companyName=c;
			this.salary=s;
			this.birthday=b;
		}
	
	public void setId(String id){
			this.id=id;
	}
	public void setName(String name){
			this.name=name;
	}
	public void setPhoneNumber(String phoneNumber){
			this.phoneNumber=phoneNumber;
	}
	public void setCompanyName(String companyName){
			this.companyName=companyName;
	}
	public void setSalary(double salary){
			this.salary=salary;
	}
	public void setBirthday(String birthday){
			this.birthday=birthday;
	}
	
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	public String getCompanyName(){
		return this.companyName;
	}
	public double getSalary(){
		return this.salary;
	}
	public String getBirthday(){
		return this.birthday;
	}
		
}

class Example{
  
    public static ContactRegistry con=new ContactRegistry();
    
	   
    //-----------------MAIN METHOD--------------------
    public static void main(String[] args){
		new HomePage().setVisible(true);
		
    }
  
    //------------------------VALIDATE PHONENUMBER---------------------------
    public static boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
            for(int i=1; i<phoneNumber.length(); i++){
                if(!Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;

    }
    //-------------------VALIDATE SALARY----------------------
    public static boolean isValidSalary(double salary){
        return salary>0;
    }
    // -------------------BIRTHDAY VALIDATION----------------
	public static boolean isValidBirthday(String birthday){
        String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
			
		if(year%4!=0 & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if(year%4==0 & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;					
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
			}else if(year==currentYear){
									
				if(month<currentMonthValue){
					return true;
				}else if(month==currentMonthValue){
									
					if(day<=currentMonthDate){
						return true;
					}
					
				}
			}
					return false;
    }
 
}

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
			
			
			
			
			label1=new JLabel("ADD CONTACT ");
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
    
}
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

class DeleteContact extends JFrame{
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
	private JButton btnDelete;	
	private JButton btnCancel;
	private JButton btnBackToHomepage;	
	
	DeleteContact(){
		setSize(600,900);
		setTitle("Delete contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panelTop=new JPanel(new GridLayout(2,1));
		JPanel panelBottom=new JPanel(new GridLayout(2,1));
		JPanel panel1=new JPanel(new GridLayout(1,1));
		JPanel panel2=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panel3=new JPanel(new GridLayout(6,2));
		JPanel panel4=new JPanel(new FlowLayout(FlowLayout.CENTER));	
		JPanel panel5=new JPanel(new FlowLayout(FlowLayout.CENTER));	
		
			labUpdate=new JLabel("DELETE CONTACT ");
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
			
			txtId=new JTextField(10);
			txtId.setFont(new Font("",1,25));
			txtId.setEnabled(false);
			
			
			labName=new JLabel("Name ");
			labName.setFont(new Font("",1,25));
			labName.setHorizontalAlignment(JLabel.LEFT);
			
			txtName=new JTextField(10);
			txtName.setFont(new Font("",1,25));
			txtName.setEnabled(false);
			
			
			
			
			labContact=new JLabel("Contact Number");
			labContact.setFont(new Font("",1,25));
			labContact.setHorizontalAlignment(JLabel.LEFT);
			
			txtContact=new JTextField(10);
			txtContact.setFont(new Font("",1,25));
			txtContact.setEnabled(false);
			
			
			
			
			labCompany=new JLabel("Company ");
			labCompany.setFont(new Font("",1,25));
			labCompany.setHorizontalAlignment(JLabel.LEFT);
			
			txtCompany=new JTextField(10);
			txtCompany.setFont(new Font("",1,25));
			txtCompany.setEnabled(false);
			
			
			
			
			labSalary=new JLabel("Salary");
			labSalary.setFont(new Font("",1,25));
			labSalary.setHorizontalAlignment(JLabel.LEFT);
			
			txtSalary=new JTextField(10);
			txtSalary.setFont(new Font("",1,25));
			txtSalary.setEnabled(false);
			
			
			
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
			
			
		    btnDelete=new JButton("Delete");
			btnDelete.setFont(new Font("",1,15));
			btnDelete.setHorizontalAlignment(JLabel.CENTER);
			btnDelete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					delete();
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
			panel4.add(btnDelete,BorderLayout.CENTER);
			panel4.add(btnCancel,BorderLayout.CENTER);
			
			panelBottom.add("Center",panel4);
			
			
			btnBackToHomepage=new JButton("Back To HomePge");
			btnBackToHomepage.setFont(new Font("",1,15));
			btnBackToHomepage.setHorizontalAlignment(JLabel.CENTER);
			
			btnBackToHomepage.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					DeleteContact.this.dispose();
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
	
	private void delete(){
			int x=JOptionPane.showConfirmDialog(null,"Do you want to delete this contact","Are you sure",JOptionPane.YES_NO_OPTION);
			
			if(x==0){
					Example.con.remove(index);
					clear();
			}
	}
	
		
	
}

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
class ListContactByName extends JFrame{
	private JTable tblContactDetail;
	private DefaultTableModel dtm;
	
	private JLabel lblName;
	
	private JButton btnBack;
	private JButton btnReload;
	
	 ListContactByName(){
		setSize(700,500);
		setTitle("View Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lblName=new JLabel("LIST CONTACTS BY NAME");
		lblName.setHorizontalAlignment(JLabel.CENTER);
		lblName.setFont(new Font("",1,30));
		add("North",lblName);
		
		
		
		String[] columName={"Contact Id","Name","Contact Number","Company","Salary","Birthday"};
		dtm=new DefaultTableModel(columName,0);
		
		sortingByName();
		
		tblContactDetail=new JTable(dtm);
		
		JScrollPane tablePane=new JScrollPane(tblContactDetail);
		add("Center",tablePane);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20));
		btnReload.setHorizontalAlignment(JButton.LEFT);
		btnReload.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					sortingByName();
				}
			});
		
		
		btnBack=new JButton("Back To Home");
		btnBack.setFont(new Font("",1,20));
		btnBack.setHorizontalAlignment(JButton.RIGHT);
		
		
		
		btnBack.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					ListContactByName.this.dispose();
				}
			});
		buttonPanel.add(btnReload);
		
		buttonPanel.add(btnBack);
		add("South",buttonPanel);
		
		pack();

	}
	
	 public  void sortingByName(){
		dtm.setRowCount(0);
	    for(int j=0; j<Example.con.size()-1; j++){
				
            for(int i=0; i<Example.con.size()-1; i++){
				
				Contact a1=Example.con.get(i);
				Contact a2=Example.con.get(i+1);
				
                if(a1.getName().compareTo(a2.getName())>0){
					Example.con.replace(i,a2,a1);
                }
            }
        }
		Node tempContact=Example.con.start;
        while(tempContact!=null) {
			Contact c=tempContact.data;
			Object[] rowData={c.getId(),c.getName(),c.getPhoneNumber(),c.getCompanyName(),c.getSalary(),c.getBirthday()};
            dtm.addRow(rowData);
            tempContact=tempContact.next;
        }

    }
}

class ListContactBySalary extends JFrame{
	private JTable tblContactDetail;
	private DefaultTableModel dtm;
	
	private JLabel lblName;
	
	private JButton btnBack;
	private JButton btnReload;
	
	 ListContactBySalary(){
		setSize(700,500);
		setTitle("View Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lblName=new JLabel("LIST CONTACTS BY SALARY");
		lblName.setHorizontalAlignment(JLabel.CENTER);
		lblName.setFont(new Font("",1,30));
		add("North",lblName);
		
		String[] columName={"Contact Id","Name","Contact Number","Company","Salary","Birthday"};
		dtm=new DefaultTableModel(columName,0);
		
		sortingBySalary();
		
		tblContactDetail=new JTable(dtm);
		
		
		JScrollPane tablePane=new JScrollPane(tblContactDetail);
		add("Center",tablePane);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20));
		btnReload.setHorizontalAlignment(JButton.RIGHT);
		
		btnReload.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					sortingBySalary();
				}
			});
		buttonPanel.add(btnReload);
		
		
		btnBack=new JButton("Back To Home");
		btnBack.setFont(new Font("",1,20));
		btnBack.setHorizontalAlignment(JButton.RIGHT);
		
		btnBack.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					ListContactBySalary.this.dispose();
				}
			});
		buttonPanel.add(btnBack);
		add("South",buttonPanel);
		
		pack();

		 
	}
	public  void sortingBySalary(){
       
        dtm.setRowCount(0);
        for(int j=1; j<Example.con.size(); j++){
            for(int i=0; i<Example.con.size()-j; i++){
				
				Contact a1=Example.con.get(i);
				
				Contact a2=Example.con.get(i+1);
				
                if(a1.getSalary()>a2.getSalary()){
					
					
					Example.con.replace(i,a2,a1);
					
                    
                }
            }
        }

       Node tempContact=Example.con.start;
        while(tempContact!=null){
			
            Contact c=tempContact.data;
            Object[] rowData={c.getId(),c.getName(),c.getPhoneNumber(),c.getCompanyName(),c.getSalary(),c.getBirthday()};
			dtm.addRow(rowData);
            tempContact=tempContact.next;
        }

    }
}

class ListContactByBirthday extends JFrame{
	private JTable tblContactDetail;
	private DefaultTableModel dtm;
	
	private JLabel lblName;
	
	private JButton btnBack;
	private JButton btnReload;
	
	 ListContactByBirthday(){
		setSize(700,500);
		setTitle("View Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lblName=new JLabel("LIST CONTACTS BY BIRTHDAY");
		lblName.setHorizontalAlignment(JLabel.CENTER);
		lblName.setFont(new Font("",1,30));
		add("North",lblName);
		
		String[] columName={"Contact Id","Name","Contact Number","Company","Salary","Birthday"};
		dtm=new DefaultTableModel(columName,0);
		
		sortingByBirthday();
		
		tblContactDetail=new JTable(dtm);
		
		JScrollPane tablePane=new JScrollPane(tblContactDetail);
		add("Center",tablePane);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20));
		btnReload.setHorizontalAlignment(JButton.RIGHT);
		
		btnReload.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					sortingByBirthday();
				}
			});
		buttonPanel.add(btnReload);
		
		btnBack=new JButton("Back To Home");
		btnBack.setFont(new Font("",1,20));
		btnBack.setHorizontalAlignment(JButton.RIGHT);
		
		btnBack.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					ListContactByBirthday.this.dispose();
				}
			});
		buttonPanel.add(btnBack);
		add("South",buttonPanel);
		
		pack();

 
	}
	 public  void sortingByBirthday(){
		 
		 dtm.setRowCount(0);
       
        for(int j=1; j<Example.con.size(); j++){
            for(int i=0; i<Example.con.size()-j; i++){
				
				Contact a1=Example.con.get(i);
				
				Contact a2=Example.con.get(i+1);
				
                if(a1.getBirthday().compareTo(a2.getBirthday())>0){
					
					Example.con.replace(i,a2,a1);
					
                    
                }
            }
        }

       Node tempContact=Example.con.start;
        while(tempContact!=null){
			
            Contact c=tempContact.data;
            Object[] rowData={c.getId(),c.getName(),c.getPhoneNumber(),c.getCompanyName(),c.getSalary(),c.getBirthday()};
			dtm.addRow(rowData);
            tempContact=tempContact.next;
        }

    }
}



