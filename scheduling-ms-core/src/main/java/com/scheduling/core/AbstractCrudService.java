package com.scheduling.core;

import com.scheduling.bridge.BusinessException;
import com.scheduling.bridge.TransactionObject;
import com.scheduling.domain.Domain;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public abstract class AbstractCrudService<TO extends TransactionObject, SD, RS, VO extends Domain, REP extends MongoRepository<VO,ObjectId>> {


    protected final REP repository;

    protected AbstractCrudService(REP repository) {
        this.repository = repository;
    }

    public TO create(TO to){

        if(to == null){
            throw new BusinessException("MB00000001");
        }else if(to.getId() != null){
            throw new BusinessException("MB00000002");
        }

        VO vo = parse(to);
        repository.save(vo);

        to = parse(vo);
        return to;

    }

    protected abstract VO parse(TO to);


    protected abstract TO parse(VO vo);




    public TO update(TO to){
        if(to == null){
            throw new BusinessException("MB00000001");
        }else if(to.getId() == null){
            throw new BusinessException("MB00000003");
        }




        ObjectId id = new ObjectId(to.getId());

        Optional<VO> optionalVo = repository.findById(id);
        VO vo;
        if(optionalVo.isPresent()){

            vo = optionalVo.get();
        }else{
            throw new BusinessException("MB00000004");
        }

        vo = parse(to);
        vo.setId(id);
        repository.save(vo);

        to = parse(vo);
        return to;
    }

    public TO delete(String id){

        Optional<VO> optionalVo = repository.findById(new ObjectId(id));
        VO vo;
        if(optionalVo.isPresent()){

            vo = optionalVo.get();
        }else{
            throw new BusinessException("MB00000004");
        }
        repository.delete(vo);
        return parse(vo);
    }


}
