package com.user.User.swaggerconfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	// from APiInfo documentation

	public static final Contact DEFAULT_CONTACT = new Contact("Sri Ram Ede", "https://www.linkedin.com/in/sri-ram-ede",
			"sriramede.in@gmail.com");

	private static final ApiInfo Customize_API_Info = new ApiInfo("User API ",
			" User Api Documentation find Readme.md On git", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

	private static final Set<String> Default_produces_Consumes = new HashSet<>(
			Arrays.asList("application/json", "application/xml"));

	// follow https://springfox.github.io/springfox/docs/current/ documentation to
	// configure swagger

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(Customize_API_Info)
				.produces(Default_produces_Consumes)
				.consumes(Default_produces_Consumes);
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
	}
}
