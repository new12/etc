package lky.web.Controller;

import com.google.common.collect.Maps;
import lky.entity.Permission;
import lky.entity.User;
import lky.service.PermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/1.
 */
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @RequestMapping(value = "/")
    private String index(){
        return "permission";
    }

    @RequestMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public void add(@Valid @ModelAttribute Permission permission){
        permissionService.createPermission(permission);
    }

    @RequestMapping(value = "/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam("id") String id){
        permissionService.deletePermission(Long.valueOf(id));
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String,List<Permission>> list(){
        Map<String,List<Permission>> maps = Maps.newHashMap();
        maps.put("data",permissionService.listPermission());
        return maps;
    }
}
