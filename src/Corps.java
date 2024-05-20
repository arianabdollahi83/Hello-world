import OTHERS.*;
public  class Corps {

    private RankedOfficer rankedOfficer;
    private int infantry;
    private int cavalry;
    private int artillery;
    private int number;

    public Corps(int number, int infantry, int cavalry, int artillery, RankedOfficer officer) {
        this.number=number;
        this.rankedOfficer = officer;
        this.infantry = infantry;
        this.cavalry = cavalry;
        this.artillery = artillery;

    }
    public int getSoldierNumber(){return this.infantry*1000+this.cavalry*400+this.artillery*10;}
    public RankedOfficer getRankedOfficer() {
        return this.rankedOfficer;
    }
    public void setInfantry(int infantry){
        this.infantry=infantry;
    }
    public void setCavalry(int cavalry){
        this.cavalry=cavalry;
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

    public int getNumber(){return number;}

    public int calculateScore(String place,RankedOfficer officer){
        int counter=0;
        if (place.equals("Forest")){
            counter=artillery*10*2+cavalry*400*5+2*1000*infantry;
        }
        else if (place.equals("Plain")){
            counter=artillery*10+2*1000*infantry;
        }
        else if (place.equals("Hill")) {
            counter=artillery*10-400*cavalry+1000*3*infantry;
        }
        else if (place.equals("Mountain")) {
            counter=10*artillery-800*cavalry+1000*infantry;
        }
        else {
            return 0;
        }


        counter+=officer.getScore()*1000+infantry*1000+cavalry*400+artillery*10;
        return counter;
    }




    public enum TERRAIN{
        Forest,Plain,Hill,Mountain;
    }
    public class Ranks{
        static int corporal=1;

    }
}


