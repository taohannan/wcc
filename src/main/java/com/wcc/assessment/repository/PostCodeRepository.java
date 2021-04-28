package com.wcc.assessment.repository;

import com.wcc.assessment.model.PostCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostCodeRepository  extends JpaRepository<PostCode,Long> {

    Optional<PostCode> findByPostcode(String postcode);

}
