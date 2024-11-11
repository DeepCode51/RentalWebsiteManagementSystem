package com.dao;

import com.entity.ZaixianqianyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianqianyueVO;
import com.entity.view.ZaixianqianyueView;


/**
 * 在线签约
 * 
 * @author 
 * @email 
 * @date 2021-03-11 14:12:56
 */
public interface ZaixianqianyueDao extends BaseMapper<ZaixianqianyueEntity> {
	
	List<ZaixianqianyueVO> selectListVO(@Param("ew") Wrapper<ZaixianqianyueEntity> wrapper);
	
	ZaixianqianyueVO selectVO(@Param("ew") Wrapper<ZaixianqianyueEntity> wrapper);
	
	List<ZaixianqianyueView> selectListView(@Param("ew") Wrapper<ZaixianqianyueEntity> wrapper);

	List<ZaixianqianyueView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianqianyueEntity> wrapper);
	
	ZaixianqianyueView selectView(@Param("ew") Wrapper<ZaixianqianyueEntity> wrapper);
	
}
