package SignInSignUp;

import java.util.regex.Pattern;

public class UsernameValidator {
    Pattern pattern;
    static final String USERNAME_PATTERN = "^[a-z0-9._-]{3,20}$";
    public UsernameValidator() {
        pattern = Pattern.compile(USERNAME_PATTERN);
    }

    public int validate(String username) {
        if(pattern.matcher(username).matches()){
            return 1 ;
        }
        return 0;
    }
}
