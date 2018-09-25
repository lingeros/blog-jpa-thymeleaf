package net.togogo.blogjpathymeleaf.controller;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author ling
 * @date 2018/9/19  19:15
 * @function:
 */
@RestController
public class SolrController {

    @Autowired
    private SolrClient client;

    @RequestMapping("/")
    public String testSolr() throws IOException, SolrServerException {
        SolrDocument document = client.getById("collection1", "3");
        if(document != null){
            System.out.println(document);
        }

        return document.toString();
    }
}
