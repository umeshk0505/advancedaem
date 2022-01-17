package com.project.core.models.impl;
import com.project.core.models.UserJson;
import com.project.core.utils.JSONLoaders;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = UserJson.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserJsonImpl implements UserJson {

    final Logger LOG = LoggerFactory.getLogger(UserJson.class);
    @Inject
    String url;

    @Override
    public String getUrl(){
        return "https://reqres.in/api/users/"+url;
    }
    @Override
    public String getMessage() {

        return JSONLoaders.readJson(getUrl());
    }

}