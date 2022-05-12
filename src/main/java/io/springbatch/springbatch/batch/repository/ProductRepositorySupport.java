package io.springbatch.springbatch.batch.repository;

import com.querydsl.jpa.JPQLQuery;
import io.springbatch.springbatch.batch.domain.Product;
import io.springbatch.springbatch.batch.domain.ProductVO;
import io.springbatch.springbatch.batch.domain.QProductVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

import static io.springbatch.springbatch.batch.domain.QProduct.product;

@Repository
public class ProductRepositorySupport extends QuerydslRepositorySupport {

    public ProductRepositorySupport() {
        super(Product.class);
    }

    /**
     * get product type group by type
     *
     * @return ProductVO list
     */
    public List<ProductVO> getProductTypeListGroupByType() {
        final JPQLQuery<ProductVO> query = from(product)
                .groupBy(product.type)
                .select(new QProductVO(product.type));
        return query.fetch();
    }

    /**
     * @param type
     * @return
     */
    public Page<Product> getProductListByType(String type) {
        final JPQLQuery<Product> query = from(product)
                .where(product.type.eq(type))
                .orderBy(product.id.desc());

        final List<Product> productList = Objects.requireNonNull(getQuerydsl()).applyPagination(Pageable.ofSize(10), query).fetch();
        return new PageImpl<>(productList, Pageable.ofSize(10), query.fetchCount());
    }
}
