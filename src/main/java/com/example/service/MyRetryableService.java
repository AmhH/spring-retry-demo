package com.example.service;

import java.sql.SQLException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface MyRetryableService {

  @Retryable(value = RuntimeException.class)
  void retryService(String sql);

  @Retryable(value = SQLException.class)
  void retryServiceWithRecovery(String sql) throws SQLException;

  @Recover
  void recover(SQLException e, String sql);
}
