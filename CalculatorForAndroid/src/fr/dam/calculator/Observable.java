package fr.dam.calculator;

public interface Observable {
	public void updateObserver();
	public void addObserver(Observer obs);
	public void deleteObserver(Observer obs); 
}
