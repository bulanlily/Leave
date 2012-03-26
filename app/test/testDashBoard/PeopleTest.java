package testDashBoard;


import com.wallofshame.domain.dashBoard.People;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PeopleTest {
    @Test
    public void shouldAddRightDate(){
        String s1="6/1/11";
        String s2="6/4/11";
        String s3="6/18/11";
        String s4="6/26/11";
        String s5="6/27/11";

        People people  = new People(123,"mmmm");
        people.addWorkDay(s1);
        assertEquals(1,people.getDaysInFirstWeek());


        people.addWorkDay(s2);
        assertEquals(2,people.getDaysInFirstWeek());

        people.addWorkDay(s3);
        assertEquals(1,people.getDaysInThirdWeek());

        people.addWorkDay(s4);
        assertEquals(1,people.getDaysInForthWeek());


        people.addWorkDay(s5);
        assertEquals(1,people.getDaysInFifthWeek());
    }

}
