package OTHERS;

public  class RankedOfficer  {
    private String rank;
    private int score;

    public RankedOfficer(String rank) {

        this.rank = rank;
    }
    public String getRank() {
        return rank;
    }
    public int getScore(){
        if (this.getRank().equals("corporal")){
            return 1;
        } else if (this.getRank().equals("sergent")) {
            return 4;
        }else if (this.getRank().equals("lieutenant")) {
            return 7;
        }else if (this.getRank().equals("capitan")) {
            return 12;
        }else if (this.getRank().equals("colonel")) {
            return 18;
        }else if (this.getRank().equals("general")) {
            return 22;
        }else {
            return 25;
        }

    }
}