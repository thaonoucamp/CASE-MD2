package data_system.factory;

public class Blackberry implements IFirm {
    private static Blackberry INSTANCE = new Blackberry();

    private Blackberry() {
    }

    public static Blackberry getInstance() {
        return INSTANCE;
    }

    @Override
    public String printLogo(String content) {
        return content;
    }
}
