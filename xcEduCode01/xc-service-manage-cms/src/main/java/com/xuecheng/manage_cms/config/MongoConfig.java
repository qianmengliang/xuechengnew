package com.xuecheng.manage_cms.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : MongoConfig  //类名
 * @Description : mongodb配置类  //描述
 * @Author : qianml  //作者
 * @Date: 2020-01-21 16:03  //时间
 * @Version: 1.0
 */
@Configuration
public class MongoConfig {
     @Value("${spring.data.mongodb.database}")
    String db;
    @Bean
    public GridFSBucket getGridFSBucket(MongoClient mongoClient){
        MongoDatabase database = mongoClient.getDatabase(db);
        GridFSBucket bucket = GridFSBuckets.create(database);
        return bucket;
    }
}
