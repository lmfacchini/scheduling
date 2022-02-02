package core.service;

import com.scheduling.bridge.service.CustomerService;
import com.scheduling.bridge.service.WorkService;
import com.scheduling.bridge.to.CustomerTO;
import com.scheduling.bridge.to.SchedulerTO;
import com.scheduling.bridge.to.WorkTO;
import com.scheduling.core.repository.CustomerRepository;
import com.scheduling.core.repository.SchedulerRepository;
import com.scheduling.core.service.CustomerServiceImpl;
import com.scheduling.core.service.SchedulerServiceImpl;
import com.scheduling.domain.vo.CustomerVO;
import com.scheduling.domain.vo.SchedulerVO;
import com.scheduling.domain.vo.WorkVO;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SchedulerServiceImplTest {


    @Test
    public void createTest(){

        SchedulerRepository repository = mock(SchedulerRepository.class);
        SchedulerVO vo = new SchedulerVO();
        vo.setCustomerDocument("1231241454");
        vo.setId(new ObjectId());
        vo.setDateTime(LocalDateTime.now());
        vo.setCodeWork("12345");
        vo.setNote("xxxxxxxxxxx");
        expect(repository.findAll(anyObject(Example.class))).andReturn(Collections.singletonList(vo));

        expect(repository.save(anyObject(SchedulerVO.class))).andReturn(vo);
        Optional<SchedulerVO> optional = Optional.of(vo);
        expect(repository.findById(anyObject(ObjectId.class))).andReturn(optional);
        repository.delete(anyObject(SchedulerVO.class));

        WorkTO work = new WorkTO();
        WorkService workService = mock(WorkService.class);
        expect(workService.findByCode("12345")).andReturn(work);


        CustomerTO customer = new CustomerTO();
        CustomerService customerService = mock(CustomerService.class);
        expect(customerService.findByDocument("1231241454")).andReturn(customer);



        replay(repository, workService, customerService);




        SchedulerServiceImpl service = new SchedulerServiceImpl(repository, workService, customerService);

        SchedulerTO to = new SchedulerTO();
        to.setCustomerDocument("1231241454");

        to.setDateTime(LocalDateTime.now());
        to.setCodeWork("12345");
        to.setNote("xxxxxxxxxxx");
        to = service.create(to);
        assertNotNull(to);

    }


    @Test
    public void updateTest(){
        SchedulerRepository repository = mock(SchedulerRepository.class);
        SchedulerVO vo = new SchedulerVO();
        vo.setCustomerDocument("1231241454");
        vo.setId(new ObjectId());
        vo.setDateTime(LocalDateTime.now());
        vo.setCodeWork("12345");
        vo.setNote("xxxxxxxxxxx");
        expect(repository.findAll(anyObject(Example.class))).andReturn(Collections.singletonList(vo));

        expect(repository.save(anyObject(SchedulerVO.class))).andReturn(vo);
        Optional<SchedulerVO> optional = Optional.of(vo);
        expect(repository.findById(anyObject(ObjectId.class))).andReturn(optional);
        repository.delete(anyObject(SchedulerVO.class));

        WorkTO work = new WorkTO();
        WorkService workService = mock(WorkService.class);
        expect(workService.findByCode("12345")).andReturn(work);


        CustomerTO customer = new CustomerTO();
        CustomerService customerService = mock(CustomerService.class);
        expect(customerService.findByDocument("1231241454")).andReturn(customer);



        replay(repository, workService, customerService);




        SchedulerServiceImpl service = new SchedulerServiceImpl(repository, workService, customerService);

        SchedulerTO to = new SchedulerTO();
        to.setCustomerDocument("1231241454");

        to.setDateTime(LocalDateTime.now());
        to.setCodeWork("12345");
        to.setNote("yyyyyyyyy");
        to.setId(new ObjectId().toHexString());
        to = service.update(to);
        assertNotNull(to);
        assertEquals(to.getNote(), "yyyyyyyyy");
    }

    @Test
    public void deleteTest(){

        SchedulerRepository repository = mock(SchedulerRepository.class);
        SchedulerVO vo = new SchedulerVO();
        vo.setCustomerDocument("1231241454");
        vo.setId(new ObjectId());
        vo.setDateTime(LocalDateTime.now());
        vo.setCodeWork("12345");
        vo.setNote("xxxxxxxxxxx");
        expect(repository.findAll(anyObject(Example.class))).andReturn(Collections.singletonList(vo));

        expect(repository.save(anyObject(SchedulerVO.class))).andReturn(vo);
        Optional<SchedulerVO> optional = Optional.of(vo);
        expect(repository.findById(anyObject(ObjectId.class))).andReturn(optional);
        repository.delete(anyObject(SchedulerVO.class));

        WorkTO work = new WorkTO();
        WorkService workService = mock(WorkService.class);
        expect(workService.findByCode("12345")).andReturn(work);


        CustomerTO customer = new CustomerTO();
        CustomerService customerService = mock(CustomerService.class);
        expect(customerService.findByDocument("1231241454")).andReturn(customer);



        replay(repository, workService, customerService);




        SchedulerServiceImpl service = new SchedulerServiceImpl(repository, workService, customerService);


        SchedulerTO to = service.delete(new ObjectId().toHexString());
        assertNotNull(to);
        assertEquals(to.getNote(), "xxxxxxxxxxx");
    }
}
