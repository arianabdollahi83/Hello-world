import java.util.*;

class Main {
    public static void main(String[] args) {
        // تست کد
        WarSimulator warSimulator = new WarSimulator();


        // تعریف کشورها و اضافه کردن آن‌ها به اتحاد یا تعیین دشمنی
        warSimulator.joinUnion("France", "Austria");
        warSimulator.joinUnion("France", "Russia");
        warSimulator.makeEnemyOf("France", "Britain");
        int a=9;
        Nationality Irani=new Nationality() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        }
        Leader HajGhasem=new Leader("Arian",2) {
            @Override
            public String getName() {
                return super.getName();
            }
        }
        Army artesh=new Army(9,HajGhasem) {
            @Override
            public int getNumber() {
                return super.getNumber();
            }
        }
        Country Iran=new Country("Iran",Irani,artesh) {
            @Override
            public String getName() {
                return super.getName();
            }
        }
        // نمایش کشورهای متحد با یک کشور
        System.out.println("Friends of France: " + warSimulator.showFriendsOf("France"));

        // نمایش کشورهای دشمن با یک کشور
        System.out.println("Enemies of France: " + warSimulator.showEnemiesOf("France"));

        // جنگ بین دو کشور
        warSimulator.warBetween("France", "Britain", "Europe");
    }
}

class WarSimulator {
    private Map<String, List<String>> unions;
    private Map<String, List<String>> enemies;

    public WarSimulator() {
        unions = new HashMap<>();
        enemies = new HashMap<>();
    }

    public void joinUnion(String country1, String country2) {
        // اضافه کردن کشورها به اتحاد
        if (!unions.containsKey(country1)) {
            unions.put(country1, new ArrayList<>());
        }
        unions.get(country1).add(country2);
        if (!unions.containsKey(country2)) {
            unions.put(country2, new ArrayList<>());
        }
        unions.get(country2).add(country1);

        // حذف از لیست دشمنان در صورت وجود
        if (enemies.containsKey(country1)) {
            enemies.get(country1).remove(country2);
        }
        if (enemies.containsKey(country2)) {
            enemies.get(country2).remove(country1);
        }
    }

    public void makeEnemyOf(String country1, String country2) {
        // اضافه کردن کشورها به لیست دشمنان
        if (!enemies.containsKey(country1)) {
            enemies.put(country1, new ArrayList<>());
        }
        enemies.get(country1).add(country2);
        if (!enemies.containsKey(country2)) {
            enemies.put(country2, new ArrayList<>());
        }
        enemies.get(country2).add(country1);

        // حذف از لیست اتحاد در صورت وجود
        if (unions.containsKey(country1)) {
            unions.get(country1).remove(country2);
        }
        if (unions.containsKey(country2)) {
            unions.get(country2).remove(country1);
        }
    }

    public List<String> showFriendsOf(String country) {
        // نمایش کشورهای متحد با یک کشور
        List<String> friends = new ArrayList<>();
        if (unions.containsKey(country)) {
            friends.addAll(unions.get(country));
        }
        return friends;
    }

    public List<String> showEnemiesOf(String country) {
        // نمایش کشورهای دشمن با یک کشور
        List<String> enemiesList = new ArrayList<>();
        if (enemies.containsKey(country)) {
            enemiesList.addAll(enemies.get(country));
        }
        return enemiesList;
    }

    public void warBetween(String country1, String country2, String place) {
        // جنگ بین دو کشور
        System.out.println("War between " + country1 + " and " + country2 + " in " + place);
        // اعلام برنده جنگ
        Random rand = new Random();
        if (rand.nextBoolean()) {
            System.out.println(country1 + " won the war!");
        } else {
            System.out.println(country2 + " won the war!");
        }
    }
}
