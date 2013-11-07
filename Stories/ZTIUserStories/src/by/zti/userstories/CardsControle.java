package by.zti.userstories;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

public class CardsControle implements CardsInterface{
	protected static List<Card> cards = new ArrayList<Card>();
	public DefaultListModel<Card> list_model = new DefaultListModel<Card>();
	
	public CardsControle(){
		cards = CardsUtilities.deSerialiseCards();
	}
	
	public void updateListModel(){
		list_model.clear();
		for(int i=0;i<cards.size();i++){
			list_model.addElement(cards.get(i));
		}
	}
	
	public DefaultListModel<Card> getListModel(){
		updateListModel();
		return list_model;
	}
	
	public Card getCard(int index){
		return cards.get(index);
	}
	
	public void addCard(int score, String name, String user_text, boolean is_done){
		cards.add(new Card(score, name, user_text, is_done));
		updateListModel();
		saveCards();
	}
	
	public void removeCard(int index){
		cards.remove(index);
		updateListModel();
	}
	
	public void removeCard(Card card){
		cards.remove(card);
		updateListModel();
	}
	
	public void saveCards(){
		CardsUtilities.serialiseCards();
	}
}
