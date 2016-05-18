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

    @Test(expected=RuntimeException.class)
    public void checkNetParserFailsWithUnknownFileMode(){
        Scraper testScraper = new Scraper.Builder(testFile).setInputType("crontug").build();
    }

    @Test
    public void CountMPsAndCheckFirstLink(){
        Scraper testScraper = new Scraper.Builder(testFile).setInputType("file").build();
        ArrayList<String> MPLinks = testScraper.getMPBiogLinks();

        assertEquals(numberOfMPs, MPLinks.size());
        assertEquals(MPLinks.get(0), "http://www.parliament.uk/biographies/commons/ms-diane-abbott/172");
    }
}
