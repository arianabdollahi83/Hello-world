import java.util.ArrayList;

public  class Country {
    private String name;

    private String Nationality;
    private int score;
    private Army army;

    public Country(String name, String nationality) {
        this.name = name;
        this.Nationality = nationality;
        //this.army = army;
    }

    ArrayList<Corps> corps=new ArrayList<>();
    ArrayList<Army> armies=new ArrayList<>();
    ArrayList<Country> allies=new ArrayList<>();
    ArrayList<Country> enemies=new ArrayList<>();
    public void setScore(int score){
        this.score=score;
    }

    public int getScore(){
        return this.score;
    }

    public void addCorps(Corps corps){
        this.corps.add(corps);
    }

    public void setEnemies(ArrayList<Country> Enemies){
        this.enemies=Enemies;
    }
    public void setAllies(ArrayList<Country> Allies){
        this.allies.equals(Allies);
    }
    public ArrayList getAllies(){return allies;}
    public String getName() {
        return name;
    }

    public String getNationality() {
        return Nationality;
    }

    public Army getArmy() {
        return army;
    }
}