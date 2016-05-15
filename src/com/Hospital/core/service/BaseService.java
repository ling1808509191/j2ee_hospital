package com.Hospital.core.service;

public interface BaseService<T> {
  T getByName(String name);
  T getById(int id);
  T getByaccount(String account);
  
  
}
