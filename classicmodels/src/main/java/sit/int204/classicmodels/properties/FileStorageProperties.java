package sit.int204.classicmodels.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix =  "file")
@Getter
@Setter

public class FileStorageProperties {
    private String uploadDir;
}
