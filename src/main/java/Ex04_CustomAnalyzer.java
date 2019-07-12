import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.apache.lucene.analysis.de.GermanAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.util.ArrayList;
import java.util.List;

public class Ex04_CustomAnalyzer {

    private static final String SAMPLE_TEXT = "Dieses Wappen auf landesmuseen.at enthält Ritter, Löwe and some english dashed-text";

    public static void main(String[] args) throws Exception {
        {
            Analyzer analyzer = CustomAnalyzer.builder()
                    .withTokenizer("standard")
                    .addTokenFilter("lowercase")
                    .addTokenFilter("stop")
                    .addTokenFilter("capitalization")
                    .build();
            List<String> result = new ArrayList<String>();

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
