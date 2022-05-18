package com.atech.teste.controller;
import com.atech.teste.services.RectangleService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rectangle")
public class RectangleController {

    @Autowired
    private RectangleService service;

    @PostMapping(path = "")
    public ResponseEntity<?> calculaArea(@RequestBody String str) {
        JSONObject resp = new JSONObject();
        resp.put("area", service.areaMaiorRetangulo(str));
        return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
    }

}
