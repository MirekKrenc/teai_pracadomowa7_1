package krenc.mirek.teaipracadomowatydzien71.dao;

import krenc.mirek.teaipracadomowatydzien71.model.Car;

import java.util.List;

public interface CarDB {

    public List<Car> findAll();

    public Car findOne(long id);

    public List<Car> getByProdYear(int fromYear, int toYear);

    public void add(Car car);

    public Car update(Car car);

    public void delete(long id);

    public long getMaxId();
}
