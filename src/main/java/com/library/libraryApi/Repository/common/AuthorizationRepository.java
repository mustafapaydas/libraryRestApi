package com.library.libraryApi.Repository.common;

import com.library.libraryApi.Entity.common.AuthorizationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorizationRepository extends JpaRepository<AuthorizationCode,Integer> {
    @Query(value = "select tac.authorization_code from tbl_authorization_code_role_relation tacrr " +
            " join tbl_role tr ON tacrr.role_id = tr.id and tr.title in :roles  "+
            " join tbl_authorization_code tac ON tac.id = code_id ",nativeQuery = true)
    List<String> getAuthorizationCodesByRoles(@Param("roles") List<String> roles);
}
