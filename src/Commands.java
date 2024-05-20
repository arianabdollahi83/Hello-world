import java.util.regex.*;

public enum Commands {
    ADD_COUNTRY("\\s*create\\s+country\\s+(?<name>\\S+)\\s+(?<nationality>\\S+)\\s*"),
    ADD_CORPS("\\s*create\\s+corps\\s+(?<infantry>\\S+)\\s+(?<cavalry>\\S+)\\s+(?<artillery>\\S+)\\s+(?<rank>\\S+)\\s+for\\s+(?<name>\\S+)\\s+(?<number>\\S+)\\s*"),
    ADD_ARMY("\\s*create\\s+army\\s+(?<number>\\S+)\\s+(?<leader>\\S+)\\s+for\\s+(?<country>\\S+)\\s+in\\s+(?<place>\\S+)\\s*"),
    ADD_ARMY_LOCATION("\\s*create\\s+army\\s+(?<number>\\S+)\\s+(?<leader>\\S+)\\s+for\\s+(?<country>\\S+)\\s*"),
    SET_ARMY_LOCATION("\\s*set\\s+place\\s+for\\s+(?<country>\\S+)\\s+(?<number>\\S+)\\s+in\\s+(?<place>\\S+)\\s*"),
    ADD_CORPS_TO_ARMY("\\s*add\\s+corps\\s+(?<corpsnumber>\\S+)\\s+to\\s+army\\s+(?<armynumber>\\S+)\\s+of\\s+(?<country>\\S+)\\s*"),
    PRINT_ARMY("\\s*print\\s+army\\s+(?<number>\\S+)\\s+(?<country>\\S+)\\s*"),
    PRINT_DETAIL_ARMY("\\s*print\\s+army\\s+with\\s+details\\s+(?<number>\\S+)\\s+(?<country>\\S+)\\s*"),
    PRINT_COUNTRY("s*print\\s+country\\s+(?<country>\\S+)\\s*"),
    PRINT_DETAIL_COUNTRY("\\s*print\\s+country\\s+with\\s+details\\s+(?<country>\\S+)\\s*"),
    ARMY_SCORE("\\s*print\\s+score\\s+of\\s+(?<country>\\S+)\\s+(?<armynumber>\\S+)\\s*"),
    COUNTRY_SCORE("\\s*print\\s+score\\s+of\\s+(?<country>\\S+)\\s*"),
    CORPS_SCORE("\\s*print\\s+score\\s+of\\s+(?<country>\\S+)\\s+(?<armynumber>\\S+)\\s+(?<corpsnumber>\\S+)\\s*"),
    BEING_ALLIES("s*(?<country1>\\S+)\\s+join\\s+union\\s+with\\s+(?<country2>\\S+)\\s*"),
    BEING_ALLIES_LIST("\\s*(?<country1>\\S+)\\s+join\\s+union\\s+with\\s+\\b\\p{Lu}[a-z]*\\b\\s*"),
    MADE_ENEMY("s*(?<country1>\\S+)\\s+made\\s+enemy\\s+of\\s+(?<country2>\\S+)\\s*"),
    SHOW_ALLIES("s*show\\s+friends\\s+of\\s+(?<country>\\S+)\\s*"),
    SHOW_ENEMIES("s*show\\s+enemies\\s+of\\s+(?<country>\\S+)\\s*"),
    WAR_WITHOUT_PLACE("s*war\\s+between\\s+(?<country1>\\S+)\\s+and\\s+(?<country2>\\S+)\\s*"),
    WAR_WITH_PLACE("s*war\\s+between\\s+(<?country1>\\S+)\\s+and\\s+(?<country2>\\S+)\\s+in\\s+(?<place>\\S+)\\s*");
    private String regex;
    Commands (String regex){
        this.regex=regex;
    }
    public static String getREgex (Commands commands){
        return commands.regex;
    }
    public static Matcher getMatcher(String input,Commands commands){
        Matcher matcher=Pattern.compile(commands.regex).matcher(input);
        if(matcher.matches())return matcher;
        return null;
    }
}
