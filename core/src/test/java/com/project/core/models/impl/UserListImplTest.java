package com.project.core.models.impl;

import com.project.core.models.HomeAbout;
import com.project.core.models.UserList;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class UserListImplTest {

    private final AemContext aemContext = new AemContext();
    private UserList userList;

    @BeforeEach
    void setUp() {
        Resource json = aemContext.load().json("/UserList.json","/content");
    }

    @Test
    void getUsers() {
        Resource json = aemContext.resourceResolver().getResource("/content/userlist");
        userList = json.adaptTo(UserList.class);
        /*assertEquals("\n" +
                "anonymous\n" +
                "varmstrong\n" +
                "imccoy\n" +
                "ksaner\n" +
                "zachary.mitchell@spambob.com\n" +
                "olive.pixley@spambob.com\n" +
                "cavery\n" +
                "willie.melton@dodgit.com\n" +
                "replication-receiver\n" +
                "campaign-remote", userList.getUsers());*/
    }
}