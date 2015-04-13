package androidworkshop.org.week3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidworkshop.org.week3.R;

/*
 * This is an activity that can calculate
 * addition between two numbers. It can do so through the
 * user interface or through intents.
 */
public class CalculateActivity extends BaseActivity {

    private TextView mResultView;
    private EditText mOperand1EditText, mOperand2EditText;

    private double mOperand1;
    private double mOperand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
         * In this section of code,
         * we first receive the intent from a calling activity.
         * We first inspect the intent and check if has two data,
         * "operand1" and "operand2", and if so, calculate and store
         * the result in a new intent, and then send it back.
         *
         * This example shows how we can take intercept data
         * from a calling activity and handle it accordingly, as well
         * as respond back with more data.
         */
        Intent intent = getIntent();

        if(intent.hasExtra("operand1") && intent.hasExtra("operand2")) {
            mOperand1 = intent.getDoubleExtra("operand1", 0);
            mOperand2 = intent.getDoubleExtra("operand2", 0);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", mOperand1 + mOperand2);

            setResult(RESULT_OK, resultIntent);
            finish();
        }

        super.onCreate(savedInstanceState);

        mToolbar.setTitle(R.string.activity_calculate);

        mResultView = (TextView) findViewById(R.id.result);
        mOperand1EditText = (EditText) findViewById(R.id.operand1_edit_text);
        mOperand2EditText = (EditText) findViewById(R.id.operand2_edit_text);

        /*
         * The following two listeners update
         * the resulting TextView whenever the number inside
         * the EditText changes
         */

        mOperand1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    mOperand1 = Double.parseDouble(s.toString());
                    updateResult();
                } catch(Exception e) {
                    if(s.equals("")) {
                        mOperand1 = 0;
                        updateResult();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mOperand2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    mOperand2 = Double.parseDouble(s.toString());
                    updateResult();
                } catch(Exception e) {
                    if(s.equals("")) {
                        mOperand2 = 0;
                        updateResult();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_calculate;
    }

    @Override
    protected boolean isRootActivity() {
        return false;
    }

    private void updateResult() {
        mResultView.setText(String.valueOf(mOperand1 + mOperand2));
    }
}
