package com.j2kb.valueup.repository;

import com.j2kb.valueup.domain.Notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
