package com.project.core.services.impl;

import com.project.core.config.SchedulerConfiguration;
import com.project.core.services.JsonUpdate;
import com.project.core.utils.ResolverUtils;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

import javax.jcr.*;

@Component(immediate = true,service = JsonUpdate.class)
@Designate(ocd = SchedulerConfiguration.class)
public class JsonUpdateImpl implements JsonUpdate {




    @Reference
    ResourceResolverFactory resourceResolverFactory;


    @Override
    public String updateJson(String path) {
        try(ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory)){
            Session session = serviceResourceResolver.adaptTo(Session.class);
            Resource resource = serviceResourceResolver.getResource("/content/project/us/en/blde/jcr:content/root/container/container/jsonupdate");
            Node node = resource.adaptTo(Node.class);
            node.setProperty("time" , updateJson("www.reqres.in/api/users?page=2"));


            session.save();
            session.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}
