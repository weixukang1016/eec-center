package com.pvsoul.eec.eeccenter.service.impl;

import com.mathworks.toolbox.javabuilder.*;
import com.pvsoul.eec.eeccenter.dto.ResultDto;
import com.pvsoul.eec.eeccenter.dto.request.CalculateMetoeCookedDataRequestDto;
import com.pvsoul.eec.eeccenter.dto.request.MeteoDataDto;
import com.pvsoul.eec.eeccenter.dto.request.MeteoStationDto;
import com.pvsoul.eec.eeccenter.dto.response.CalculateMetoeCookedDataResponesDto;
import com.pvsoul.eec.eeccenter.mtdto.*;
import com.pvsoul.eec.eeccenter.service.EecCenterService;
import eecmodel.Class1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
@Slf4j
public class EecCenterServiceImpl implements EecCenterService {

    public ResultDto test() {
        ResultDto resultDto = new ResultDto();

        Object[] result = null;    /* Stores the result */
        Class1 test = null;     /* Stores magic class instance */
        MWStructArray[] mtData = new MWStructArray[2];
        MWCellArray timeStamp = null;
        MWNumericArray value = null;
        MWStructArray meteo_station = null;
        MWStructArray meteo_data = null;
        try
        {
            test = new Class1();
/*
            Properties meteoStationProp = new Properties();
            meteoStationProp.setProperty("latitude", "31.4");
            meteoStationProp.setProperty("longitude", "121.5");
            meteoStationProp.setProperty("altitude", "1");
            meteoStationProp.setProperty("UTC", "8");

 */
            MeteoStationDto station = new MeteoStationDto();
            station.setLatitude(31.4);
            station.setLongitude(121.5);
            station.setAltitude(1.0);
            station.setUTC(8);
            meteo_station = MWStructArray.fromBean(station);

            MeteoDataMtdto data = new MeteoDataMtdto();
            Calendar now = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSX");
            timeStamp = new MWCellArray(new int[]{1511, 1});
            double[][] valueArray = new double[1511][7];
            for (int i = 0; i < 1511; i++) {
                now.add(Calendar.MINUTE, 1);
                String time = sdf.format(now.getTime());
                //timeStamp.setData(time);
                int[] idx = new int[] {i + 1, 1};
                timeStamp.set(idx, time);

                valueArray[i][0] = 7.8;
                valueArray[i][1] = 0;
                valueArray[i][2] = 101716;
                valueArray[i][3] = 93.4;
                valueArray[i][4] = 13;
                valueArray[i][5] = 0;
                valueArray[i][6] = 0;
            }
            data.setTime_stamp(timeStamp);

            value = new MWNumericArray(valueArray, MWClassID.DOUBLE);
            data.setValue(value);

            meteo_data = MWStructArray.fromBean(data);

            mtData[0] = meteo_station;
            mtData[1] = meteo_data;
            /* Compute magic square and print result */
            result = test.f_ClearSky_detection(1, mtData);

            log.info(result[0].toString());
        }
        catch (Exception e)
        {
            log.error("Matlab Error:",e);
        }

        finally
        {
            /* Free native resources */
            MWArray.disposeArray(timeStamp);
            MWArray.disposeArray(value);
            MWArray.disposeArray(meteo_station);
            MWArray.disposeArray(meteo_data);
            MWArray.disposeArray(mtData);
            MWArray.disposeArray(result);
            if (test != null)
                test.dispose();
        }
        return resultDto;
    }

