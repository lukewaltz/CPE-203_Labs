package comparator;

import java.util.Comparator;

public class ArtistComparator implements Comparator<Song> {

    @Override
    public int compare(Song s1, Song s2) {
        String a1 = s1.getArtist();
        String a2 = s2.getArtist();
        return (a1.compareTo(a2));
    }

}