package bridge.search;

import com.scheduling.bridge.search.CustomerSearchData;
import com.scheduling.bridge.search.result.WorkSearchResult;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CustomerSearchDataTest {

    @Test
    public void searchTest(){
        CustomerSearchData search = new CustomerSearchData();
        search.setDocument(StringUtils.EMPTY);
        search.setName(StringUtils.EMPTY);
        assertEquals(search.getDocument(),StringUtils.EMPTY);
        assertEquals(search.getName(),StringUtils.EMPTY);
        search.setDocument(null);
        search.setName(null);
        assertNull(search.getDocument());
        assertNull(search.getName());
    }
}
