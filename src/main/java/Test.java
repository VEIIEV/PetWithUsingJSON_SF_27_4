import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test{

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        logger.info("Test log from {}", Test.class.getSimpleName());
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
    }
}