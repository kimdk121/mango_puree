package com.mangopuree.support.config;

import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class HadoopConfig {

    @Value("${hadoop.hdfs.url}")
    private String url;

    @Bean
    public org.apache.hadoop.conf.Configuration hadoopConfiguration() {
        org.apache.hadoop.conf.Configuration configuration = new org.apache.hadoop.conf.Configuration();
        configuration.set("fs.defaultFS", url);
        configuration.set("dfs.client.use.datanode.hostname", "true");
        return configuration;
    }

    @Bean
    public FileSystem fileSystem(org.apache.hadoop.conf.Configuration configuration) throws IOException {
        return  FileSystem.get(configuration);
    }
}
