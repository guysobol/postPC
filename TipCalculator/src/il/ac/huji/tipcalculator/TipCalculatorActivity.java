package il.ac.huji.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Color;

public class TipCalculatorActivity extends Activity {

	
	private final double TIP_PERSENTAGE = 0.12;
	private final String DECIMAL_FORMAT = "#.##";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox roundCB = (CheckBox) findViewById(R.id.chkRound);      
        final EditText billAmountET = (EditText)findViewById(R.id.edtBillAmount);
        final Button calc_button = (Button) findViewById(R.id.btnCalculate);
        
        calc_button.setOnClickListener(
        		new View.OnClickListener() {
        			
					@Override
					public void onClick(View v) {
						
							double bill,tip;					        
					        String res;
					        String bill_amount =  billAmountET.getText().toString();
					        boolean round = roundCB.isChecked();
					        TextView result_TV = (TextView) findViewById(R.id.txtTipResult);
					        
					        
					        try{
					        	bill = Double.valueOf(bill_amount);
					        }
					        catch(NumberFormatException e){
					        	bill = -1;
					        }					        					        
					        
					        if(bill < 0){
					        	result_TV.setText(R.string.invalid_input);
					        	result_TV.setTextColor(Color.RED);
					        	return;
					        }					      
					        
					        tip = bill*TIP_PERSENTAGE;
					        
					        if(round){
					        	tip = (tip - Math.floor(tip) <= 0.5) ? Math.floor(tip): Math.ceil(tip);
					        	res = String.valueOf((int)tip);					        						        
					        }
					        else{
					        	DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);
					        	res = df.format(tip);
					        }
					        
					        result_TV.setTextColor(Color.BLACK);
					        result_TV.setText(getString(R.string.result_label) + res);
					}
		});
        
        

    }
    
}
