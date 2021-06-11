package model.factory;

public class Samsung implements IFirm {

    private static Samsung INSTANCE = new Samsung();

    private Samsung() {
    }

    public static Samsung getInstance() {
        return INSTANCE;
    }

    @Override
    public String printLogo(String content) {
        return content;
    }
}
