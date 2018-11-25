package com.kovalenkovolodymyr.builder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static com.kovalenkovolodymyr.builder.NewsApiConst.ENDPOINT;

public abstract class AbstractNewsApiRequestBuilder<T extends AbstractNewsApiRequestBuilder<T>> {

    protected final static Client client = ClientBuilder.newClient();

    private String path;
    private String apiKey;
    private String q;
    private String sources;
    private Integer pageSize;
    private Integer page;

    protected abstract T self();

    public AbstractNewsApiRequestBuilder() {
        path = path();
    }
    public abstract String path();

    public T apiKey(String k) {
        apiKey = k;
        return self();
    }

    public T q(String q) {
        this.q = q;
        return self();
    }

    public T sources(String s) {
        sources = s;
        return self();
    }

    public T pageSize(Integer ps) {
        pageSize = ps;
        return self();
    }

    public T page(Integer p) {
        page = p;
        return self();
    }

    public WebTarget build() {
        WebTarget target;
        // mandatory
        if (path == null) {
            throw new IllegalArgumentException("Parameter 'path' should not be null");
        }
        target = client.target(ENDPOINT).path(path);
        if (apiKey == null) {
            throw new IllegalArgumentException("Parameter 'apiKey' should not be null");
        }
        target = target.queryParam("apiKey", apiKey);
        // optional
        if (q != null) target = target.queryParam("q", q);
        if (page != null) target = target.queryParam("page", page);
        if (pageSize != null) target = target.queryParam("pageSize", pageSize);
        if (sources != null) target = target.queryParam("sources", sources);
        return target;
    }
}
