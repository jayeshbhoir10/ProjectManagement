package com.v2Technologies.project_management_system.Service;

import com.v2Technologies.project_management_system.entity.GeneralAdmin;

public interface GeneralAdminService 
{
	GeneralAdmin findByAdminNameAndPassword(String adminName, String password);
}
