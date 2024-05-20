import OTHERS.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public  class Army {
    private int number;
    private Leader leader;
    private List<Corps> corpsList;
    private String place;
    private int score;
    ArrayList<String> places=new ArrayList<>();

    public Army(int number, Leader leader,String place) {
        this.number = number;
        this.place=place;
        this.leader = leader;
        this.corpsList = new ArrayList<>();
    }
    ArrayList<Corps> corps=new ArrayList<>();
    public int getNumber() {
        return number;
    }
    public int getScore(){return score;}
    public void setPlace(String place){
        this.place=place;
    }
    public void setScore(int score){this.score=score;}
    public String getPlace(){
        return this.place;
    }

    public Leader getLeader() {
        return leader;
    }

    public List<Corps> getCorpsList() {
        return corpsList;
    }

    public void addCorps(Corps corps) {
        if (corpsList.size() < 30) {
            corpsList.add(corps);
        } else {
            System.out.println("Cannot add more than 30 corps.");
        }
    }
}