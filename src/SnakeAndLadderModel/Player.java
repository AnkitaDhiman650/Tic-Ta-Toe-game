package SnakeAndLadderModel;

public class Player {
    String name;
    int id;
    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public int getNumber() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int id) {
        this.id = id;
    }
}
