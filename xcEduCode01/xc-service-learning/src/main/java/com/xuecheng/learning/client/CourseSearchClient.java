package com.xuecheng.learning.client;

import com.xuecheng.framework.domain.course.TeachplanMediaPub;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName CourseSearchClient
 * @Description: TODO
 * @Author qianml
 * @Date 2020/7/19
 * @Version V1.0
 **/
@FeignClient(value = "xc-service-search")
public interface CourseSearchClient {

    @GetMapping(value="/getmedia/{teachplanId}")
    public TeachplanMediaPub getmedia(@PathVariable("teachplanId") String teachplanId);
}
