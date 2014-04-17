package fr.dam.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CalculatorActivity extends Activity{

	RelativeLayout 	rLayout 	= null;
	
	CalculatorModel calculatorModel 	= null;

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

	TextView	displayResult = null;

	String	operation	= null;
//	String	first		= null;
//	String	second		= null;
//	int		digit		= 0;
//	String numbers[] 	= null;
//	String operand[]	= null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		rLayout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.activity_calculator, null);
		setContentView(rLayout);

		calculatorModel = new CalculatorModel();
		

//		first = "";
//		second = "";
		

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
		zero.setOnClickListener(calculatorModel);
		one.setOnClickListener(calculatorModel);
		two.setOnClickListener(calculatorModel);
		three.setOnClickListener(calculatorModel);
		four.setOnClickListener(calculatorModel);
		five.setOnClickListener(calculatorModel);
		six.setOnClickListener(calculatorModel);
		seven.setOnClickListener(calculatorModel);
		eight.setOnClickListener(calculatorModel);
		nine.setOnClickListener(calculatorModel);
		equal.setOnClickListener(calculatorModel);
		add.setOnClickListener(calculatorModel);
		minus.setOnClickListener(calculatorModel);
		multiply.setOnClickListener(calculatorModel);
		divide.setOnClickListener(calculatorModel);
		clear.setOnClickListener(calculatorModel);
		dot.setOnClickListener(calculatorModel);
		
		this.calculatorModel.addObserver(new Observer() {
			
			@Override
			public void update(String operation) {
				displayResult.setText(operation);
				
			}
		});
	}

};



//	private OnClickListener numberListener = new OnClickListener() {
//
//       @Override
//       public void onClick(View v) {
//           switch (v.getId()) {
//		   case R.id.zero:
//			   // displayResult.setText(R.string.zero);
//			   operation += "0";
//			   break;
//
//		   case R.id.one:
//			   // displayResult.setText(R.string.one);
//			   operation += "1";
//			   break;
//
//		   case R.id.two:
//			   // displayResult.setText(R.string.two);
//			   operation += "2";
//			   break;
//
//		   case R.id.three:
//			   // displayResult.setText(R.string.three);
//			   operation += "3";
//			   break;
//
//		   case R.id.four:
//			   // displayResult.setText(R.string.four);
//			   operation += "4";
//			   break;
//
//		   case R.id.five:
//			   // displayResult.setText(R.string.five);
//			   operation += "5";
//			   break;
//
//		   case R.id.six:
//			   // displayResult.setText(R.string.six);
//			   operation += "6";
//			   break;
//
//		   case R.id.seven:
//			   // displayResult.setText(R.string.seven);
//			   operation += "7";
//			   break;
//
//		   case R.id.eight:
//			   // displayResult.setText(R.string.eight);
//			   operation += "8";
//			   break;
//
//		   case R.id.nine:
//			   // displayResult.setText(R.string.nine);
//			   operation += "9";
//			   break;
//
//		   case R.id.add:
//			  
//			   operation += "+";
//			   break;
//
//			   
//			   
//		   case R.id.equal:
//			   equality(operation);
//			   operation += "=";
//			   break;
//		   default:
//			   displayResult.setText("error");
//			   
//			   break;
//		   }
//           		if(!(operation.indexOf("=") >0))
//        	   displayResult.setText(operation);
//       }
//
//	};
//	
//       
//	private void equality(String operation) {
//        String first = null;
//        String second = null;
//        String addi = "+";
//        float resultat = 0;
//         
//        first = operation.substring(0, operation.indexOf(addi));	 
//        second = operation.substring(operation.indexOf(addi)+1);
//        resultat = Float.valueOf(first) + Float.valueOf(second);
//        displayResult.setText("");
//        displayResult.setText(String.valueOf(resultat));
//	}
//};
