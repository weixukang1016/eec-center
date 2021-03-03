package com.pvsoul.eec.eeccenter.mtdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeteoStationSensorPyranometerMaintainanceMtdto {

    private String last_calibration_date;

    private String last_cleaning_date;

    public void setLast_calibration_date(String last_calibration_date) {
        this.last_calibration_date = last_calibration_date;
    }

    public String getLast_calibration_date() {
        return last_calibration_date;
    }

    public void setLast_cleaning_date(String last_cleaning_date) {
        this.last_cleaning_date = last_cleaning_date;
    }

    public String getLast_cleaning_date() {
        return last_cleaning_date;
    }
}
