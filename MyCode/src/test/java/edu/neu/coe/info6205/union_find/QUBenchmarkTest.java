package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class QUBenchmarkTest {

    @Test
    public void benchmarkSeed() {
        int initialN = 100;
        writeToCSV("Data/Assignment4/size2loops.csv", "M,N,Time");
        int times=13;
        for (int i = 0; i < times; i++) {
            initialN *= 2;
            String description = "Random generator";
            QUBenchmarkHelpler QUBenchmarkHelpler = new QUBenchmarkHelpler(initialN,50,true);
            WQUPC wqupc = new WQUPC(initialN);
            Supplier<List<List<Integer>>> supplier = () -> QUBenchmarkHelpler.randomIntegePairs();
            Benchmark<List<List<Integer>>> benchmark = new Benchmark_Timer<List<List<Integer>>>(
                    description + " for " + initialN + " Integers",
                    null,
                    wqupc::benchMarkUnion,
                    null
            );
            double average = benchmark.runFromSupplier(supplier, 50);
            writeToCSV("Data/Assignment4/size2loops.csv", QUBenchmarkHelpler.getPairsSize()+","+initialN + "," + average);
            System.out.println("MilionSecond :" + average+", M size :"+ QUBenchmarkHelpler.getPairsSize()+", N size :"+ initialN);
        }
    }

    @Test
    public void benchmark2Seed() {
        int initialN = 100;
        writeToCSV("Data/Assignment4/depth2loops.csv", "M,N,Time");
        int times=13;
        for (int i = 0; i < times; i++) {
            initialN *= 2;
            String description = "Random generator";
            QUBenchmarkHelpler QUBenchmarkHelpler = new QUBenchmarkHelpler(initialN,50,true);
            WQUPC wqupc = new WQUPC(initialN);
            Supplier<List<List<Integer>>> supplier = () -> QUBenchmarkHelpler.randomIntegePairs();
            Benchmark<List<List<Integer>>> benchmark = new Benchmark_Timer<List<List<Integer>>>(
                    description + " for " + initialN + " Integers",
                    null,
                    wqupc::benchMarkUnion2,
                    null
            );
            double average = benchmark.runFromSupplier(supplier, 50);
            writeToCSV("Data/Assignment4/depth2loops.csv", QUBenchmarkHelpler.getPairsSize()+","+initialN + "," + average);
            System.out.println("MilionSecond :" + average+", M size :"+ QUBenchmarkHelpler.getPairsSize()+", N size :"+ initialN);
        }
    }

    @Test
    public void benchmark3Seed() {
        int initialN = 100;
        writeToCSV("Data/Assignment4/size1loop.csv", "M,N,Time");
        int times=13;
        for (int i = 0; i < times; i++) {
            initialN *= 2;
            String description = "Random generator";
            QUBenchmarkHelpler QUBenchmarkHelpler = new QUBenchmarkHelpler(initialN,50,true);
            UF_HWQUPC wqupc = new UF_HWQUPC(initialN,true);
            Supplier<List<List<Integer>>> supplier = () -> QUBenchmarkHelpler.randomIntegePairs();
            Benchmark<List<List<Integer>>> benchmark = new Benchmark_Timer<List<List<Integer>>>(
                    description + " for " + initialN + " Integers",
                    null,
                    wqupc::benchMarkUnionMerge,
                    null
            );
            double average = benchmark.runFromSupplier(supplier, 50);
            writeToCSV("Data/Assignment4/size1loop.csv", QUBenchmarkHelpler.getPairsSize()+","+initialN + "," + average);
            System.out.println("MilionSecond :" + average+", M size :"+ QUBenchmarkHelpler.getPairsSize()+", N size :"+ initialN);
        }
    }


    public static void writeToCSV(String fileName, String line) {
        FileWriter fw = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) file.createNewFile();
            fw = new FileWriter(file, true);
            fw.write(line + "\n");
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
