package com.pvsoul.eec.eeccenter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDto implements Serializable {

    private static final long serialVersionUID = 3905756703742518796L;

    //成功
    @JsonProperty("success")
    private Boolean success = true;

    //应答码，0 代表成功
    @JsonProperty("code")
    private String code = "0";

    //错误消息，成功的情况消息为空
    @JsonProperty("msg")
    private String msg = "";

    //成功
    @JsonProperty("entity")
    private Object entity;
}