    @Override
    public ResultDto calculateMetoeData(CalculateMetoeCookedDataRequestDto calculateMetoeCookedDataRequestDto) {

        MeteoStationDto meteoStationDto = calculateMetoeCookedDataRequestDto.getMeteoStation();
        MeteoDataDto meteoDataDto = calculateMetoeCookedDataRequestDto.getMeteoData();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        double[][] valueArray = new double[1][1];

        ResultDto resultDto = new ResultDto();

        Object[] result = null;    /* Stores the result */
        Class1 eecModel = null;     /* Stores magic class instance */
        MWStructArray meteoStationStruct = null;
        MWStructArray locationStruct = null;
        MWStructArray sensorStruct = null;
        MWStructArray pyranometerStruct = null;
        MWStructArray maintainanceStruct = null;
        MWCellArray deviceTimeCell = null;
        MWNumericArray pyranometerValue = null;
        MWStructArray rainStruct = null;
        MWLogicalArray rainValue = null;
        MWStructArray tambStruct = null;
        MWNumericArray tambValue = null;
        MWStructArray presssureStruct = null;
        MWNumericArray presssureValue = null;
        MWStructArray RHStruct = null;
        MWNumericArray RHValue = null;
        MWStructArray wind_dirStruct = null;
        MWNumericArray wind_dirValue = null;
        MWStructArray wind_speedStruct = null;
        MWNumericArray wind_speedValue = null;


        try
        {
            eecModel = new Class1();

            MeteoStationMtdto meteoStationMtdto = new MeteoStationMtdto();

            MeteoStationLocationMtdto meteoStationLocationMtdto = new MeteoStationLocationMtdto();
            meteoStationLocationMtdto.setElevation(meteoStationDto.getAltitude());
            meteoStationLocationMtdto.setLatitude(meteoStationDto.getLatitude());
            meteoStationLocationMtdto.setLongitude(meteoStationDto.getLongitude());
            meteoStationLocationMtdto.setUTC(meteoStationDto.getUTC());
            locationStruct = MWStructArray.fromBean(meteoStationLocationMtdto);
            meteoStationMtdto.setLocation(locationStruct);

            MeteoStationSensorMtdto meteoStationSensorMtdto = new MeteoStationSensorMtdto();
            MeteoStationSensorPyranometerMtdto meteoStationSensorPyranometerMtdto = new MeteoStationSensorPyranometerMtdto();
            meteoStationSensorPyranometerMtdto.setTilt_angle(meteoStationDto.getTitlAngle());
            meteoStationSensorPyranometerMtdto.setAzimuth_angle(meteoStationDto.getAzimuthAngle());

            MeteoStationSensorPyranometerMaintainanceMtdto meteoStationSensorPyranometerMaintainanceMtdto = new MeteoStationSensorPyranometerMaintainanceMtdto();
            meteoStationSensorPyranometerMaintainanceMtdto.setLast_calibration_date(meteoStationDto.getLastCalibrationDate());
            meteoStationSensorPyranometerMaintainanceMtdto.setLast_cleaning_date(meteoStationDto.getLastCleaningDate());
            maintainanceStruct = MWStructArray.fromBean(meteoStationSensorPyranometerMaintainanceMtdto);
            meteoStationSensorPyranometerMtdto.setMaintainance(maintainanceStruct);

            deviceTimeCell = new MWCellArray(new int[]{1, 1});
            deviceTimeCell.set(new int[]{1, 1}, sdf.format(meteoDataDto.getDeviceTime()));
            log.info("Time:" + meteoDataDto.getDeviceTime().toString());
            log.info(sdf.format(meteoDataDto.getDeviceTime()));
            meteoStationSensorPyranometerMtdto.setTime(deviceTimeCell);
            valueArray[0][0] = meteoDataDto.getIrradiance().doubleValue();
            pyranometerValue = new MWNumericArray(valueArray, MWClassID.DOUBLE);
            meteoStationSensorPyranometerMtdto.setData(pyranometerValue);

            pyranometerStruct =  MWStructArray.fromBean(meteoStationSensorPyranometerMtdto);
            meteoStationSensorMtdto.setPyranometer(pyranometerStruct);

            TimeLogicalDataMtdto rainDataMtdto = new TimeLogicalDataMtdto();
            rainDataMtdto.setTime(deviceTimeCell);
            rainValue = new MWLogicalArray(MWClassID.LOGICAL);
            rainValue.set(new int[]{1, 1}, meteoDataDto.getRainFall());
            rainDataMtdto.setData(rainValue);
            rainStruct = MWStructArray.fromBean(rainDataMtdto);
            meteoStationSensorMtdto.setRain(rainStruct);

            TimeDoubleDataMtdto tambDataMtdto = new TimeDoubleDataMtdto();
            tambDataMtdto.setTime(deviceTimeCell);
            valueArray[0][0] = meteoDataDto.getTemperature().doubleValue();
            tambValue = new MWNumericArray(valueArray, MWClassID.DOUBLE);
            tambDataMtdto.setData(tambValue);
            tambStruct = MWStructArray.fromBean(tambDataMtdto);
            meteoStationSensorMtdto.setTamb(tambStruct);

            TimeDoubleDataMtdto presssureDataMtdto = new TimeDoubleDataMtdto();
            presssureDataMtdto.setTime(deviceTimeCell);
            valueArray[0][0] = meteoDataDto.getPressure().doubleValue();
            presssureValue = new MWNumericArray(valueArray, MWClassID.DOUBLE);
            presssureDataMtdto.setData(presssureValue);
            presssureStruct = MWStructArray.fromBean(presssureDataMtdto);
            meteoStationSensorMtdto.setPresssure(presssureStruct);

            TimeDoubleDataMtdto RHDataMtdto = new TimeDoubleDataMtdto();
            RHDataMtdto.setTime(deviceTimeCell);
            valueArray[0][0] = meteoDataDto.getHumidity().doubleValue();
            RHValue = new MWNumericArray(valueArray, MWClassID.DOUBLE);
            RHValue.set(new int[]{1, 1}, meteoDataDto.getHumidity().doubleValue());
            RHDataMtdto.setData(RHValue);
            RHStruct = MWStructArray.fromBean(RHDataMtdto);
            meteoStationSensorMtdto.setRH(RHStruct);

            TimeDoubleDataMtdto wind_dirMtdto = new TimeDoubleDataMtdto();
            wind_dirMtdto.setTime(deviceTimeCell);
            valueArray[0][0] = meteoDataDto.getWindDirection().doubleValue();
            wind_dirValue = new MWNumericArray(valueArray, MWClassID.DOUBLE);
            wind_dirMtdto.setData(wind_dirValue);
            wind_dirStruct = MWStructArray.fromBean(wind_dirMtdto);
            meteoStationSensorMtdto.setWind_dir(wind_dirStruct);

            TimeDoubleDataMtdto wind_speedMtdto = new TimeDoubleDataMtdto();
            wind_speedMtdto.setTime(deviceTimeCell);
            valueArray[0][0] = meteoDataDto.getWindSpeed().doubleValue();
            wind_speedValue = new MWNumericArray(valueArray, MWClassID.DOUBLE);
            wind_speedMtdto.setData(wind_speedValue);
            wind_speedStruct = MWStructArray.fromBean(wind_speedMtdto);
            meteoStationSensorMtdto.setWind_speed(wind_speedStruct);

            sensorStruct = MWStructArray.fromBean(meteoStationSensorMtdto);
            meteoStationMtdto.setSensor(sensorStruct);

            meteoStationStruct = MWStructArray.fromBean(meteoStationMtdto);

            result = eecModel.f_meteo_data_processing(1, meteoStationStruct);

            MWStructArray cookedData = (MWStructArray)result[0];

            double[][] GHI = (double[][])cookedData.get("GHI", 1);
            double[][] SunZen = (double[][])cookedData.get("SunZen", 1);
            double[][] SunAz = (double[][])cookedData.get("SunAz", 1);
            double[][] HExtra = (double[][])cookedData.get("HExtra", 1);
            double[][] AM = (double[][])cookedData.get("AM", 1);
            double[][] Pwat = (double[][])cookedData.get("Pwat", 1);
            double[][] DNI = (double[][])cookedData.get("DNI", 1);
            double[][] DHI = (double[][])cookedData.get("DHI", 1);

            CalculateMetoeCookedDataResponesDto calculateMetoeCookedDataResponesDto = new CalculateMetoeCookedDataResponesDto();
            calculateMetoeCookedDataResponesDto.setGHI(GHI[0][0]);
            calculateMetoeCookedDataResponesDto.setSunZen(SunZen[0][0]);
            calculateMetoeCookedDataResponesDto.setSunAz(SunAz[0][0]);
            calculateMetoeCookedDataResponesDto.setHExtra(HExtra[0][0]);
            calculateMetoeCookedDataResponesDto.setAM(AM[0][0]);
            calculateMetoeCookedDataResponesDto.setPwat(Pwat[0][0]);
            calculateMetoeCookedDataResponesDto.setDNI(DNI[0][0]);
            calculateMetoeCookedDataResponesDto.setDHI(DHI[0][0]);

            resultDto.setEntity(calculateMetoeCookedDataResponesDto);
        }
        catch (Exception e)
        {
            resultDto.setCode("-1");
            resultDto.setSuccess(false);
            resultDto.setMsg("Matlab Error");
            log.error("Matlab Error:",e);
        }
        finally
        {
            /* Free native resources */
            MWArray.disposeArray(result);
            MWArray.disposeArray(meteoStationStruct);
            MWArray.disposeArray(locationStruct);
            MWArray.disposeArray(sensorStruct);
            MWArray.disposeArray(pyranometerStruct);
            MWArray.disposeArray(maintainanceStruct);
            MWArray.disposeArray(deviceTimeCell);
            MWArray.disposeArray(pyranometerValue);
            MWArray.disposeArray(rainStruct);
            MWArray.disposeArray(rainValue);
            MWArray.disposeArray(tambStruct);
            MWArray.disposeArray(tambValue);
            MWArray.disposeArray(presssureStruct);
            MWArray.disposeArray(presssureValue);
            MWArray.disposeArray(RHStruct);
            MWArray.disposeArray(RHValue);
            MWArray.disposeArray(wind_dirStruct);
            MWArray.disposeArray(wind_dirValue);
            MWArray.disposeArray(wind_speedStruct);
            MWArray.disposeArray(wind_speedValue);

            if (eecModel != null) {
                eecModel.dispose();
            }
        }
        return resultDto;
    }
}
