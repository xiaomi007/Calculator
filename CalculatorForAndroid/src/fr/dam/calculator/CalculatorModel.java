package fr.dam.calculator;

import java.util.ArrayList;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class CalculatorModel implements Observable, OnClickListener {

	private ArrayList<Observer> listObserver = new ArrayList<Observer>();

	private String	operation;

	public CalculatorModel() {
		this.operation = "";
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.zero:
			setOperation(getOperation()+v.getResources().getString(R.string.zero));
			updateObserver();
			break;

		case R.id.one:
			setOperation(getOperation()+v.getResources().getString(R.string.one));
			updateObserver();
			break;

		case R.id.two:
			setOperation(getOperation()+v.getResources().getString(R.string.two));
			updateObserver();
			break;

		case R.id.three:
			setOperation(getOperation()+v.getResources().getString(R.string.three));
			updateObserver();
			break;

		case R.id.four:
			setOperation(getOperation()+v.getResources().getString(R.string.four));
			updateObserver();
			break;

		case R.id.five:
			setOperation(getOperation()+v.getResources().getString(R.string.five));
			updateObserver();
			break;

		case R.id.six:
			setOperation(getOperation()+v.getResources().getString(R.string.six));
			updateObserver();
			break;

		case R.id.seven:
			setOperation(getOperation()+v.getResources().getString(R.string.seven));
			updateObserver();
			break;

		case R.id.eight:
			setOperation(getOperation()+v.getResources().getString(R.string.eight));
			updateObserver();
			break;

		case R.id.nine:
			setOperation(getOperation()+v.getResources().getString(R.string.nine));
			updateObserver();
			break;

		case R.id.add:
			setOperation(getOperation()+v.getResources().getString(R.string.add));
			updateObserver();
			break;

		case R.id.minus:
			setOperation(getOperation()+v.getResources().getString(R.string.minus));
			updateObserver();
			break;

		case R.id.multiply:
			setOperation(getOperation()+v.getResources().getString(R.string.multiply));
			updateObserver();
			break;

		case R.id.divide:
			setOperation(getOperation()+v.getResources().getString(R.string.divide));
			updateObserver();
			break;

		case R.id.dot:
			setOperation(getOperation()+v.getResources().getString(R.string.dot));
			updateObserver();
			break;

		case R.id.clear:
			clear();
			updateObserver();
			break;

		case R.id.equal:
			compute();
			updateObserver();
			
			break;
		default:
			break;
		}

	}

	private void compute() {
		String str = getOperation();
		String numbers[] = null;
		String operands[] = null;
		String regForNumber = "[+|\\-|*|/|%|]";// "[+|-|*|/]";
		int index = 0;
		int numbersLength = 0;
		float a = 0;
		float b = 0;
		String add = "+";
		String minus = "-";
		String divide = "/";
		String multiply = "*";
		
		str = str.replace('x', '*');
		Log.d("ope", "str = " + str);
		
		//Extraction of the numbers into a String array numbers[]
		numbers = str.split(regForNumber);
		//To know the number of numbers
		numbersLength = numbers.length;
		
		//Initialize the String array operands, take numbersLength minus one
		operands = new String[numbersLength-1];
		Log.d("ope","operand length " + operands.length);
		for (int i = 0, j = 0; i < numbers.length; i++) {

			index += numbers[i].length();

			if (index < str.length()) {
				operands[j] = String.valueOf(str.charAt(index));
				Log.d("ope", "before " + operands[j]);
				j++;
				index += 1;
			}
		}
		

		for(int i = 0, j = 1; i < numbersLength -1 ; i++, j++ ){
			
			a = Float.valueOf(numbers[i]);
			b = Float.valueOf(numbers[j]);
			
			Log.d("ope", operands[i]);
			if(add.equalsIgnoreCase(operands[i])){
				a = Mathematics.addition(a, b);
				Log.d("ope", "addition");
			}else if (minus.equalsIgnoreCase(operands[i])){
				a = Mathematics.soustraction(a, b);
				Log.d("ope", "minus");
			}else if(multiply.equalsIgnoreCase(operands[i])){
				a = Mathematics.multiplication(a, b);
				Log.d("ope", "multy");
			}else if(divide.equalsIgnoreCase(operands[i])){
				a = Mathematics.division(a, b);
				Log.d("ope", "division");
			}
			
			numbers[j] = String.valueOf(a);
		}
		setOperation("");
		setOperation(String.valueOf(numbers[numbers.length - 1]));
	}

	private void clear() {
		setOperation("");

	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);

	}

	@Override
	public void updateObserver() {
		for (Observer obs : this.listObserver) {
			obs.update(getOperation());
		}

	}

	@Override
	public void deleteObserver(Observer obs) {
		int obsIndex = listObserver.indexOf(obs);
		listObserver.remove(obsIndex);

	}

}
