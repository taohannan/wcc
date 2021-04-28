package com.wcc.assessment.service;

import com.wcc.assessment.model.PostCode;
import com.wcc.assessment.repository.PostCodeRepository;
import com.wcc.assessment.utils.RangeCalculator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PostCodeService {

    private PostCodeRepository postCodeRepository;

    public PostCodeService(PostCodeRepository postCodeRepository) {
        this.postCodeRepository = postCodeRepository;
    }

    public PostCode getPostCodeDetail(String postcode) {
        return postCodeRepository.findByPostcode(postcode).orElse(null);
    }

    public double calculateDistance(PostCode from, PostCode to) {

        double distance = RangeCalculator.calculateDistance(
                Double.parseDouble(from.getLatitude()),Double.parseDouble(from.getLongitude()),
                Double.parseDouble(to.getLatitude()),Double.parseDouble(to.getLongitude())
        );

        return distance;

    }
}
