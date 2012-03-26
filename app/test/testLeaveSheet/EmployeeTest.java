package testLeaveSheet;

import com.wallofshame.domain.leave.Constants;
import com.wallofshame.domain.leave.Employee;
import com.wallofshame.domain.leave.Leave;
import org.hamcrest.core.Is;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class EmployeeTest {
    private Employee employee1;


    @Before
    public void setUp() {
        new DateTime();
        employee1 = new Employee(new DateTime(1999, 2, 2, 0, 0, 0, 0), 1, "Lily", "Beijing");
        //less than 10 days.
        //7 lessThan10DaysEmployee
        //2
        //8
    }

    @Test
    public void shouldEmployeeEquals() {
        Employee employee2 = new Employee(new DateTime(1999, 2, 2, 0, 0, 0, 0), 1, "Lily", "Beijing");
        assertThat(employee1.equals(employee2), Is.is(true));
    }

    @Test
    public void shouldGetRightTenner() {
        assertEquals((Constants.getCurrentYear() - 1999), employee1.getTenner());
    }

    @Test
    public void shouldGetRightAvailableAnnualLeave() {
        employee1.addHistoryLeavesSize(new Leave(new DateTime(2012, 3, 2, 0, 0, 0, 0), "ANNUAL_LV", "sick", 4));
        assertEquals((25.0 / 366 * Constants.getCurrentDayOfYear() - 0.5), employee1.getRemainingAnnualLeave(), 0.01);
    }

    @Test
    public void shouldGetRightActualRateByYear() {
        assertEquals(25, employee1.getRightActualRateByYear());
    }

    @Test
    public void shouldGetRightActualRateByMonth() {
        assertEquals(2.08, employee1.getRightActualRateByMonth(), 0.01);
    }

    @Test
    public void shouldAddAHistoryLeave() {
        int size = employee1.addHistoryLeavesSize(new Leave(new DateTime(2012, 2, 2, 0, 0, 0, 0), "SICK_LV", "sick", 4));
        assertEquals(1, size);
    }

}
