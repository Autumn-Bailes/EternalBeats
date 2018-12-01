package codedragon.com.eternalbeats;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BeatsActivity extends AppCompatActivity {


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.music_list );
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled( true );


        // Create an array list of music
        final ArrayList<Music> beats = new ArrayList<Music>();

        beats.add( new Music( R.string.beat, R.string.artist, R.drawable.headphones_girl ) );
        beats.add( new Music( R.string.beat, R.string.artist, R.drawable.headphones_girl ) );
        beats.add( new Music( R.string.beat, R.string.artist, R.drawable.headphones_girl ) );
        beats.add( new Music( R.string.beat, R.string.artist, R.drawable.headphones_girl ) );
        beats.add( new Music( R.string.beat, R.string.artist, R.drawable.headphones_girl ) );
        beats.add( new Music( R.string.beat, R.string.artist, R.drawable.headphones_girl ) );
        beats.add( new Music( R.string.beat, R.string.artist, R.drawable.headphones_girl ) );
        beats.add( new Music( R.string.beat, R.string.artist, R.drawable.headphones_girl ) );
        beats.add( new Music( R.string.beat, R.string.artist, R.drawable.headphones_girl ) );
        beats.add( new Music( R.string.beat, R.string.artist, R.drawable.headphones_girl ) );

        // Create an {@link MusicAdapter}, whose data source is a list of {@link Music} objects. The
        // adapter knows how to create list items for each item on the list.
        MusicAdapter adapter = new MusicAdapter( this, beats );

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // music_list.xml layout file.
        ListView listView = (ListView) findViewById( R.id.music_list );

        // Make the {@link ListView} use the {@link MusicAdapter} we created above, so that the
        // {@link ListView} will display the list items for each {@link Music} object in the list.
        listView.setAdapter( adapter );

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                // When the user chooses a song it will trigger an intent to
                // the now playing activity.
                Intent nowPlaying = new Intent( BeatsActivity.this, NowPlayingActivity.class );
                BeatsActivity.this.startActivity( nowPlaying );
            }
        } );
    }
}