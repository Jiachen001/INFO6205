package edu.neu.coe.info6205.sort.simple;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.LazyLogger;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class InsertionSortBenchmarksTest {
    /*
Implement a main program (or you could do it via your own unit tests) to actually run the following benchmarks:
measure the running times of this sort, using four different initial array ordering situations: random, ordered, partially-ordered and reverse-ordered.
I suggest that your arrays to be sorted are of type Integer. Use the doubling method for choosing n and test for at least five values of n.
Draw any conclusions from your observations regarding the order of growth.
 */
    final static LazyLogger logger = new LazyLogger(Benchmarks.class);

    public static void writeToFile(String fileName,String line){
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(fileName),true);
            fw.write(line+"\n");
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void randomTest(){
        int initialN=200;
        Random random=new Random();
        String fileName="Data/Assignment2/randomInput.csv";
        File file=new File(fileName);
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(fileName,"N,Time");
        for(int i=0;i<6;i++){
            initialN*=2;
            Integer[] integers=new Integer[initialN];
            String description="Random generator";
            Helper<Integer> helper=new BaseHelper<>(description,initialN);
            InsertionSort<Integer> insertionSort= new InsertionSort<Integer>(helper);

            for(int j=0;j<initialN;j++){
                integers[j]=random.nextInt(initialN);
            }
            Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                    description + " for " + initialN + " Integers",
                    (xs) -> Arrays.copyOf(xs, xs.length),
                    insertionSort::mutatingSort,
                    null
            );
            double average=benchmark.run(integers,50);
            writeToFile(fileName,initialN+","+average);
            logger.info("Function Average MilionSecond :"+average);
        }
    }

    @Test
    public void orderedTest(){
        int initialN=200;
        String fileName="Data/Assignment2/orderedInput.csv";
        File file=new File(fileName);
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(fileName,"N,Time");
        for(int i=0;i<6;i++){
            initialN*=2;
            String description="ordered generator";
            Helper<Integer> helper=new BaseHelper<>(description);
            InsertionSort<Integer> insertionSort= new InsertionSort<Integer>(helper);

            Integer[] data=new Integer[initialN];
            for(int j=0;j<initialN;j++){
                data[j]=j;
            }
            Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                    description + " for " + initialN + " Integers",
                    (xs) -> Arrays.copyOf(xs, xs.length),
                    insertionSort::mutatingSort,
                    null
            );
            double average=benchmark.run(data,50);
            writeToFile(fileName,initialN+","+average);
            logger.info("Function Average MilionSecond :"+average);
        }
    }
    @Test
    public void partialOrderedTest(){
        int initialN=200;
        String fileName="Data/Assignment2/particialOrderedInput.csv";
        File file=new File(fileName);
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(fileName,"N,Time");
        Random random=new Random();
        for(int i=0;i<6;i++){
            initialN*=2;
            String description="ordered generator";
            Helper<Integer> helper=new BaseHelper<>(description);
            InsertionSort<Integer> insertionSort= new InsertionSort<Integer>(helper);

            Integer[] data=new Integer[initialN];
            for(int j=0;j<initialN;j++){
                data[j]= random.nextInt(initialN);
            }
            int orderCount= (int) (initialN*0.4);
            int startOrdedIndex=random.nextInt(initialN-orderCount);
            for (int j=startOrdedIndex;j<initialN;j++){
                data[j]=startOrdedIndex;
            }
            Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                    description + " For " + initialN + " Integers",
                    (xs) -> Arrays.copyOf(xs, xs.length),
                    insertionSort::mutatingSort,
                    null
            );
            double average=benchmark.run(data,50);
            writeToFile(fileName,initialN+","+average);
            logger.info("Function Average MilionSecond :"+average);
        }
    }
    @Test
    public void reverseOrderedTest(){
        int initialN=200;
        String fileName="Data/Assignment2/reversedInput.csv";
        File file=new File(fileName);
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(fileName,"N,Time");
        for(int i=0;i<6;i++){
            initialN*=2;
            String description="reverse generator";
            Helper<Integer> helper=new BaseHelper<>(description);
            InsertionSort<Integer> insertionSort= new InsertionSort<Integer>(helper);

            Integer[] data=new Integer[initialN];
            for(int j=0;j<initialN;j++){
                data[j]=initialN-j;
            }
            Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                    description + " for " + initialN + " Integers",
                    (xs) -> Arrays.copyOf(xs, xs.length),
                    insertionSort::mutatingSort,
                    null
            );
            double average=benchmark.run(data,50);
            writeToFile(fileName,initialN+","+average);
            logger.info("Function Average MilionSecond :"+average);
        }
    }
}
