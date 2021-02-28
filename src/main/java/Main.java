import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws JAXBException {

        System.out.println("************ Student from xml ************");
        getStudentFromXml();
        System.out.println();

        System.out.println("************ Student from GsonXML ************");
        getStudentFromGsonXml();
        System.out.println();

        System.out.println("************ Object to Xml ************");
        createXmlFromObject();
        System.out.println();

    }

    public static void getStudentFromGsonXml() {

        String msg = "<Employee>\n" +
                "   <id>1</id>\n" +
                "   <name>Dilanka</name>\n" +
                "   <address>Anuradhapura</address>\n" +
                "</Employee>";


//        GsonXml gsonXml = getGsonXMLInstance();
//        gsonXml.fromXml(msg, Employee.class);


    }

    public static void createXmlFromObject() throws JAXBException {

        StringWriter xmlMessage = new StringWriter();
        Student student = new Student();

        student.setId(2);
        student.setName("Nimsara");
        student.setAddress("Colombo");

        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(student, xmlMessage);

        System.out.println(xmlMessage);
        /**
         * write to xml file
         */
        //        marshaller.marshal(student, new File("xmlfile.xml"));

    }


    public static GsonXml getGsonXMLInstance() {

        XmlParserCreator parserCreator = () -> {
            try {
                return XmlPullParserFactory.newInstance().newPullParser();
            } catch (XmlPullParserException e) {
                throw new RuntimeException(e);
            }
        };

        GsonXml gsonXml = new GsonXmlBuilder()
                .setXmlParserCreator(parserCreator)
                .setPrimitiveArrays(true)
                .setRootArrayPrimitive(true)
                .setSameNameLists(true)
                .setTreatNamespaces(true)
                .setSkipRoot(true)
                .setTreatNamespaces(true)
                .create();

        return gsonXml;

    }

    public static void getStudentFromXml() throws JAXBException {

        String msg = "<student>\n" +
                "   <id>1</id>\n" +
                "   <name>Dilanka</name>\n" +
                "   <address>Anuradhapura</address>\n" +
                "</student>";

        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(msg);
        Student student = (Student) unmarshaller.unmarshal(reader);
        System.out.println(student);

    }
}
