package techproed.day08_Assertion_BeforeClassAfterClass;

import org.junit.*;

public class C01_BeforeClassAfterClass {

    /*
    @BeforeClass ve @AfterClass methodlari static olmak zorundadir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her class'dan once BeforeClass methodu bir kez calisir.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her class'dan sonra AfterClass methodu bir kez calisir.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her method'dan once before method'u bir kez calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her method'dan sonra after method'u bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("Test01 methodu calisti");
    }

    @Test
    public void test02() {
        System.out.println("Test02 methodu calisti");
    }

    @Test
    public void test03() {
        System.out.println("Test02 methodu calisti");

    }
}

