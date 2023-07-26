package com.library.libraryApi.core.Abstract;

import com.library.libraryApi.configuration.AuthenticationLogic;
import org.springframework.data.jpa.repository.JpaRepository;


public abstract class AbstractLogic<ID,ENTITY> extends AuthenticationLogic implements ILogic<ENTITY,ID>{
    //    @Autowired protected
    protected abstract JpaRepository<ENTITY,ID> getRepository();
    public  ENTITY create(ENTITY entity){
        if (entity instanceof AbstractEntity){
            AbstractEntity entity1 = (AbstractEntity) entity;
            ((AbstractEntity) entity).setCreatedBy(getCurrentUserId());
        }
        return getRepository().saveAndFlush(entity);
    }
    public ENTITY update(ENTITY entity){
        if (entity instanceof AbstractEntity){
            AbstractEntity entity1 = (AbstractEntity) entity;
            ((AbstractEntity) entity).setUpdatedBy(getCurrentUserId());
        }
        return getRepository().saveAndFlush(entity);
    }
    public ENTITY findById(ID id){
        return getRepository().findById(id).get();
    }

    public void delete(ID id){
        getRepository().deleteById(id);
    }
}
