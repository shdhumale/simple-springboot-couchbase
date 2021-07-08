package com.siddhu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.mapping.CouchbaseMappingContext;


@Configuration

public class MyCouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "admin";
    }

    @Override
    public String getPassword() {
        return "admin1";
    }

    @Override
    public String getBucketName() {
        return "siddhu";
    }
    

}
