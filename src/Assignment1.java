import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Assignment1 {

    public static void main(String[] args) {

        try {
            File inputFile = new File("books.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("book");
            System.out.println("\n----------------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter book ID:");
            String BId = scanner.nextLine();
            scanner.close();

            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getAttribute("id");
                    if (id.equals(BId)) {
                        String author = element.getElementsByTagName("author").item(0).getTextContent();
                        System.out.println("Author: " + author);
                        String title = element.getElementsByTagName("title").item(0).getTextContent();
                        System.out.println("Title: " + title);
                        String year = element.getElementsByTagName("genre").item(0).getTextContent();
                        System.out.println("Genre: " + year);
                        String price = element.getElementsByTagName("price").item(0).getTextContent();
                        System.out.println("Price: " + price);
                        String publish_date = element.getElementsByTagName("publish_date").item(0).getTextContent();
                        System.out.println("Publish date: " + publish_date);
                        String description = element.getElementsByTagName("description").item(0).getTextContent();
                        System.out.println("Description: " + description);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
