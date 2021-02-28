import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class UtilMethods {
    public static GsonXml getGsonXMLInstance() {

        XmlParserCreator parserCreator = new XmlParserCreator() {
            @Override
            public XmlPullParser createParser() {
                try {
                    return XmlPullParserFactory.newInstance().newPullParser();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
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
}
