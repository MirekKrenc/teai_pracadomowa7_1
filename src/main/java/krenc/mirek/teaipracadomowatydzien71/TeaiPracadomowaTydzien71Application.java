package krenc.mirek.teaipracadomowatydzien71;

import krenc.mirek.teaipracadomowatydzien71.dao.CarDBApi;
import krenc.mirek.teaipracadomowatydzien71.model.Car;
import krenc.mirek.teaipracadomowatydzien71.model.Color;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TeaiPracadomowaTydzien71Application {

    private CarDBApi carDBApi;
    private JdbcTemplate jdbcTemplate;

    public TeaiPracadomowaTydzien71Application(CarDBApi carDBApi, JdbcTemplate jdbcTemplate) {
        this.carDBApi = carDBApi;
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(TeaiPracadomowaTydzien71Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void databaseProcessing()
    {
        String sql ="create table car (id int, brand varchar(30), year int, color varchar(20))";
        jdbcTemplate.update(sql);
        //add cars
        //long id = carDBApi.getMaxId();
        carDBApi.add(new Car(carDBApi.getMaxId(), "Ford", 2010, Color.BLUE));
        carDBApi.add(new Car(carDBApi.getMaxId(), "Fiat", 2000, Color.GRREN));
        carDBApi.add(new Car(carDBApi.getMaxId(), "Audi", 1990, Color.SILVER));
        carDBApi.add(new Car(carDBApi.getMaxId(), "Skoda", 2018, Color.BROWN));

        //get one car
        System.out.println(carDBApi.findOne(2l));
        System.out.println("##############");
        //get all cars
        carDBApi.findAll().stream()
                .forEach(System.out::println);
        System.out.println("##############");
        //gat cars by year
        carDBApi.getByProdYear(1989, 2011).stream()
        .forEach(System.out::println);


    }

}
