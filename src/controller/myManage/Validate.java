package controller.myManage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String REGEX_NAME = "^[A-Za-z0-9]*$";
    public static final String REGEX_EMAIL = "^[a-z0-9]+@[gmail]{1}[.]{1}[com]{1}$";
    public static final String REGEX_TELEPHONE = "^[0-9]{10}$";
    public static final String REGEX_PRICE = "^[0-9]*$";
    public static final String REGEX_GEN = "^[0|9]{1}$";
    public static final String REGEX_BORN = "^[0-9]{2}[/|-]{1}[0-9]{2}[/|-]{1}[0-9]{4}$";
    public static final String REGEX_ADDRESS = "^[A-Za-z]";
    public static final String REGEX_ID = "^[C]{1}[0-9]{4}[G|I|K|]{1}[0-9]{1}";
    public static final String REGEX_KIP = "^[AM|PM]{1}$";

    public static boolean validate(String REGEX, String content) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }
}
