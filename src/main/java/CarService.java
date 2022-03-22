import entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Car get(int id);

    void create(Car car);

    void update(Car car);

    void delete(Long id);
}
