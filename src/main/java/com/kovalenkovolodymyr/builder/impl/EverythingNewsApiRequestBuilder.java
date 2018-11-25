package com.kovalenkovolodymyr.builder.impl;

import com.kovalenkovolodymyr.builder.AbstractNewsApiRequestBuilder;
import com.kovalenkovolodymyr.builder.NewsApiConst;

import javax.ws.rs.client.WebTarget;

public class EverythingNewsApiRequestBuilder extends AbstractNewsApiRequestBuilder<EverythingNewsApiRequestBuilder> {
    private String domains;
    private String excludeDomains;
    private String from;
    private String to;
    private String language;
    private String sortBy;

    public static EverythingNewsApiRequestBuilder builder() {
        return new EverythingNewsApiRequestBuilder();
    }

    public EverythingNewsApiRequestBuilder domains(String c) {
        domains = c;
        return self();
    }

    public EverythingNewsApiRequestBuilder excludeDomains(String c) {
        excludeDomains = c;
        return self();
    }

    public EverythingNewsApiRequestBuilder from(String f) {
        from = f;
        return self();
    }

    public EverythingNewsApiRequestBuilder to(String t) {
        to = t;
        return self();
    }

    public EverythingNewsApiRequestBuilder language(String l) {
        language = l;
        return self();
    }

    public EverythingNewsApiRequestBuilder sortBy(String s) {
        sortBy = s;
        return self();
    }

    @Override
    protected EverythingNewsApiRequestBuilder self() {
        return this;
    }

    public String path() {
        return NewsApiConst.EVERYTHING_PATH;
    }

    @Override
    public WebTarget build() {
        WebTarget target = super.build();
        if (domains != null) target = target.queryParam("domains", domains);
        if (excludeDomains != null) target = target.queryParam("excludeDomains", excludeDomains);
        if (from != null) target = target.queryParam("from", from);
        if (to != null) target = target.queryParam("to", to);
        if (language != null) target = target.queryParam("language", language);
        if (sortBy != null) target = target.queryParam("sortBy", sortBy);
        return target;
    }
}
