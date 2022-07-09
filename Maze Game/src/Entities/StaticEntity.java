//Programmer: Raj Shukla
//Purpose: To be able to determine which entities are not moving (So a class for solid entities)
package Entities;

import MainClasses.Handler;
import Entities.Entity;

public abstract class StaticEntity extends Entity {
	//Constructor
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
}
