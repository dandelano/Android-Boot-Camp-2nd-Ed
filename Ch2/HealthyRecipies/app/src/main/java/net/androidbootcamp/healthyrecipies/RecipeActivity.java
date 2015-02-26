package net.androidbootcamp.healthyrecipies;

import android.app.Activity;
import android.os.Bundle;


/**
 * Created by dannyjdelanojr on 1/20/15.
 */
public class RecipeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);
    }
}
