package bridge.to;

import com.scheduling.bridge.to.CustomerTO;
import com.scheduling.bridge.to.SchedulerTO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SchedulerTOTest   {

    @Test
    public void toTest(){

        SchedulerTO to = new SchedulerTO();
        LocalDateTime now = LocalDateTime.now();
        to.setDateTime(now);
        to.setId(StringUtils.EMPTY);
        to.setCustomerDocument(StringUtils.EMPTY);
        to.setCodeWork(StringUtils.EMPTY);
        to.setNote(StringUtils.EMPTY);

        assertEquals(to.getDateTime(),now);
        assertEquals(to.getCustomerDocument(),StringUtils.EMPTY);
        assertEquals(to.getCodeWork(),StringUtils.EMPTY);
        assertEquals(to.getId(),StringUtils.EMPTY);
        assertEquals(to.getNote(),StringUtils.EMPTY);
        to.setDateTime(null);
        to.setId(null);
        to.setCustomerDocument(null);
        to.setCodeWork(null);
        to.setNote(null);
        assertNull(to.getDateTime());
        assertNull(to.getCustomerDocument());
        assertNull(to.getCodeWork());
        assertNull(to.getId());
        assertNull(to.getNote());
    }
}
