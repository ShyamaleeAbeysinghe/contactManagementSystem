import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;

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

