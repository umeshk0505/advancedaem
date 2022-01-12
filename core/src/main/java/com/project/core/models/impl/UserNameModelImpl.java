package com.project.core.models.impl;


import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.project.core.models.UserNameModel;
import com.project.core.services.UserNameService;
import com.project.core.utils.ResolverUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.*;

@Model(
        adaptables = Resource.class,
        adapters = UserNameModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class UserNameModelImpl implements UserNameModel {

    final Logger log = LoggerFactory.getLogger(UserNameModelImpl.class);

    @OSGiService
    UserNameService userNameService;

    @PostConstruct
    protected void init(){
        log.info("\n Inside Model");
    }

    @Reference
    ResourceResolver resourceResolver;

    @Inject
    private ResourceResolverFactory resourceResolverFactory;

    @Inject
    QueryBuilder queryBuilder;

    StringBuilder user = new StringBuilder();

    @Override
    public StringBuilder getUsernames() {
        log.info("\n Inside Getusername of service ");
        Map<String, String> userMap = new HashMap<>();
        userMap.put("p.hits", "selective");
        userMap.put("p.limit", "-1");
        userMap.put("property", "jcr:primaryType");
        userMap.put("property.value", "rep:User");
        userMap.put("path", "/home/users");
        userMap.put("type", "rep:User");
        userMap.put("p.properties", "rep:principalName");
        try(ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory)){
            log.info("\n Inside Try..");

            Session session = resourceResolver.adaptTo(Session.class);
            log.info("\n Result "+session.getUserID());
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
            SearchResult result = userQuery.getResult();
            List<Hit> hits = result.getHits();
            for (Hit hit : hits) {
                user = user.append("\r\n").append(hit.getProperties().get("rep:principalName", String.class));
            }
        } catch (LoginException | RepositoryException e) {
            log.info("Service User ERROR",e.getMessage());
        }
        return user;
    }
}