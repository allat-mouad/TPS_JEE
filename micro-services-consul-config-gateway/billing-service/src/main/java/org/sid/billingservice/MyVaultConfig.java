package org.sid.billingservice;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//generaly used for secrests such as passwords credit card cridentials ...
@Component
@ConfigurationProperties(prefix = "user")
@Data
public class MyVaultConfig {
    private String username;
    private String password;
}
