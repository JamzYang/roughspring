package com.yang.roughspring.io;

import java.net.URL;

/**
 * @author yang
 * Date 2019/11/25 23:00
 */
public class ResourceLoader {
    public Resource getResource(String location){
        URL url = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(url);
    }
}
