package codedragon.com.eternalbeats;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link codedragon.com.eternalbeats.MusicAdapter} is an {@link ArrayAdapter} that can provide the
 * layout for each list item
 * based on a data source, which is a list of {@link Music} objects.
 */
public class MusicAdapter extends ArrayAdapter<Music> {

    /**
     * Create a new {@link codedragon.com.eternalbeats.MusicAdapter} object.
     *
     * @param context is the current Activity that the adapter is being created in.
     * @param music   is the list of {@link Music} objects to be displayed.
     */
    public MusicAdapter(Context context, ArrayList<Music> music) {
        super( context, 0, music );
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from( getContext() ).inflate(
                    R.layout.music_list_item, parent, false );
        }

        // Get the {@link Music} object located at this position in the list
        Music currentMusic = getItem( position );

        // Find the TextView in the list_item.xml layout with the Id music_title.
        TextView beatTextView = (TextView) listItemView.findViewById( R.id.beat_text_view );
        // Get the beat Id from the currentMusic object and set this text on
        // the beat TextView.
        beatTextView.setText( currentMusic != null ? currentMusic.getBeatId() : 0 );


        // Find the TextView in the list_item.xml layout with the Id artist_name.
        TextView artistTextView = (TextView) listItemView.findViewById( R.id.artist_text_view );
        // Get the artist Id from the current music object and set this text on
        // the artist TextView.
        artistTextView.setText( currentMusic != null ? currentMusic.getArtistId() : 0 );

        // Find the ImageView in the list_item.xml layout with the Id album_art.
        ImageView albumArt = (ImageView) listItemView.findViewById( R.id.album_art );
        // Check if any album art is provided for this music or not.
        if (currentMusic != null && currentMusic.hasImage()) {
            // If album art is available, display the provided image based on the resource Id.
            albumArt.setImageResource( currentMusic.getImageId() );
            // Make sure the view is visible
            albumArt.setVisibility( View.VISIBLE );
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            albumArt.setVisibility( View.GONE );
        }
        // Return the whole list item layout (containing 2 TextViews and 1 ImageView)
        // so that it can be shown in the ListView.
        return listItemView;
    }
}