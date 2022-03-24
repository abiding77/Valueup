package com.j2kb.valueup.repository;

import com.j2kb.valueup.domain.Image.File;
import com.j2kb.valueup.domain.Notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
