package jp.shibadog.learn.effective.learn45;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Anagrams {

    public void run(String[] args) {
        List<String> file = Arrays.asList(
            "english",
            "shingle",
            "server",
            "revers",
            "habit",
            "tailor"
        );
        Reader in = new StringReader(file.stream().collect(Collectors.joining("\n")));
        // run1(in, 2);
        // run2(in, 2);
        run3(in, 2);
    }

    // 辞書内の大きなアナグラムのグループを全て繰り返し表示する。
    public void run1(Reader in, int minGroupSize) {
        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(in)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word),
                    (unused) -> new TreeSet<>()).add(word);
            }
        }

        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize)
                log.info(group.size() + ": " + group);
        }
    }

    // ストリームの乱用 - これを行ってはいけない
    public void run2(Reader in, int minGroupSize) {
        try (Stream<String> words = new BufferedReader(in).lines()) {
            words.collect(
                Collectors.groupingBy(word -> word.chars().sorted()
                    .collect(StringBuilder::new,
                        (sb, c) -> sb.append((char) c),
                        StringBuilder::append).toString()))
            .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .map(group -> group.size() + ": " + group)
                .forEach(log::info);
        }
    }

    // ストリームの感じの良い使い方は明瞭さと簡潔さを高めます
    public void run3(Reader in, int minGroupSize) {
        try (Stream<String> words = new BufferedReader(in).lines()) {
            words.collect(Collectors.groupingBy(word -> alphabetize(word)))
                .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .forEach(g -> log.info(g.size() + ": " + g));
        }
    }

    private String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}