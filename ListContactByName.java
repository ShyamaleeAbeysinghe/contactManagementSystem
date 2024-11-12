import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;

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

