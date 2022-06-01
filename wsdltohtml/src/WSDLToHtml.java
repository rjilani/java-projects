/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjilan01
 */

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class WSDLToHtml {

    public WSDLToHtml(String dataXML, String inputXSL, String outputHTML) {
        
        try {
            
            transform(dataXML, inputXSL, outputHTML);
        } catch (TransformerConfigurationException e) {
            System.err.println("TransformerConfigurationException");
            System.err.println(e);
        } catch (TransformerException e) {
            System.err.println("TransformerException");
            System.err.println(e);
        }
    }
    
    
    public void transform(String dataXML, String inputXSL, String outputHTML)
            throws TransformerConfigurationException,
            TransformerException {

        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(inputXSL);
        Transformer transformer = factory.newTransformer(xslStream);
        StreamSource in = new StreamSource(dataXML);
        StreamResult out = new StreamResult(outputHTML);
        transformer.transform(in, out);
        System.out.println("The generated HTML file is:" + outputHTML);
    }
    
}
