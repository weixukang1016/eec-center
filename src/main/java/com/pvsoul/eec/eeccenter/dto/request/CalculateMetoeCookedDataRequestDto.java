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
public class CalculateMetoeCookedDataRequestDto implements Serializable {

    private static final long serialVersionUID = -8016127317906477230L;

    private MeteoStationDto meteoStation;

    private MeteoDataDto meteoData;
}
