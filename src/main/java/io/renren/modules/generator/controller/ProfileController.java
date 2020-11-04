package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ProfileEntity;
import io.renren.modules.generator.service.ProfileService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 个人资料
 *
 * @author lizhenrong
 * @email 798776228@qq.com
 * @date 2020-11-03 18:21:45
 */
@RestController
@RequestMapping("generator/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:profile:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = profileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:profile:info")
    public R info(@PathVariable("id") Integer id){
		ProfileEntity profile = profileService.getById(id);

        return R.ok().put("profile", profile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:profile:save")
    public R save(@RequestBody ProfileEntity profile){
		profileService.save(profile);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:profile:update")
    public R update(@RequestBody ProfileEntity profile){
		profileService.updateById(profile);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:profile:delete")
    public R delete(@RequestBody Integer[] ids){
		profileService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
