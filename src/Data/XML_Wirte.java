package Data;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML_Wirte {
    private String Name, Url;

    public XML_Wirte(String name, String url) {
        this.Name = name;
        this.Url = url;
    }

    public void Wirte(int Num) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Red_List 엘리먼트
            Document doc = docBuilder.newDocument();
            doc.setXmlStandalone(true); //standalone="no" 를 없애준다.

            Element Red_List = doc.createElement("Red_List");
            doc.appendChild(Red_List);

            // v_List 엘리먼트
            Element v_List = doc.createElement("v_List");
            Red_List.appendChild(v_List);

            // 속성값 정의 (id:1)
            v_List.setAttribute("id", String.valueOf(Num));

            // name 엘리먼트
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(Name));
            v_List.appendChild(name);

            // writer 엘리먼트
            Element writer = doc.createElement("writer");
            writer.appendChild(doc.createTextNode(Url));
            v_List.appendChild(writer);


            v_List = doc.createElement("v_List");
            Red_List.appendChild(v_List);


            // XML 파일로 쓰기
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); //정렬 스페이스4칸
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //들여쓰기
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes"); //doc.setXmlStandalone(true); 했을때 붙어서 출력되는부분 개행

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(new File("Red_List.xml")));

            transformer.transform(source, result);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
