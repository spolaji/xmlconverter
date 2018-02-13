
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class ConvertObjToXML {

    public static void main(String args[]) throws Exception
    {
        ArrayList<String> numberList = new ArrayList<String>();

        numberList.add("344074070234");
        numberList.add("434324324324");
        numberList.add("343243243243");

        Customer c = new Customer();

        c.setId(23);
        c.setName("Johnny Jackson");
        c.setAge(45);
        c.setAddress("Cambridge, MA, USA");
        c.setMobileNo(numberList);

        //Change the file path below
        File file = new File("/Users/xxxx/LocalDev/SampleTestFiles/customer.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(c, file);// this line create customer.xml file in specified path.

        StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal(c, sw);
        String xmlString = sw.toString();

        System.out.println(xmlString);
    }

}
