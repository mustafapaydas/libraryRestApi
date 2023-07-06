package com.library.libraryApi.core;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractLogic<ENTITY,ID>{
//    @Autowired protected
    protected abstract JpaRepository<ENTITY, ID> getRepository();

    public  ENTITY create(ENTITY entity){
        return getRepository().saveAndFlush(entity);
    }
    public ENTITY update(ENTITY entity){
        return getRepository().saveAndFlush(entity);
    }
    public ENTITY findById(ID id){
        return getRepository().findById(id).get();
    }
    public void delete(ID id){
        getRepository().deleteById(id);
    }
}
