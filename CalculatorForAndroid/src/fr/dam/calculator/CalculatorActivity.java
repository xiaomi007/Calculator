package fr.dam.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CalculatorActivity extends Activity{

	//invoke object null to optimize the memory allocation.
	RelativeLayout 	rLayout 	= null; //Optimization of XML inflate
	CalculatorModel calculatorModel 	= null; //Model for the calculator
	TextView	displayResult = null; //Text which appears on the screen
	String	operation	= null;//Intern String to know the operation
	
	//Creation of the calculator's buttons
	Button	zero	= null;
	Button	one		= null;
	Button	two		= null;
	Button	three	= null;
	Button	four	= null;
	Button	five	= null;
	Button	six		= null;
	Button	seven	= null;
	Button	eight	= null;
	Button	nine	= null;
	
	Button	clear	= null;
	Button	dot		= null;
	Button	equal	= null;
	Button	add		= null;
	Button	minus	= null;
	Button	multiply= null;
	Button	divide	= null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		rLayout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_calculator, null);
		setContentView(rLayout);

		calculatorModel = new CalculatorModel();

		zero 	= (Button) findViewById(R.id.zero);
		one 	= (Button) findViewById(R.id.one);
		two 	= (Button) findViewById(R.id.two);
		three 	= (Button) findViewById(R.id.three);
		four 	= (Button) findViewById(R.id.four);
		five 	= (Button) findViewById(R.id.five);
		six 	= (Button) findViewById(R.id.six);
		seven 	= (Button) findViewById(R.id.seven);
		eight 	= (Button) findViewById(R.id.eight);
		nine 	= (Button) findViewById(R.id.nine);
		
		clear 	= (Button) findViewById(R.id.clear);
		dot 	= (Button) findViewById(R.id.dot);
		equal 	= (Button) findViewById(R.id.equal);
		add 	= (Button) findViewById(R.id.add);
		minus 	= (Button) findViewById(R.id.minus);
		multiply= (Button) findViewById(R.id.multiply);
		divide 	= (Button) findViewById(R.id.divide);
 
		displayResult = (TextView) findViewById(R.id.displayResult);
	
		// Listeners
		zero.setOnClickListener(	calculatorModel);
		one.setOnClickListener(		calculatorModel);
		two.setOnClickListener(		calculatorModel);
		three.setOnClickListener(	calculatorModel);
		four.setOnClickListener(	calculatorModel);
		five.setOnClickListener(	calculatorModel);
		six.setOnClickListener(		calculatorModel);
		seven.setOnClickListener(	calculatorModel);
		eight.setOnClickListener(	calculatorModel);
		nine.setOnClickListener(	calculatorModel);
		
		clear.setOnClickListener(	calculatorModel);
		dot.setOnClickListener(		calculatorModel);
		equal.setOnClickListener(	calculatorModel);
		add.setOnClickListener(		calculatorModel);
		minus.setOnClickListener(	calculatorModel);
		multiply.setOnClickListener(calculatorModel);
		divide.setOnClickListener(	calculatorModel);
		
		
		this.calculatorModel.addObserver(new Observer() {
			
			@Override
			public void update(String operation) {
				displayResult.setText(operation);
				
			}
		});
	}

};