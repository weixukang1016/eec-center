package com.pvsoul.eec.eeccenter.dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoDataDto implements Serializable {

    private static final long serialVersionUID = 7872731538679104857L;

    @JsonProperty("DeviceTime")
    private Date deviceTime;

    /**
     * 气温（单位：℃）
     */
    @JsonProperty("Temperature")
    private Float temperature;

    /**
     * 相对湿度
     */
    @JsonProperty("Humidity")
    private Float humidity;

    /**
     * 降雨(false：未降雨，true：降雨）
     */
    @JsonProperty("RainFall")
    private Boolean rainFall;

    /**
     * 大气压（单位：帕）
     */
    @JsonProperty("Pressure")
    private Float pressure;

    /**
     * 风向（0~15的值，分别代表22.5度，0：北风，8：南风，4：东风，12：西风
     */
    @JsonProperty("WindDirection")
    private Integer windDirection;

    /**
     * 风速
     */
    @JsonProperty("WindSpeed")
    private Float windSpeed;

    /**
     * 太阳总辐射（单位：W/㎡）
     */
    @JsonProperty("Irradiance")
    private Float irradiance;
}
