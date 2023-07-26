package com.magda.presentation.controllers;

// import graphql.kickstart.tools.GraphQLSubscriptionResolver;
// import org.reactivestreams.Publisher;
// import org.springframework.stereotype.Component;

// import com.magda.presentation.models.Comment;

// import reactor.core.publisher.Flux;
// import reactor.core.publisher.FluxSink;

// import java.time.Duration;
// import java.time.LocalDateTime;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Random;
// import java.util.Set;
// import java.util.concurrent.ConcurrentHashMap;
// import java.util.concurrent.ConcurrentMap;

// public class SubscriptionController implements GraphQLSubscriptionResolver {

// private final ConcurrentMap<Integer, Set<FluxSink<Object>>> subscribers = new
// ConcurrentHashMap<Integer, Set<FluxSink<Object>>>();

// public Publisher<List<Comment>> commentAdded(int postId) {
// if (subscribers.get(postId) == null) {
// subscribers.put(postId, new HashSet<FluxSink<Object>>());
// }
// return Flux.create(
// subscriber -> subscribers.get(postId).add(subscriber.onDispose(() ->
// subscribers.remove(postId, subscriber))),
// FluxSink.OverflowStrategy.LATEST);
// }
// }