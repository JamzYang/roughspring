package com.yang.roughspring;

import com.yang.roughspring.io.Resource;
import com.yang.roughspring.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yang
 * Date 2019/11/25 23:05
 */
public class TestResourceLoader {

    @Test
    public void testLoadResource() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("tinyioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
