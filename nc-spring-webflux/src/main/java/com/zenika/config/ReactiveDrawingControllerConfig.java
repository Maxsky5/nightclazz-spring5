package com.zenika.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.zenika.controller.ReactiveDrawingController;
import com.zenika.controller.ReactiveDrawingControllerImpl;
import com.zenika.domain.Drawing;
import com.zenika.repository.DrawingRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

/**
 * This configuration creates a {@link ReactiveDrawingController} based on MongoDB.
 *
 * @author Guillaume DROUET
 */
@Configuration
public class ReactiveDrawingControllerConfig {

    /**
     * Builds a low level template that will be used to create tailable cursors MongoDB.
     *
     * @param mongoClient the mongo client
     * @return the new bean
     */
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient) {
        return new ReactiveMongoTemplate(mongoClient, "spring-reactive");
    }

    /**
     * Builds a {@link Drawing} controller with its dependencies.
     *
     * @param repository the CRUD repository injected to the controller
     * @return the new bean
     */
    @Bean
    public ReactiveDrawingController drawingController(DrawingRepository repository) {
        return new ReactiveDrawingControllerImpl(repository);
    }
}
