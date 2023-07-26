package com.library.libraryApi.core;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMapper<T,DTO extends AbstractDTO<T>,ENTITY extends AbstractEntity<T>> {
    protected abstract DTO convertToDto(ENTITY entity);

    protected abstract ENTITY convertToEntity(DTO dto);
    private AbstractMapper<?, ?, ?> parent;
    private Integer level;
    public AbstractMapper(Class<DTO> dtoClazz, Class<ENTITY> entityClazz) {
        parent = this;
    }

    public AbstractMapper(
            AbstractMapper<?, ?, ?> parent, Class<DTO> dtoClazz, Class<ENTITY> entityClazz,Integer level) {
        this(dtoClazz, entityClazz);
        this.parent = parent != null ? parent : this;
        this.level = level;
    }
    public AbstractMapper(
            AbstractMapper<?, ?, ?> parent, Class<DTO> dtoClazz, Class<ENTITY> entityClazz) {
        this(dtoClazz, entityClazz);
        this.parent = parent != null ? parent : this;
    }
    public AbstractMapper(){}


    public DTO toDTO(ENTITY entity){
        DTO dto = convertToDto(entity);
        dto.setId(entity.getId());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }
    public ENTITY toEntity(DTO dto){
        ENTITY entity = convertToEntity(dto);
        entity.setId(dto.getId());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    public List<ENTITY> toListEntity(List<DTO> dtos){
        return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
    }
    public List<DTO> toListDTO(List<ENTITY> entities){
        return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
    }
}
