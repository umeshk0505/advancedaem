package com.project.core.services.impl;

import com.project.core.services.MultipleUserOsgi;
import com.project.core.services.SingleUserOsgi;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.*;

@Component(service = MultipleUserOsgi.class,immediate = true)
@Designate(ocd = MultipleUserOsgiImpl.MultipleConfig.class )
public class MultipleUserOsgiImpl implements MultipleUserOsgi {


    @ObjectClassDefinition(name = "Multiple User Config",
            description = "Multiple User Config")
    public @interface MultipleConfig {

        @AttributeDefinition(
                name = "User Data Link",
                description = "User Data Link",
                type = AttributeType.STRING)
        public String getMultipleLinkData() default "https://reqres.in/api/users?page=";

    }

    protected String userLinkData = "";

    @Override
    public String getMultipleLinkData() {
        return userLinkData;
    }


    @Activate
    protected void activate(MultipleConfig multipleConfig) {
        userLinkData = multipleConfig.getMultipleLinkData();
    }
}