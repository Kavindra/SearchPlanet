package com.planet;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

/**
 * Register classes to be used as Entity Classes
 * 
 * see http://code.google.com/p/objectify-appengine/wiki/IntroductionToObjectify
 * 
 * @author ramon, fred
 */
public class DatabaseFactory extends DAOBase {
	//private final static Logger log = Logger.getLogger(DAO.class.getName());
	static {
		ObjectifyService.register(SearchPlanet.class);
		
		
	}

	//CHANGED: 2011-08-03 fred - changed to static
	public static Objectify getDatabase() {
		return (new DatabaseFactory()).ofy();
	}

	//	}
}