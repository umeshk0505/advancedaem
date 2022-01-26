package com.project.core.services.impl;

import com.project.core.config.PersonalOSGIConfig;
import com.project.core.services.OSGIConfigModule;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
@Component(service = OSGIConfigModule.class,immediate = true)
@Designate(ocd = PersonalOSGIConfig.class)
public class OSGIConfigModuleImpl implements OSGIConfigModule{
    private int serviceId;
    private String serviceName;
    private String serviceURL;
    @Activate
    protected void activate(PersonalOSGIConfig geeksOSGiConfig){
        serviceId=geeksOSGiConfig.serviceID();
        serviceName=geeksOSGiConfig.serviceName();
        serviceURL=geeksOSGiConfig.serviceURL();
    }
    @Override
    public int getServiceId() {
        return serviceId;
    }
    @Override
    public String getServiceName() {
        return serviceName;
    }
    @Override
    public String getServiceURL() {
        return serviceURL;
    }
}