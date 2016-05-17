package com.Hospital.core.modeleimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Hospital.core.entity.manager;
import com.Hospital.core.model.exampleModel;
import com.Hospital.core.serviceimp.managerServiceImp;
@Component
public class exampleModelImp implements exampleModel<manager> {
    @Autowired
	private managerServiceImp managerServiceImp;
	@Override
	public List<manager> getBeans() {
		// TODO Auto-generated method stub
		return managerServiceImp.getManagers();
	}

}
