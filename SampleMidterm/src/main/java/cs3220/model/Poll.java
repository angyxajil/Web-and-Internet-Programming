package cs3220.model;

import java.util.ArrayList;
import java.util.List;

public class Poll {

	static int idSeed = 1;
	private int id;

	private String question;
	private List<String> answers;
	private boolean singleChoice;

	public Poll() {
		id = idSeed++;
		answers = new ArrayList<String>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public boolean isSingleChoice() {
		return singleChoice;
	}

	public void setSingleChoice(boolean singleChoice) {
		this.singleChoice = singleChoice;
	}
}
