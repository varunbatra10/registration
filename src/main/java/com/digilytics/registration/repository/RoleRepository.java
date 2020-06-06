package com.digilytics.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digilytics.registration.model.Role;

@Repository(value = "roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query(value = "Select id, name from role where name=:roleName", nativeQuery = true)
	Role findByRoleName(@Param(value = "roleName") String roleName);
}
