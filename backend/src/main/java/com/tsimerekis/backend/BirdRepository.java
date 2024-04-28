package com.tsimerekis.backend;

import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends SpannerRepository<BirdEntry, String> {

}
