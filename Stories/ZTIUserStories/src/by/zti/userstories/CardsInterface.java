package by.zti.userstories;

import javax.swing.DefaultListModel;

public interface CardsInterface {
	public Card getCard(int index);
	public DefaultListModel<Card> getListModel();
	public void addCard(int score, String name, String user_text, boolean is_done);
	public void saveCards();
	public void removeCard(Card card);
	public void removeCard(int index);
}
