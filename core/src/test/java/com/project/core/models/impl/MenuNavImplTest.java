package com.project.core.models.impl;

import com.project.core.models.MenuNav;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class MenuNavImplTest {

    AemContext aemContext = new AemContext();
    MenuNav menuNav;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/MenuNav.json","/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.resourceResolver().getResource("/content/menunav");
        menuNav = json.adaptTo(MenuNav.class);
        assertEquals("Hello",menuNav.getTitle());
    }

    @Test
    void getPath() {
        Resource json = aemContext.resourceResolver().getResource("/content/menunav");
        menuNav = json.adaptTo(MenuNav.class);
        assertEquals("path",menuNav.getPath());
    }
}