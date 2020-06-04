package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName : CmsPageRepository  //类名
 * @Description : CmsPageDao层  //描述
 * @Author : qianml  //作者
 * @Date: 2020-02-21 15:54  //时间
 * @Version: 1.0
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {

}
