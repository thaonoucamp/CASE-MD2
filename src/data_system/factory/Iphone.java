package data_system.factory;

public class Iphone implements IFirm{
    private static Iphone INSTANCE = new Iphone();

    private Iphone() {
    }

    public static Iphone getInstance() {
        return INSTANCE;
    }
    @Override
    public String printLogo(String content) {
        return content;
    }
}
