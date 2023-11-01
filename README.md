# LuceneSearch
A Search Engine based on Lucene.
Apache Lucene is a free and open-source search engine software library, originally written in Java. 
Lucene is widely used as a standard foundation for production search applications

This Project uses:

1. Oracle JDK 17
2. Lucene 9.8.1
3. Installation
4. Springboot
5. Planning to add vector db (Pinecone) 
+ Semantic Search
  
The easiest way to use Lucene in your project is to import it using Maven. You need to at least import lucene-core (just pasting the following to your pom.xml's dependencies).

<dependency>
    <groupId>org.apache.lucene</groupId>
    <artifactId>lucene-core</artifactId>
    <version>8.10.1</version>
</dependency>

You may also need Lucene-analyzers-common and lucene-queryparser.

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


# Searching documents: BuildQuery

<h3>Query Parsing logic</h3>

https://lucene.apache.org/core/2_9_4/queryparsersyntax.html#Overview


<h3>Available Type of query in lucene</h3>

<ul>
<li>BooleanQuery</li>
    <li>ConstantScoreQuery</li>
    <li>CustomScoreQuery</li>
    <li>DisjunctionMaxQuery</li>
    <li>FilteredQuery</li>
    <li>MatchAllDocsQuery</li>
    <li>MultiPhraseQuery</li>
    <li>MultiTermQuery</li>
    <li>PhraseQuery</li>
    <li>RangeQuery</li>
    <li>SpanQuery</li>
    <li>TermQuery</li>
    <li>ValueSourceQuery</li>
</ul>

<h3>BooleanQuery is most important and it follows, AND, OR, MUST, MUST_NOT and SHOULD </h3>

BooleanQuery can be created using other other type of query and BooleanQuery itself


You can view this in details here

https://riptutorial.com/lucene/example/19933/booleanquery

<h3>Example Boolean Query</h3>
<p>
String str = "foo bar"; <br/>
String id = "123456";<br/>
BooleanQuery bq = new BooleanQuery();<br/>
Query query = qp.parse(str);<br/>
bq.add(query, BooleanClause.Occur.MUST);<br/>
bq.add(new TermQuery(new Term("id", id), BooleanClause.Occur.MUST_NOT);<br/>
</p>


Using spring-boot, java 17, maven, react 
