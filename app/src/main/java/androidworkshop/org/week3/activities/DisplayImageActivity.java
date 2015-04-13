package androidworkshop.org.week3.activities;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidworkshop.org.week3.R;

/*
 * This activity is used for showing how intent filters work.
 * This activity can't be accessed through the regular app, but it can
 * be accessed from an outside app provided the implicit intent
 * has the ACTION_SEND action.
 */
public class DisplayImageActivity extends BaseActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar.setTitle(R.string.activity_display_image);
        mImageView = (ImageView) findViewById(R.id.image_view);

        // Copies the clipboard data and sets the ImageView's image Uri
        Intent   intent   = getIntent();
        ClipData data     = intent.getClipData();
        Uri      imageUri = data.getItemAt(0).getUri();

        mImageView.setImageURI(imageUri);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_display_image;
    }

    @Override
    protected boolean isRootActivity() {
        return false;
    }
}
