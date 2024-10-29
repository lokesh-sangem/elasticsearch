package com.tac.optimized_es.repo;

import com.tac.optimized_es.entity.Task;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends ElasticsearchRepository<Task,String> {

}
