package com.hcmute.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.hcmute.dao.ICategoryDAO;
import com.hcmute.model.CategoryModel;
import com.hcmute.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDAO;
	
//	public CategoryService() {
//		categoryDAO = new CategoryDAO();
//	}
	
	@Override
	public List<CategoryModel> findAll() {
		
		return categoryDAO.findAll();
	}

}
