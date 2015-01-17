package test;

import java.util.List;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Tour;

public class DaoTest {

	public static void main(String[] args) {
		Dao<Tour> dao = new Dao<Tour>(Tour.class, "en");
		List<Tour> tours = dao.selectAll();
		System.out.println(tours);
		//dao.insert(new Transformer(Tour.class, "en").modelToTable(Tours.get(0)));
	}

}
