package com.rayen.test;

import com.rayen.dao.ConcertDao;
import com.rayen.entities.Concert;

public class ConcertTest {
	public static void main(String[] args) {
		Concert c = new Concert();
		c.setNom("A Tour");
		c.setVille("London");
		
		Concert c1 = new Concert();
		c1.setNom("B Tour");
		c1.setVille("London");
		
		ConcertDao cltDao = new ConcertDao();
		cltDao.ajouter(c);
		cltDao.ajouter(c1);
		
		System.out.println("Appel de la méthode listerTous");
		for (Concert cl : cltDao.listerTous())
			System.out.println(cl);
		
		System.out.println("Appel de la méthode listerParNom");
		for (Concert cl : cltDao.listerParNom("Tour"))

			System.out.println(cl);
	}
}