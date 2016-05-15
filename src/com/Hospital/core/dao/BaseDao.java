package com.Hospital.core.dao;

import java.util.List;

public interface BaseDao<T> {
  boolean save(T t);
  boolean delete(T t);
  boolean update(T t);
  List<T> getParts(String pagenum,String pagesize);
}
