package com.xuecheng.manage_cms.web.controller;

import com.xuecheng.api.cms.SysDictionaryControllerApi;
import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage_cms.service.SysdictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysDictionaryController
 * @Description: TODO
 * @Author qianml
 * @Date 2020/3/31
 * @Version V1.0
 **/
@RestController
@RequestMapping("/sys/dictionary")
public class SysDictionaryController implements SysDictionaryControllerApi {
    @Autowired
    SysdictionaryService sysdictionaryService;

    /**
     * /根据字典分类id查询字典信息
     * @param type
     * @return
     */
    @Override
    @GetMapping("/get/{type}")
    public SysDictionary getByType(@PathVariable("type")String type) {
        return sysdictionaryService.findDictionaryByType(type);
    }
}
