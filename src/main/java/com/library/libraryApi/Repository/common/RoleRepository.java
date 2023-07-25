package com.library.libraryApi.Repository.common;

import com.library.libraryApi.Entity.common.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "select * from tbl_role tr where title in :roleList",nativeQuery = true)
    List<Role> getRolesByTitles(@Param("roleList") Set<String> roles);
}
