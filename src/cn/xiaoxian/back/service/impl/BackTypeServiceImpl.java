package cn.xiaoxian.back.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.back.service.IBackTypeService;
import cn.xiaoxian.dao.ITypeDAO;
import cn.xiaoxian.pojo.Type;
//服务层实现类
@Service
public class BackTypeServiceImpl implements IBackTypeService {
    private ITypeDAO typeDAO;
    @Resource(name="typeDAOImpl")
	public void setTypeDAO(ITypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}
	@Override
	public boolean insert(Type vo) throws Exception {
		return this.typeDAO.doCreate(vo);
	}
	@Override
	public boolean update(Type vo) throws Exception {
		return this.typeDAO.doUpdate(vo);
	}
	@Override
	public boolean remove(Integer id) throws Exception {
		return this.typeDAO.doRemove(id);
	}
	@Override
	public List<Type> list() throws Exception {
		return this.typeDAO.findAll();
	}
	@Override
	public Type findById(Integer id) throws Exception {
		return this.typeDAO.findById(id);
	}

	
}
