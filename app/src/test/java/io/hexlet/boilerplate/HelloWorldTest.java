package io.hexlet.boilerplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class HelloWorldTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static Logger log = LoggerFactory.getLogger(HelloWorldTest.class);

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("'main' method works correctly")
    void testMain() {
        log.debug("Start test");
        HelloWorld.main(null);
        assertEquals("Hello, World!", output.toString(StandardCharsets.UTF_8).trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
