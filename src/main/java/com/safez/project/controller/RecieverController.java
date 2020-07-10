package com.safez.project.controller;

import com.safez.project.entity.*;
import com.safez.project.service.HaddoopService;
import com.safez.project.service.YwtanzhenDataUseService;
import com.safez.project.service.YwxtGjDataService;
import com.safez.project.system.service.*;
import com.safez.project.util.IpUtil;
import com.safez.project.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.eclipse.jetty.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/reciever")
@Api(value="/reciever",tags={"数据接收"})
@RestController
public class RecieverController {

        @Autowired
        YwxtJieruService ywxtJieruService;
        @Autowired
        YwtanzhenDataUseService  ywtanzhenDataUseService;
        @Autowired
        YwxtGjDataService ywxtGjDataService;
        @Autowired
        YwxtKeyManagerService     ywxtKeyManagerService;
        @Autowired
        AllowIpService  allowIpService;
        @Autowired
        UserBehaviorService   userBehaviorService;
        @Autowired
        UserTaizhangService userTaizhangService;
        @Autowired
        HaddoopService      haddoopService;
        @ApiOperation(value="接收",tags={"接收"},notes="数据接收")
        @PostMapping(value = "/post")
        public Map<String,Object> getReciver(HttpServletRequest reqquest, HttpServletResponse response) throws Exception {
            Map<String,Object> result = new HashMap<>();
            response.addHeader("Access-Control-Allow-Origin","*");
            String ipAddress = IpUtil.getIpAddress(reqquest);
            String requestUrl = reqquest.getRequestURI();
            String gddataTable = "ywxt_gjdata";
            String ywxtXtmcQdsj = "ywxt_xtmc_qdsj";
            String strDateFormat = "yyyy-MM-ddHH:mm:ss";
            SimpleDateFormat format = new SimpleDateFormat(strDateFormat);
            Date date = new Date();
            String currentDate = format.format(date);
            String sendInfo = reqquest.getParameter("send_info");
            if(StringUtils.isBlank(sendInfo)||sendInfo.length()<16){
                insertYwxtGjData("",ipAddress,"篡改数据");
                return new HashMap<>();
            }
            String ywxitanzhengid = sendInfo.substring(0,16);
            String resultInfo = sendInfo.substring(16);
            YwxtJieruManagerWithBLOBs obj = ywxtJieruService.getObjByTanzhen(ywxitanzhengid);
            String ywid = "";
            //判断是否为攻击数据
            if(obj!=null){
                 ywid= obj.getYwid().toString();
            }else{
                //篡改业务id的攻击数据
                insertYwxtGjData(ywxitanzhengid,ipAddress,"篡改数据");
            }
            //业务系统
            List<YwtanzhenDataUse> dataUseList= ywtanzhenDataUseService.getYwtanzhenDataUseList(ywid);
            Map<String,Object> map = new HashMap<>();
            for (YwtanzhenDataUse param:dataUseList) {
                    map.put(param.getZdyname(),param.getFjgqdzhiduan());
            }
            //查询私钥
            YwxtKeyManagerWithBLOBs ywxtKeymanagerWithBLOBs = ywxtKeyManagerService.getYwxtkeyManagerByYwId(ywid);
            String privateKey = ywxtKeymanagerWithBLOBs.getKey2();
            String decrptInfo = "";
            try{
                 decrptInfo = SecurityUtil.decrypt(resultInfo,privateKey);
            }catch (Exception e){
                e.printStackTrace();
                return result;
            }
            String jqid = "";
            String userId ="";
            String tmmp_get_info = "";
            if(StringUtils.isNotBlank(decrptInfo)){
                System.out.println("解密成功");
                System.out.println(resultInfo);
                System.out.println(privateKey);
                //分解解密的过程
                String [] decrpt=decrptInfo.split("####");
                List<String> resultInfoKey = new ArrayList<>();
                List<String> resultInfoValue= new ArrayList<>();
                for (String decrptStr:decrpt) {
                    if(StringUtils.isEmpty(decrptStr)){
                        continue;
                    }
                    String [] item = decrptStr.split("@@@@@");
                    if(item[0].equals("JQID")&&item.length>2){
                        net.sf.json.JSON $temp_jqid_json= (net.sf.json.JSON) JSON.parse(item[1]);
                        String $item1=item[1].split(",")[0];
                        String jqidItem=$item1.split(":")[1];
                    }else {
                        if(item[0].equals("xtuserid")){
                            userId=item[1];
                        }
                        if(item[0].equals("get_info")){
                            tmmp_get_info=item[1];
                            continue;
                        }
                        if(item[0].equals("post_info")){
                            tmmp_get_info=item[1];
                            continue;
                        }
                        if(item.length>1){
                            resultInfoKey.add(item[0]);
                            resultInfoValue.add(item[1]);
                        }
                    }
                }
            }else {
                System.out.println("解密失败！");
                System.out.println(resultInfo);
                System.out.println(privateKey);
            }
             //判断是否为攻击数据
            result = isAttract(decrptInfo);
            String param = "";
            ywxtQdsjInsert(ywid,"",new Date(),jqid,userId,ipAddress,requestUrl);
            //存入前端数据 ，将合适的数据存入hadoop中的hdfs。
            String dpath="D:\\"+ywid+currentDate+"test.txt";
            string2File(tmmp_get_info,dpath);
            String outPath="E:\\"+ywid+currentDate+"test.txt";
            boolean haddoop = haddoopService.uploadFile(dpath,outPath);
            return result;
        }


