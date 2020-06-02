package com.gxzy.bigdata.einfo.controller;

  import com.gxzy.bigdata.core.http.HttpResult;
  import com.gxzy.bigdata.einfo.service.EInfoService;
  import com.gxzy.bigdata.einfo.service.EmpNewService;
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.security.access.prepost.PreAuthorize;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 */
@RestController
@RequestMapping("empnew")
public class EmpNewController {

    private static final Logger logger = LoggerFactory.getLogger(EInfoController.class);

    @Autowired
    //private EInfoService eInfoService;
     private EmpNewService empNewService;


    @PreAuthorize("hasAuthority('sys:ADF:view')")
    @GetMapping(value = "/empadd")
    public HttpResult EmpAdd() {
        //try {
           // return HttpResult.ok(eInfoService.findMachInfoAll());
      //  } catch (Exception e) {
       //     return HttpResult.error(e.getMessage());
       // }
        try {
          return  HttpResult.ok(empNewService.FindEMI());
        } catch (Exception e) {
            return HttpResult.error(e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('sys:ADF:view')")
    @GetMapping(value = "/empdel")
    public boolean Empdel() {
      //  try {
      //      return HttpResult.ok(eInfoService.findBrandAll());
      //  } catch (Exception e) {
      //      return HttpResult.error(e.getMessage());
       // }
        return  true;
    }

    @PreAuthorize("hasAuthority('sys:ADF:view')")
    @GetMapping(value = "/empshow")
    public HttpResult Empshow() {
       // try {
        //    return HttpResult.ok(eInfoService.findBrandAll());
      //  } catch (Exception e) {
     //       return HttpResult.error(e.getMessage());
      //  }
        try {
             return HttpResult.ok(empNewService.FindEMI());
        } catch (Exception e){
            return HttpResult.error(e.getMessage());
        }
     }
}

