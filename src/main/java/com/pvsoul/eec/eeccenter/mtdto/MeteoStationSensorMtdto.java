package com.pvsoul.eec.eeccenter.mtdto;

import com.mathworks.toolbox.javabuilder.MWStructArray;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeteoStationSensorMtdto {

    private MWStructArray pyranometer;

    private MWStructArray rain;

    private MWStructArray tamb;

    private MWStructArray presssure;

    private MWStructArray RH;

    private MWStructArray wind_dir;

    private MWStructArray wind_speed;

}
