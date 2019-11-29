package com.yang.roughspring.xml;

import com.yang.roughspring.AbstractBeanDefinitionReader;
import com.yang.roughspring.BeanDefinition;
import com.yang.roughspring.BeanReference;
import com.yang.roughspring.PropertyValue;
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

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
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

    private void registerBeanDefinitions(Document doc) throws Exception {
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) throws Exception {
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if(node instanceof Element) {
                Element el = (Element) node;
                processBeanDefinition(el);
            }
        }
    }

    private void processBeanDefinition(Element el) throws Exception {
        String name = el.getAttribute("name");
        String className = el.getAttribute("class");
        BeanDefinition bd = new BeanDefinition();
        processPropertys(el,bd);
        bd.setBeanClassName(className);
        getRegistry().put(name, bd);
    }

    private void processPropertys(Element el, BeanDefinition bd) throws Exception {
        NodeList nodeList = el.getElementsByTagName("property");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Element el2 = (Element) node;
                String name = el2.getAttribute("name");
                String value = el2.getAttribute("value");
                if(value != null && value.length() > 0){
                    bd.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                }else{
                    String ref = el2.getAttribute("ref");
                    if(ref != null && ref.length() > 0){
                        BeanReference beanReference = new BeanReference(ref);
                        bd.getPropertyValues().addPropertyValue(new PropertyValue(name,beanReference));
                    }else{
                        throw new Exception("ref 值不能为空");
                    }
                }
            }
        }
    }


}
