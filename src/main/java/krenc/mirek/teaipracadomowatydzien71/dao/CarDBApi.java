package krenc.mirek.teaipracadomowatydzien71.dao;

import krenc.mirek.teaipracadomowatydzien71.model.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDBApi implements CarDB{

    private JdbcTemplate jdbcTemplate;

    public CarDBApi(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Car> findAll() {
        String sql = "select * from car";
        List<Car> carList = jdbcTemplate.query(sql,
                (rs, i) -> new Car(
                        rs.getInt("id"),
                        rs.getString("brand"),
                        rs.getInt("year"),
                        rs.getString("color")
                ));
        return carList;

    }

    @Override
    public Car findOne(long id) {
        String sql = "select * from car where car.id=?";
        Car car = jdbcTemplate.queryForObject(sql, (rs, i) -> new Car(
                rs.getInt("id"),
                rs.getString("brand"),
                rs.getInt("year"),
                rs.getString("color")
        ), id);
        return car;
    }

    @Override
    public List<Car> getByProdYear(int fromYear, int toYear) {
        String sql = "select * from car where car.year between ? and ? order by car.year";
        List<Car> carListByYear = jdbcTemplate.query(sql, (rs, i) -> new Car(
                rs.getInt("id"),
                rs.getString("brand"),
                rs.getInt("year"),
                rs.getString("color")
        ), fromYear, toYear);
        return carListByYear;
    }

    @Override
    public void add(Car car) {

        String sql = "insert into car values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getId(), car.getBrand(), car.getProductionYear(), car.getColorString());

    }

    @Override
    public Car update(Car car) {
        String sql = "update car set car.brand=?, car.year=?, car.color=? where car.id=?";
        jdbcTemplate.update(sql, car.getBrand(), car.getProductionYear(), car.getColor(), car.getId());
        return car;
    }

    @Override
    public void delete(long id) {
        String sql="delete from car where car.id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public long getMaxId() {
        String sql = "select count(*) from car";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer + 1;
    }
}
