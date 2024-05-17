public abstract class RankedOfficer extends Leader {
    private int rank;

    public RankedOfficer(String name, int score, int rank) {
        super(name, score);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
