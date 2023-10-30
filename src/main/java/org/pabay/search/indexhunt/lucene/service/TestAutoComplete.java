package org.pabay.search.indexhunt.lucene.service;

import java.io.IOException;
import java.util.List;

public class TestAutoComplete {

    public static void main(String args[]) {

        AutoCompleteService autoCompleteService = new AutoCompleteService();

        try {
            // create the two indexes 1. autocomplete 2. normal indexing
            autoCompleteService.initialize();
            // search for auto complete
            List<String> suggestion = autoCompleteService.suggestTermsFor("an");

            for (String a:suggestion ) {
                System.out.println(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
