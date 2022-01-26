package com.project.core.models.impl;

import com.project.core.models.Price;
import com.project.core.models.TitleText;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PriceImplTest {

    private final AemContext aemContext = new AemContext();
    Price price;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Price.json","/content");
    }

    @Test
    void getCount() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        price = json.adaptTo(Price.class);
        assertEquals("1",price.getCount());
    }

    @Test
    void getTitle() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        price = json.adaptTo(Price.class);
        assertEquals("a",price.getTitle());
    }

    @Test
    void getHeading() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        price = json.adaptTo(Price.class);
        assertEquals("b",price.getHeading());
    }

    @Test
    void getTag1() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        price = json.adaptTo(Price.class);
        assertEquals("c",price.getTag1());
    }

    @Test
    void getTag2() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        price = json.adaptTo(Price.class);
        assertEquals("d",price.getTag2());
    }

    @Test
    void getTag3() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        price = json.adaptTo(Price.class);
        assertEquals("e",price.getTag3());
    }
}