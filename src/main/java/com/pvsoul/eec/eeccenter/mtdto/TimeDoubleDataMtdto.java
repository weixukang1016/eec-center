package com.pvsoul.eec.eeccenter.mtdto;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeDoubleDataMtdto {

    private MWCellArray time;

    private MWNumericArray data;
}
