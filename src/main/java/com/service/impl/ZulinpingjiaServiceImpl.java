package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZulinpingjiaDao;
import com.entity.ZulinpingjiaEntity;
import com.service.ZulinpingjiaService;
import com.entity.vo.ZulinpingjiaVO;
import com.entity.view.ZulinpingjiaView;

@Service("zulinpingjiaService")
public class ZulinpingjiaServiceImpl extends ServiceImpl<ZulinpingjiaDao, ZulinpingjiaEntity> implements ZulinpingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZulinpingjiaEntity> page = this.selectPage(
                new Query<ZulinpingjiaEntity>(params).getPage(),
                new EntityWrapper<ZulinpingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZulinpingjiaEntity> wrapper) {
		  Page<ZulinpingjiaView> page =new Query<ZulinpingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZulinpingjiaVO> selectListVO(Wrapper<ZulinpingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZulinpingjiaVO selectVO(Wrapper<ZulinpingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZulinpingjiaView> selectListView(Wrapper<ZulinpingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZulinpingjiaView selectView(Wrapper<ZulinpingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
