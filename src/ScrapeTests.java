/**
 * Created by Josh on 10-May-16.
 */

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ScrapeTests {

    static String testFile = "res/test-source-mps.html";
    static int numberOfMPs = 649;

    @Test(expected=IllegalArgumentException.class)
    public void checkNetParserRaisesErrorWithFile(){
        Scraper testScraper = new Scraper.Builder(testFile).build();
    }

    @Test
    public void checkNetParserWorksInFileMode(){
        Scraper testScraper = new Scraper.Builder(testFile).setInputType("file").build();
    }

    @Test
    public void CountMPs(){
        Scraper testScraper = new Scraper.Builder(testFile).setInputType("file").build();
        assertEquals(numberOfMPs, testScraper.getMPBiogLinks().size());
    }
}
