package com.finalproject.mooc.repository;

import com.finalproject.mooc.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
