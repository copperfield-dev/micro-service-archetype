#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by copperfield @ 2019-07-15 20:12
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                   .apiInfo(apiInfo())
                   .select()  // 选择那些路径和API会生成document
                   .apis(RequestHandlerSelectors.basePackage("${package}.controller"))
                   .paths(PathSelectors.any()) // 对所有路径进行监控
                   .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                   .title("More")
                   .description("相关wiki: ")
                   .contact(new Contact("Copperfield", "", "xwhfcenter@gmail.com"))
                   .version("v1")
                   .build();
    }
}
