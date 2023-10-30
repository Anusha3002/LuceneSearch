package org.pabay.search.indexhunt.lucene.analyser;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.standard.StandardTokenizer;

public class AutocompleteAnalyzer extends Analyzer  {

    @Override
    protected TokenStreamComponents createComponents(String s) {
        Tokenizer source = new StandardTokenizer();
        TokenFilter filter = new LowerCaseFilter(source);
        return new TokenStreamComponents(source, filter);
    }
}
