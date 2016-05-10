/**
 * Originally taken from Leeds University's geography course,
 * found here in 2016:
 * http://www.geog.leeds.ac.uk/courses/other/programming/practicals/general/web/scraping-intro/Scraper.java
 */

import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*; // Only needed if scraping a local File.
import java.util.ArrayList;

public class Scraper {

    private String URLToScrape;
    private Document URLDocument;

    public Scraper(String URLEntered) {
        URLToScrape = URLEntered;
        URLDocument = this.getDocument();
    }

    public Document getDocument(){
        Document doc = null;
        try {
            doc = Jsoup.connect(this.URLToScrape).get();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return doc;
    }

    public ArrayList<String> getNumbers(){

        ArrayList<String> result = new ArrayList<String>();

        Element table = this.URLDocument.getElementById("datatable");
        Elements rows = table.getElementsByTag("TR");

        for (Element row : rows) {
            Elements tds = row.getElementsByTag("TD");
            for (int i = 0; i < tds.size(); i++) {
                if (i == 1) result.add(tds.get(i).text());
            }
        }

        return result;

    }
}
