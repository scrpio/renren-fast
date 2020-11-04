package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ProfileEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 个人资料
 * 
 * @author lizhenrong
 * @email 798776228@qq.com
 * @date 2020-11-03 18:21:45
 */
@Mapper
public interface ProfileDao extends BaseMapper<ProfileEntity> {
	
}
