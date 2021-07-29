import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig {
    @Beans
    public Matcher matcher() {
        String pwPattern = "^(\\d{4})$";\
        return Pattern.compile(pwPattern);
    }
}