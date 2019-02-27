package com.erihackton.shopping;

import org.springframework.stereotype.Component;

@Component
public class ThorAxe {
    String name ="storm breaker";
    String origin ="Nivdelia";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }
}
