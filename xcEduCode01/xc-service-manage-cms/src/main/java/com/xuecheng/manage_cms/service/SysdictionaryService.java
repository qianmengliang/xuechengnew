package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage_cms.dao.SysDictionaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysdictionaryService
 * @Description: TODO
 * @Author qianml
 * @Date 2020/3/31
 * @Version V1.0
 **/
@Service
public class SysdictionaryService {
    @Autowired
    SysDictionaryDao sysDictionaryDao;

    /**
     * /根据字典分类type查询字典信息
     * @param type
     * @return
     */
    public SysDictionary findDictionaryByType(String type){
        return sysDictionaryDao.findBydType(type);
    }
}
