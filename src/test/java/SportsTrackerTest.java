import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import com.example.SportsTracker;

public class SportsTrackerTest {
    private SportsTracker tracker;

    @BeforeEach
    public void setUp() {
        tracker = new SportsTracker();
    }

    @Test
    public void testAddActivity() {
        tracker.addActivity("Basketball", 60);
        assertEquals(1, tracker.getActivities().size(), "Activity count should be 1 after adding an activity.");
    }

    @Test
    public void testTotalTimeCalculation() {
        tracker.addActivity("Basketball", 60);
        tracker.addActivity("Running", 30);
        assertEquals(90, tracker.calculateTotalTime(), "Total time should be 90 minutes.");
    }

    @Test
    public void testViewActivities() {
        tracker.addActivity("Swimming", 45);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        tracker.viewActivities();
        String output = outputStream.toString();
        
        assertTrue(output.contains("Swimming - 45 minutes"), "Output should contain the added activity.");
        
        // Reset system output
        System.setOut(System.out);
    }
}
