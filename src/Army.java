
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Army {
    private int number;
    private Leader leader;
    private List<Corps> corpsList;

    public Army(int number, Leader leader) {
        this.number = number;
        this.leader = leader;
        this.corpsList = new ArrayList<>();
    }

    public int getNumber() {
        return number;
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
