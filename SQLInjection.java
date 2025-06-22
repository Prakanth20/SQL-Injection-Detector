import java.util.regex.*;

public class SQLInjectionDetector {

    // Common SQL Injection patterns
    private static final String[] PATTERNS = {
        "('.+--)|(--)|(%7C)",             // Comments or OR clause
        "('.+\\s+OR\\s+.+=.+)",           // ' OR '1'='1
        "(\\bUNION\\b.*\\bSELECT\\b)",    // UNION SELECT
        "(\\bSELECT\\b.+\\bFROM\\b)",     // SELECT ... FROM
        "(\\bDROP\\b\\s+\\bTABLE\\b)",    // DROP TABLE
        "(\\bINSERT\\b\\s+INTO)",         // INSERT INTO
        "(\\bUPDATE\\b.+\\bSET\\b)",      // UPDATE SET
        "(\\bDELETE\\b\\s+FROM\\b)",      // DELETE FROM
        "(\\bEXEC\\b(UTE)?\\b)",          // EXEC/EXECUTE
        "(\\bOR\\b\\s+1=1)",              // OR 1=1
    };

    public static boolean isSQLInjection(String input) {
        for (String regex : PATTERNS) {
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

    // Test
    public static void main(String[] args) {
        String[] testInputs = {
            "admin' --",
            "test'; DROP TABLE users; --",
            "normalInput",
            "' OR 1=1 --",
            "SELECT * FROM users"
        };

        for (String input : testInputs) {
            System.out.println("Input: \"" + input + "\" | Suspicious: " + isSQLInjection(input));
        }
    }
}
