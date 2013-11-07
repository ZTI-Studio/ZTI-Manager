package test;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import by.zti.projectmembers.MembersControle;
import by.zti.projectmembers.MemberInterface;

public class test extends JFrame implements Runnable{
	private JTable table;
	public MemberInterface controler = new MembersControle();
	Object[][] data = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
	};
	Object[] head = {1,2,3};
	
	Object[][] data2 = {
			{11,22,33},
			{44,55,66},
			{77,88,99}
	};
	Object[] head2 = {1,2,3};
	
	public test() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 12, 263, 229);
		getContentPane().add(scrollPane);
		
//		controler.addMember("1", "1", 1);
		table = new JTable(controler.getTableModel());
		scrollPane.setViewportView(table);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new Thread(new test()).start();
	}
	
	@Override
	public void run() {
		while(true){
			table = new JTable(controler.getTableModel());
//			controler.addMember("1", "1", 1);
		}
	}
}
