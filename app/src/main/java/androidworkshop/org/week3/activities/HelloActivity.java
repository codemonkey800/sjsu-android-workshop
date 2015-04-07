package androidworkshop.org.week3.activities;

import android.os.Bundle;

import androidworkshop.org.week3.R;

public class HelloActivity extends ToolbarActivity {
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
