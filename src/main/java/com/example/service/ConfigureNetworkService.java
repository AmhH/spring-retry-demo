package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConfigureNetworkService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureNetworkService.class);
  @Autowired
  private RetryTemplate retryTemplate;

  public String configureNetworkSystem(){
    Boolean execute = retryTemplate.execute(context -> {
      verifyNwConfiguration(context);
      return true;
    });
    return String.valueOf(execute);
  }

  int counter = 0;
  private void verifyNwConfiguration(RetryContext context) {
    counter++;

    LOGGER.info("N/W configuration service failed {} retry count {}", counter, context.getRetryCount());
    throw new RuntimeException();
  }
}
