package com.magda.presentation.directives;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetcherFactories;
import graphql.schema.FieldCoordinates;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLFieldsContainer;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;

public class AdminDirective implements SchemaDirectiveWiring {
  @Override
  public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> environment) {

    GraphQLFieldDefinition field = environment.getElement();
    GraphQLFieldsContainer parentType = environment.getFieldsContainer();
    DataFetcher originalFetcher = environment.getCodeRegistry().getDataFetcher(parentType, field);

    DataFetcher dataFetcher = DataFetcherFactories.wrapDataFetcher(originalFetcher,
        ((dataFetchingEnvironment, value) -> {

          String authRole = (String) dataFetchingEnvironment.getGraphQlContext().getOrDefault("authRole", "guest");
          System.out.println("AUTHROLE: " + authRole);

          if (authRole.equals("admin")) {
            return value;
          } else {
            return null;
          }
        }));

    FieldCoordinates coordinates = FieldCoordinates.coordinates(parentType, field);
    environment.getCodeRegistry().dataFetcher(coordinates, dataFetcher);

    return field;
  }

}
