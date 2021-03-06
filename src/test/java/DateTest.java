import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class DateTest {

    private Logger logger = Logger.getLogger(DateTest.class.getName());

    @Test
    public void testConvertDateFromJson() throws ParseException {
        String dateFromJson = "2012-04-23";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date javaDate = dateFormat.parse(dateFromJson);
        logger.log(Level.INFO, javaDate.toString());
    }
}