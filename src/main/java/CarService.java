import entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Car get(int id);

    void create(Long id, String carModel);

    void update(Long id, String carModel);

    void delete(Long id);
}
