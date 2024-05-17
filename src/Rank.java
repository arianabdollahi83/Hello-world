public enum Rank {
    CORPORAL(1),
    SERGEANT(4),
    LIEUTENANT(7),
    CAPTAIN(12),
    COLONEL(18),
    GENERAL(22),
    MARSHAL(25);

    private final int score;

    Rank(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
