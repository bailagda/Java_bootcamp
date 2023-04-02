package ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

import static java.lang.Math.sqrt;


public class Program {
    public static void main(String[] args) throws IOException {
        System.out.print(args[0]);
        System.out.print(args[1]);
        BufferedReader file1
                = new BufferedReader(new FileReader(args[0]));
        BufferedReader file2
                = new BufferedReader(new FileReader(args[1]));

        Map<String, Integer> dict1 = new HashMap<String, Integer>();
        Map<String, Integer> dict2 = new HashMap<String, Integer>();

        dict1 = getDict(file1, dict1);
        dict2 = getDict(file2, dict2);

        Map<String, Integer> dictMerged = new HashMap<String, Integer>(dict1);
        dictMerged.putAll(dict2);

        System.out.println(dictMerged);
        Vector<Integer> A = getVector(dictMerged, dict1);
        Vector<Integer> B = getVector(dictMerged, dict2);
        System.out.println(A);
        System.out.println(B);
        double numerator = getSimilarity(A, B);
        System.out.println(numerator);

    }
    public static Map<String, Integer> getDict(BufferedReader file, Map<String, Integer> dict) throws IOException {
        int letter;
        while((letter = file.read()) != -1) {
            String word = "";
            while(letter != ' ' && letter != -1) {
                word+=(char)letter;
                letter = file.read();
            }
            dict.merge(word, 1, Integer::sum);
        }
        return dict;
    }

    public static Vector<Integer> getVector(Map<String, Integer> dictMerged,
                                            Map<String, Integer> dict) {
        Vector<Integer> A = new Vector<Integer>(dictMerged.size(), 1);
        for(String i: dictMerged.keySet()){
            int flag = 0;
            for(String j : dict.keySet()) {
                if(Objects.equals(i, j)){
                    A.add(dict.get(j));
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                A.add(0);
            }
        }
        return A;
    }

    public static double getSimilarity(Vector<Integer> A, Vector<Integer> B) {
        double numerator = 0;
        double denA = 0;
        double denB = 0;
        for(int i = 0; i < A.size(); ++i) {
            numerator += (A.get(i) *B.get(i));
            denA += A.get(i)*A.get(i);
            denB += B.get(i)*B.get(i);
        }
        double denominator = (sqrt(denA)*sqrt(denB));
        return numerator/denominator;
    }
}
