package com.picc.rule.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.picc.common.controller.BaseController;
import com.picc.common.entity.FebsResponse;
import com.picc.common.entity.QueryRequest;
import com.picc.rule.entity.PrpClaimInfo;
import com.picc.rule.service.IPrpclaimService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 示例见test包下CRUDDemo.java
 * 单标查询可以做到零sql
 * Created by Administrator on 2019/9/30.
 */
@Slf4j
@RestController
@RequestMapping("prp")
public class PrpClaimController extends BaseController {
    @Autowired
    private IPrpclaimService iPrpclaimService;

    /**
     * mybatisplus方式查询
     *
     * @param id
     * @return
     */
    @GetMapping("list")
    public FebsResponse loginLogList(@RequestParam String id) {
        PrpClaimInfo prpClaimInfo  = iPrpclaimService.findbyId("17f1bc4e-28dc-4c0e-ae4a-2f790ace5b34");
//        PrpClaimInfo prpClaimInfo  = iPrpclaimService.getById("17f1bc4e-28dc-4c0e-ae4a-2f790ace5b34");

        return new FebsResponse().success().data(prpClaimInfo);
    }

    /**
     * 通过 xml方式查询
     * @param id
     * @return
     */
    @GetMapping("list2")
    public FebsResponse loginLogList2(@RequestParam String id) {
        PrpClaimInfo prpClaimInfo  = iPrpclaimService.findbyMapperId("17f1bc4e-28dc-4c0e-ae4a-2f790ace5b34");
        return new FebsResponse().success().data(prpClaimInfo);
    }

    /**
     * 分页数据
     * @param prpClaimInfo
     * @param queryRequest
     * @return
     */
    @RequestMapping("page")
    public FebsResponse getpage(PrpClaimInfo prpClaimInfo, QueryRequest queryRequest) {
        IPage<PrpClaimInfo> ipage = iPrpclaimService.findAll(prpClaimInfo, queryRequest);
        Map<String, Object> dataTable = getDataTable(ipage);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 注解方式查询
     * @param prpClaimInfo
     * @param queryRequest
     * @return
     */
    @RequestMapping("page2")
    public FebsResponse getpage2(PrpClaimInfo prpClaimInfo,QueryRequest queryRequest) {
        IPage<PrpClaimInfo> ipage = iPrpclaimService.findByRegistno(prpClaimInfo,queryRequest);
        Map<String,Object> dataTable = getDataTable(ipage);
        return  new FebsResponse().success().data(dataTable);
    }

}
