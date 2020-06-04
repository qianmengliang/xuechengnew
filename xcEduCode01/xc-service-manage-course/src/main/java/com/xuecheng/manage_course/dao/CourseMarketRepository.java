package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CourseMarket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName CourseMarketRepository
 * @Description: TODO
 * @Author qianml
 * @Date 2020/3/31
 * @Version V1.0
 **/
public interface CourseMarketRepository extends JpaRepository<CourseMarket, String> {
}
