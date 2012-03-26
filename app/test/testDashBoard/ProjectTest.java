package testDashBoard;

import com.wallofshame.domain.dashBoard.Project;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProjectTest {
    String[] strings1;
    String[] strings2;
    String[] strings3;
    String[] strings4;

    @Before
    public void setUp() {
        strings1 = new String[]{"Employee","An,Hui","TWORKS1","TWORKS1_CON_CHN","OFF_ANNUAL_LV","6/1/11","0.00","0.00","8.00","","13770","01","TCH","6/5/11","6/3/11 1:36","CHN"};
        strings3 = new String[]{"Employee","An,Hui","TWORKS1","TWORKS1_CON_CHN","OFF_ANNUAL_LV","6/6/11","0.00","0.00","8.00","","13770","01","TCH","6/5/11","6/3/11 1:36","CHN"};
        strings4 = new String[]{"Employee","An,Hui","TWORKS1","TWORKS1_CON_CHN","OFF_ANNUAL_LV","6/7/11","0.00","0.00","8.00","","13770","01","TCH","6/5/11","6/3/11 1:36","CHN"};
    }

    @Test
    public void shouldAddPeopleRight(){
        Project project= new Project("TWORKS1_CON_CHN") ;
        project.addPeopleRecordByStrings(strings1);
        assertTrue(project.hasPeople(13770));
        assertEquals("An,Hui",project.getPeopleById(13770).getName());
        assertEquals(1,project.getPeopleById(13770).getDaysInFirstWeek());

    }
}
