import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ex01_StandardAnalyzer {

    private static final String SAMPLE_TEXT = "Dieses Wappen auf landesmuseen.at enthält Ritter, Löwe and some english dashed-text";

    public static void main(String[] args) throws Exception {
        {
            Analyzer analyzer = new StandardAnalyzer();
            List<String> result = new ArrayList<String>();

            // http://lucene.apache.org/core/8_1_1/core/org/apache/lucene/analysis/TokenStream.html
            TokenStream tokenStream = analyzer.tokenStream("text", SAMPLE_TEXT);
            CharTermAttribute attr = tokenStream.addAttribute(CharTermAttribute.class);
            tokenStream.reset();

            while (tokenStream.incrementToken()) {
                result.add(attr.toString());
            }

            System.out.println(result);

        }
    }
}
