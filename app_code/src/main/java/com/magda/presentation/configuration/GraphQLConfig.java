package com.magda.presentation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import com.magda.presentation.directives.AdminDirective;

@Configuration
public class GraphQLConfig {
  @Bean
  public RuntimeWiringConfigurer runtimeWiringConfigurer() {
    System.out.println("Graphql config ");

    return builder -> builder.directive("admin", new AdminDirective());
  }

}
