package com.pvsoul.eec.eeccenter.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class CalculateMetoeCookedDataResponesDto implements Serializable {

    private static final long serialVersionUID = -3014662397170333266L;

    private Double GHI;

    private Double SunZen;

    private Double SunAz;

    private Double HExtra;

    private Double AM;

    private Double Pwat;

    private Double DNI;

    private Double DHI; 
}
