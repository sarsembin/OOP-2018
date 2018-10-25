package com.company;

public class MinMax {
    public MinMax(){};
    static class Values{
        public int min;
        public int max;
        public Values(){min = 0; max = 0;};

        @Override
        public String toString() {
            return min + " " + max + "\n";
        }
    }

    static Values minmax(int values[]){
        Values v = new Values();
        for (int i = 0; i<values.length ;i++){
            if (i == 0){
                v.min = values[i];
                v.max = values[i];
            }
            if (v.min > values[i]) v.min = values[i];
            if (v.max < values[i]) v.max = values[i];
        }
        return v;
    }
}
