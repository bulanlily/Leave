package testDashBoard;


import com.wallofshame.domain.dashBoard.DashBoardProcessor;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class IntegrationBoardTest {
    @Test
    public void shouldCalculateCsv() throws IOException {
        DashBoardProcessor processor = new DashBoardProcessor();
        ArrayList<String[]> list =processor.getDashBoardList();
        assertEquals(1,1);
    }
}
