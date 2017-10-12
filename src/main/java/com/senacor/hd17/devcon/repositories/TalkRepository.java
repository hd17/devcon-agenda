package com.senacor.hd17.devcon.repositories;


import com.senacor.hd17.devcon.model.Talk;
import com.senacor.hd17.devcon.projections.TalkEdit;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "talks", path = "talks")
public interface TalkRepository extends PagingAndSortingRepository<Talk, Long> {

    List<Talk> findTalkByName(@Param("name") String name);

}