        public boolean ywxtQdsjInsert(String ywid,String ywtanzhenid,Date qdsjtime,String jqid,String userid,String ip,String url){
            boolean result=false;
            return result;
        }


        public void insertYwxtGjData(String ywxitanzhengid,String ipAddress,String gjType){
            YwxtGjdataWithBLOBs ywxtGjdataWithBLOBs = new YwxtGjdataWithBLOBs();
            ywxtGjdataWithBLOBs.setYwid(ywxitanzhengid);
            ywxtGjdataWithBLOBs.setGjip(ipAddress);
            ywxtGjdataWithBLOBs.setGjtime(new Date());
            ywxtGjdataWithBLOBs.setAqdj("1");
            ywxtGjdataWithBLOBs.setGjdatahash(gjType);
            ywxtGjdataWithBLOBs.setSetStatus((byte) 0);
            ywxtGjDataService.insert(ywxtGjdataWithBLOBs);
        }


    public static boolean string2File(String res, String filePath) {
        boolean flag = true;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            File distFile = new File(filePath);
            if (!distFile.getParentFile().exists()) distFile.getParentFile().mkdirs();
            bufferedReader = new BufferedReader(new StringReader(res));
            bufferedWriter = new BufferedWriter(new FileWriter(distFile));
            char buf[] = new char[1024];         //字符缓冲区
            int len;
            while ((len = bufferedReader.read(buf)) != -1) {
                bufferedWriter.write(buf, 0, len);
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            return flag;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    /**
     * 用户行为判断
     * @return
     */
    public String judgeBehavior(Date currentDate,String ywUrl,String userId,String clientIp,String param){
            String gjtype = "";
            boolean gjFlag = false;
            Integer risk = 0;
            List<AllowIpWithBLOBs>  allowIpServiceList=allowIpService.getList(clientIp);
            if(allowIpServiceList!=null){
                for (AllowIpWithBLOBs allowIpWithBloBs:allowIpServiceList) {
                    if(allowIpWithBloBs.getIp().equals(clientIp)){
                        gjtype="";
                        return gjtype;
                    }
                }
            }
            //查找对应Url是否存在越权行为
           List<UserBehaviorWithBLOBs>  userBehaviorList=userBehaviorService.getEntityByIp(clientIp);
            if(userBehaviorList==null){
                gjtype = "unkonw url";
            }
            if(userBehaviorList!=null){
                String role=userBehaviorList.get(0).getRolecons();
                String behavior=userBehaviorList.get(0).getBehavior();
                //查看台账中有无对应用户
                List<UserTaizhangWithBLOBs> userTaizhangList = userTaizhangService.getUserTaiZhangByUserName(userId);
                if(userTaizhangList!=null){
                    gjtype=behavior;
                }
                String role2=userTaizhangList.get(0).getRole();
                if(role.equals("领导")&&role2.equals("员工")){
                    gjtype="越权_"+behavior;
                    gjFlag=true;
                    risk=3;
                }
            }
            return gjtype;
        }



    public Map<String,Object> isAttract(String param){
        Map<String,Object> compare= new HashMap<>();
        if(param.matches("/script\\b|javascript\\b|eval\\b|alert\\b|prompt\\b|msgboxscript\\b\\<([^\\<]+)\\>/is")){
            compare.put("state","fail");
            compare.put("message","xss");
        }
        if(param.matches("/select\\b|insert\\b|update\\b|drop\\b|delete\\b|dumpfile\\b|outfile\\b|load_file|rename\\b|floor\\(|extractvalue|updatexml|name_const|multipoint\\(/i")){
            compare.put("state","fail");
            compare.put("message","sql_injection");
        }
//        文件检测
//        此处文件包含的检测我真的不会写了，求高人指点。。。
//                if(substr_count($str,$_SERVER['PHP_SELF']) < 2){
//                    $tmp = str_replace($_SERVER['PHP_SELF'], "", $str);
//                    if(preg_match("/\.\.|.*\.php[35]{0,1}/i", $tmp)){
//                        $reMessage["state"] = "fail";
//                        $reMessage["message"] = "file_include";
//                        return $reMessage;
//                    }
//                }
        if(param.matches("/base64_decode|eval\\(|assert\\(/i")){
            compare.put("state","fail");
            compare.put("message","yichu");
        }
        if(!param.contains("state")){
            compare.put("state","true");
            compare.put("message","");
        }
        return compare;
    }



}
