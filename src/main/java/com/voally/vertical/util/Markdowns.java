package com.voally.vertical.util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Markdowns {

    private static final String MARKED_ENGINE_URL = "http://localhost:8250";

    private static String toHtmlByMarked(final String markdownText) throws Exception {
        final URL url = new URL(MARKED_ENGINE_URL);
        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(100);
        conn.setReadTimeout(1000);
        conn.setDoOutput(true);

        try (final OutputStream outputStream = conn.getOutputStream()) {
            IOUtils.write(markdownText, outputStream, "UTF-8");
        }

        String ret;
        try (final InputStream inputStream = conn.getInputStream()) {
            ret = IOUtils.toString(inputStream, "UTF-8");
        }
        //conn.disconnect();

        return ret;
    }
}
