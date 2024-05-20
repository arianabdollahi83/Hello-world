import OTHERS.Leader;
import OTHERS.RankedOfficer;
import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Matcher;

public class GamePlay {
    private ArrayList<Country> countries=new ArrayList<>();
    private ArrayList<Corps> corps=new ArrayList<>();

    public void addCountry(Matcher matcher){
        String name=matcher.group("name");
        String nationality=matcher.group("nationality");
        if (countryExist(name)==true){
            System.out.println("country was created");
        }
        else {
            Country country=new Country(name,nationality);
            countries.add(country);
            System.out.println("country "+name+" created");
        }
    }
    public void printCorpsScore(Matcher matcher){
        System.out.println();
    }

    private boolean countryExist(String name){
        for(Country country:countries){
            if(country.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private int addCorps(Matcher matcher){
        int infantry=Integer.parseInt(matcher.group("infantry"));
        int cavalry=Integer.parseInt(matcher.group("cavalry"));
        int artillery=Integer.parseInt(matcher.group("artillery"));
        String name=matcher.group("name");
        String rank=matcher.group("rank");
        int number=romanToInt(matcher.group("number"));
        for (Country country : countries){
            if (country.getName().equals(name)){
                if (!corpsExist(number,country)){
                    RankedOfficer officer=new RankedOfficer(rank);
                    Corps corp=new Corps(number,infantry,cavalry,artillery,officer);
                    if(corp.getSoldierNumber()>30000){System.out.println("cannot have more than 30k in a corps!");}
                    else {
                        country.addCorps(corp);
                        System.out.println("corps "+matcher.group("number")+" created successfully!");}
                    return 1;
                }
                else {
                    System.out.println("the country already has this corps!");
                    return 2;
                }
            }
        }
        System.out.println("country was not found");
        return 0;
    }

    boolean corpsExist(int number,Country country){
        for(Corps corp : country.corps){
            if (corp.getNumber()==number){
                return true;
            }
        }
        return false;
    }


    private int addArmy1(Matcher matcher){
        int number=Integer.parseInt(matcher.group("number"));
        String rank=matcher.group("leader");
        String name=matcher.group("country");
        String place=matcher.group("place");
        for (Country country : countries){
            if (country.getName().equals(name)){
                if (!armyExist(number,country)){
                    Leader leader=new Leader(rank);
                    Army army=new Army(number,leader,place);
                    country.armies.add(army);
                    System.out.println("army created successfully!");
                    return 12;
                }
                else {
                    System.out.println("the country already has this army!");
                    return 2;
                }
            }
        }
        System.out.println("country was not found!");
        return 0;
    }

    private int addArmy2(Matcher matcher){
        int number=Integer.parseInt(matcher.group("number"));
        String rank=matcher.group("leader");
        String name=matcher.group("country");


        for (Country country : countries){
            if (country.getName().equals(name)){
                if (!armyExist(number,country)){
                    Leader leader=new Leader(rank);
                    Army army=new Army(number,leader,null);
                    country.armies.add(army);
                    System.out.println("army created successfully!");
                    return 12;
                }
                else {
                    System.out.println("the country already has this army!");
                    return 2;
                }
            }
        }
        System.out.println("country was not found!");
        return 0;
    }


    private int setPlaceArmy(Matcher matcher){
        String name=matcher.group("country");

        int number=Integer.parseInt(matcher.group("number"));
        String place=matcher.group("place");
        for (Country country : countries){
            if (country.getName().equals(name)){
              for (Army army:country.armies){
                  if(army.getNumber()==number) {
                      army.setPlace(place);
                      System.out.println("set successfully!");
                      return 1;
                  }
              }
              return 2;
            }
        }
        System.out.println("country was not found!");
        return 0;
    }
    boolean armyExist(int number,Country country){
        for(Army army : country.armies){
            if (army.getNumber()==number){
                return true;
            }
        }
        return false;
    }


    private int addCorpsToArmy(Matcher matcher){
        int corps_number=romanToInt(matcher.group("corpsnumber"));
        int army_number=Integer.parseInt(matcher.group("armynumber"));
        String name=matcher.group("country");
        for (Country country:countries){
            if(country.getName().equals(name)){
                for (Army army:country.armies){
                    if (army.getNumber()==army_number){
                        for (Corps corp:country.corps){
                            if (corp.getNumber()==corps_number){
                                if(!corpsExist2(corps_number,army)){
                                    army.corps.add(corp);
                                    System.out.println("corps added to army successfully!");
                                    return 0;
                                }
                                else {
                                    System.out.println("this corps is in an army!");
                                    return 1;
                                }
                            }
                        }
                        System.out.println("corps was not found!");
                        return 2;
                    }
                }
                System.out.println("army was not found!");
                return 3;
            }
        }
        System.out.println("country was not found!");
        return 4;

    }
    boolean corpsExist2(int number,Army army){
        for(Corps corp : army.corps){
            if (corp.getNumber()==number){
                return true;
            }
        }
        return false;
    }
    public int printArmy(Matcher matcher) {
        int number = Integer.parseInt(matcher.group("number"));
        String name = matcher.group("country");
        for (Country country : countries) {
            if (country.getName().equals(name)) {
                for (Army army : country.armies) {
                   if (army.getNumber()==number){
                       System.out.println(army.getLeader().getName() + " " + army.corps.size());
                       return 0;
                   }
                }
                System.out.println("army was not found!");
                return 1;
            }
        }
        System.out.println("country was not found!");
        return 2;
    }

    public int printDetailArmy(Matcher matcher){
        int number = Integer.parseInt(matcher.group("number"));
        String name = matcher.group("country");
        for (Country country : countries) {
            if (country.getName().equals(name)) {
                for (Army army : country.armies) {
                    if (army.getNumber()==number){
                        System.out.println(army.getLeader().getName() + " " + army.corps.size());
                        int i=1;
                        for (Corps corp:army.corps){
                            System.out.println(corp.getInfantry()+" "+corp.getCavalry()+" "+corp.getArtillery()+" "+corp.getRankedOfficer().getRank()+" "+corp.getSoldierNumber());
                            i++;
                            if(i>3)break;
                        }
                        return 0;
                    }
                }
                System.out.println("army was not found!");
                return 1;
            }
        }
        System.out.println("country was not found!");
        return 2;
    }
    public int printCounry(Matcher matcher){
        String name=matcher.group("country");
        for(Country country:countries){
            if(country.getName().equals(name)){
                System.out.print(country.getNationality()+" "+country.armies.size()+" ");
                for (Army army:country.armies){
                    System.out.print(army.corps.size()+" ");
                }
                System.out.println();
                return 0;
            }
        }
        System.out.println("country was not found!");
        return 1;
    }

    public int printDetailCountry(Matcher matcher){
        String name=matcher.group("country");
        for(Country country:countries){
            if(country.getName().equals(name)){
                System.out.print(country.getNationality()+" "+country.armies.size()+" ");
                for (Army army:country.armies){
                    System.out.print(army.corps.size()+" ");
                }
                System.out.println();
                for (Army army:country.armies){
                    System.out.print(army.getLeader().getName()+" ");
                }
                System.out.println();
                return 0;
            }
        }
        System.out.println("country was not found!");
        return 1;
    }

    public int corpsScore(Matcher matcher){
        String name=matcher.group("country");
        int army_number=Integer.parseInt(matcher.group("armynumber"));
        int corps_number=romanToInt("corpsnumber");
        for(Country country:countries){
            if(country.getName().equals(name)){
                for(Army army:country.armies){
                    if (army.getNumber()==army_number){
                        for (Corps corp:army.corps){
                            if(corp.getNumber()==corps_number){
                                System.out.println(corp.calculateScore(army.getPlace(),corp.getRankedOfficer()));
                            return 0;
                            }
                        }
                        System.out.println("corps was not found!");return 1;
                    }
                }
                System.out.println("army was not found!");return 2;
            }
        }
        System.out.println("country was not found!");return 3;
    }

    public int armyScore(Matcher matcher){
        String name=matcher.group("country");
        int army_number=Integer.parseInt(matcher.group("armynumber"));
        for(Country country:countries){
            if(country.getName().equals(name)){
                for(Army army:country.armies){
                    if (army.getNumber()==army_number){
                        int counter=0;
                        for (Corps corp:army.corps){
                            counter+=corp.calculateScore(army.getPlace(),corp.getRankedOfficer());
                        }
                        System.out.println(counter);return 0;
                    }
                }
                System.out.println("army was not found!");return 2;
            }
        }
        System.out.println("country was not found!");return 3;
    }

    public void setCountryScores(){
        int counter=0;
        for(Country country:countries){
            for(Army army:country.armies){
                for (Corps corp:army.corps){
                    counter+=corp.calculateScore(army.getPlace(),corp.getRankedOfficer());
                }
            }
           // System.out.println("Score of "+country.getName()+" is "+counter+" and there are "+countries.size()+" countries");
            country.setScore(counter);
            counter=0;
        }
    }
    public void setArmyScores(Country country){
        int counter=0;
        for (Army army:country.armies){
            for (Corps corp:army.corps){
                counter+=corp.calculateScore(army.getPlace(),corp.getRankedOfficer());
            }
            army.setScore(counter);
        }
    }


    public int countryScore(Matcher matcher){
        String name=matcher.group("country");
        for(Country country:countries){
            if(country.getName().equals(name)){
                int counter=0;
                for(Army army:country.armies){
                    for (Corps corp:army.corps){
                        counter+=corp.calculateScore(army.getPlace(),corp.getRankedOfficer());
                    }
                }

                System.out.println(counter);return counter;
            }
        }
        System.out.println("country was not found!");return 3;
    }

    public int setAllies(Matcher matcher){
        String name1=matcher.group("country1");
        String name2=matcher.group("country2");

        Country country1=countryFinder(name1);
        Country country2=countryFinder(name2);
        if(country2==null || country1==null){
            System.out.println("country was not found!");return 4;
        }
        else {
            if (!checkEnemyUnion(country1,country2.allies) && !checkEnemyUnion(country1,country2.enemies)){
                System.out.println("unionized successfully!");
                country1.allies.add(country2);
                country2.allies.add(country1);
                return 0;
            }
            else {System.out.println("something went wrong!");}return 1;
        }

    }
    public int setAlliesList(Matcher matcher){
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        return 2;
    }

    public int makeEnemy(Matcher matcher){
        String name1=matcher.group("country1");
        String name2=matcher.group("country2");

        Country country1=countryFinder(name1);
        Country country2=countryFinder(name2);
        if(country2==null || country1==null){

            System.out.println("country was not found!");return 4;
        }
        else {
            if (!checkEnemyUnion(country1,country2.enemies) && !checkEnemyUnion(country1,country2.allies)){
                System.out.println("enemy made successfully!");
                country1.enemies.add(country2);
                country2.enemies.add(country1);
                return 0;
            }
            else {System.out.println("something went wrong!");}return 1;
        }
    }
    public int showAllies(Matcher matcher){
        String name=matcher.group("country");
        Country country1=countryFinder(name);
        if (country1==null){

            System.out.println("country was not found!");
        }
        else{
            ArrayList<Integer> scores=new ArrayList<>();
            for (Country country:country1.allies){
                scores.add(country.getScore());
            }
            Collections.sort(scores);
            for (int i:scores){
                for (Country country:country1.allies){
                    if (country.getScore()==i){
                        System.out.print(country.getName()+" ");
                    }
                }
            }
        }
        return 1;
    }
    public int showEnemies(Matcher matcher){
        String name=matcher.group("country");
        Country country1=countryFinder(name);
        if (country1==null){

            System.out.println("country was not found!");
        }
        else{
            ArrayList<Integer> scores=new ArrayList<>();
            for (Country country:country1.enemies){
                scores.add(country.getScore());
            }
            Collections.sort(scores);
            for (int i:scores){
                for (Country country:country1.enemies){
                    if (country.getScore()==i){
                        System.out.print(country.getName()+" ");
                    }
                }
            }
        }
        return 1;
    }
    public Country countryFinder(String name){
        for (Country country:countries){
            if (country.getName().equals(name)){
                return country;
            }
        }
        return null;
    }
    public boolean checkEnemyUnion(Country country,ArrayList<Country> they){
        if(they.contains(country)){
            return true;
        }
        return false;
    }
    public void warWithPlace(Matcher matcher){
        String name1=matcher.group("country1");
        Country country1=countryFinder(name1);
        String name2=matcher.group("country2");
        Country country2=countryFinder(name2);
        String place=matcher.group("place");
        setArmyScores(country1);
        setArmyScores(country2);
        if (country1==null || country2==null){
            System.out.println("country was not found!");
        }
        else {
            int counter1=0,counter2=0;
            for (Army army:country1.armies){
                if (army.getPlace().equals(place)){
                    counter1+=army.getScore();
                }
            }
            for (Army army:country2.armies){
                if (army.getPlace().equals(place)){
                    counter2+=army.getScore();
                }
            }
            if (counter1>counter2){
                System.out.println(country1.getName());
                for (Army army:country2.armies){
                    for (Corps corp:army.corps){
                        if (corp.getInfantry()%2==0){
                            corp.setInfantry(corp.getInfantry()/2);
                        }
                        else {
                            corp.setInfantry((corp.getInfantry()-1)/2);
                        }
                        if (corp.getCavalry()%2==0){
                            corp.setCavalry(corp.getCavalry()/2);
                        }
                        else {
                            corp.setCavalry((corp.getCavalry()-1)/2);
                        }
                    }
                }
            }
            else {
                System.out.println(country2.getName());
                for (Army army:country1.armies){
                    for (Corps corp:army.corps){
                        if (corp.getInfantry()%2==0){
                            corp.setInfantry(corp.getInfantry()/2);
                        }
                        else {
                            corp.setInfantry((corp.getInfantry()-1)/2);
                        }
                        if (corp.getCavalry()%2==0){
                            corp.setCavalry(corp.getCavalry()/2);
                        }
                        else {
                            corp.setCavalry((corp.getCavalry()-1)/2);
                        }
                    }
                }
            }
        }
    }
    public void warNoPlace(Matcher matcher){
        String name1=matcher.group("country1");
        Country country1=countryFinder(name1);
        String name2=matcher.group("country2");
        Country country2=countryFinder(name2);
        setArmyScores(country1);
        setArmyScores(country2);
        if (countryFinder(name1)==null || countryFinder(name2)==null){
            System.out.println("country was not found!");
        }
        else {
            int counter1=0,counter2=0;
            for (Army army:country1.armies){
                    counter1+=army.getScore();

            }
            for (Army army:country2.armies){
                    counter2+=army.getScore();
            }
            if (counter1>counter2){
                System.out.println(country1.getName());
                for (Army army:country2.armies){
                    for (Corps corp:army.corps){
                        if (corp.getInfantry()%2==0){
                            corp.setInfantry(corp.getInfantry()/2);
                        }
                        else {
                            corp.setInfantry((corp.getInfantry()-1)/2);
                        }
                        if (corp.getCavalry()%2==0){
                            corp.setCavalry(corp.getCavalry()/2);
                        }
                        else {
                            corp.setCavalry((corp.getCavalry()-1)/2);
                        }
                    }
                }
            }
            else {
                System.out.println(country2.getName());
                for (Army army:country1.armies){
                    for (Corps corp:army.corps){
                        if (corp.getInfantry()%2==0){
                            corp.setInfantry(corp.getInfantry()/2);
                        }
                        else {
                            corp.setInfantry((corp.getInfantry()-1)/2);
                        }
                        if (corp.getCavalry()%2==0){
                            corp.setCavalry(corp.getCavalry()/2);
                        }
                        else {
                            corp.setCavalry((corp.getCavalry()-1)/2);
                        }
                    }
                }
            }
        }
    }


    public static int romanToInt(String s){
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        int result =0;
        int i;
        for(i=0; i<s.length(); i++) {
            int value=mp.get(s.charAt(i));
            if(i<s.length()-1 && value<mp.get(s.charAt(i+1))){
                result-=value;
            }
            else {
                result +=value;
            }

        }return result;
    }

    public void run(Scanner scanner){
        boolean end=false;
        String string;
        while (!end){
            string=scanner.nextLine();
            string=string.trim();
            setCountryScores();
            if (string.matches(Commands.getREgex(Commands.ADD_COUNTRY))){
                Matcher matcher=Commands.getMatcher(string,Commands.ADD_COUNTRY);
                addCountry(matcher);
            }
            else if (string.matches(Commands.getREgex(Commands.ADD_CORPS))){
                Matcher matcher=Commands.getMatcher(string,Commands.ADD_CORPS);
                addCorps(matcher);

            } else if (string.matches(Commands.getREgex(Commands.ADD_ARMY))) {
                Matcher matcher=Commands.getMatcher(string,Commands.ADD_ARMY);
                addArmy1(matcher);
            } else if (string.matches(Commands.getREgex(Commands.ADD_ARMY_LOCATION))) {
                Matcher matcher=Commands.getMatcher(string,Commands.ADD_ARMY_LOCATION);
                addArmy2(matcher);
            } else if (string.matches(Commands.getREgex(Commands.SET_ARMY_LOCATION))) {
                Matcher matcher=Commands.getMatcher(string,Commands.SET_ARMY_LOCATION);
                setPlaceArmy(matcher);
            }else if (string.matches(Commands.getREgex(Commands.ADD_CORPS_TO_ARMY))) {
                Matcher matcher=Commands.getMatcher(string,Commands.ADD_CORPS_TO_ARMY);
                addCorpsToArmy(matcher);
            }else if (string.matches(Commands.getREgex(Commands.PRINT_ARMY))) {
                Matcher matcher=Commands.getMatcher(string,Commands.PRINT_ARMY);
                printArmy(matcher);
            }else if (string.matches(Commands.getREgex(Commands.PRINT_DETAIL_ARMY))) {
                Matcher matcher=Commands.getMatcher(string,Commands.PRINT_DETAIL_ARMY);
                printDetailArmy(matcher);
            }else if (string.matches(Commands.getREgex(Commands.PRINT_COUNTRY))) {
                Matcher matcher=Commands.getMatcher(string,Commands.PRINT_COUNTRY);
                printCounry(matcher);
            }else if (string.matches(Commands.getREgex(Commands.PRINT_DETAIL_COUNTRY))) {
                Matcher matcher=Commands.getMatcher(string,Commands.PRINT_DETAIL_COUNTRY);
                printDetailCountry(matcher);
            }else if (string.matches(Commands.getREgex(Commands.CORPS_SCORE))) {
                Matcher matcher=Commands.getMatcher(string,Commands.CORPS_SCORE);
                corpsScore(matcher);
            }else if (string.matches(Commands.getREgex(Commands.ARMY_SCORE))) {
                Matcher matcher=Commands.getMatcher(string,Commands.ARMY_SCORE);
                armyScore(matcher);
            }else if (string.matches(Commands.getREgex(Commands.COUNTRY_SCORE))) {
                Matcher matcher=Commands.getMatcher(string,Commands.COUNTRY_SCORE);
                countryScore(matcher);
            }else if (string.matches(Commands.getREgex(Commands.BEING_ALLIES))) {
                Matcher matcher=Commands.getMatcher(string,Commands.BEING_ALLIES);
                setAllies(matcher);
            }else if (string.matches(Commands.getREgex(Commands.BEING_ALLIES_LIST))) {
                Matcher matcher=Commands.getMatcher(string,Commands.BEING_ALLIES_LIST);
                setAlliesList(matcher);
            }else if (string.matches(Commands.getREgex(Commands.MADE_ENEMY))) {
                Matcher matcher=Commands.getMatcher(string,Commands.MADE_ENEMY);
                makeEnemy(matcher);
            }
            else if (string.matches(Commands.getREgex(Commands.SHOW_ALLIES))) {
                Matcher matcher=Commands.getMatcher(string,Commands.SHOW_ALLIES);
                showAllies(matcher);
            }else if (string.matches(Commands.getREgex(Commands.SHOW_ENEMIES))) {
                Matcher matcher=Commands.getMatcher(string,Commands.SHOW_ENEMIES);
                showEnemies(matcher);
            }
            else if (string.matches(Commands.getREgex(Commands.WAR_WITH_PLACE))) {
                Matcher matcher=Commands.getMatcher(string,Commands.WAR_WITH_PLACE);
                warWithPlace(matcher);
            }
            else if (string.matches(Commands.getREgex(Commands.WAR_WITHOUT_PLACE))) {
                Matcher matcher=Commands.getMatcher(string,Commands.WAR_WITHOUT_PLACE);
                warNoPlace(matcher);
            }else {
                System.out.println("invalid input!");
            }

        }








    }
}
