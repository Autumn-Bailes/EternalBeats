package codedragon.com.eternalbeats;

public class Music {

    /**
     * Constant value that represents no image was provided for this song
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * String resource Id for the title of the song
     */
    private int mBeatId;
    /**
     * String resource Id for the artist of the song
     */
    private int mArtistId;
    /**
     * Image resource ID for album art of the song
     */
    private int mImageId = NO_IMAGE_PROVIDED;


    /**
     * Create a new Music object.
     *
     * @param beatId   is the string resource Id for the title of the music.
     * @param artistId is the string resource Id for the artist of the music.
     * @param imageId  is the drawable resource Id for the image associated with the music.
     */

    public Music(int beatId, int artistId, int imageId) {
        mBeatId = beatId;
        mArtistId = artistId;
        mImageId = imageId;
    }

    /**
     * Get the string resource Id for the title of the beat.
     */
    public int getBeatId() {
        return mBeatId;
    }

    /**
     * Get the string resource Id for the artist of the beat.
     */
    public int getArtistId() {
        return mArtistId;
    }

    /**
     * Get the image resource Id for the album art of the beat.
     */
    public int getImageId() {
        return mImageId;
    }

    /**
     * Returns whether or not there is an image for this beat.
     */
    public boolean hasImage() {
        return mImageId != NO_IMAGE_PROVIDED;
    }
}
