package androidworkshop.org.testapplication.activities;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import androidworkshop.org.testapplication.R;

public abstract class ToolbarActivity extends Activity {

    protected Toolbar                           mToolbar        = null;
    protected android.support.v7.widget.Toolbar mSupportToolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());

        View toolbar = findViewById(R.id.toolbar);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar = (Toolbar) toolbar;
        } else {
            mSupportToolbar = (android.support.v7.widget.Toolbar) toolbar;
        }
    }

    /**
     * Returns the layout ID of the implementing activity
     *
     * @return the layout ID of the implementing activity
     */
    public abstract int getActivityLayout();
}
