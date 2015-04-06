package androidworkshop.org.week3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidworkshop.org.week3.R;

public class CalculateActivity extends ToolbarActivity {

    private TextView mResultView;
    private EditText mOperand1EditText, mOperand2EditText;

    private double mOperand1;
    private double mOperand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        if(intent.hasExtra("operand1") && intent.hasExtra("operand2")) {
            mOperand1 = intent.getDoubleExtra("operand1", 0);
            mOperand2 = intent.getDoubleExtra("operand2", 0);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", mOperand1 + mOperand2);

            setResult(RESULT_OK, resultIntent);
            finish();
        }

        mToolbar.setTitle(R.string.activity_calculate);

        mResultView = (TextView) findViewById(R.id.result);
        mOperand1EditText = (EditText) findViewById(R.id.operand1_edit_text);
        mOperand2EditText = (EditText) findViewById(R.id.operand2_edit_text);

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
