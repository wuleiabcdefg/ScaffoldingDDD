/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ddd.auth.app;

import ddd.auth.services.MessageUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spirng.ddd.services.MessageUtils;
import spirng6.ddd.services.MessageUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageUtilsTest {
    @Test void testGetMessage() {
        Assertions.assertEquals("Hello      World!", MessageUtils.getMessage());
    }
}
