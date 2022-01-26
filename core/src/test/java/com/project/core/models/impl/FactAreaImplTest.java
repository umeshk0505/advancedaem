package com.project.core.models.impl;

import com.project.core.models.FactArea;
import com.project.core.models.Testimonial;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class FactAreaImplTest {

    private final AemContext aemContext = new AemContext();
    //private FactArea factArea = new FactAreaImpl();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/FactArea.json","/content");
    }


    @Test
    void getFactDetailsWithMap() {
        /*Resource json = aemContext.currentResource("/content");
        //FactArea factArea = aemContext.request().adaptTo(FactArea.class);
        FactArea factArea = json.adaptTo(FactArea.class);

        assertEquals("2536",factArea.getFactDetailsWithMap().get(0).get("factnumber"));
        assertEquals("Projects Completed",factArea.getFactDetailsWithMap().get(0).get("factlabel"));*/
    }
}