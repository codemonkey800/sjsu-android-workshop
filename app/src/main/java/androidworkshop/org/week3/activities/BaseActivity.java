package androidworkshop.org.week3.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidworkshop.org.week3.R;

/**
 * It's good convention to have a "base" activity to
 * do common actions for an activity.
 */
public abstract class BaseActivity extends Activity {

    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutID());

        /*
         * This section of code
         * gets the toolbar of the current activity.
         *
         * If it doesn't exist, then a toolbar is appended to the top
         * of the view hierarchy.
         */
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if(mToolbar == null) {
            mToolbar = (Toolbar) View.inflate(this, R.layout.toolbar, null);

            ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
            ViewGroup childLayout = (ViewGroup) decorView.getChildAt(0);

            childLayout.addView(mToolbar, 0);

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mToolbar.getLayoutParams().height = getResources().getDimensionPixelOffset(R.dimen.mobile_toolbar_height);
            }

        }

        /*
         * Sets the toolbar color to white.
         * This assumes we use a theme where white would look nice
         */
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setSubtitleTextColor(Color.WHITE);

        /*
         * If the current activity isn't a root activity, then
         * we'll display a back arrow
         */
        if(!isRootActivity()) {
            mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    protected abstract int getContentViewLayoutID();

    protected abstract boolean isRootActivity();
}
