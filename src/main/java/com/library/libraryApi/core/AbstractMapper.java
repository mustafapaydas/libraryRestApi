package com.library.libraryApi.core;

public abstract class AbstractMapper<DTO extends AbstractDTO,ENTITY extends AbstractEntity> {
    protected abstract DTO convertToDto(ENTITY entity);

    protected abstract ENTITY convertToEntity(DTO dto);

    public DTO toDTO(ENTITY entity){
        DTO dto = convertToDto(entity);
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }
    public ENTITY tooEntity(DTO dto){
        ENTITY entity = convertToEntity(dto);
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }
}
