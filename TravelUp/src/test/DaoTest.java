package test;

import java.util.List;

import com.epam.dakhniy.orm.dao.Dao;
import com.epam.dakhniy.orm.model.Portfolio;
import com.epam.dakhniy.orm.model.Tour;
import com.epam.dakhniy.orm.transformer.Transformer;
import com.sun.scenario.effect.impl.prism.PrTexture;

public class DaoTest {

	public static void main(String[] args) {
		Dao<Tour> dao = new Dao<Tour>(Tour.class, "en");
		List<Tour> tours = dao.selectAll();
		System.out.println(tours);
		//dao.insert(new Transformer(Tour.class, "en").modelToTable(Tours.get(0)));
	}

}
