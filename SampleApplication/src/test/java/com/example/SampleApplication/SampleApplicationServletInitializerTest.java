package com.example.SampleApplication;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleApplicationServletInitializerTest {
    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void checkActuator() throws Exception {
        final String url = "http://localhost:8080/actuator/health";
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> re = new RestTemplate().getForEntity(url, Map.class);
        System.out.println(re);
        assertEquals(HttpStatus.OK, re.getStatusCode());
        re.getStatusCode();
    }
    @Test
    public void testInfo() {
        final String url = "http://localhost:8080/actuator/info";
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> re = new RestTemplate().getForEntity(url, Map.class);
        System.out.println(re);
        assertEquals(HttpStatus.OK, re.getStatusCode());
        re.getStatusCode();
    }
    @Test
    void testBeans() throws Exception {
        final String url = "http://localhost:8080/actuator/beans";
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> re = new RestTemplate().getForEntity(url, Map.class);
        System.out.println(re);
        assertEquals(HttpStatus.OK, re.getStatusCode());
        re.getStatusCode();
        //Assert.assertEquals(1, re.getBody().size());
    }
    @Test
    public void testEnv() {

        final String url = "http://localhost:8080/actuator/env";
        ResponseEntity<Map> re = new RestTemplate().getForEntity(url, Map.class);

        assertEquals(HttpStatus.OK, re.getStatusCode());
    }
    @Test
    public void testMetrics() {

        final String url = "http://localhost:8080/actuator/metrics";
        ResponseEntity<Map> re = new RestTemplate().getForEntity(url, Map.class);

        assertEquals(HttpStatus.OK, re.getStatusCode());
    }
    @Test
    public void testMappings() {

        final String url = "http://localhost:8080/actuator/mappings";
        ResponseEntity<Map> re = new RestTemplate().getForEntity(url, Map.class);

        assertEquals(HttpStatus.OK, re.getStatusCode());
    }
    @Test
    public void testThreaddump() {

        final String url = "http://localhost:8080/actuator/threaddump";
        ResponseEntity<Map> re = new TestRestTemplate().getForEntity(url, Map.class);

        assertEquals(HttpStatus.OK, re.getStatusCode());
    }

    public void testAutoConfig() {

        final String url = "http://localhost:8080/actuator/autoconfig";
        ResponseEntity<Map> re = new TestRestTemplate().getForEntity(url, Map.class);
        assertEquals(HttpStatus.OK, re.getStatusCode());

    }

}

