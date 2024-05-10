package com.modulus;

import io.gatling.javaapi.core.Simulation;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class TestSimulation extends Simulation {
    {
        setUp(
                scenario("Test scenario - google").exec(
                        http("Google Homepage").get("https://google.com")
                ).injectOpen(
                        rampUsers(10)
                                .during(Duration.ofSeconds(10))
                )
        );
    }
}
