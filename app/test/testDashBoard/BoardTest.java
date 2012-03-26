package testDashBoard;

import com.wallofshame.domain.dashBoard.Board;
import com.wallofshame.domain.dashBoard.Project;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


public class BoardTest {

    Board board;
    String[] strings1;
    String[] strings2;
    String[] strings3;
    String[] strings4;

    @Before
    public void setUp() {
        board = new Board();
        strings1 = new String[]{"Employee","An,Hui","TWORKS1","TWORKS1_CON_CHN","OFF_ANNUAL_LV","6/1/11","0.00","0.00","8.00","","13770","01","TCH","6/5/11","6/3/11 1:36","CHN"};
        strings2 = new String[]{"Employee","Bn,Hui","TWORKS1","TWORKS1_CON_CHN","OFF_ANNUAL_LV","6/1/11","0.00","0.00","8.00","","13771","01","TCH","6/5/11","6/3/11 1:36","CHN"};
        strings3 = new String[]{"Employee","An,Hui","TWORKS1","TWORKS1_CON_CHN","OFF_ANNUAL_LV","6/6/11","0.00","0.00","8.00","","13770","01","TCH","6/5/11","6/3/11 1:36","CHN"};
        strings4 = new String[]{"Employee","An,Hui","TWORKS1","TWORKS1_CON_CHN","OFF_ANNUAL_LV","6/7/11","0.00","0.00","8.00","","13770","01","TCH","6/5/11","6/3/11 1:36","CHN"};
    }
    @Test
    public void shouldAddInfomationFromStrings(){
        Project project = board.addInfomationFromStrings(strings1);
        assertEquals("TWORKS1_CON_CHN",project.getName());
        assertEquals(1,board.getProjectsSize());
        assertTrue(project.hasPeople(13770));
        assertEquals(1,project.getPeopleById(13770).getDaysInFirstWeek());
        assertEquals("An,Hui",project.getPeopleById(13770).getName());


        project = board.addInfomationFromStrings(strings2);
        assertEquals("TWORKS1_CON_CHN",project.getName());
        assertEquals(1,board.getProjectsSize());
        assertTrue(project.hasPeople(13771));
        assertEquals(1,project.getPeopleById(13771).getDaysInFirstWeek());
        assertEquals("Bn,Hui",project.getPeopleById(13771).getName());

        project = board.addInfomationFromStrings(strings3);
        assertEquals(1,board.getProjectsSize());
        assertEquals(2,project.getPeopleSize());
        assertEquals(1,project.getPeopleById(13770).getDaysInSecondWeek());

        project = board.addInfomationFromStrings(strings4);
        assertEquals(1,board.getProjectsSize());
        assertEquals(2,project.getPeopleSize());
        assertEquals(2,project.getPeopleById(13770).getDaysInSecondWeek());




    }
}
