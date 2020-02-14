package com.david.bigdata;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import javax.security.auth.login.AppConfigurationEntry;
import java.io.IOException;

public class WordCountApp
{
    public static void main(String[] args) throws Exception {

        System.setProperty("HADOOP_USER_NAME","root");
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS","hdfs://192.168.56.101:9000");

        Job job = Job.getInstance(configuration);
        job.setJarByClass(WordCountApp.class);

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job,new Path("/wordcount/input"));
        FileOutputFormat.setOutputPath(job,new Path("/wordcount/output"));

        boolean result = job.waitForCompletion(true);
        System.exit(result?0 : -1);

    }
}
