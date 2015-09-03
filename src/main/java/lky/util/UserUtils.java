package lky.util;

import org.apache.shiro.SecurityUtils;

/**
 * Created by Administrator on 2015/8/30.
 */
public class UserUtils {
    public static String getLoginName(){
        return (String)SecurityUtils.getSubject().getPrincipal();
    }
}
