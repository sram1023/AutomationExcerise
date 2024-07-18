package com.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutResponse {

    private String status;
    private Data data;
    private String message;
}
