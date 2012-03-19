import com.wallofshame.domain.leave.CSVProcessor;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CSVProcessorTest {
    CSVProcessor csvProcessor;
    String fileAddress;
    ArrayList<String[]> stringsList;
    @Before
    public void setUp(){
        csvProcessor = new CSVProcessor();
        fileAddress ="excels";
        stringsList = new ArrayList<String[]>();
        stringsList.add(new String[]{"1","Beijing","10139","__","Guo","Xiao","Guo,Xiao","1999-07-06"});
        stringsList.add(new String[]{"2","Australia","11192","__","Huang","Liang","Huang,Liang","2005-06-09"});
    }

    @Test
    public void shouldChooseLastestFile() throws IOException {
        csvProcessor.pickUpLatestFolder();
        assertArrayEquals(stringsList.get(1),csvProcessor.getEmployeeInfo().get(1));
    }

    @Test
    public void shouldGetAllFileListInBasicFolder(){
        assertEquals("2012-02\n2012-03\n",csvProcessor.listAllFilesInBasicFolder());
    }
}
