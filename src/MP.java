/**
 * Created by Josh on 18-May-16.
 */

public class MP {

    final String name;
    final String constituency;
    final String screenName;

    public static class Builder{
        private String name;
        private String constituency;
        private String screenName = "";

        public Builder(String newName, String newConstituency){
            this.name = newName;
            this.constituency = newConstituency;
        }

        public Builder setScreenName(String newScreenName){
            this.screenName = newScreenName;
            return this;
        }

        public MP build(){
            return new MP(this);
        }
    }

    MP(Builder builder){
        this.constituency = builder.constituency;
        this.name = builder.name;
        this.screenName = builder.screenName;
    }
}

