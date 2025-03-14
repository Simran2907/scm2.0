package com.scm.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


@RestController
public class BibFrameController{


    @GetMapping("/getFields")
    public Map<String,String> getBibFields(){
        Map<String,String> tagValueMap = new HashMap<>();
        try{
          InputStream in = new FileInputStream("C:/Users/paras/bibfr.rdf");
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(in);
            document.getDocumentElement().normalize();

            // Get all elements with the BibFrame namespace
            NodeList nodeList = document.getElementsByTagName("*");

            // Iterate through the node list and fetch tag values
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                // Check if the node is an element (to avoid text nodes or comments)
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String tagName = element.getNodeName();
                    String tagValue = element.getTextContent().trim();

                    // Only add to map if the tag has a value (non-empty)
                    if (!tagValue.isEmpty()) {
                        tagValueMap.put(tagName, tagValue);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return tagValueMap;
    }

}