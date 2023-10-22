package org.pabay.search.indexhunt.lucene.service;

import org.pabay.search.indexhunt.lucene.service.impl.DBIndexServiceImpl;

public class ServiceFactory {

    private static IndexService indexService;

    private static Object lock = new Object();

    public static  IndexService createIndexService() {

        if (indexService == null) {
            synchronized (lock) {
                if (indexService == null) {

                   // indexService = new DBIndexServiceImpl();
                }
            }
        }

        return indexService;
    }
}
