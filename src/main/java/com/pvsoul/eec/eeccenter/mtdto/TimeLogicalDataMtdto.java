package com.pvsoul.eec.eeccenter.mtdto;

import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWLogicalArray;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeLogicalDataMtdto {

    private MWCellArray time;

    private MWLogicalArray data;
}
