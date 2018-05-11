package com.v2Technologies.project_management_system.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2Technologies.project_management_system.Repository.GeneralAdminRepository;
import com.v2Technologies.project_management_system.entity.GeneralAdmin;

@Service
@Transactional
public class GeneralAdminServiceImpl implements GeneralAdminService
{

	@Autowired
	GeneralAdminRepository generaladminRepo;
	
	@Override
	public GeneralAdmin findByAdminNameAndPassword(String adminName, String password) {
		// TODO Auto-generated method stub
		return generaladminRepo.findByAdminNameAndPassword(adminName, password);
	}

}
