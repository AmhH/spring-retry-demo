package com.example.controller;

import com.example.service.ConfigureNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetworkClientService {

  @Autowired
  private ConfigureNetworkService networkService;

  @GetMapping("/network")
  public String callRetryService(){
    return networkService.configureNetworkSystem();
  }
}
