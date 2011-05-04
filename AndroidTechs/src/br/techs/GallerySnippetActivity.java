package br.techs;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class GallerySnippetActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.gallery_snippet);

		final TextView title = (TextView) findViewById(R.id.title);
		final Gallery gallery = (Gallery) findViewById(R.id.gallery);

		final List<Picture> pics = new ArrayList<Picture>();
		pics.add(new Picture("Pic 1", load(R.drawable.book1)));
		pics.add(new Picture("Pic 2", load(R.drawable.book2)));
		pics.add(new Picture("Pic 3", load(R.drawable.book3)));
		pics.add(new Picture("Pic 4", load(R.drawable.book4)));
		pics.add(new Picture("Pic 5", load(R.drawable.book5)));
		pics.add(new Picture("Pic 6", load(R.drawable.book6)));
		pics.add(new Picture("Pic 7", load(R.drawable.book7)));

		gallery.setAdapter(new ImageAdapter(this, pics));

		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Picture book = pics.get(arg2);
				title.setText(book.title);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

	}

	private Bitmap load(int resourceId) {
		return BitmapFactory.decodeResource(getResources(), resourceId);
	}

	private class ImageAdapter extends BaseAdapter {
		private List<Picture> images;
		private Context context;

		public ImageAdapter(Context context, List<Picture> images) {
			this.images = images;
			this.context = context;
		}

		@Override
		public int getCount() {
			return images.size();
		}

		@Override
		public Object getItem(int position) {
			return images.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView item = null;

			if (convertView != null)
				item = (ImageView) convertView;
			else
				item = new ImageView(context);

			item.setLayoutParams(new LayoutParams(280, 460));
			item.setImageBitmap(((Picture) getItem(position)).getImage());

			return item;
		}
	}

	private class Picture {
		private String title;
		private Bitmap image;

		public Picture(String title, Bitmap image) {
			this.title = title;
			this.image = image;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Bitmap getImage() {
			return image;
		}

		public void setImage(Bitmap image) {
			this.image = image;
		}
	}
}