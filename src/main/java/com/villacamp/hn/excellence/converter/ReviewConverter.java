package com.villacamp.hn.excellence.converter;

import com.villacamp.hn.excellence.dto.ReviewDTO;
import com.villacamp.hn.excellence.entity.Review;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public final class ReviewConverter {
    public static ReviewDTO convert(Review entity) {
        return new ModelMapper().map(entity, ReviewDTO.class);
    }
}
