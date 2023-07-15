package com.steven.cns.minio.spring.boot.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: steven
 * @date: 2023/7/7 01:04
 */
@Data
@ConfigurationProperties(prefix = MinIOProperties.PREFIX)
public class MinIOProperties {
    public static final String PREFIX = "cns.minio";

    private String accessKey;

    private String secretKey;

    private String endpoint;

}
