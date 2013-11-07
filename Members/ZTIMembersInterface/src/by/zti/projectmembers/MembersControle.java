package by.zti.projectmembers;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RepaintManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class MembersControle implements MemberInterface{
	protected static List<Member> members = new ArrayList<Member>();
	private TableModel members_table_model = new MembersTableModel();
	
	public MembersControle(){
		members = Utilities.deSerialiseMembers();
	}

	@Override
	public void addMember(String name, String surname, String fathername, String city, String skype, String extra, int age) {
		members.add(new Member(name, surname, fathername, city, skype, extra, age));
		saveMembers();
	}

	@Override
	public void removeMember(int member_id) {
		members.remove(member_id);
		saveMembers();
	}
	
	class MembersTableModel extends AbstractTableModel{

		@Override
		public String getColumnName(int column) {
			Object return_object = null;
			switch(column){
				case 0:
					return_object = "Имя";
					break;
				case 1:
					return_object = "Фамилия";
					break;
				case 2:
					return_object = "Отчество";
					break;
				case 3:
					return_object = "Город";
					break;
				case 4:
					return_object = "Skype";
					break;
				case 5:
					return_object = "Дополнительно";
					break;
				case 6:
					return_object = "Возраст";
					break;
			}
			return (String) return_object;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			switch(columnIndex){
				case 0:
					members.get(rowIndex).setName((String)aValue);
					fireTableCellUpdated(rowIndex, columnIndex);
					break;
				case 1:
					members.get(rowIndex).setSurname((String)aValue);
					fireTableCellUpdated(rowIndex, columnIndex);
					break;
				case 2:
					members.get(rowIndex).setFathername((String)aValue);
					fireTableCellUpdated(rowIndex, columnIndex);
					break;
				case 3:
					members.get(rowIndex).setCity((String)aValue);
					fireTableCellUpdated(rowIndex, columnIndex);
					break;
				case 4:
					members.get(rowIndex).setSkype((String)aValue);
					fireTableCellUpdated(rowIndex, columnIndex);
					break;
				case 5:
					members.get(rowIndex).setExtra((String)aValue);
					fireTableCellUpdated(rowIndex, columnIndex);
					break;
				case 6:
					members.get(rowIndex).setAge((int)aValue);
					fireTableCellUpdated(rowIndex, columnIndex);
					break;
			}
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return members.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 7;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Object return_object = null;
			switch(columnIndex){
				case 0:
					return_object = members.get(rowIndex).getName();
					break;
				case 1:
					return_object = members.get(rowIndex).getSurname();
					break;
				case 2:
					return_object = members.get(rowIndex).getFathername();
					break;
				case 3:
					return_object = members.get(rowIndex).getCity();
					break;
				case 4:
					return_object = members.get(rowIndex).getSkype();
					break;
				case 5:
					return_object = members.get(rowIndex).getExtra();
					break;
				case 6:
					return_object = members.get(rowIndex).getAge();
					break;
			}
			return return_object;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			// TODO Auto-generated method stub
			return String.class.getClass();
		}
		
		public void fireDataChange(){
			fireDataChange();
		}
	}

	@Override
	
	public void saveMembers() {
		Utilities.serialiseMembers();
	}

	@Override
	public TableModel getTableModel() {
		return members_table_model;
	}

	@Override
	public Member getMember(int index) {
		return members.get(index);
	}
}
