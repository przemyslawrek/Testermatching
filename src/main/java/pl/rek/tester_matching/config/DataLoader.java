package pl.rek.tester_matching.config;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.rek.tester_matching.tester.Tester;
import pl.rek.tester_matching.tester.TesterRepository;

import java.util.Date;


@Component
public class DataLoader implements ApplicationRunner {

    private TesterRepository testerRepository;

    @Autowired
    public DataLoader(TesterRepository testerRepository) {
        this.testerRepository = testerRepository;
    }

    public void run(ApplicationArguments args) {
        CsvMapper mapper = new CsvMapper();
    //    testerRepository.save(new Tester(0L,null,null,"Przemyslaw","Rek","PL",new Date()));

//        testerRepository.save(new User("lala", "lala", "lala"));
    }
}