import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {

    public static Japanese parseWord() throws IOException {

        Japanese japanese = new Japanese();


        String level = "2";
        int index = 0;
        for (int i = 1; i <= 46; i++) {
            String page = String.valueOf(i);
            String url = "https://wordbook.daum.net/open/wordbook.do?id=23&&page=" + page;
            Connection connect = Jsoup.connect(url);
            Document document = connect.get();

            //        System.out.println("document = " + document);
            Elements rows = document.getElementsByClass("wrap_word ");

            for (Element row : rows) {
                index++;
                //            System.out.println("row = " + row);
                Elements means = row.getElementsByClass("layer_body");
                Elements japaneses = row.getElementsByClass("f_l");
                japanese.getWord().add(japaneses.text());
                japanese.getMeans().add(means.text());

            }
        }

        japanese.setTotalCount(index);
        for (int i = 0; i < index ; i++) {
            System.out.println("word = " + japanese.getWord().get(i));
            System.out.println("means = " +japanese.getMeans().get(i));
        }
        return japanese;
    }


}
