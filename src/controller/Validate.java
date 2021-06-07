package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean validate(String REGEX, String content){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }
}
