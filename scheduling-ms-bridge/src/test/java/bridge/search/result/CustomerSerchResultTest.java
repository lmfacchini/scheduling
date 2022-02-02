package bridge.search.result;

import com.scheduling.bridge.search.result.CustomerSerchResult;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerSerchResultTest {


    @Test
    public void searchTest(){
        CustomerSerchResult result = new CustomerSerchResult(StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);
        assertEquals(result.getDocument(),StringUtils.EMPTY);
        assertEquals(result.getName(),StringUtils.EMPTY);
        assertEquals(result.getId(),StringUtils.EMPTY);
        result.setDocument(null);
        result.setName(null);
        result.setId(null);
        assertNull(result.getDocument());
        assertNull(result.getName());
        assertNull(result.getId());
    }

}
