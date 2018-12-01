package codedragon.com.eternalbeats;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    private ImageView play;
    private ImageView pause;

    private MediaPlayer mediaPlayer;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask( this );
                mediaPlayer.stop();
                mediaPlayer.release();
                finish();
                return true;
        }
        return super.onOptionsItemSelected( item );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_now_playing );


        mediaPlayer = MediaPlayer.create( NowPlayingActivity.this,
                R.raw.marilyn_manson_this_is_halloween );
        mediaPlayer.start();

        play = findViewById( R.id.play );
        play.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    return;
                }
                play.setVisibility( View.GONE );
                pause.setVisibility( View.VISIBLE );
                Toast.makeText( getApplicationContext(), "Now Playing", Toast.LENGTH_SHORT ).show();
                mediaPlayer.start();
            }
        } );


        pause = findViewById( R.id.pause );
        pause.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    return;
                }
                pause.setVisibility( View.GONE );
                play.setVisibility( View.VISIBLE );
                Toast.makeText( getApplicationContext(), "Music Paused", Toast.LENGTH_SHORT ).show();
                mediaPlayer.pause();
            }
        } );

        ImageView skipForward = findViewById( R.id.skip_forward );
        skipForward.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    return;
                }
                int position = mediaPlayer.getCurrentPosition();
                position += 15000;  // 15 seconds
                mediaPlayer.seekTo( position );

                Toast.makeText( getApplicationContext(), "Forward 15 Seconds", Toast.LENGTH_SHORT )
                        .show();
            }
        } );

        ImageView skipReverse = findViewById( R.id.skip_reverse );
        skipReverse.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    return;
                }
                int position = mediaPlayer.getCurrentPosition();
                position -= 15000;  // 15 seconds
                mediaPlayer.seekTo( position );

                Toast.makeText( getApplicationContext(), "Reverse 15 Seconds", Toast
                        .LENGTH_SHORT )
                        .show();
            }
        } );

        ImageView shuffle = findViewById( R.id.shuffle );
        shuffle.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    return;
                }
                Toast.makeText( getApplicationContext(), "Shuffle Beats", Toast.LENGTH_SHORT )
                        .show();
            }
        } );

        ImageView repeat = findViewById( R.id.repeat );
        repeat.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    return;
                }
                Toast.makeText( getApplicationContext(), "Repeat Beat", Toast.LENGTH_SHORT )
                        .show();
            }
        } );

    }
}
