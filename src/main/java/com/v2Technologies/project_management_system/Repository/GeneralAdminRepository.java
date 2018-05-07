package com.v2Technologies.project_management_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v2Technologies.project_management_system.entity.GeneralAdmin;

public interface GeneralAdminRepository extends JpaRepository<GeneralAdmin,java.lang.Long>
{	
	GeneralAdmin findByAdminNameAndPassword(String adminName, String password);
}
