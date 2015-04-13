package androidworkshop.org.week3.activities;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidworkshop.org.week3.R;

/*
 * Probably the most advanced part of this example.
 * This activity illustrates how to start an activity chooser through an implicit
 * intent, handle the results of that intent, and start a specific activity
 * from a different application.
 */
public class TweetActivity extends BaseActivity {

    // The request code for the image picker intent
    private static final int MEDIA_REQUEST_CODE = 1;

    // Of course yo
    private static final int MAX_CHARACTERS = 140;

    private String mBody;
    private Uri    mMediaUri;

    private EditText mEditText;
    private TextView mCharactersLeft;

    private boolean mIsRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolbar.setTitle(R.string.activity_twitter);
        mEditText = (EditText) findViewById(R.id.tweet_edit_text);
        mCharactersLeft = (TextView) findViewById(R.id.characters_left);

        final int originalColor = mCharactersLeft.getCurrentTextColor();

        /*
         * This awesome code makes the character count red when
         * the text length is greater than 140.
         */
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCharactersLeft.setText(String.valueOf(s.length()));
                if(s.length() >= MAX_CHARACTERS && !mIsRed) {
                    mCharactersLeft.setTextColor(Color.RED);
                    mIsRed = true;
                } else if(s.length() < MAX_CHARACTERS && mIsRed) {
                    mCharactersLeft.setTextColor(originalColor);
                    mIsRed = false;
                }

                if(s.length() <= MAX_CHARACTERS) {
                    mBody = s.toString();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_twitter;
    }

    @Override
    protected boolean isRootActivity() {
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Gets the data from the image picker
        if(requestCode == MEDIA_REQUEST_CODE && resultCode == RESULT_OK) {
            mMediaUri = data.getData();
        }
    }

    /*
     * The layout of this activity has a button for attaching media.
     * This method handles that. It does so by starting an implicit intent
     * that can handle image picking, or ACTION_GET_CONTENT with the mime type
     * of "image/*". After getting the image, onActivityResult() handles the data
     */
    public void onAttachMediaButtonClick(View v) {
        Intent mediaIntent = new Intent();
        mediaIntent.setAction(Intent.ACTION_GET_CONTENT);
        mediaIntent.setType("image/*");
        if(mediaIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(mediaIntent, MEDIA_REQUEST_CODE);
        } else {
            Toast.makeText(this, "Unable to find such an activity", Toast.LENGTH_SHORT).show();
        }
    }

    /*
     * Finally, this method sends the tweet data
     * over to the Twitter application. Make sure you have the Twitter app open
     * otherwise this won't work.
     *
     * This method attaches the media (if it was chosen earlier) as well as the body of the text.
     */
    public void onSendTweetButtonClick(View v) {
        Intent tweetIntent = new Intent();
        try {
            tweetIntent.setAction(Intent.ACTION_SEND);
            tweetIntent.setClassName("com.twitter.android", "com.twitter.android.composer.ComposerActivity");
            tweetIntent.putExtra(Intent.EXTRA_TEXT, mBody);
            if(mMediaUri != null) {
                tweetIntent.putExtra(Intent.EXTRA_STREAM, mMediaUri);
                tweetIntent.setType("image/*");
            } else {
                tweetIntent.setType("text/plain");
            }
            startActivity(tweetIntent);
        } catch(Exception e) {
            Toast.makeText(this, "Unable to find Twitter app.", Toast.LENGTH_SHORT).show();
        }
    }
}
