package core.service;

import com.scheduling.bridge.to.CustomerTO;
import com.scheduling.core.repository.CustomerRepository;
import com.scheduling.core.service.CustomerServiceImpl;
import com.scheduling.domain.vo.CustomerVO;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;

import java.util.Collections;
import java.util.Optional;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerServiceImplTest {


    @Test
    public void createTest(){
        CustomerRepository repository = mock(CustomerRepository.class);
        CustomerVO vo = new CustomerVO();
        vo.setDocument("37845322334");
        vo.setId(new ObjectId());
        vo.setName("José Amaral");
        expect(repository.findAll(anyObject(Example.class))).andReturn(Collections.singletonList(vo));
        expect(repository.findByDocument("37845322334")).andReturn(vo);
        expect(repository.save(anyObject(CustomerVO.class))).andReturn(vo);
        Optional<CustomerVO> optional = Optional.of(vo);
        expect(repository.findById(anyObject(ObjectId.class))).andReturn(optional);
        repository.delete(anyObject(CustomerVO.class));

        replay(repository);




        CustomerServiceImpl service = new CustomerServiceImpl(repository);

        CustomerTO to = new CustomerTO();
        to.setDocument("333344455");
        to.setName("Maria Fernanda");
        to = service.create(to);
        assertNotNull(to);
    }


    @Test
    public void updateTest(){

        CustomerRepository repository = mock(CustomerRepository.class);
        CustomerVO vo = new CustomerVO();
        vo.setDocument("37845322334");
        vo.setId(new ObjectId());
        vo.setName("José Amaral");
        expect(repository.findAll(anyObject(Example.class))).andReturn(Collections.singletonList(vo));
        expect(repository.findByDocument("37845322334")).andReturn(vo);
        expect(repository.save(anyObject(CustomerVO.class))).andReturn(vo);
        Optional<CustomerVO> optional = Optional.of(vo);
        expect(repository.findById(anyObject(ObjectId.class))).andReturn(optional);
        repository.delete(anyObject(CustomerVO.class));

        replay(repository);




        CustomerServiceImpl service = new CustomerServiceImpl(repository);

        CustomerTO to = new CustomerTO();
        to.setDocument("37845322334");
        to.setName("Maria Fernanda");
        to.setId(new ObjectId().toHexString());
        to = service.update(to);
        assertNotNull(to);
        assertEquals(to.getName(), "Maria Fernanda");
    }

    @Test
    public void deleteTest(){
        CustomerRepository repository = mock(CustomerRepository.class);
        CustomerVO vo = new CustomerVO();
        vo.setDocument("37845322334");
        vo.setId(new ObjectId());
        vo.setName("José Amaral");
        expect(repository.findAll(anyObject(Example.class))).andReturn(Collections.singletonList(vo));
        expect(repository.findByDocument("37845322334")).andReturn(vo);
        expect(repository.save(anyObject(CustomerVO.class))).andReturn(vo);
        Optional<CustomerVO> optional = Optional.of(vo);
        expect(repository.findById(anyObject(ObjectId.class))).andReturn(optional);
        repository.delete(anyObject(CustomerVO.class));

        replay(repository);




        CustomerServiceImpl service = new CustomerServiceImpl(repository);


        CustomerTO to = service.delete(new ObjectId().toHexString());
        assertNotNull(to);
        assertEquals(to.getName(), "José Amaral");
        assertEquals(to.getDocument(), "37845322334");
    }
}
