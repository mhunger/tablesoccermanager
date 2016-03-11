package org.hungerhome.soccermanager.api.integration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.hungerhome.soccermanager.api.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

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
public class GetGameCollectionTest {

    final RestTemplate template = new RestTemplate();

    @Test
    @DatabaseSetup(value = {"/player.xml", "/team.xml", "/game.xml"})
    public void testSpringBootDatabaseRestTest() throws Exception {
        String message = template.getForObject("http://localhost:8080/api/games", String.class);

        Assert.hasLength(message, "The Api does not return anything");
    }

    @Test
    @DatabaseSetup(value = {"/player.xml", "/team.xml", "/game.xml"})
    public void testGetAllGames()
    {
        get("/api/games").then()
            .body("_embedded.games.size()", equalTo(2));
    }

}
