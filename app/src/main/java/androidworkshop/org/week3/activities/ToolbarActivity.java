package androidworkshop.org.week3.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import androidworkshop.org.week3.R;

public abstract class ToolbarActivity extends Activity {

    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutID());

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if(mToolbar == null) {
            mToolbar = (Toolbar) View.inflate(this, R.layout.toolbar, null);

            ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
            ViewGroup childLayout = (ViewGroup) decorView.getChildAt(0);

            childLayout.addView(mToolbar, 0);

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mToolbar.getLayoutParams().height
                        = getResources().getDimensionPixelOffset(R.dimen.mobile_toolbar_height);
            }

        }

        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setSubtitleTextColor(Color.WHITE);

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
