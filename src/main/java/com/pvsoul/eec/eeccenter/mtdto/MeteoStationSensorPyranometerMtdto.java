package com.pvsoul.eec.eeccenter.mtdto;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import com.mathworks.toolbox.javabuilder.MWStructArray;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeteoStationSensorPyranometerMtdto {

    private Double tilt_angle;

    private Double azimuth_angle;

    private MWStructArray maintainance;

    private MWCellArray time;

    private MWNumericArray data;

    public void setTilt_angle(Double tilt_angle) {
        this.tilt_angle = tilt_angle;
    }

    public Double getTilt_angle() {
        return this.tilt_angle;
    }

    public void setAzimuth_angle(Double azimuth_angle) {
        this.azimuth_angle = azimuth_angle;
    }

    public Double getAzimuth_angle() {
        return azimuth_angle;
    }
/*
    public void setMaintainance(MWStructArray maintainance) {
        this.maintainance = maintainance;
    }

    public MWStructArray getMaintainance() {
        return maintainance;
    }

    public void setTime(MWNumericArray time) {
        this.time = time;
    }

    public MWNumericArray getTime() {
        return time;
    }

    public void setData(MWNumericArray data) {
        this.data = data;
    }

    public MWNumericArray getData() {
        return data;
    }
 */
}
