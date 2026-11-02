package org.iesteis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiListResponse<T> {
    @JsonProperty("count")
    private int count;
    @JsonProperty("results")
    private List<T> results;
    public ApiListResponse() {}

    public ApiListResponse(int count, List<T> results) {
        this.count = count;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
