import org.junit.Test;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void testSingleAnswer() throws FileNotFoundException {
        main.main(new String[]{"single.csv", "-d", "2018-12-09"});
    }
}
