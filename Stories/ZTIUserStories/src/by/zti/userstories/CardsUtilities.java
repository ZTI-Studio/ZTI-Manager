package by.zti.userstories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

public class CardsUtilities extends CardsControle{

	public static void serialiseCards(){
		try {
			FileOutputStream output_file = new FileOutputStream("cards.ser");
			ObjectOutputStream output = new ObjectOutputStream(output_file);
			output.writeObject(cards);
			output.close();
		} catch (FileNotFoundException e) {
			int chouse = JOptionPane.showConfirmDialog(null, e.getMessage()+" Ошибка: Не найден сереализуемый файл, создать?");
			if(chouse==0){
				try {
					new File("cards.ser").createNewFile();
					cards.add(new Card(0, "null", "null", false));
					serialiseCards();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e.getMessage()+" Критическая ошибка, невозможно создать файл");
				}
			}
		} catch (IOException e) {
			int chouse = JOptionPane.showConfirmDialog(null, e.getMessage()+" Ошибка: Файл невозможно сереализовать, сбросить его?");
			if(chouse==0){
				cards.add(new Card(0, "null", "null", false));
				serialiseCards();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static List<Card> deSerialiseCards(){
		List<Card> deser_members = null;
		try {
			FileInputStream input_file = new FileInputStream("cards.ser");
			ObjectInputStream input = new ObjectInputStream(input_file);
			deser_members =  (List<Card>) input.readObject();
			input.close();
		} catch (FileNotFoundException e) {
			int chouse = JOptionPane.showConfirmDialog(null, e.getMessage()+" Ошибка: Не найден десереализуемый файл, создать?");
			if(chouse==0){
				try {
					new File("cards.ser").createNewFile();
					cards.add(new Card(0, "null", "null", false));
					serialiseCards();
					JOptionPane.showMessageDialog(null, "Перезапустите программу");
					System.exit(0);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e.getMessage()+" Критическая ошибка, невозможно создать файл");
				}
			}
		} catch (IOException e) {
			int chouse = JOptionPane.showConfirmDialog(null, e.getMessage()+" Ошибка: Файл невозможно десереализовать, сбросить файл?");
			if(chouse==0){
				cards.add(new Card(0, "null", "null", false));
				serialiseCards();
			}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage()+" Критическая Ошибка: Певрежедены файлы программы");
		}
		return deser_members;
	}
}
