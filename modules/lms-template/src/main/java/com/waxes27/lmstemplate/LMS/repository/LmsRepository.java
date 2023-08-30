package com.waxes27.lmstemplate.LMS.repository;


import com.waxes27.lmstemplate.LMS.models.LmsPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsRepository extends JpaRepository<LmsPlatform, Long> {
}
