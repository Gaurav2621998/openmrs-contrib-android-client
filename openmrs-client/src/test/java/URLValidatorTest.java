import org.junit.Test;
import org.openmrs.client.utilities.URLValidator;

import static org.junit.Assert.assertEquals;

public class URLValidatorTest {
    private static final String INVALID_URL_1;
    private static final String INVALID_URL_2;
    private static final String VALID_URL_1;
    private static final String VALID_URL_1_TRIMMED;
    private static final String VALID_URL_2;

    static {
        INVALID_URL_1 = "http://";
        INVALID_URL_2 = "http://demo.openmrs.org/openmrsl.na15.force.com";
        VALID_URL_1 = "http://demo.openmrs.org/openmrs/";
        VALID_URL_1_TRIMMED = "http://demo.openmrs.org/openmrs";
        VALID_URL_2 = "https://demo.openmrs.org:8081/openmrs-standalone";
    }

    @Test
    public void testURLValidator() {
        URLValidator.ValidationResult result;
        URLValidator.ValidationResult expected;

        result = URLValidator.validate(INVALID_URL_1);
        expected = new URLValidator.ValidationResult(false, INVALID_URL_1);
        assertEquals(expected.isURLValid(), result.isURLValid());
        assertEquals(expected.getUrl(), result.getUrl());

        result = URLValidator.validate(INVALID_URL_2);
        expected = new URLValidator.ValidationResult(false, INVALID_URL_2);
        assertEquals(expected.isURLValid(), result.isURLValid());
        assertEquals(expected.getUrl(), result.getUrl());


        result = URLValidator.validate(VALID_URL_1);
        expected = new URLValidator.ValidationResult(true, VALID_URL_1_TRIMMED);
        assertEquals(expected.isURLValid(), result.isURLValid());
        assertEquals(expected.getUrl(), result.getUrl());

        result = URLValidator.validate(VALID_URL_2);
        expected = new URLValidator.ValidationResult(true, VALID_URL_2);
        assertEquals(expected.isURLValid(), result.isURLValid());
        assertEquals(expected.getUrl(), result.getUrl());

    }
}