/**
 * Created by Josh on 10-May-16.
 */

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ScrapeTests {

    @Test
    public void smokeTest () {
        String TestURL = "http://www.geog.leeds.ac.uk/courses/other/programming/practicals/general/web/scraping-intro/table.html";

        Scraper testScraper = new Scraper(TestURL);

        ArrayList<String> expectedArray = new ArrayList<String>();
        expectedArray.add("2");
        expectedArray.add("4");

        assertEquals(expectedArray, testScraper.getNumbers());

    }
}
