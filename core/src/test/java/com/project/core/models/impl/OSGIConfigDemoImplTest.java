package com.project.core.models.impl;

import com.project.core.models.OSGIConfigDemo;
import com.project.core.services.OSGIConfig;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class OSGIConfigDemoImplTest {

    AemContext aemContext = new AemContext();
    OSGIConfigDemo osgiConfigDemo;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/OSGI.json","/content");
    }

    @Test
    void getServiceName() {
        /*Resource json = aemContext.resourceResolver().getResource("content/osgi");
        osgiConfigDemo = json.adaptTo(OSGIConfigDemo.class);
        assertEquals("A",osgiConfigDemo.getServiceName());*/
    }

    @Test
    void getServiceCount() {
    }

    @Test
    void isLiveData() {
    }

    @Test
    void getCountries() {
    }

    @Test
    void getRunModes() {
    }
}