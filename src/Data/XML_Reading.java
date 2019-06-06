package Data;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class XML_Reading {
    private String Road;

    public XML_Reading(String Road) {
        this.Road = Road;
    }

    public void start(){

        Document doc = null;
        try {
            doc = parseXML("Red_List.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert doc != null;
        NodeList descNodes = doc.getElementsByTagName("v_List");

        for(int i=0; i<descNodes.getLength();i++){

            for(Node node = descNodes.item(i).getFirstChild(); node!=null; node=node.getNextSibling()){
                //첫번째 자식을 시작으로 마지막까지 다음 형제를 실행

                if(node.getNodeName().equals("name")){
                    System.out.println(node.getTextContent());
                }else if(node.getNodeName().equals("writer")){
                    System.out.println(node.getTextContent());
                }

            }

        }
    }

    private Document parseXML(String stream) throws Exception{
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;

        try{

            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);

        }catch(Exception ex){
            throw ex;
        }

        return doc;
    }
}
