package br.teaching.android;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import br.techs.R;

public class TodoListProgramaticallyActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final EditText text = new EditText(this);
		final ListView list = new ListView(this);
		final Button button = new Button(this);
		// Via codigo também é possivel acessar as Strings que estão em
		// resources, o seguinte é o mesmo que o atributo
		// android:text="@string/hello"
		text.setText(R.string.hello); 
		button.setText("Adicionar");

		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.HORIZONTAL);

		LinearLayout top = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);

		top.addView(text, new LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT));
		top.addView(button, new LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT));

		layout.addView(top, new LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT));
		layout.addView(list, new LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT));

		setContentView(layout);

		final List<String> data = new ArrayList<String>();
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data);

		list.setAdapter(adapter);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						String txt = text.getText().toString();
						data.add(txt);
						adapter.notifyDataSetChanged();
					}
				});
			}
		});
	}
}