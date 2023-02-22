package comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   private static final Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Gerry Rafferty", "Baker Street", 1978)
      };

   @Test
   public void testArtistComparator00()
   {
      Song s1 = new Song("Decemberists", "The Mariner's Revenge Song", 2005);
      Song s2 = new Song("Rogue Wave", "Love's Lost Guarantee", 2005);
      ArtistComparator ac = new ArtistComparator();
      assertTrue(ac.compare(s1, s2) < 0);
   }

   @Test
   public void testArtistComparator01()
   {
      Song s1 = new Song("Gerry Rafferty", "Baker Street", 1998);
      Song s2 = new Song("Gerry Rafferty", "Baker Street", 1978);
      ArtistComparator ac = new ArtistComparator();
      assertEquals(0, ac.compare(s1, s2));
   }

   @Test
   public void testLambdaTitleComparator()
   {
      Comparator<Song> cmpTitle = ((Song s1, Song s2) -> CharSequence.compare(s1.getTitle(), s2.getTitle()));
      Arrays.sort(songs, cmpTitle);
      System.out.print(Arrays.toString(songs));
   }

   @Test
   public void testYearExtractorComparator00()
   {
      Comparator<Song> cmpYear = Comparator.comparing(Song::getYear);
      Arrays.sort(songs, cmpYear);
      System.out.print(Arrays.toString(songs));
   }

   @Test
   public void testYearExtractorComparator01()
   {
      Comparator<Song> cmpTitle = Comparator.comparing(Song::getTitle);
      Arrays.sort(songs, cmpTitle);
      System.out.print(Arrays.toString(songs));
   }

   @Test
   public void testComposedComparator00()
   {
      Comparator<Song> cmpArtist = ((Song s1, Song s2) -> CharSequence.compare(s1.getArtist(), s2.getArtist()));
      Comparator<Song> cmpYear = ((Song s1, Song s2) -> Integer.compare(s1.getYear(), s2.getYear()));

      ComposedComparator cc = new ComposedComparator(cmpArtist, cmpYear);
      Arrays.sort(songs, cc);
      System.out.print(Arrays.toString(songs));
   }

   @Test
   public void testComposedComparator01()
   {
      Comparator<Song> cmpTitle = ((Song s1, Song s2) -> CharSequence.compare(s1.getTitle(), s2.getTitle()));
      Comparator<Song> cmpArtist = ((Song s1, Song s2) -> CharSequence.compare(s1.getArtist(), s2.getArtist()));
      Comparator<Song> cmpYear = ((Song s1, Song s2) -> Integer.compare(s1.getYear(), s2.getYear()));

      ComposedComparator cc = new ComposedComparator(cmpTitle, cmpArtist);
      ComposedComparator cc2 = new ComposedComparator(cc, cmpYear);
      Arrays.sort(songs, cc2);
      System.out.print(Arrays.toString(songs));
   }

   @Test
   public void testThenComparing00()
   {
      Comparator<Song> cmpTitle = ((Song s1, Song s2) -> CharSequence.compare(s1.getTitle(), s2.getTitle()));
      Comparator<Song> cmpArtist = cmpTitle.thenComparing(Song::getArtist);
      Arrays.sort(songs, cmpArtist);
      System.out.print(Arrays.toString(songs));
   }

   @Test
   public void testThenComparing01()
   {
      Comparator<Song> cmpArtist = ((Song s1, Song s2) -> CharSequence.compare(s1.getArtist(), s2.getArtist()));
      Comparator<Song> cmpYear = cmpArtist.thenComparing(Song::getYear);
      Arrays.sort(songs, cmpYear);
      System.out.print(Arrays.toString(songs));
   }

   @Test
   public void runSort()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Gerry Rafferty", "Baker Street", 1978),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005)
         );

      songList.sort(
              Comparator.comparing(Song :: getArtist).thenComparing(Song :: getTitle).thenComparing(Song :: getYear)
      );

      assertEquals(songList, expectedList);
   }
}
