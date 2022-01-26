package com.project.core.models.impl;

import com.project.core.models.UserList;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import javax.inject.Inject;
import javax.jcr.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.day.cq.search.result.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Model(adaptables = SlingHttpServletRequest.class,
        adapters = UserList.class,
        resourceType = UserListImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporter(name = "jackson",selector = "userlist",extensions = "json")
public class UserListImpl implements UserList {
    static final String RESOURCE_TYPE = "/apps/project/components/content/listusers";
    private static final Logger LOG = LoggerFactory.getLogger(UserListImpl.class);
    @Inject
    ResourceResolver resolver;

    @Inject
    QueryBuilder queryBuilder;

    @Inject
    StringBuilder listofusers = new StringBuilder();

    @Override
    public StringBuilder getUsers() {
        LOG.info("\n Printing LOGS from inside CLass");



        Map<String, String> map = new HashMap<>();
        map.put("path", "/home/users");
        map.put("property", "jcr:primaryType");
        map.put("property.value", "rep:User");
        map.put("p.hits", "selective");
        map.put("p.properties", "rep:principalName");
        map.put("type", "rep:User");

        try {

            Session session = resolver.adaptTo(Session.class);
            Query listQuery = queryBuilder.createQuery(PredicateGroup.create(map), session);
            SearchResult result = listQuery.getResult();
            List<Hit> hits = result.getHits();
            for(Hit hit : hits){
                listofusers = listofusers.append("\r\n").append(hit.getProperties().get("rep:principalName", String.class));

            }

        }catch(Exception e){
            LOG.info("exception",e.getMessage());
        }
        return listofusers;
    }
}