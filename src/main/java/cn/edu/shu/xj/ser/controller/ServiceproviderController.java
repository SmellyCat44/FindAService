package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Admin;
import cn.edu.shu.xj.ser.entity.Service;
import cn.edu.shu.xj.ser.entity.Serviceprovider;
import cn.edu.shu.xj.ser.service.IAdminService;
import cn.edu.shu.xj.ser.service.IServiceproviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "ServiceproviderInterface")
@RequestMapping("/serviceprovider")
@RestController
@CrossOrigin("http://localhost:3000")
public class ServiceproviderController {

    @Autowired
    IServiceproviderService serviceproviderService;

    @ApiOperation(value = "serviceprovider_login")
    @PostMapping("/login")
    public String Serviceproviderlogin(@RequestParam(value = "provider_id")String pid, @RequestParam(value = "provider_pwd")String ppd){
        Serviceprovider oneServiceprovider = serviceproviderService.findSpbyId(pid);
        if (oneServiceprovider==null) return "empty";
        else{
            if(oneServiceprovider.getProviderPwd().equals(ppd)) return pid;
            else return "wrong pwd!";
        }
    }

    @ApiOperation(value = "serviceprovider_changeinfo")
    @PostMapping("/save")
    public boolean save(@RequestBody Serviceprovider serviceprovider){
        return serviceproviderService.saveOrUpdate(serviceprovider);
    }

    @ApiOperation(value = "serviceprovider_register")
    @PostMapping("/register")
    public String register(@RequestBody Serviceprovider serviceprovider){
        Serviceprovider oneServiceprovider = serviceproviderService.findSpbyId(serviceprovider.getProviderId());
        if(oneServiceprovider!=null) return "user does exsit!";
        else serviceproviderService.saveOrUpdate(serviceprovider);
        return serviceprovider.getProviderId();
    }

    @ApiOperation(value = "admin_verify_serviceprovider")
    @PostMapping("/admin_verify")
    public int adminVerify(@RequestParam(value = "provider_id") String pid){
        Serviceprovider onesp = serviceproviderService.getById(pid);
        if(onesp == null) return -1;
        return serviceproviderService.adminVerify(pid);
    }

    @ApiOperation(value = "admin_verify_serviceprovider")
    @GetMapping("/admin_checklist")
    public List<Serviceprovider> verifinglist(){ return serviceproviderService.verifing_list();}

    @ApiOperation(value = "admin_reject_serviceprovider")
    @PostMapping("/admin_reject")
    public int adminReject(@RequestParam(value = "provider_id") String pid){
        Serviceprovider onesp = serviceproviderService.getById(pid);
        if(onesp == null) return -1;
        return serviceproviderService.adminReject(pid);
    }

    @ApiOperation(value = "admin_request_serviceprovider")
    @PostMapping("/admin_request")
    public int adminRequest(@RequestParam(value = "provider_id") String pid){
        Serviceprovider onesp = serviceproviderService.getById(pid);
        if(onesp == null) return -1;
        return serviceproviderService.adminRequest(pid);
    }

    @ApiOperation(value = "admin_delete_provider")
    @PostMapping("/admin_delete_provider")
    public boolean adminDeleteProvider(@RequestParam(value = "provider_id") String pid){
        Serviceprovider onesp = serviceproviderService.getById(pid);
        if(onesp == null) return false;
        if (onesp.getVerified()==1)  return serviceproviderService.removeById(pid);
        else return false;
    }

    @ApiOperation(value = "provider_update_request")
    @PostMapping("/provider_update_request")
    public boolean providerUpdateRequest(@RequestParam(value = "provider_id") String pid, @RequestParam(value = "description") String des){
        Serviceprovider onesp = serviceproviderService.getById(pid);
        if(onesp == null) return false;
        if (onesp.getVerified()==2) return serviceproviderService.providerUpdateRequest(pid,des);
        else return false;
    }

    @ApiOperation(value = "get_provider_verified")
    @PostMapping("/get_provider_verified")
    public Integer getProviderVerified(@RequestParam(value = "provider_id") String pid){
        Serviceprovider onesp = serviceproviderService.getById(pid);
        if(onesp == null) return -99;//it means the service_provider does not exist
        else return onesp.getVerified();
    }


}
