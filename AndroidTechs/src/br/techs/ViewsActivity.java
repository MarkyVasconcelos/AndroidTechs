package br.techs;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ViewsActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.views);
		
		RadioButton b1 = (RadioButton) findViewById(R.id.r1button);
		RadioButton b2 = (RadioButton) findViewById(R.id.r2button);
		
		RadioGroup group = new RadioGroup(this);
//		group.addV
	}
}
