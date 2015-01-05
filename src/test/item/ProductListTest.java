package test.item;

import item.ProductList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * ProductList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 5, 2015</pre>
 */
public class ProductListTest {

    /**
     * Method: getBarcode()
     */
    @Test
    public static void testGetBarcode() throws Exception {
//TODO: Test goes here...
        List<ProductList> productList = new ArrayList<ProductList>();
        ProductList product = new ProductList(productList);
        assertEquals("ITEM000001", productList.get(5).getBarcode());

    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: setBarcode(String barcode)
     */
    @Test
    public void testSetBarcode() throws Exception {
//TODO: Test goes here... 
    }


} 
