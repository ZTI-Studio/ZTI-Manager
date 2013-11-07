package by.zti.projectmembers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JOptionPane;


public class Utilities extends MembersControle{
	public static void serialiseMembers(){
		try {
			FileOutputStream output_file = new FileOutputStream("members.ser");
			ObjectOutputStream output = new ObjectOutputStream(output_file);
			output.writeObject(members);
			output.close();
		} catch (FileNotFoundException e) {
			int chouse = JOptionPane.showConfirmDialog(null, e.getMessage()+" Ошибка: Не найден сереализуемый файл, создать?");
			if(chouse==0){
				try {
					new File("members.ser").createNewFile();
					members.add(new Member("null", "null", "null", "null", "null", "null", 0));
					serialiseMembers();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e.getMessage()+" Критическая ошибка, невозможно создать файл");
				}
			}
		} catch (IOException e) {
			int chouse = JOptionPane.showConfirmDialog(null, e.getMessage()+" Ошибка: Файл невозможно сереализовать, сбросить его?");
			if(chouse==0){
				members.add(new Member("null", "null", "null", "null", "null", "null", 0));
				serialiseMembers();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static List<Member> deSerialiseMembers(){
		List<Member> deser_members = null;
		try {
			FileInputStream input_file = new FileInputStream("members.ser");
			ObjectInputStream input = new ObjectInputStream(input_file);
			deser_members =  (List<Member>) input.readObject();
			input.close();
		} catch (FileNotFoundException e) {
			int chouse = JOptionPane.showConfirmDialog(null, e.getMessage()+" Ошибка: Не найден десереализуемый файл, создать?");
			if(chouse==0){
				try {
					new File("members.ser").createNewFile();
					members.add(new Member("null", "null", "null", "null", "null", "null", 0));
					serialiseMembers();
					JOptionPane.showMessageDialog(null, "Перезапустите программу");
					System.exit(0);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e.getMessage()+" Критическая ошибка, невозможно создать файл");
				}
			}
		} catch (IOException e) {
			int chouse = JOptionPane.showConfirmDialog(null, e.getMessage()+" Ошибка: Файл невозможно десереализовать, сбросить файл?");
			if(chouse==0){
				members.add(new Member("null", "null", "null", "null", "null", "null", 0));
				serialiseMembers();
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+" Критическая Ошибка: Певрежедены файлы программы");
		}
		return deser_members;
	}
}
