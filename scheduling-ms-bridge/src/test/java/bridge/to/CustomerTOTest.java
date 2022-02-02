package bridge.to;

import com.scheduling.bridge.search.WorkSearchData;
import com.scheduling.bridge.to.CustomerTO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CustomerTOTest{

    @Test
    public void toTest(){

        CustomerTO to = new CustomerTO();
        to.setDocument(StringUtils.EMPTY);
        to.setId(StringUtils.EMPTY);
        to.setName(StringUtils.EMPTY);
        assertEquals(to.getDocument(),StringUtils.EMPTY);
        assertEquals(to.getId(),StringUtils.EMPTY);
        assertEquals(to.getName(),StringUtils.EMPTY);
        to.setDocument(null);
        to.setId(null);
        to.setName(null);
        assertNull(to.getDocument());
        assertNull(to.getId());
        assertNull(to.getName());
    }
}
