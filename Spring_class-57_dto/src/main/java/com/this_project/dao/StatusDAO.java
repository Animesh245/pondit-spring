package com.this_project.dao;

import com.this_project.entity.Status;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public interface StatusDAO {

    Long insert(Status status);

    Status getById(Long id);

    void update(Status status);

    void delete(Long id);

    List<Status> getAll();
}
