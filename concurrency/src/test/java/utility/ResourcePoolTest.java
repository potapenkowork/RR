package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ResourcePoolTest {

    @Test
    void testPoolIsClosedBeforeInitially() {
        ResourcePool<String> underTest = ResourcePoolFactory.getInstance();
        assertFalse(underTest.isOpen(), "Default state before open should be closed");
    }
}
