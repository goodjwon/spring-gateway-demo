package org.example;

import java.util.List;


public class Member {
    private String id;
    private String name;
    private List<String> allowedProductIds;

    public Member(String id, String name, List<String> allowedProductIds) {
        this.id = id;
        this.name = name;
        this.allowedProductIds = allowedProductIds;
    }

    // Getters and setters
}
