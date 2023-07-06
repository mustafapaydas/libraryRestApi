package com.library.libraryApi.core;

public abstract class AbstractService<ID, DTO extends AbstractDTO, ENTITY extends AbstractEntity>{
    protected abstract AbstractLogic<ID, ENTITY> getLogic();

    protected abstract AbstractMapper<DTO, ENTITY> getMapper();

    public DTO create(DTO dto){
        return getMapper().toDTO(getLogic().create(getMapper().convertToEntity(dto)));
    }
    public DTO update(DTO dto){
        return getMapper().toDTO(getLogic().update(getMapper().convertToEntity(dto)));
    }
    public void delete(ID id){
        getLogic().delete(id);
    }
    public DTO findById(ID id){
        return getMapper().toDTO(getLogic().findById(id));
    }
}
