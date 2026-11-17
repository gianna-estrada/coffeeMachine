/**
 * Contains all the types of coffee
 */
package coffeeType;

import java.util.ResourceBundle;

/**
 * This class is the blueprint for all the coffee types
 * @author giannaestrada
 */
public abstract class Coffee {
	String name;
	String desc;
	
	/**
	 * This method is for making an instance of Coffee, or
	 * any of the coffee types
	 * @param name  Coffee name
	 * @param desc  Coffee description
	 */
	public Coffee(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	/**
	 * This method gets the name of the coffee type
	 * through internationalization
	 * @param  bundle  For translation
	 * @return The translated name
	 */
	public String getName(ResourceBundle bundle) {
		return bundle.getString(name);
	}
	
	/**
	 * This method gets the description of the coffee
	 * type through internationalization
	 * @param bundle  For translation
	 * @return The translated description
	 */
	public String getDescription(ResourceBundle bundle) {
		return bundle.getString(name + ".desc");
	}
	
}
