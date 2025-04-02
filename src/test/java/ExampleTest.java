import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("ExamplePack")
public class ExampleTest {

    @Test
    void exampleTestCase(){
        System.out.println("Running an example test...");
        assertTrue(true, "Example test passed");
    }
}

