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
        if (this.inputType.equals("file")){
            File inputFile = new File(this.URLToScrape);
            try {
                doc = Jsoup.parse(inputFile, "UTF-8","");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else if (this.inputType.equals("web")) {
            try {
                doc = Jsoup.connect(this.URLToScrape).get();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            throw new RuntimeException("No idea how to read a ".concat(this.inputType));
        }
        return doc;
    }

    public ArrayList<Element> getMPBiogLinks(){

        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Element> MPLinks = new ArrayList<Element>();

        Element table = this.URLDocument.getElementsByTag("tbody").get(0);
        Elements MPNames = table.getElementsByTag("td");

        for (Element row : MPNames) {
            if (row.id().contains("tdNameCellLeft")){
               MPLinks.add(row.child(0));
            }
        }
        return MPLinks;
    }
}
