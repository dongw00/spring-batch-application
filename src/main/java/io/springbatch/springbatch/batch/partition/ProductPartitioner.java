package io.springbatch.springbatch.batch.partition;

import io.springbatch.springbatch.batch.domain.ProductVO;
import io.springbatch.springbatch.batch.repository.ProductRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProductPartitioner implements Partitioner {

    private final ProductRepositorySupport productRepository;

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        List<ProductVO> productList = productRepository.getProductTypeListGroupByType();

        Map<String, ExecutionContext> res = new HashMap<>();

        int num = 0;

        for (ProductVO productVO : productList) {
            ExecutionContext value = new ExecutionContext();

            res.put("partition" + num, value);
            value.put("product", productVO);

            num++;
        }

        return res;
    }
}
