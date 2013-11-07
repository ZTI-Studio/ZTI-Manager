package by.zti.userstories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Card implements Serializable{
	private int score;
	private String name;
	private String user_text;
	private boolean is_done;

	public Card(int score, String name, String user_text, boolean is_done) {
		this.score = score;
		this.name = name;
		this.user_text = user_text;
	}

	public int getScore() {
		return score;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getUser_text() {
		return user_text;
	}

	public void setUser_text(String user_text) {
		this.user_text = user_text;
	}
	
	@Override
	public String toString() {
		return String.format("%s               %d", name, score);
	}

	public boolean isIs_done() {
		return is_done;
	}

	public void setIs_done(boolean is_done) {
		this.is_done = is_done;
	}

}
