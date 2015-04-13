package androidworkshop.org.week3.activities;

import android.os.Bundle;

import androidworkshop.org.week3.R;

/*
 * A simple activity with a TextView in the center.
 * Similar to what we did in week 1
 */
public class HelloActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolbar.setTitle(R.string.activity_hello);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_hello;
    }

    @Override
    protected boolean isRootActivity() {
        return false;
    }
}
