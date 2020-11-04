package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ProfileEntity;

import java.util.Map;

/**
 * 个人资料
 *
 * @author lizhenrong
 * @email 798776228@qq.com
 * @date 2020-11-03 18:21:45
 */
public interface ProfileService extends IService<ProfileEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

