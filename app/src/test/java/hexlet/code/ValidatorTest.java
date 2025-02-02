package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @Test
    void testStringSchemaCreation() {
        StringSchema schema = validator.string();
        assertNotNull(schema);
    }

    @Test
    void testNoRequiredValidation() {
        StringSchema schema = validator.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }

    @Test
    void testRequiredValidation() {
        StringSchema schema = validator.string().required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    void testContainsValidation() {
        StringSchema schema = validator.string();
        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    void testMinLengthValidation() {
        StringSchema schema = validator.string().minLength(5);
        assertFalse(schema.isValid("abcd"));
        assertTrue(schema.isValid("abcde"));
        assertTrue(schema.isValid("abcdef"));
    }

    @Test
    void testMultipleMinLengthCalls() {
        StringSchema schema= validator.string();
        assertTrue(schema.minLength(10).minLength(4).isValid("Hexlet"));
    }


}
