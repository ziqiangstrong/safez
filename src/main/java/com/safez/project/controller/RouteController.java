package com.safez.project.controller;

import com.safez.project.entity.*;
import com.safez.project.service.TanzhenManagerService;
import com.safez.project.service.YwtanzhenDataUseService;
import com.safez.project.service.YwtanzhenUseService;
import com.safez.project.service.YwxtGjDataService;
import com.safez.project.system.service.YwxtKeyManagerService;
import com.safez.project.system.service.YwxtJieruService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;
import java.util.Map;

@RequestMapping("/route")
@Api(value="/route",tags={"路由api"})
@RestController
public class RouteController {

    @Autowired
    YwxtGjDataService ywxtGjDataService;
    @Autowired
    TanzhenManagerService tanzhenManagerService;
    @Autowired
    YwxtJieruService ywxtjieruService;
    @Autowired
    YwtanzhenUseService ywtanzhenUseService;
    @Autowired
    YwxtKeyManagerService ywxtKeyManagerService;
    @Autowired
    YwtanzhenDataUseService ywtanzhenDataUseService;

    @ApiOperation(value="获取调度文件",tags={"获取调度文件"},notes="注意问题点")
    @GetMapping(value = "/get")
    public String getFileByYwid(String ywid,String remoteIp,String token){
            String result="";
            boolean isAttract=false;//检查请求IP是否为攻击者IP
            boolean isFanghu=false;//检查是否开启安全防护类探针
            YwxtJieruManager jieruManager =  ywxtjieruService.getObjByTanzhen(ywid);
            String transYwid = jieruManager.getYwid().toString();
            YwxtGjdataWithBLOBs obj =ywxtGjDataService.getObjById(remoteIp);
            //是否为攻击地址
            if(obj!=null){
                isAttract=true;
            }
            List<Map> param = ywxtGjDataService.getYwtzByYwId(transYwid);
            YwxtKeyManagerWithBLOBs keyObj = ywxtKeyManagerService.getYwxtkeyManagerByYwId(transYwid);
            //插入表头
            result=insertHeadTable(result,keyObj.getKey1(),"",ywid);
            //插入文件
            result=insertFile(result);
            if(param!=null){
                for (Map map:param) {
                    if(map.containsKey("jrtztype")){
                        String jrtztype= map.get("jrtztype").toString();
                        if(jrtztype.contains("安全防护探针")||jrtztype.contains("攻击反刺探针")){
                            isFanghu=true;
                        }
                    }
                }
            }
            List<Map> tanzhenInfoAll=tanzhenManagerService.getTanzhenAll();
            YwtanzhenUse  ywtanzhenUse = ywtanzhenUseService.getObjById(transYwid);
            if(ywtanzhenUse!=null){
                String[] tzUseId = ywtanzhenUse.getTzuseid().split(",");
                //读取js文件
                try {
                    if(isAttract&&isFanghu){
                        for (String id:tzUseId) {
                            for (Map map:tanzhenInfoAll) {
                                if(map.get("tzid").equals(id)){
                                    result+=fileRead(map.get("tzpath").toString());
                                    result+="send_info=send_info+'####"+get_zdyname(transYwid,id)+"@@@@@'+"+map.get("tzfunction")+";";
                                };
                            }
                        }
                    }else{
                        for (String id:tzUseId) {
                            for (Map map:tanzhenInfoAll) {
                                if(map.containsKey("tzid")&&map.get("tzid").toString().equals(id)){
                                    result+=fileRead(map.get("tzpath").toString());
                                    result+="send_info=send_info+'####"+get_zdyname(transYwid,id)+"@@@@@'+"+map.get("tzfunction")+";";
                                    //print "send_info=send_info+'####".get_zdyname($ywid,$value)."@@@@@'+".$tzinfo_all["tzid_".$value]['tzfunction']."();";
                                };
                            }
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
          String tz_path="D:\\programs\\xampp\\htdocs\\www\\tzfile";
          //插入表尾
          result=insertFoot(result);
//        foreach ($jrtz_id_all as $key => $value){
//            if($tzinfo_all["tzid_".$value]['tzfunction']=="ajax_info"){
//                //----------------- ajax hook ---------------------------------------
//                print get_tzfile_info(tz_path."\\ajaxhook.js");
            try {
                result += fileRead(tz_path+"\\ajaxhook.js");
                result += fileRead(tz_path+"\\formhook.js");
            }catch (Exception e){
                e.printStackTrace();
            }
//            }
//            if($tzinfo_all["tzid_".$value]['tzfunction']=="form_info"){
//                //----------------- form hook ---------------------------------------

//            }
//        }
        return  result;
    }

    //接入表头
    public String insertHeadTable(String result,String publicKey,String domain,String ywid){
        result += "var PUBLIC_KEY = '"+publicKey+"';";
        result += "var send_info='';";
        result += "var ywxittanzhengid='"+ywid+"';";
        result += "var domainZtt='www.safetz.com';";
        result += "var web_pathZtt='/www/';";
        result += "var Days = 356;";
        result += "var exp = new Date();";
        result += "exp.setTime(exp.getTime() + Days*24*60*60*1000);";
        result += "document.cookie =\"ywtanzhenid=\"+ escape ('"+ywid+"') + \";expires=\" + exp.toGMTString();";
        result += "var encode_function;";
        result += "var send_function;";
        result += "var get_jqid_function;";
        return result;
    }

    public String insertFile(String result){
        String tz_path="D:\\programs\\xampp\\htdocs\\www\\tzfile";
        try {
            result+=fileRead(tz_path+"\\init.js");
            result+="get_jqid_function =";
            result+=fileRead(tz_path+"\\jqid.js");
            result+="encode_function  =";
            result+=fileRead(tz_path+"\\encode.js");
            result+="send_function = ";
            result+=fileRead(tz_path+"\\upload.js");
            result+="send_info = send_info + '####JQID@@@@@' + get_jqid_function(); \r";
            result+=fileRead(tz_path+"\\getpars.js");
            result+= "send_info=send_info+'####get_info@@@@@'+getpars();";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public String insertFoot(String result){
        String tz_path="D:\\programs\\xampp\\htdocs\\www\\tzfile";
        //--------------encode info--------------------------
        result+=" send_info = send_info + '####youxiang@@@@@' + youjian();";
        result+=" function demo_youxiangtz() {";
        result+=" var name_dom = document.getElementsByClassName(\"accountPlace\");";
        result+=" return name_dom[0].innerText; }";
        result+=" send_info = send_info + '####xtuserid@@@@@' + demo_youxiangtz();";
        result+=" send_info = encode_function(send_info);";
        //--------------upload info------------------------------
        result+= " send_function(send_info); ";
        //----------------- foot ---------------------------------------
        try {
            result+= fileRead(tz_path+"\\foot.js");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public String get_zdyname(String ywid,String tzid){
        YwtanzhenDataUse ywtanzhenDataUse=ywtanzhenDataUseService.getYwtanzhenDataUse(ywid,tzid);
       return ywtanzhenDataUse.getZdyname();
    }

//    function get_zdyname($ywid,$tzid){
//        $zdyname="";
//        $table = "ywtanzhen_data_use";
//        $column = array("zdyname");
//        $where = "ywid='".trim($ywid)."' and tzid='".trim($tzid)."'";
//        $searchrst = search($column,$table,$where);
//        if($searchrst == 'error' || count($searchrst)<=0){
//            writelog("route.php 数据库查询失败get_zdyname");
//        }else{
//            $zdyname=$searchrst[0]['zdyname'];
//        }
//        return $zdyname;
//    }




    public String fileRead(String path) throws IOException {
        File file = new File(path);//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader( new InputStreamReader(new FileInputStream(file),"UTF-8") );//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
        System.out.println(str );
        return str;
    }

}
