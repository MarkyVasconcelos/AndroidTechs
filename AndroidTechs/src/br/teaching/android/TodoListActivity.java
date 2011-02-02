package br.teaching.android;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class TodoListActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);

		final EditText text = (EditText) findViewById(R.id.text);
		Button button = (Button) findViewById(R.id.button);
		final ListView list = (ListView) findViewById(R.id.listView);

		final List<String> data = new ArrayList<String>();
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				data);
		list.setAdapter(adapter);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// O método getText() da classe EditText retorna um Editable, e
				// não uma String ele também implementa CharSequence por costume
				// uso toString só pra retornar uma String normal.
				String txt = text.getText().toString();
				data.add(txt);
				adapter.notifyDataSetChanged();
			}
		});
	}
}