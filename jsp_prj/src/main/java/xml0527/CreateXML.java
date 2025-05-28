package xml0527;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreateXML {

	public void createXML() {
		//1.XML문서 객체 생성
		Document doc = new Document();
		
		//2.최상위 부모노드 생성
		Element rootNode = new Element("root");
		
		//3.자식 노드 생성
		Element msgNode = new Element("msg");
		Element nameNode = new Element("name");
		
		//자식노드에 값 설정
		msgNode.setText("안녕하세요?");
		nameNode.setText("주현석");
		
		//자식노드를 부모노드에 배치
		rootNode.addContent(msgNode);
		rootNode.addContent(nameNode);
		//모든 자식노드를 가진 부모노드를 문서객체에 배치
		doc.addContent(rootNode);
		
		//출력객체 생성
		XMLOutputter xOut = new XMLOutputter(Format.getPrettyFormat());
		
		
		try {
			//콘솔출력
			xOut.output(doc, System.out);
			//파일로 출력
			xOut.output(doc, new FileOutputStream("C:/dev/workspace/sist/jsp_prj/src/main/webapp/xml0527/create.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//createXML
	
	public static void main(String[] args) {
		new CreateXML().createXML();
	}
	

}
