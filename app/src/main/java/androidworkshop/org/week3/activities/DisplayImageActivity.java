package androidworkshop.org.week3.activities;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidworkshop.org.week3.R;

public class DisplayImageActivity extends ToolbarActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar.setTitle(R.string.activity_display_image);
        mImageView = (ImageView) findViewById(R.id.image_view);

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
