package com.yang.roughspring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yang
 * Date 2019/11/25 22:53
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
