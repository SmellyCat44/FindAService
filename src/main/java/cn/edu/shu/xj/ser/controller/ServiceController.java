package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Service;
import cn.edu.shu.xj.ser.service.IServiceService;
import cn.edu.shu.xj.ser.service.impl.ServiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "ServiceInterface")
@RequestMapping("/service")
@RestController
@CrossOrigin("http://localhost:3000")
public class ServiceController {

    @Autowired
    IServiceService serviceService;

    @ApiOperation(value = "add_service/modify_service")
    @PostMapping("/save")
    public boolean register(@RequestBody Service service){
        return serviceService.saveOrUpdate(service);
    }

    @ApiOperation(value = "user_browse_services")
    @GetMapping("/user_list")
    public List<Service> list(){ return serviceService.verified_list();}

    @ApiOperation(value = "admin_verify_service")
    @PostMapping("/admin_verify")
    public boolean adminVerify(@RequestParam(value = "service_id") Integer sid){
        Service oneService = serviceService.getById(sid);
        if(oneService == null) return false;
        return serviceService.adminVerify(sid);
    }

    @ApiOperation(value = "admin_verify_service")
    @GetMapping("/admin_checklist")
    public List<Service> verifinglist(){ return serviceService.verifing_list();}

    @ApiOperation(value = "search_by_id")
    @PostMapping("/search_by_id")
    public Service searchById(@RequestParam(value = "service_id") Integer sid){
        //return serviceService.getById(sid);
        return serviceService.searchById(sid);
    }

    @ApiOperation(value = "search_by_name")
    @PostMapping("/search_by_name")
    public List<Service> searchById(@RequestParam(value = "service_description") String sd){
        return serviceService.searchByName(sd);
    }

    @ApiOperation(value = "search_by_area")
    @PostMapping("/search_by_area")
    public List<Service> searchByArea(@RequestParam(value = "service_area") String sa){
        return serviceService.searchByArea(sa);
    }

    @ApiOperation(value = "search_by_category")
    @PostMapping("/search_by_category")
    public List<Service> searchByCategory(@RequestParam(value = "service_category") Integer sc){
        return serviceService.searchByCategory(sc);
    }

    @ApiOperation(value = "search_by_area_category")
    @PostMapping("/search_by_area_category")
    public List<Service> searchByAreaCategory(@RequestParam(value = "service_area") String sa, @RequestParam(value = "service_category") Integer sc){
        return serviceService.searchByAreaCategory(sa,sc);
    }

    @ApiOperation(value = "provider_list")
    @PostMapping("/provider_list")
    public List<Service> providerList(@RequestParam(value = "provider_id") String pid){
        return serviceService.providerList(pid);
    }
}
