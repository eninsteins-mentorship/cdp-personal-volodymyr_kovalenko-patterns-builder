package com.kovalenkovolodymyr.builder.impl;

import com.kovalenkovolodymyr.builder.AbstractNewsApiRequestBuilder;
import com.kovalenkovolodymyr.builder.NewsApiConst;

import javax.ws.rs.client.WebTarget;

public class TopHeadlinesNewsApiRequestBuilder extends AbstractNewsApiRequestBuilder<TopHeadlinesNewsApiRequestBuilder> {
    private String country;
    private String category;

    public static TopHeadlinesNewsApiRequestBuilder builder() {
        return new TopHeadlinesNewsApiRequestBuilder();
    }

    public TopHeadlinesNewsApiRequestBuilder country(String c) {
        country = c;
        return self();
    }

    public TopHeadlinesNewsApiRequestBuilder category(String c) {
        category = c;
        return self();
    }

    @Override
    protected TopHeadlinesNewsApiRequestBuilder self() {
        return this;
    }

    public String path() {
        return NewsApiConst.TOP_HEADLINES_PATH;
    }

    @Override
    public WebTarget build() {
        WebTarget target = super.build();
        if (country != null) target = target.queryParam("country", country);
        if (category != null) target = target.queryParam("category", category);
        return target;
    }
}
