public abstract class Corps {
    private String romanNumber;
    private RankedOfficer rankedOfficer;
    private int infantry;
    private int cavalry;
    private int artillery;

    public Corps(String romanNumber, RankedOfficer rankedOfficer, int infantry, int cavalry, int artillery) {
        this.romanNumber = romanNumber;
        this.rankedOfficer = rankedOfficer;
        this.infantry = infantry;
        this.cavalry = cavalry;
        this.artillery = artillery;
    }

    public String getRomanNumber() {
        return romanNumber;
    }

    public RankedOfficer getRankedOfficer() {
        return rankedOfficer;
    }

    public int getInfantry() {
        return infantry;
    }

    public int getCavalry() {
        return cavalry;
    }

    public int getArtillery() {
        return artillery;
    }

    public int getTotalSoldiers() {
        return infantry + cavalry + artillery;
    }
}
