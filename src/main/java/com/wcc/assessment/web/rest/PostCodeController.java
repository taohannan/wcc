package com.wcc.assessment.web.rest;

import com.wcc.assessment.model.PostCode;
import com.wcc.assessment.service.PostCodeService;
import com.wcc.assessment.web.rest.vm.DistanceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostCodeController {

    private final Logger log = LoggerFactory.getLogger(PostCodeController.class);
    private PostCodeService postCodeService;

    public PostCodeController(PostCodeService postCodeService) {
        this.postCodeService = postCodeService;
    }

    @GetMapping("/distance")
    public ResponseEntity<DistanceResponse> getDistance(@RequestParam(name = "postcodeFrom") String postcodeFrom,
                                                        @RequestParam(name = "postcodeTo") String postcodeTo) {

        DistanceResponse response = new DistanceResponse();

        PostCode postCodeFrom = postCodeService.getPostCodeDetail(postcodeFrom);
        PostCode postCodeTo = postCodeService.getPostCodeDetail(postcodeTo);

        double distance = postCodeService.calculateDistance(postCodeFrom, postCodeTo);
        response.setFrom_location(postCodeFrom);
        response.setTo_location(postCodeTo);
        response.setDistance(distance);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/postcode")
    public ResponseEntity<PostCode> getPostCode(@RequestParam(name = "postcode") String postCode) {

        return ResponseEntity.ok(postCodeService.getPostCodeDetail(postCode));

    }

    @PutMapping("/postcode")
    public ResponseEntity<PostCode> updatePostcode(@RequestBody PostCode postCode) throws Exception {

        if (postCode.getId() == null) {
            throw new Exception("Id cannot be null");
        }

        return ResponseEntity.ok(postCodeService.updatePostcode(postCode));
    }

    @PostMapping("/postcode")
    public ResponseEntity<PostCode> createPostcode(@RequestBody PostCode postCode) throws Exception {
        if (postCode.getId() != null) {
            throw new Exception("Id must be null");
        }

        return ResponseEntity.ok(postCodeService.updatePostcode(postCode));
    }
}
