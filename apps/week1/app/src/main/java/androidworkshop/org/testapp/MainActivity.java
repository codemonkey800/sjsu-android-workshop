package androidworkshop.org.testapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * An activity class that designates the starting point of our
 * application. Notice the MainActivity class extends ActionBarActivity.
 * In the future, we won't be extending ActionBarActivity because
 * ActionBar's are deprecated as of Android 5.0 Lollipop in favor
 * of the new Toolbar class.
 */
public class MainActivity extends ActionBarActivity {

    /**
     * This is the lifecycle method where the activity is first created.
     * Every time you override onCreate(), you must call super.onCreate().
     *
     * To use the activity_main.xml layout, simply refer to
     *
     *     R.layout.activity_main
     *
     * Where R is an automatically generated class holding constants such
     * as XML ids, layouts, etc. We'll go over it in the future.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
