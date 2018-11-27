package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
class person_score_data{
    String surname;
    String name;
    Integer score;
    public person_score_data(String surname, String name, Integer score){
        this.surname = surname;
        this.name = name;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }
}
public class Main {
    public void bubbleSort(ArrayList<person_score_data> a){
        for (int i = 0;i<a.size();i++){
            for (int j=i;j<a.size();j++) {
                if (a..indexOf(i) > a.indexOf(j)) {

                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader score_reader = new BufferedReader(new FileReader("scores.txt"));
            String line = score_reader.readLine();
            ArrayList<person_score_data> scoreData = new ArrayList<person_score_data>();
            while (line != null){
                String[] data = line.split(" ");
                Integer score = Integer.parseInt(data[2]);
                person_score_data cur_person = new person_score_data(data[0], data[1], score);
                scoreData.add(cur_person);
            }
            score_reader.close();
            scoreData.sort(Comparator.comparing();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } finally {
            BufferedWriter grades_writer = new BufferedWriter(new FileWriter("grades.txt"));
            grades_writer.write("");
        }
    }
}
