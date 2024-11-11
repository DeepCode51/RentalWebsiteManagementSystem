package com.entity.view;

import com.entity.ZaixianqianyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 在线签约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-11 14:12:56
 */
@TableName("zaixianqianyue")
public class ZaixianqianyueView  extends ZaixianqianyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianqianyueView(){
	}
 
 	public ZaixianqianyueView(ZaixianqianyueEntity zaixianqianyueEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianqianyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
