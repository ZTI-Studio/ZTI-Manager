package by.zti.projectmembers;
import javax.swing.table.TableModel;


public interface MemberInterface {
	public void addMember(String name, String surname, String fathername, String city, String skype, String extra, int age);
	public void removeMember(int member_id);
	public void saveMembers();
	public Member getMember(int index);
	public TableModel getTableModel();
}
