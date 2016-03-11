package org.hungerhome.soccermanager.api.integration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.hungerhome.soccermanager.api.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@WebIntegrationTest({"server.port=8080"})
public class PostPlayerTest
{
    @Test
    @DatabaseSetup(value = {"/player.xml", "/team.xml", "/game.xml"})
    public void testSaveNewPlayerCreatesAllTeams()
    {
        String url = "http://localhost:8080/api/players";
        String jsonBody = "{\"name\": \"Test-Name\", \"age\": 20, \"email\": \"test@google.de\"}";

        get("/api/players").then()
            .body("_embedded.players.size()", equalTo(4));

        get("/api/teams").then()
            .body("_embedded.teams.size()", equalTo(4));

        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.setBody(jsonBody);
        specBuilder.setContentType("application/json; charset=UTF-8");

        RequestSpecification requestSpecfication = specBuilder.build();

        given()
            .spec(requestSpecfication)
        .when()
            .post(url);

        get("/api/players").then()
            .body("_embedded.players.size()", equalTo(5));

        get("/api/teams").then()
            .body("_embedded.teams.size()", equalTo(8));

    }
}
