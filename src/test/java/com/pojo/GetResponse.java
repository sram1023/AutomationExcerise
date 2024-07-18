package com.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetResponse {

    private String status;
    private Data data;
    private String message;
}
