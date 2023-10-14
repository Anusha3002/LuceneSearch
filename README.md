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
    <version>8.10.1</version>
</dependency>
<dependency>
    <groupId>org.apache.lucene</groupId>
    <artifactId>lucene-queryparser</artifactId>
    <version>8.10.1</version>
</dependency>
