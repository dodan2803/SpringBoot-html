package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface IStudentService<E> {
    void save(E e);
    void delete(Long id);
    List<E> findAll();
    Optional<E> findById(Long id);
    List<E> findByNameContaining(String name);
}
