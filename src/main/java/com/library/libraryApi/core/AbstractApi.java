package com.library.libraryApi.core;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public abstract class AbstractApi <DTO extends AbstractDTO,ENTITY extends AbstractEntity,ID>{
    protected abstract AbstractService<ID, DTO,ENTITY> getService();

    @GetMapping("/{id}")
    @Operation(
            summary = "ID ye göre kayıt çekmek için kullanılan servis",
            security = {@SecurityRequirement(name = "Token")})
    public ResponseEntity<DTO> getById(@PathVariable ID id) {
        return new ResponseEntity<>(getService().findById(id), HttpStatus.OK);
    }
    @PostMapping("/")
    @Operation(
            summary = "Kayıt eklemek için kullanılan servis",
            security = {@SecurityRequirement(name = "Token")})
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {
        return new ResponseEntity<>(getService().create(dto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Id'ye göre kayıt silmek için kullanılan servis",
            security = {@SecurityRequirement(name = "Token")})
    public ResponseEntity<DTO> deleteById(@PathVariable ID id) {
        getService().deleteById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
