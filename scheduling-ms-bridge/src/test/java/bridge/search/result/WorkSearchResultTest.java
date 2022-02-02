package bridge.search.result;

import com.scheduling.bridge.search.result.SchedulerSerchResult;
import com.scheduling.bridge.search.result.WorkSearchResult;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WorkSearchResultTest {

    @Test
    public void searchTest(){
        WorkSearchResult result = new WorkSearchResult(StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY, BigDecimal.ZERO);
        assertEquals(result.getId(),StringUtils.EMPTY);
        assertEquals(result.getCode(),StringUtils.EMPTY);
        assertEquals(result.getDescription(),StringUtils.EMPTY);
        assertEquals(result.getValue(),BigDecimal.ZERO);
        result.setId(null);
        result.setCode(null);
        result.setDescription(null);
        result.setValue(null);
        assertNull(result.getId());
        assertNull(result.getCode());
        assertNull(result.getDescription());
        assertNull(result.getValue());
    }

}
