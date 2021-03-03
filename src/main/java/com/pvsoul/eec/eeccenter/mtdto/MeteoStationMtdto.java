package com.pvsoul.eec.eeccenter.mtdto;

import com.mathworks.toolbox.javabuilder.MWStructArray;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeteoStationMtdto {

    private MWStructArray location;

    private MWStructArray sensor;

    private MWStructArray cooked_data;
}
