package com.liululu.demoLucene;

import java.io.File;
import  java.io.IOException;   
import java.util.List;

import  org.apache.lucene.analysis.Analyzer;   
import  org.apache.lucene.analysis.standard.StandardAnalyzer;   
import org.apache.lucene.index.IndexReader;
import  org.apache.lucene.queryParser.ParseException;   
import  org.apache.lucene.queryParser.QueryParser;   
import  org.apache.lucene.search.IndexSearcher;   
import  org.apache.lucene.search.Query;   
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
  
public   class  TestQuery  {   
     private static Query query;

	public   static   void  main(String[] args)  throws  IOException, ParseException  {   
        int hits = 0 ;   
        String queryString  =   "你好" ;   
        query = null;
        String field = "body";
        File searchDir  =   new  File( " E:/luncetestfile " );
        IndexReader reader = IndexReader.open(FSDirectory.open(searchDir), true);
        IndexSearcher searcher  =  new  IndexSearcher(reader);   
  
        Analyzer analyzer  =   new  StandardAnalyzer(Version.LUCENE_CURRENT);   
         try   {   
            QueryParser qp  =   new  QueryParser(Version.LUCENE_CURRENT,field, analyzer);   
            query  =  qp.parse(queryString);   
        }   catch  (ParseException e)  {   
        }    
         while  (searcher  !=   null )  {   
            searcher.search(query, null, 100);
            hits++;
         }
             if  (hits>   0 )  {   
                System.out.println( "找到: "   +  hits  +   "  个结果! " );   
            }    
        }    
    }  
  
