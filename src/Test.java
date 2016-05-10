/**
 * Created by Josh on 10-May-16.
 */


public class Test {

    public static void main (String args[]) {
        String TestURL = "http://www.geog.leeds.ac.uk/courses/other/programming/practicals/general/web/scraping-intro/table.html";

        Scraper testScraper = new Scraper(TestURL);

        System.out.print(testScraper.getNumbers());
    }

}
