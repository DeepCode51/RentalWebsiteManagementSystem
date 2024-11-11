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


import com.dao.ZaixianqianyueDao;
import com.entity.ZaixianqianyueEntity;
import com.service.ZaixianqianyueService;
import com.entity.vo.ZaixianqianyueVO;
import com.entity.view.ZaixianqianyueView;

@Service("zaixianqianyueService")
public class ZaixianqianyueServiceImpl extends ServiceImpl<ZaixianqianyueDao, ZaixianqianyueEntity> implements ZaixianqianyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianqianyueEntity> page = this.selectPage(
                new Query<ZaixianqianyueEntity>(params).getPage(),
                new EntityWrapper<ZaixianqianyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianqianyueEntity> wrapper) {
		  Page<ZaixianqianyueView> page =new Query<ZaixianqianyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixianqianyueVO> selectListVO(Wrapper<ZaixianqianyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianqianyueVO selectVO(Wrapper<ZaixianqianyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianqianyueView> selectListView(Wrapper<ZaixianqianyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianqianyueView selectView(Wrapper<ZaixianqianyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
