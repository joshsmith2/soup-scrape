/**
 * Created by Josh on 10-May-16.
 */

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ScrapeTests {

    static String testFile = "res/test-source-mps.html";
    static int numberOfMPs = 649;

    @Test
    public void CountMPs(){
        Scraper testScraper = new Scraper(testFile);
        assertEquals(numberOfMPs, testScraper.getMPBiogLinks().size());
    }
}
