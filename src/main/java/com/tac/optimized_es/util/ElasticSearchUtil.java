package com.tac.optimized_es.util;

import co.elastic.clients.elasticsearch._types.query_dsl.FuzzyQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;


import java.util.function.Supplier;

public class ElasticSearchUtil {
        public static Supplier<Query> createSupplierQuery(String approximateTaskName,String fuzziness){
        Supplier<Query> supplier = ()->Query.of(q->q.fuzzy(createFuzzyQuery(approximateTaskName,fuzziness)));
        return supplier;
    }

    public static FuzzyQuery createFuzzyQuery(String approximateTaskName,String fuzziness){
        val fuzzyQuery = new FuzzyQuery.Builder();
        return fuzzyQuery.field("name").value(approximateTaskName)
                .fuzziness(fuzziness).build();//setting fuzziness dynamically

    }
}
