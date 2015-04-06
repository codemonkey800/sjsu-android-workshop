package androidworkshop.org.weektwo.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activity: a single, focused thing that the user can do. Almost all activities interact with the user,
 *  so the Activity class takes care of creating a window for you in which you can place your UI
 * MainActivity: The first view that loads when the app runs.
 * ActionBarActivity: The action bar is a window feature that identifies the user location,
 *  and provides user actions and navigation modes. However, the ActionBar is deprecated and
 *  replaced with Toolbar. We will go over Toolbar in the Material Design lesson.
 */
public class MainActivity extends ActionBarActivity {

    /**
     * Declaration of the widgets
     * It is Android convention to name the variables of widgets preceded with a lowercase m.
     */
    private Button   mButton;
    private EditText mEditText;
    private TextView mTextView;

    /**
     * Initialization of the activity
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle
     *                           contains the data it most recently supplied.
     * setContentView(R.layout.activity_main): Set the activity content from a layout resource, in this case activity_main.
     *                           The resource will be inflated, adding all top-level views to the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Initialization of variables.
         * findViewById(int id): Finds a view that was identified by the id attribute from the XML
         *      Don't forget to cast!
         */
        mButton = (Button) findViewById(R.id.send_button);
        mEditText = (EditText) findViewById(R.id.edit_text);
        mTextView = (TextView) findViewById(R.id.text_view);

        /**
         * Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
         * This will allow us to handle when the button is clicked.
         */
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mEditText.getText()); //set textview's text to user input
                mEditText.setText("");                  //reset editText to display the placeholder value
            }
        });
    }
}
