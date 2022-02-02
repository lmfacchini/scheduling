package bridge.search;

import com.scheduling.bridge.search.SchedulerSearchData;
import com.scheduling.bridge.search.WorkSearchData;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WorkSearchDataTest {

    @Test
    public void searchTest(){

        WorkSearchData search = new WorkSearchData();
        search.setCode(StringUtils.EMPTY);
        search.setDescription(StringUtils.EMPTY);
        search.setValue(BigDecimal.ZERO);
        assertEquals(search.getCode(),StringUtils.EMPTY);
        assertEquals(search.getDescription(),StringUtils.EMPTY);
        assertEquals(search.getValue(),BigDecimal.ZERO);
        search.setCode(null);
        search.setDescription(null);
        search.setValue(null);
        assertNull(search.getCode());
        assertNull(search.getDescription());
        assertNull(search.getValue());
    }
}
