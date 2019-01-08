package jp.shibadog.learn.effective;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jp.shibadog.learn.effective.learn45.Learn45;
import jp.shibadog.learn.effective.learn55.Learn55;

@SpringBootApplication
public class Application {

    @Autowired
    @SuppressWarnings("unused")
    private Learn45 learn45;

    @Autowired
    private Learn55 learn55;

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
        learn55.run(args);
    }
}