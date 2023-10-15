# LuceneSearch
A Search Engine based on Lucene.
Apache Lucene is a free and open-source search engine software library, originally written in Java. 
Lucene is widely used as a standard foundation for production search applications

This Project uses:

Oracle JDK 11
Lucene 9.8.1
Installation

The easiest way to use Lucene in your project is to import it using Maven. You need to at least import lucene-core (just pasting the following to your pom.xml's dependencies).

<dependency>
    <groupId>org.apache.lucene</groupId>
    <artifactId>lucene-core</artifactId>
    <version>8.10.1</version>
</dependency>

You may also need lucene-analyzers-common and lucene-queryparser.

<dependency>
    <groupId>org.apache.lucene</groupId>
    <artifactId>lucene-analyzers-common</artifactId>
    <version>9.8.1</version>
</dependency>
<dependency>
    <groupId>org.apache.lucene</groupId>
    <artifactId>lucene-queryparser</artifactId>
    <version>8.10.1</version>
</dependency>


# Lucene : Searching the already indexed documents and different criteria

<h3>Query Parsing logic</h3>

https://lucene.apache.org/core/2_9_4/queryparsersyntax.html#Overview


#. Available Type of query in lucene

BooleanQuery
ConstantScoreQuery
CustomScoreQuery
DisjunctionMaxQuery
FilteredQuery
MatchAllDocsQuery
MultiPhraseQuery
MultiTermQuery
PhraseQuery
RangeQuery
SpanQuery
TermQuery
ValueSourceQuery

# BooleanQuery is most important and it follows, AND, OR, MUST, MUST_NOT and SHOULD

BooleanQuery can be created using other other type of query and BooleanQuery itself


You can view this in details here

https://riptutorial.com/lucene/example/19933/booleanquery

# Example Boolean Query

String str = "foo bar";
String id = "123456";
BooleanQuery bq = new BooleanQuery();
Query query = qp.parse(str);
bq.add(query, BooleanClause.Occur.MUST);
bq.add(new TermQuery(new Term("id", id), BooleanClause.Occur.MUST_NOT);



