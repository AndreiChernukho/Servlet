import entity.Car;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@WebServlet(value = "/car")
public class CarServlet extends HttpServlet {

    private static final String CAR_ID_PARAMETER_NAME = "id";
    private static final String CAR_MODEL_PARAMETER_NAME = "carModel";
    private static final String TIME_COOKIE_NAME = "time";
    private static final String CARS_ATTRIBUTE_NAME = "cars";
    private static final String CARS_PAGE_NAME = "cars.jsp";

    private final CarService carService = new CarServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet start");
        String id = req.getParameter(CAR_ID_PARAMETER_NAME);
        List<Car> cars = id == null
                ? carService.getAll()
                : Collections.singletonList(carService.get(Integer.parseInt(id)));
        String time = LocalDateTime.now().toString();
        Cookie cookie = new Cookie(TIME_COOKIE_NAME, time);
        resp.addCookie(cookie);
        req.setAttribute(CARS_ATTRIBUTE_NAME, cars);
        req.getRequestDispatcher(CARS_PAGE_NAME).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doPost start");
        Long id = Long.getLong(req.getParameter(CAR_ID_PARAMETER_NAME));
        String carModel = req.getParameter(CAR_MODEL_PARAMETER_NAME);
        carService.create(id, carModel);
        req.getRequestDispatcher(CARS_PAGE_NAME).forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        log.info("doPut start");
        Long id = Long.getLong(req.getParameter(CAR_ID_PARAMETER_NAME));
        String carModel = req.getParameter(CAR_MODEL_PARAMETER_NAME);
        carService.update(id, carModel);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        log.info("doDelete start");
        Long id = Long.getLong(req.getParameter(CAR_ID_PARAMETER_NAME));
        carService.delete(id);
    }
}
