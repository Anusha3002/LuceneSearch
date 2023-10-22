package com.lucenesearch.searcher;

import com.lucenesearch.model.Product;
import com.lucenesearch.util.LuceneDocumentUtil;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import static com.lucenesearch.config.Constants.INDEX_DIR;

import java.util.List;

public class TestSearchV2 {

    public static void main(String str[]) {


        try {
            //testDefault();
            // index dir
            String indexDir = INDEX_DIR;
            // create a query object
            Query query = buildBooleanQuery();

            // create the seacher obbject

            Searcher s = new Searcher(indexDir);

            SortField softField = new SortField("id", SortField.Type.STRING, false);
            Sort sort = new Sort(softField);
            SearcherResult result = s.search(query, 10, sort);

            // how many result
            System.out.println(" Total document "+result.getTotalHits());

            // convert back document to product
            List<Product> products = LuceneDocumentUtil.convertDocumentsToProducts(result.getMatchingProducts());

            // print the result
            products.forEach((k) -> {
                System.out.println(k.getId());
            });


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void testDefault() {
        try {
            // index dir
            String indexDir = INDEX_DIR;
            // create a query object
            Query query = buildDefault("a*");

            // create the seacher obbject

            Searcher s = new Searcher(indexDir);

            SortField softField = new SortField("id", SortField.Type.STRING, false);
            Sort sort = new Sort(softField);
            SearcherResult result = s.search(query, 10, sort);

            // how many result
            System.out.println(" Total document "+result.getTotalHits());

            // convert back document to product
            List<Product> products = LuceneDocumentUtil.convertDocumentsToProducts(result.getMatchingProducts());

            // print the result
            products.forEach((k) -> {
                System.out.println(k.getId());
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Query buildDefault(String searchStr) throws ParseException {
        //We will use standard analyzer while we parse our query.
        Analyzer analyzer = new StandardAnalyzer();
        //This query parser will search in title field by default if no field is specified.
        //Also, this will use our Standard analyzer to create terms for the query.
        QueryParser queryParser = new QueryParser("defaultField", analyzer);
        //We pass in the title as it is to the query parser.
        // This will create a term query for us on the terms in our title.
        Query query = queryParser.parse(searchStr);

        return query;

    }

    public static Query buildBooleanQuery() throws ParseException {
        //We will use standard analyzer while we parse our query.
        Analyzer analyzer = new StandardAnalyzer();
        //This query parser will search in title field by default if no field is specified.
        //Also, this will use our Standard analyzer to create terms for the query.
        Query query1 = new TermQuery(new Term("id", "27956"));
        Query query2 = new TermQuery(new Term("id", "27997"));
        Query query3 = new TermQuery(new Term("id", "29057"));
        BooleanQuery query = new BooleanQuery.Builder()
                .add(query1, BooleanClause.Occur.SHOULD)
                .add(query2, BooleanClause.Occur.SHOULD)
                .add(query3, BooleanClause.Occur.SHOULD)
                .setMinimumNumberShouldMatch(1)

                .build();

        //27956
        //27997
        //29057
        return query;

    }

}
