package net.androidbootcamp.endangeredspeciesgallery;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;


public class ESGMainActivity extends Activity {
    // The images to display
    Integer[] imageIDs = {R.drawable.panda,R.drawable.eagle,R.drawable.elephant,
            R.drawable.gorilla,R.drawable.panther,R.drawable.polar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esgmain);

        Gallery gallery = (Gallery)findViewById(R.id.gallery1);

        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),
                        "pic"+(position+1)+ " selected",
                        Toast.LENGTH_SHORT).show();

                // display image selection
                ImageView imageView = (ImageView)findViewById(R.id.image1);
                imageView.setImageResource(imageIDs[position]);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter
    {
        Context context;
        int itemBackground;

        public ImageAdapter(Context c)
        {
            context = c;
            // Setting the style
            TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
            itemBackground = a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground,0);
            a.recycle();
        }

        //returns number of images
        public int getCount()
        {
            return imageIDs.length;
        }

        // returns the item
        public Object getItem(int position)
        {
            return position;
        }

        // returns the ID of an item
        public long getItemId(int position)
        {
            return position;
        }

        // returns an imageview view
        public View getView(int position,View convertView,ViewGroup parent)
        {
            ImageView imageView;

            if (convertView == null)
            {
                imageView = new ImageView(context);
                imageView.setImageResource(imageIDs[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new Gallery.LayoutParams(250,250));
            }
            else
            {
                imageView = (ImageView)convertView;
            }
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }
}
