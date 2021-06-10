package data_system.factory;

public class LogoFactory {
    public IFirm getFirm(String name) {
        if (name == null) {
            return Iphone.getInstance();
        }
        if (name.equalsIgnoreCase("ios")) {
            return Iphone.getInstance();
        } else if (name.equalsIgnoreCase("blackOS")) {
            return Blackberry.getInstance();
        } else if (name.equalsIgnoreCase("android")) {
            return Samsung.getInstance();
        }
        return Iphone.getInstance();
    }
}
