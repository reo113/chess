package application;

public class Player {

    private String name;
    private boolean isBlack;
    //timer

    public Player(String name, boolean isBlack) {
        this.name = name;
        this.isBlack = isBlack;
    }

    public String getName() {
        return name;
    }

    public boolean isBlack() {
        return isBlack;
    }
}
