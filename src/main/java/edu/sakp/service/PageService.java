package edu.sakp.service;


import edu.sakp.model.ResultMap;
import edu.sakp.pojo.Page;

import java.util.List;

public interface PageService {
	public List<Page> getAllPageByRoleId(Integer roleId);

	public List<Page> getAllPage();

	public ResultMap updatePageById(Page page);

	public Page addPage(Page page);

	public ResultMap delPageById(Integer id);

	public List<Page> getAllRolePageByUserId(String userId);
}
