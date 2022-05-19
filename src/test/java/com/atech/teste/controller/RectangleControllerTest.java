package com.atech.teste.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.atech.teste.services.RectangleService;

@WebMvcTest
public class RectangleControllerTest {

    @Autowired
    private RectangleController rectangleController;
    @MockBean
    private RectangleService service;

    @BeforeEach
    public void setup(){
        standaloneSetup(this.rectangleController);
    }

    @Test
    public void retornarSucesso_AreaMaiorRetangulo(){

        when(service.areaMaiorRetangulo(this.value())).thenReturn(6);

        given().accept(ContentType.JSON)
                .body("param")
                .when()
                .post("/rectangle")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    private String value(){

        JSONObject json = new JSONObject();

        List<String[]> maps = new ArrayList<>();

        String[] str1 = {"1", "0", "1", "0", "0"};
        String[] str2 = {"1", "0", "1", "1", "1"};
        String[] str3 = {"1", "1", "1", "1", "1"};
        String[] str4 = {"1", "0", "0", "1", "0"};

        maps.add(str1);
        maps.add(str2);
        maps.add(str3);
        maps.add(str4);

        try {
            json.put("map", maps);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();
    }
    
}
