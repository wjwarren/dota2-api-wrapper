package nl.ansuz.android.steam.dota.util.gson;

import java.lang.reflect.Field;

import android.util.Log;

/**
 * Deserializer base.
 *
 * @author Wijnand
 */
public class DotaDeserializer {

	private static final String LOG_TAG = "DotaDeserializer";

	/**
	 * Copies the values from the base object to the actual target object.
	 * 
	 * @param from The base object to copy the values from.
	 * @param to The object to copy the values to.
	 */
	protected <T> T copyFromTo(Object from, T to) {
		Field[] baseFields = from.getClass().getFields();
		
		for(Field fromProperty : baseFields) {
			String propertyName = fromProperty.getName();
			
			Object value = null;
			
			try {
				value = from.getClass().getField(propertyName).get(from);
			} catch (NoSuchFieldException e) {
				Log.e(LOG_TAG, " - NoSuchFieldException when getting the value for: " + propertyName);
				continue;
			} catch (IllegalAccessException e) {
				Log.e(LOG_TAG, " - IllegalAccessException when getting the value for: " + propertyName);
				continue;
			}
			
			try {
				Field toField = to.getClass().getField(propertyName);
				toField.set(to, value);
			} catch (NoSuchFieldException e) {
				Log.e(LOG_TAG, " - NoSuchFieldException when setting the value for: " + propertyName);
				continue;
			} catch(IllegalAccessException e) {
				Log.e(LOG_TAG, " - IllegalAccessException when setting the value for: " + propertyName);
				continue;
			}
			
		}
		
		return to;
	}
	
}
