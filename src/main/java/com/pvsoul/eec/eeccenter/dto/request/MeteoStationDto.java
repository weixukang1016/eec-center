package com.pvsoul.eec.eeccenter.dto.request;

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
public class MeteoStationDto implements Serializable {

    private static final long serialVersionUID = 5388305725495787027L;

    private Double latitude;

    private Double longitude;

    private Double altitude;

    @JsonProperty("UTC")
    private int UTC;

    private Double titlAngle;

    private Double azimuthAngle;

    private String lastCalibrationDate;

    private String lastCleaningDate;
}
