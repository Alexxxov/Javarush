package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args)  throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        ArrayList<String> list = new ArrayList<>();
        while (fileReader.ready())
        {
            list.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        fileReader.close();

        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < list.size(); )
            {
                if(list.get(j).equals(new StringBuilder(list.get(i)).reverse().toString()) && j != i)
                {
                    Pair pair = new Pair();
                    pair.first = list.get(j);
                    pair.second = list.get(i);
                    result.add(pair);
                    list.remove(j);
                    list.remove(i);
                    j = 0;
                }
                else
                    j++;
            }
        }


        for (Pair p: result) {
            System.out.println(p.first + " "  + p.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
