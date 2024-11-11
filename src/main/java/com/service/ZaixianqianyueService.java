package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianqianyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianqianyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianqianyueView;


/**
 * 在线签约
 *
 * @author 
 * @email 
 * @date 2021-03-11 14:12:56
 */
public interface ZaixianqianyueService extends IService<ZaixianqianyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianqianyueVO> selectListVO(Wrapper<ZaixianqianyueEntity> wrapper);
   	
   	ZaixianqianyueVO selectVO(@Param("ew") Wrapper<ZaixianqianyueEntity> wrapper);
   	
   	List<ZaixianqianyueView> selectListView(Wrapper<ZaixianqianyueEntity> wrapper);
   	
   	ZaixianqianyueView selectView(@Param("ew") Wrapper<ZaixianqianyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianqianyueEntity> wrapper);
   	
}

