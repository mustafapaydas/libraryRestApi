package com.library.libraryApi.core;

public abstract class AbstractMapper<T,DTO extends AbstractDTO<T>,ENTITY extends AbstractEntity<T>> {
    protected abstract DTO convertToDto(ENTITY entity);

    protected abstract ENTITY convertToEntity(DTO dto);

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
}
