package com.zfb.bigdata;

import com.zfb.bigdata.mapper.TextMapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestMapper {

    MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
    ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
    MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;


    @Before
    public void setUp() {
        TextMapper mapper = new TextMapper();
//        SMSCDRReducer reducer = new SMSCDRReducer();
        mapDriver = MapDriver.newMapDriver(mapper);
//        reduceDriver = ReduceDriver.newReduceDriver(reducer);
//        mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);

    }

    @Test
    public void testMapper() throws IOException {
        mapDriver.withInput(new LongWritable(), new Text(
                "655209;1;796764372490213;804422938115889;6"));
//        mapDriver.withOutput(new Text("6"), new IntWritable(1));
        mapDriver.runTest();
    }

}
