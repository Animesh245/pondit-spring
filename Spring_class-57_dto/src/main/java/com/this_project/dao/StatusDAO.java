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

    Long update(Status status);

    Long delete(Long id);

    List<Status> getAll();
}
