import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Josh on 18-May-16.
 */
public class ParliamentScraper extends Scraper {

    private String URLToScrape;

    public static class Builder extends Scraper.Builder {

        private String URLToScrape;

        public Builder(String URL){
            super(URL);
        }

        public ParliamentScraper build(){
            return new ParliamentScraper(this);
        }
    }

    protected ParliamentScraper(Builder builder){
        super(builder);
    }

    public ArrayList<String> getMPBiogLinks(){

        ArrayList<String> MPLinks = new ArrayList<String>();

        Element table = URLDocument.getElementsByTag("tbody").get(0);
        Elements MPNames = table.getElementsByTag("td");

        for (Element row : MPNames) {
            if (row.id().contains("tdNameCellLeft")){
                MPLinks.add(row.child(0).attr("href"));
            }
        }
        return MPLinks;
    }

}
