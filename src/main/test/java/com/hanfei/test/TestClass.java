package com.hanfei.test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hanfei
 * @Date: 2017/8/30
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:TestClass
 */

public class TestClass {

    /* @Test
     public void test1() throws IOException {
         Directory directory = FSDirectory.open(Paths.get("c:/hanfeiIndex"));
         Analyzer analyzer = new StandardAnalyzer(StandardAnalyzer.STOP_WORDS_SET);
         IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
         IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
         Document document = new Document();
         document.add(new StringField("title", "你好", Field.Store.YES));
         document.add(new TextField("content", "河北时代电子公司", Field.Store.YES));
         indexWriter.addDocument(document);
         indexWriter.close();
     }

     @Test
     public void test2() throws IOException, ParseException {
         Directory directory = FSDirectory.open(Paths.get("c:/hanfeiIndex"));
         DirectoryReader ireader = DirectoryReader.open(directory);
         Analyzer analyzer = new StandardAnalyzer();
         IndexSearcher isearcher = new IndexSearcher(ireader);
         QueryParser parser = new QueryParser("content", analyzer);
         Query query = parser.parse("公司和");
         ScoreDoc[] hits = isearcher.search(query, 10).scoreDocs;
         System.out.println(hits.length);
         for (int i = 0; i < hits.length; i++) {
             Document hitDoc = isearcher.doc(hits[i].doc);
             System.out.println(hitDoc.get("content"));
         }
     }


     @Test
     public void createIndex() throws Exception {
         //indexDir is the directory that hosts Lucene's index files
         Directory indexDir = FSDirectory.open(Paths.get("c:/hanfeiIndex"));
         //dataDir is the directory that hosts the text files that to be indexed
         File dataDir = new File("C:\\luceneData");
         Analyzer luceneAnalyzer = new StandardAnalyzer();
         File[] dataFiles = dataDir.listFiles();
         IndexWriterConfig indexWriterConfig = new IndexWriterConfig(luceneAnalyzer);
         IndexWriter indexWriter = new IndexWriter(indexDir, indexWriterConfig);
         long startTime = new Date().getTime();
         for (int i = 0; i < dataFiles.length; i++) {
             if (dataFiles[i].isFile() && dataFiles[i].getName().endsWith(".txt")) {
                 System.out.println("Indexing file " + dataFiles[i].getCanonicalPath());
                 Document document = new Document();
                 Reader txtReader = new FileReader(dataFiles[i]);
                 document.add(new TextField("path", dataFiles[i].getCanonicalPath(), Field.Store.YES));
                 document.add(new TextField("contents", txtReader));
                 indexWriter.addDocument(document);
             }
         }
         indexWriter.commit();
         indexWriter.close();
         long endTime = new Date().getTime();

         System.out.println("It takes " + (endTime - startTime)
                 + " milliseconds to create index for the files in directory "
                 + dataDir.getPath());
     }
 */
    @Test
    public void jsoupTest() throws Exception {
        for (int i = 0; i < 100; i++) {
            Document document = Jsoup.connect("https://www.baidu.com/s?wd=北京&pn=" + i + "0&oq=北京&ie=utf-8&usm=4&rsv_idx=1&rsv_pq=ae49e3c100037773&rsv_t=95868VROld23H9%2F8CB6NvSyAsWvNmctBii9M4VeqsaStQN3pMjb8mdcSu%2FI").get();
            Elements contentDiv = document.select("div.result.c-container");
            for (Element element : contentDiv) {
                String h3 = element.select("h3").first().text();
                String href = element.select("h3").select("a").attr("abs:href");
                System.out.println(h3 + "----" + href);
            }
            System.out.println("********************第" + i + "页**********************");
        }
    }

    @Test
    public void name() throws Exception {
        String html = "<html><p>An <a href='http://example.com/'><b>example</b></a> link.</html>";
        Document doc = Jsoup.parse(html);
        doc.getElementsByTag("a").remove();
        System.out.println(doc);
    }

    @Test
    public void enumTest() throws Exception {

        Person person = new Person();
        person.setName("hanfei");
        person.setAge(25);
        person.setSalary(10000.0);
        Dept dept = new Dept();
        dept.setDeptId("123456");
        dept.setName("北京市");
        List<Dept> list = new ArrayList<>();
        list.add(dept);
        list.add(dept);
        person.setDept(list);
        System.out.println(toXML(Person.class, person));
        Field[] declaredFields = Person.class.getDeclaredFields();


    }

    @Test
    public void enumTest2() throws Exception {
        String xml = "<Person>\n" +
                "  <name>hanfei</name>\n" +
                "  <age>25</age>\n" +
                "  <salary>10000.0</salary>\n" +
                "  <Dept>\n" +
                "    <deptId>123456</deptId>\n" +
                "    <name>北京市</name>\n" +
                "  </Dept>\n" +
                "  <Dept>\n" +
                "    <deptId>123456</deptId>\n" +
                "    <name>北京市</name>\n" +
                "  </Dept>\n" +
                "</Person>";
        Person person = (Person) toObj(Person.class, xml);
        System.out.println(person);
    }

    private <T> String toXML(Class<T> clazz, T object) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(Person.class);
        xStream.setMode(XStream.NO_REFERENCES);
        String s = xStream.toXML(object);
        return s;
    }

    private <T> T toObj(Class<T> clazz, String objXML) {
        XStream xStream = new XStream(new DomDriver());
        xStream.aliasPackage("", "com.hanfei.test");
        xStream.addImplicitCollection(clazz, "dept");
        xStream.setMode(XStream.NO_REFERENCES);
        T obj = (T) xStream.fromXML(objXML);
        return obj;
    }

    @Test
    public void test8() throws Exception {
        String html = HttpUtil.httpGet("http://www.bilibili.com");
        System.out.println(html);
        Document parse = Jsoup.parse(html);
        Elements meta = parse.select("meta");
        for (Element element : meta) {
            System.out.println(element.attr("content"));
        }
    }

    @Test
    public void test9() throws Exception {

    }

}