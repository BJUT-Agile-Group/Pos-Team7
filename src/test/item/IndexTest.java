package test.item;

import item.Index;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Index Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 6, 2015</pre>
 */
public class IndexTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getName()
     */
    @Test
    public void testGetName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setName(String name)
     */
    @Test
    public void testSetName() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getBarcode()
     */
    @Test
    public void testGetBarcode() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setBarcode(String barcode)
     */
    @Test
    public void testSetBarcode() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getUnit()
     */
    @Test
    public void testGetUnit() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setUnit(String unit)
     */
    @Test
    public void testSetUnit() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getPrice()
     */
    @Test
    public void testGetPrice() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setPrice(double price)
     */
    @Test
    public void testSetPrice() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getDiscount()
     */
    @Test
    public void testGetDiscount() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setDiscount(double discount)
     */
    @Test
    public void testSetDiscount() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: isPromotion()
     */
    @Test
    public void testIsPromotion() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setPromotion(boolean promotion)
     */
    @Test
    public void testSetPromotion() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteIndex(List<ProductList> productList, String index)
     */
    @Test
    public void testDeleteIndex() throws Exception {
//TODO: Test goes here... 
    }

    @Test
    public void testName() throws Exception {

    }

    /**
     * Method: read(List<Index> indexList)
     */
    @Test
    public void testRead() throws Exception {
//TODO: Test goes here...
        try {
            List<Index> indexList = new ArrayList<Index>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Index.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String data = null;
            do {
                data = bufferedReader.readLine();
                if (data != null) {
                    stringBuilder.append(data);
                }
            } while (data != null);
            data = stringBuilder.toString().replaceAll(" |\n|\t", "");
            String c[] = data.substring(0, data.length() - 2).split("},");
            for (String d : c) {
                Index index = new Index(d.replaceAll("\\'\\:|\\{|\\'|name|unit|price|discount|promotion| |\\'|\\,|，", "").split(":"));
                indexList.add(index);
            }
            System.out.println(indexList.get(1).getName());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // assertEquals("ITEM00000",);

} 


} 
