public abstract class Country {
    private String name;
    private Nationality nationality;
    private Army army;

    public Country(String name, Nationality nationality, Army army) {
        this.name = name;
        this.nationality = nationality;
        this.army = army;
    }

    public String getName() {
        return name;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public Army getArmy() {
        return army;
    }
}
