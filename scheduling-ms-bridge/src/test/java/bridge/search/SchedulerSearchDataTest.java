package bridge.search;

import com.scheduling.bridge.search.CustomerSearchData;
import com.scheduling.bridge.search.SchedulerSearchData;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SchedulerSearchDataTest {

    @Test
    public void searchTest(){
        SchedulerSearchData search = new SchedulerSearchData();
        LocalDateTime now = LocalDateTime.now();
        search.setDateTime(now);
        search.setCustomerDocument(StringUtils.EMPTY);
        assertEquals(search.getDateTime(),now);
        assertEquals(search.getCustomerDocument(),StringUtils.EMPTY);
        search.setDateTime(null);
        search.setCustomerDocument(null);
        assertNull(search.getDateTime());
        assertNull(search.getCustomerDocument());
    }

}
