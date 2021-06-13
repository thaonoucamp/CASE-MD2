package controller.myManage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String REGEX_NAME = "^[A-Za-z\\s]*$";
    public static final String REGEX_EMAIL = "^[a-z0-9]+@[a-z]+[.]{1}[a-z]+$";
    public static final String REGEX_TELEPHONE = "^[0-9]{10}$";
    public static final String REGEX_PRICE = "^[0-9]*$";
    public static final String REGEX_GEN = "^[9|0]{1}$";
    public static final String REGEX_BORN = "^[0-9]{2}[/|-]{1}[0-9]{2}[/|-]{1}[0-9]{4}$";
    public static final String REGEX_ADDRESS = "^[A-Za-z]";
    public static final String REGEX_PASSWORD = "^[0-9]{6}$";

    public static boolean validate(String REGEX, String content) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }
}
