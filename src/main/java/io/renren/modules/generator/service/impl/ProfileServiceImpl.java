package io.renren.modules.generator.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ProfileDao;
import io.renren.modules.generator.entity.ProfileEntity;
import io.renren.modules.generator.service.ProfileService;


@Service("profileService")
public class ProfileServiceImpl extends ServiceImpl<ProfileDao, ProfileEntity> implements ProfileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String) params.get("name");
        IPage<ProfileEntity> page = this.page(
                new Query<ProfileEntity>().getPage(params),
                new QueryWrapper<ProfileEntity>()
                        .like(StringUtils.isNotBlank(name), "name", name)
        );

        return new PageUtils(page);
    }

}