package bridge.search.result;

import com.scheduling.bridge.search.result.CustomerSerchResult;
import com.scheduling.bridge.search.result.SchedulerSerchResult;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SchedulerSerchResultTest {

    @Test
    public void searchTest(){
        SchedulerSerchResult result = new SchedulerSerchResult(StringUtils.EMPTY, Collections.EMPTY_MAP);
        assertEquals(result.getCustomer(),StringUtils.EMPTY);
        assertEquals(result.getDates(),Collections.EMPTY_MAP);
        assertNull(result.getId());
        result.setCustomer(null);
        result.setDates(null);
        result.setId(null);
        assertNull(result.getCustomer());
        assertNull(result.getDates());
        assertNull(result.getId());
    }

}
