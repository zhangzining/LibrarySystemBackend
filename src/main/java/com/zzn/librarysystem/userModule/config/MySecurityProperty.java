package com.zzn.librarysystem.userModule.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "security.config")
public class MySecurityProperty {
    private Integer accessTokenValidatePeriod;
    private Integer refreshTokenValidatePeriod;
    private String publicKeyPath;
    private String privateKeyPath;
}
