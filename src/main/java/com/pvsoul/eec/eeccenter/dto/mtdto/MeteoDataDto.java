package com.pvsoul.eec.eeccenter.dto.mtdto;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class MeteoDataDto {
    private MWCellArray time_stamp;

    private MWNumericArray value;

    public MWCellArray getTime_stamp() {
        return  time_stamp;
    }

    public void setTime_stamp(MWCellArray time_stamp) {
        this.time_stamp = time_stamp;
    }

    public MWNumericArray getValue(){
        return value;
    }

    public void setValue(MWNumericArray value) {
        this.value = value;
    }
}
