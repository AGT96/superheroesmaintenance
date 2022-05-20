package com.agt.mantenimientosuperheroes.util;

/**
 * This class contains the constants used in the application.
 * @author AGT96
 */
public final class Constants {
	
	private Constants() {
		throw new IllegalStateException("Cannot instantiate this utility class: " + Constants.class.getName());
	}

	public static final String SUCCESS_MESSAGE = "Success";
	public static final String SEVERAL_ITEMS_MESSAGE = "Several items to show";
	public static final String NO_ITEMS_TO_SHOW_MESSAGE = "There is no items to show";
	public static final String EXCEPTION_OCURRED_MESSAGE = "A exception has ocurred: ";
	public static final String OBJECT_NOT_FOUND_MESSAGE = "Object not found";
	
	public static final String NOTHING_TO_SHOW = "Nothing to show";
	public static final String ALL_ITEMS_DELETED = "All items deleted";
	
	public static final String ID_MUST_NOT_BE_NULL = "Id must not be null";
}
