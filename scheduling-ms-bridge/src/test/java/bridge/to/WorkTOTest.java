package bridge.to;

import com.scheduling.bridge.to.SchedulerTO;
import com.scheduling.bridge.to.WorkTO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WorkTOTest  {


    @Test
    public void toTest(){

        WorkTO to = new WorkTO();

        to.setId(StringUtils.EMPTY);
        to.setCode(StringUtils.EMPTY);
        to.setDescription(StringUtils.EMPTY);
        to.setValue(BigDecimal.ZERO);

        assertEquals(to.getId(),StringUtils.EMPTY);
        assertEquals(to.getCode(),StringUtils.EMPTY);
        assertEquals(to.getDescription(),StringUtils.EMPTY);
        assertEquals(to.getValue(),BigDecimal.ZERO);

        to.setId(null);
        to.setCode(null);
        to.setDescription(null);
        to.setValue(null);

        assertNull(to.getId());
        assertNull(to.getCode());
        assertNull(to.getDescription());
        assertNull(to.getValue());
    }
}
