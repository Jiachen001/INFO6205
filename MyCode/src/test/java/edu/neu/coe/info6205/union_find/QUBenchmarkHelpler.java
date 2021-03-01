package edu.neu.coe.info6205.union_find;

import java.util.*;

public class QUBenchmarkHelpler {
    private int unionFindInitSize;
    private Random random;
    private int pairsSize;
    private int seed;
    private boolean setSeed;
    private int count;
    private double coefficent=3;

    public QUBenchmarkHelpler(int unionFindInitSize, int seed, boolean setSeed) {
        this.unionFindInitSize = unionFindInitSize;
        this.seed=seed;
        this.setSeed=setSeed;
        random=new Random();
    }

    public List<List<Integer>> randomIntegePairs(){
        count++;
        if(setSeed) random.setSeed(seed);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        pairsSize= (int) Math.pow(unionFindInitSize,1.135);
        for (int i=0;i<pairsSize;i++){
            List<Integer> pairs=new ArrayList<Integer>();
            int q=random.nextInt(unionFindInitSize);
            int p=random.nextInt(unionFindInitSize);
            pairs.add(q);
            pairs.add(p);
            list.add(pairs);
        }
        return list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUnionFindInitSize() {
        return unionFindInitSize;
    }

    public void setUnionFindInitSize(int unionFindInitSize) {
        this.unionFindInitSize = unionFindInitSize;
    }

    public int getPairsSize() {
        return pairsSize;
    }

    public void setPairsSize(int pairsSize) {
        this.pairsSize = pairsSize;
    }
}
