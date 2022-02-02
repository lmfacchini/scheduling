package bridge;

import com.scheduling.bridge.BusinessException;
import com.scheduling.bridge.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BusinessExceptionTest {


    @Test
    public void exceptionTest(){

        BusinessException exception = new BusinessException("B00001");
        assertNotNull(exception.getMessage());
        assertEquals(exception.getMessage(), "B00001");

        ServiceException serviceException1 = new ServiceException();
        assertNull(serviceException1.getCause());
        assertNull(serviceException1.getMessage());


        ServiceException serviceException4 = new ServiceException("B00002");
        assertNull(serviceException4.getCause());
        assertNotNull(serviceException4.getMessage());
        assertEquals(serviceException4.getMessage(), "B00002");


        ServiceException serviceException2 = new ServiceException("B00003", exception);
        assertNotNull(serviceException2.getCause());
        assertNotNull(serviceException2.getMessage());
        assertEquals(serviceException2.getMessage(), "B00003");




        ServiceException serviceException3 = new ServiceException(exception);
        assertNotNull(serviceException3.getCause());
        assertNotNull(serviceException3.getMessage());



        ServiceException serviceException5 = new ServiceException("B00004", exception, false, false);
        assertNotNull(serviceException5.getCause());
        assertNotNull(serviceException5.getMessage());
        assertEquals(serviceException5.getMessage(), "B00004");

    }

}
