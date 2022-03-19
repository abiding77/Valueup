package com.j2kb.valueup.repository;

import com.j2kb.valueup.domain.Community.Community;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommunityRepository extends JpaRepository<Community , Long> {

}
