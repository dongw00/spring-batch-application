package io.springbatch.springbatch.batch.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductVO {

    private Long id;
    private String name;
    private int price;
    private String type;

    @QueryProjection
    public ProductVO(String type) {
        this.type = type;
    }
}
