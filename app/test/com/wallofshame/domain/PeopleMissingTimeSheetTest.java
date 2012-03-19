package com.wallofshame.domain;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 * User: twer
 * Date: 3/15/12
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleMissingTimeSheetTest {

    @Test
    public void shouldReturnNameList() {
        PeopleMissingTimeSheet timeSheet = new PeopleMissingTimeSheet();
        String zhiheng = "Zhiheng";
        String chen = "Chen";
        timeSheet.addName(zhiheng);
        timeSheet.addName(chen);
        List<String> names = timeSheet.names();
        assertNotNull(names);
        assertContainsName(names, zhiheng);
        assertContainsName(names, chen);
    }

    private void assertContainsName(List<String> names, String name) {
        for (String each : names)
            if (each.equals(name))
                return;
        fail(name + " not found");
    }
}
