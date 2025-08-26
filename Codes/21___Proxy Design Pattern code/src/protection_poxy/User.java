package protection_poxy;

public class User {
    private final String name;
    private boolean isPremium;

    public User(String name) {
        this.name = name;
        this.isPremium = false;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}