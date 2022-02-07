package SignInSignUp;

import java.util.regex.Pattern;

public class PasswordValidator
{
     Pattern pattern;
     static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]{8,20}$";
    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public int validate(String password) {
        if(pattern.matcher(password).matches()){
            return 1 ;
        }
        return 0;
    }
}
