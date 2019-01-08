package jp.shibadog.learn.effective.learn45;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Learn45 {

    @Autowired
    @SuppressWarnings("unused")
    private Anagrams anagrams;
    
    @Autowired
    @SuppressWarnings("unused")
    private Mersenne mersenne;

    @Autowired
    private CartesianProduct cartesian;

    public void run(String[] args) {
        // anagrams.run(args);
        // mersenne.run();
        cartesian.run();
    }
}