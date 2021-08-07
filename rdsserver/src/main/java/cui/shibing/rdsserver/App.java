package cui.shibing.rdsserver;

import cui.shibing.rdsserver.entity.TRdsUser;
import cui.shibing.rdsserver.user.repository.RdsUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    private RdsUserEntityRepository rdsUserEntityRepository;

    @Override
    public void run(String... args) throws Exception {
        TRdsUser byId = rdsUserEntityRepository.findById(1);

        System.out.println(byId);
    }
}