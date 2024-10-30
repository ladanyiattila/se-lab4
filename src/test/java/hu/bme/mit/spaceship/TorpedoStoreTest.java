package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    TorpedoStore s;

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @BeforeEach
    void setUp() {
        s = new TorpedoStore(2);
    }

    @Test
    void fireAll() {
        boolean result = s.fire(s.getTorpedoCount());

        assertEquals(true, result);
        assertEquals(0, s.getTorpedoCount());
    }

    @Test
    void fireAllAndMore() {
        boolean result = s.fire(s.getTorpedoCount());

        assertEquals(true, result);

        assertThrows(IllegalArgumentException.class, () -> {s.fire(1);});
    }

    @Test
    void getTorpedoCount() {
        assertEquals(2, s.getTorpedoCount());
    }

    @Test
    void testIfTorpedoStoreIsEmpty() {
        assertFalse(s.isEmpty());
    }
}
