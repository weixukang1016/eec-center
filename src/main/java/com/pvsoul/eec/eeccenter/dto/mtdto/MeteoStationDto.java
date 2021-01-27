package com.pvsoul.eec.eeccenter.dto.mtdto;

public class MeteoStationDto {

    private Double latitude;

    private Double longitude;

    private Double altitude;

    private int UTC;

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public int getUTC() {
        return UTC;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public void setUTC(int UTC) {
        this.UTC = UTC;
    }
}
