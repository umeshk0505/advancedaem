package com.project.core.models.impl;

import com.project.core.models.SchedulerDemo;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class SchedulerDemoImplTest {

    AemContext aemContext = new AemContext();
    SchedulerDemo schedulerDemo;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Time.json","/content");
    }

    @Test
    void getTime() {
        Resource json = aemContext.resourceResolver().getResource("/content/scheduler");
        schedulerDemo = json.adaptTo(SchedulerDemo.class);
        assertEquals("2021-12-29T12:00:39.862Z",schedulerDemo.getTime());
    }
}