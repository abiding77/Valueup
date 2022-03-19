package com.j2kb.valueup.repository;

import com.j2kb.valueup.domain.Image.File;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<File, Long> {

}
