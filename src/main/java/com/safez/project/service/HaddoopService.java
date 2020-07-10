package com.safez.project.service;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HaddoopService {

    @Value("${hdfs.path}")
    private String haddoopPath;


    public boolean uploadFile(String filePath,String outPath) throws IOException {
        boolean result = true;
        try {
            Configuration conf=new Configuration();
            conf.set("fs.defaultFS", haddoopPath);

            FileSystem fs=FileSystem.get(conf);

            FSDataOutputStream fsDataOutputStream=fs.create(new Path(outPath));

            FileInputStream fileInputStream=new FileInputStream(filePath);

            IOUtils.copy(fileInputStream, fsDataOutputStream);
        }catch(Exception e){
            e.printStackTrace();
            result = false;
        }
        return result;
    }



    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Configuration conf=new Configuration();

        conf.set("fs.defaultFS", "hdfs://localhost:9000");

        FileSystem fs=FileSystem.get(conf);

        FSDataOutputStream fsDataOutputStream=fs.create(new Path("/RoseHA.rar"));

        FileInputStream fileInputStream=new FileInputStream("d:/RoseHA.rar");

        IOUtils.copy(fileInputStream, fsDataOutputStream);

        //一句话搞定文件的上传
        fs.copyFromLocalFile(new Path("d:/PowerDesigner15_Evaluation.rar"), new Path("/PowerDesigner15_Evaluation.rar"));
    }



}
