package com.yang.roughspring.xml;

import com.yang.roughspring.AbstractBeanDefinitionReader;
import com.yang.roughspring.BeanDefinition;
import com.yang.roughspring.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yang
 * Date 2019/11/27 23:07
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    protected XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }


    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = super.getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(inputStream);
        registerBeanDefinitions(doc);
        inputStream.close();
    }

    private void registerBeanDefinitions(Document doc) {
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if(node instanceof Element) {
                Element el = (Element) node;
                processBeanDefinition(el);
            }
        }
    }

    private void processBeanDefinition(Element el) {
        String name = el.getAttribute("name");
        String className = el.getAttribute("class");
        BeanDefinition bd = new BeanDefinition();
        bd.setBeanClassName(className);
        getRegistry().put(name, bd);
    }
}
