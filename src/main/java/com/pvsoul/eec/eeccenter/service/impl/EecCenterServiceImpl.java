package com.pvsoul.eec.eeccenter.service.impl;

import com.mathworks.toolbox.javabuilder.*;
import com.pvsoul.eec.eeccenter.dto.ResultDto;
import com.pvsoul.eec.eeccenter.dto.mtdto.MeteoDataDto;
import com.pvsoul.eec.eeccenter.dto.mtdto.MeteoStationDto;
import com.pvsoul.eec.eeccenter.service.EecCenterService;
import f_ClearSkyDetection.Class1;
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
            MeteoStationDto  station = new MeteoStationDto();
            station.setLatitude(31.4);
            station.setLongitude(121.5);
            station.setAltitude(1.0);
            station.setUTC(8);
            meteo_station = MWStructArray.fromBean(station);

            MeteoDataDto data = new MeteoDataDto();
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
            result = test.f_ClearSkyDetection(1, mtData);

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
}
