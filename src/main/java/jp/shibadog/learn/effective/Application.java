package jp.shibadog.learn.effective;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    @Autowired
    private Anagrams anagrams;
    
    @Autowired
    private Mersenne mersenne;

    @Autowired
    private CartesianProduct cartesian;

    public static void main(String[] args) {
        System.out.println("main()");
        try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)) {
            Application app = ctx.getBean(Application.class);
            app.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run(String[] args) {
        // anagrams.run(args);
        // mersenne.run();
        cartesian.run();
    }
}