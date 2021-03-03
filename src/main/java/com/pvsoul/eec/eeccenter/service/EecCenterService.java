package com.pvsoul.eec.eeccenter.service;

import com.pvsoul.eec.eeccenter.dto.ResultDto;
import com.pvsoul.eec.eeccenter.dto.request.CalculateMetoeCookedDataRequestDto;

public interface EecCenterService {

    public ResultDto test();

    ResultDto calculateMetoeData(CalculateMetoeCookedDataRequestDto calculateMetoeCookedDataRequestDto);
}
