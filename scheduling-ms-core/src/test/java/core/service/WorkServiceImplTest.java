package core.service;

import com.scheduling.bridge.to.WorkTO;
import com.scheduling.core.repository.WorkRepository;
import com.scheduling.core.service.WorkServiceImpl;
import com.scheduling.domain.vo.WorkVO;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WorkServiceImplTest {


    @Test
    public void createTest(){
        WorkRepository repository = mock(WorkRepository.class);
        WorkVO vo = new WorkVO();

        vo.setDescription("dddddddddddddddd");
        vo.setValue(BigDecimal.ZERO);
        vo.setCode("tttttttttttttttt");


        expect(repository.findAll(anyObject(Example.class))).andReturn(Collections.singletonList(vo));

        expect(repository.save(anyObject(WorkVO.class))).andReturn(vo);
        Optional<WorkVO> optional = Optional.of(vo);
        expect(repository.findById(anyObject(ObjectId.class))).andReturn(optional);
        repository.delete(anyObject(WorkVO.class));




        replay(repository);




        WorkServiceImpl service = new WorkServiceImpl(repository);

        WorkTO to = new WorkTO();


        to.setDescription("vvvvvvvvvvvvv");
        to.setValue(BigDecimal.TEN);
        to.setCode("ccccccccfffffvvvvvs");

        to = service.create(to);
        assertNotNull(to);
        assertEquals(to.getValue(), BigDecimal.TEN);


    }


    @Test
    public void updateTest(){

        WorkRepository repository = mock(WorkRepository.class);
        WorkVO vo = new WorkVO();

        vo.setDescription("dddddddddddddddd");
        vo.setValue(BigDecimal.ZERO);
        vo.setCode("tttttttttttttttt");


        expect(repository.findAll(anyObject(Example.class))).andReturn(Collections.singletonList(vo));

        expect(repository.save(anyObject(WorkVO.class))).andReturn(vo);
        Optional<WorkVO> optional = Optional.of(vo);
        expect(repository.findById(anyObject(ObjectId.class))).andReturn(optional);
        repository.delete(anyObject(WorkVO.class));




        replay(repository);




        WorkServiceImpl service = new WorkServiceImpl(repository);

        WorkTO to = new WorkTO();


        to.setDescription("vvvvvvvvvvvvv");
        to.setValue(BigDecimal.TEN);
        to.setId(new ObjectId().toHexString());
        to.setCode("ccccccccfffffvvvvvs");

        to = service.update(to);
        assertNotNull(to);
        assertEquals(to.getValue(), BigDecimal.TEN);
    }

    @Test
    public void deleteTest(){
        WorkRepository repository = mock(WorkRepository.class);
        WorkVO vo = new WorkVO();

        vo.setDescription("dddddddddddddddd");
        vo.setValue(BigDecimal.ZERO);
        vo.setCode("tttttttttttttttt");


        expect(repository.findAll(anyObject(Example.class))).andReturn(Collections.singletonList(vo));

        expect(repository.save(anyObject(WorkVO.class))).andReturn(vo);
        Optional<WorkVO> optional = Optional.of(vo);
        expect(repository.findById(anyObject(ObjectId.class))).andReturn(optional);
        repository.delete(anyObject(WorkVO.class));




        replay(repository);




        WorkServiceImpl service = new WorkServiceImpl(repository);


        WorkTO to = service.delete(new ObjectId().toHexString());
        assertNotNull(to);
        assertEquals(to.getValue(), BigDecimal.ZERO);

    }
}
