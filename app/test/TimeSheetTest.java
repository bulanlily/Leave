import com.wallofshame.domain.leave.Employee;
import com.wallofshame.domain.leave.Leave;
import com.wallofshame.domain.leave.TimeSheet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.*;

public class TimeSheetTest {
    TimeSheet timeSheet;
    String[] employeeString1;
    String[] employeeString2;
    String[] leaveString1;


    @Before
    public void setUp() {
        timeSheet = new TimeSheet();
        employeeString1 = new String[]{"", "beijing", "1", "", "", "", "", "1999-9-9"};
        employeeString2 = new String[]{"", "beijing", "2", "", "", "", "", "1999-9-9"};
        leaveString1 = new String[]{"Employee","TCH","Chang,Xin","TW_TOFF","TW_TOFF_LEAVE","ANNUAL_LV","2/24/12","0.ub Proj00","0.00","8.00","Familly Issue","12100","01","2/26/12","2/27/12 20:15"
};
    }

    @Test
    public void shouldBuildEmployeeFromStrings() {
        Employee employee = timeSheet.buildEmployeeFromStrings(employeeString1);
        assertEquals("beijing", employee.getOffice());
    }

    @Test
    public void shouldAddEmployee() {
        Employee employee = timeSheet.buildEmployeeFromStrings(employeeString1);
        assertTrue(timeSheet.addEmployeeToList(employee));
        assertFalse(timeSheet.addEmployeeToList(employee));
    }

    @Test
    public void shouldAddAllEmployeeToList() {

        int size = 0;
        ArrayList<String[]> stringsList = new ArrayList<String[]>();
        stringsList.add(employeeString1);
        size = timeSheet.addAllEmployeeToListByStrings(stringsList);
        assertEquals(1, size);
        stringsList.add(employeeString1);
        size = timeSheet.addAllEmployeeToListByStrings(stringsList);
        assertEquals(1, size);
        stringsList.add(employeeString2);
        size = timeSheet.addAllEmployeeToListByStrings(stringsList);
        assertEquals(2, size);
    }

    @Test
    public void shouldBuildLeaveFromStrings() {
       Leave leave = timeSheet.buildLeaveFromStrings(leaveString1);
       assertEquals(8.00,leave.getHours(),0.01);

    }
}
