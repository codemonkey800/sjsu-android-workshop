package androidworkshop.org.week3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidworkshop.org.week3.R;

/*
 * The entry point of the application
 */
public class MainActivity extends BaseActivity {

    /*
     * This request code is used to get the result from a specific intent.
     * It doesn't matter what number we use, as long as its something
     * we can specify for the specific intent.
     */
    private static final int CALCULATE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolbar.setTitle(getString(R.string.app_name));
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isRootActivity() {
        return true;
    }

    /*
     * This method is used for handling results when
     * starting a different activity for results.
     *
     * This method uses the request code defined earlier to handle the specific
     * requests properly.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CALCULATE_REQUEST_CODE) {
            double result = data.getDoubleExtra("result", Double.POSITIVE_INFINITY);
            if(result != Double.POSITIVE_INFINITY) {
                Toast.makeText(this,
                               String.format("10.6 + 69.6 = %f", result),
                               Toast.LENGTH_SHORT).show();
            }
        }
    }

    /*
     * The following methods are alternatives to on click listeners.
     * Instead, we define the methods in the class
     * and then specify them in the XML layout.
     */

    public void onHelloButtonClick(View v) {
        Intent helloIntent = new Intent(this, HelloActivity.class);
        startActivity(helloIntent);
    }

    public void onCalculateButtonClick(View v) {
        Intent calculateIntent = new Intent(this, CalculateActivity.class);
        startActivity(calculateIntent);
    }

    public void onCalculateWithIntentDataButtonClick(View v) {
        Intent calculateIntent = new Intent(this, CalculateActivity.class);
        calculateIntent.putExtra("operand1", 10.6);
        calculateIntent.putExtra("operand2", 69.9);
        startActivityForResult(calculateIntent, CALCULATE_REQUEST_CODE);
    }

    public void onTwitterButtonClick(View v) {
        Intent twitterIntent = new Intent(this, TweetActivity.class);
        startActivity(twitterIntent);
    }
}
