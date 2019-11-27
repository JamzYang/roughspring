package com.yang.roughspring;

import java.io.IOException;

/**
 * @author yang
 * Date 2019/11/25 23:09
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
