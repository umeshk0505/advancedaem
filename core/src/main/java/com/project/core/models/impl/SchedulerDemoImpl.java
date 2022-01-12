package com.project.core.models.impl;

import com.project.core.models.SchedulerDemo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,adapters = SchedulerDemo.class,resourceType = SchedulerDemoImpl.RESOURCE_TYPE,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson",selector = "time",extensions = "json")
public class SchedulerDemoImpl implements SchedulerDemo {

    static final String RESOURCE_TYPE = "project/components/content/schedulerdemo";

    @Inject
    String time;

    @Override
    public String getTime() {
        return time;
    }
}
