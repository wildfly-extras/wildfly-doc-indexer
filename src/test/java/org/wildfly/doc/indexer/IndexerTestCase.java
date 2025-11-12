package org.wildfly.doc.indexer;

import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

public class IndexerTestCase {

    @Test
    public void testProcessData() {
        Indexer indexer = new Indexer();

        Document doc = Jsoup.parse("""
                <div id="content">
                    <h1 class="sect0">
                        <a class="anchor" href="#section0"></a>
                        Different flavors of WildFly
                    </h1>
                    <div class="openblock partintro">
                       <div class="content">
                          <div class="paragraph">
                             <p>Open Block Paragraph One</p>
                          </div>
                          <div class="paragraph">
                             <p>Open Block Paragraph Two</p>
                          </div>
                       </div>
                    </div>
                    <div class="sect1">
                       <h2><a class="anchor" href="#section1"></a>1. Title</h2>
                       <div class="sectionbody">
                          <div class="paragraph">
                             <p>Section 1 Paragraph One</p>
                          </div>
                          <div class="paragraph">
                             <p>Section 1 Paragraph two</p>
                          </div>
                          <div class="sect2">
                             <h3><a class="anchor" href="#section1"></a>1.1. Title</h3>
                             <div class="paragraph">
                               <p>Section 1.1 Paragraph</p>
                             </div>
                             <div class="sect3">
                                <h4><a class="anchor" href="#Section 3"></a> 1.1.1. Title</h4>
                                <div class="paragraph">
                                   <p>Section 1.1.1 Paragraph</p>
                                </div>
                             </div>
                          </div>
                       </div>
                    </div>
                </div>
                """);

        indexer.processContent(doc, Paths.get("test").toString());
    }
}
