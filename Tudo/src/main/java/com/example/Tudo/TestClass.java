package com.example.Tudo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestClass {
    @GetMapping("/hi")
  public String hi(){
      return "ok";
  }
}
