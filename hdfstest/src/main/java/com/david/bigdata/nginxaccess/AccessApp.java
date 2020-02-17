package com.david.bigdata.nginxaccess;

import com.david.bigdata.wc.WordCountApp;
import com.david.bigdata.wc.WordCountMapper;
import com.david.bigdata.wc.WordCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AccessApp {
    public static void main(String[] args) throws  Exception {
        System.setProperty("HADOOP_USER_NAME","root");
        Configuration configuration = new Configuration();
        //configuration.set("fs.defaultFS","hdfs://192.168.56.101:9000");

        Job job = Job.getInstance(configuration);
        job.setJarByClass(AccessApp.class);

        job.setMapperClass(AccessMapper.class);
        job.setReducerClass(AccessReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        Path inputPath = new Path("raw/nginxaccess/input");
        Path outPutPath = new Path("raw/nginxaccess/wordcount/output");

        /*FileSystem fs = FileSystem.get(new URI("hdfs://192.168.56.101:9000"),configuration);
        if (fs.exists(outPutPath)){
            fs.delete(outPutPath,true);
        }*/

        FileInputFormat.setInputPaths(job,inputPath);
        FileOutputFormat.setOutputPath(job,outPutPath);

        boolean result = job.waitForCompletion(true);
        System.exit(result?0 : -1);
    }
}
