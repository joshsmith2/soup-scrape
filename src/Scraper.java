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
import java.net.URL;
import java.util.ArrayList;

public class Scraper {

    private String URLToScrape;
    private Document URLDocument;
    private String inputType;

    public static class Builder{
        // Required variables
        private String URLToScrape;
        // Optional variables
        private String InputType = "web";

        public Builder(String newURLEntered)
        {
            this.URLToScrape = newURLEntered;
        }

        public Builder setInputType(String type){
            this.InputType = type;
            return this;
        }

        public Scraper build(){
            return new Scraper(this);
        }
    }

    //Set up default arguments
    public Scraper(Builder builder){
        this.URLToScrape = builder.URLToScrape;
        this.inputType = builder.InputType;
        this.URLDocument = this.getDocument();
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

    public ArrayList<String> getMPBiogLinks(){

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
