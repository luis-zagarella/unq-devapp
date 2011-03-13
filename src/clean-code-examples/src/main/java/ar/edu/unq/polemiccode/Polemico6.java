package ar.edu.unq.polemiccode;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ar.edu.unq.polemiccode.Polemico6.FieldMap.Lala;

/**
 * Codigo sacado de Dozer
 */
@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class Polemico6 {

    public class MappingProcessor {

        private Object mapCollection(final Object srcObj, Object srcCollectionValue, final FieldMap fieldMap,
                final Object destObj) {
            // since we are mapping some sort of collection now is a good time
            // to decide
            // if they provided hints
            // if no hint is provided then we will use
            // generics to determine the mapping type
            // this will only happen once on the dest hint. the next mapping
            // will
            // already have the hint
            if (fieldMap.getDestHintContainer() == null) {
                Class<?> genericType = null;
                try {
                    Method method = fieldMap.getDestFieldWriteMethod(destObj.getClass());
                    genericType = ReflectionUtils.determineGenericsType(method, false);
                } catch (Throwable e) {
                    log.info("The destObj:" + destObj + " does not have a write method");
                }
                if (genericType != null) {
                    HintContainer destHintContainer = new HintContainer();
                    destHintContainer.setHintName(genericType.getName());
                    fieldMap.setDestHintContainer(destHintContainer);
                }
            }

            // if it is an iterator object turn it into a List
            if (srcCollectionValue instanceof Iterator) {
                srcCollectionValue = IteratorUtils.toList((Iterator<?>) srcCollectionValue);
            }

            Class<?> destCollectionType = fieldMap.getDestFieldType(destObj.getClass());
            Class<?> srcFieldType = srcCollectionValue.getClass();
            Object result = null;

            // if they use a standard Collection we have to assume it is a
            // List...better
            // way to handle this?
            if (destCollectionType.getName().equals(Collection.class.getName())) {
                destCollectionType = List.class;
            }
            // Array to Array
            if (CollectionUtils.isArray(srcFieldType) && CollectionUtils.isArray(destCollectionType)) {
                result = this.mapArrayToArray(srcObj, srcCollectionValue, fieldMap, destObj);
                // Array to List
            } else if (CollectionUtils.isArray(srcFieldType) && CollectionUtils.isList(destCollectionType)) {
                result = this.mapArrayToList(srcObj, srcCollectionValue, fieldMap, destObj);
            }
            // List to Array
            else if (CollectionUtils.isList(srcFieldType) && CollectionUtils.isArray(destCollectionType)) {
                result = this.mapListToArray(srcObj, (List<?>) srcCollectionValue, fieldMap, destObj);
                // List to List
            } else if (CollectionUtils.isList(srcFieldType) && CollectionUtils.isList(destCollectionType)) {
                result = this.mapListToList(srcObj, (List<?>) srcCollectionValue, fieldMap, destObj);
            }
            // Set to Array
            else if (CollectionUtils.isSet(srcFieldType) && CollectionUtils.isArray(destCollectionType)) {
                result = this.mapSetToArray(srcObj, (Set<?>) srcCollectionValue, fieldMap, destObj);
            }
            // Array to Set
            else if (CollectionUtils.isArray(srcFieldType) && CollectionUtils.isSet(destCollectionType)) {
                result = this.addToSet(srcObj, fieldMap, Arrays.asList((Object[]) srcCollectionValue), destObj);
            }
            // Set to List
            else if (CollectionUtils.isSet(srcFieldType) && CollectionUtils.isList(destCollectionType)) {
                result = this.mapListToList(srcObj, (Set<?>) srcCollectionValue, fieldMap, destObj);
            }
            // Collection to Set
            else if (CollectionUtils.isCollection(srcFieldType) && CollectionUtils.isSet(destCollectionType)) {
                result = this.addToSet(srcObj, fieldMap, (Collection<?>) srcCollectionValue, destObj);
            }
            // List to Map value
            else if (CollectionUtils.isCollection(srcFieldType) && MappingUtils.isSupportedMap(destCollectionType)) {
                result = this.mapListToList(srcObj, (List<?>) srcCollectionValue, fieldMap, destObj);
            }
            return result;
        }

        private Object mapMap(final Object srcObj, final Map srcMapValue, final FieldMap fieldMap, final Object destObj) {
            Map result;
            Map destinationMap = fieldMap.getDestValue(destObj);
            if (destinationMap == null) {
                result = DestBeanCreator.create(srcMapValue.getClass());
            } else {
                result = destinationMap;
            }

            for (Entry<?, Object> srcEntry : ((Map<?, Object>) srcMapValue).entrySet()) {
                Object srcEntryValue = srcEntry.getValue();

                if (srcEntryValue == null) { // overwrites with null in any case
                    result.put(srcEntry.getKey(), null);
                    continue;
                }

                Object destEntryValue = this.mapOrRecurseObject(srcObj, srcEntryValue, srcEntryValue.getClass(),
                        fieldMap, destObj);
                Object obj = result.get(srcEntry.getKey());
                if (obj != null && obj.equals(destEntryValue) && fieldMap.isNonCumulativeRelationship()) {
                    this.map(null, srcEntryValue, obj, false, null);
                } else {
                    result.put(srcEntry.getKey(), destEntryValue);
                }
            }
            return result;
        }

        private Object mapUsingCustomConverterInstance(final CustomConverter converterInstance,
                final Class<?> srcFieldClass, final Object srcFieldValue, final Class<?> destFieldClass,
                final Object existingDestFieldValue, final FieldMap fieldMap, final boolean topLevel) {

            // 1792048 - If map-null = "false" and src value is null, then don't
            // even invoke custom converter
            if (srcFieldValue == null && !fieldMap.isDestMapNull()) {
                return null;
            }

            long start = System.currentTimeMillis();

            // TODO Remove code duplication
            Object result;
            if (converterInstance instanceof ConfigurableCustomConverter) {
                ConfigurableCustomConverter theConverter = (ConfigurableCustomConverter) converterInstance;

                // Converter could be not configured for this particular case
                if (fieldMap != null) {
                    String param = fieldMap.getCustomConverterParam();
                    theConverter.setParameter(param);
                }

                // if this is a top level mapping the destObj is the highest
                // level
                // mapping...not a recursive mapping
                if (topLevel) {
                    result = theConverter.convert(existingDestFieldValue, srcFieldValue, destFieldClass, srcFieldClass);
                } else {
                    Object existingValue = this.getExistingValue(fieldMap, existingDestFieldValue, destFieldClass);
                    result = theConverter.convert(existingValue, srcFieldValue, destFieldClass, srcFieldClass);
                }
            } else {
                // if this is a top level mapping the destObj is the highest
                // level
                // mapping...not a recursive mapping
                if (topLevel) {
                    result = converterInstance.convert(existingDestFieldValue, srcFieldValue, destFieldClass,
                            srcFieldClass);
                } else {
                    Object existingValue = this.getExistingValue(fieldMap, existingDestFieldValue, destFieldClass);
                    result = converterInstance.convert(existingValue, srcFieldValue, destFieldClass, srcFieldClass);
                }
            }

            long stop = System.currentTimeMillis();
            statsMgr.increment(StatisticType.CUSTOM_CONVERTER_SUCCESS_COUNT);
            statsMgr.increment(StatisticType.CUSTOM_CONVERTER_TIME, stop - start);

            return result;
        }

        private void mapFromIterateMethodFieldMap(final Object srcObj, final Object destObj, Object srcFieldValue,
                final FieldMap fieldMapping) {
            // Iterate over the destFieldValue - iterating is fine unless we are
            // mapping
            // in the other direction.
            // Verify that it is truly a collection if it is an iterator object
            // turn it
            // into a List
            if (srcFieldValue instanceof Iterator) {
                srcFieldValue = IteratorUtils.toList((Iterator<?>) srcFieldValue);
            }
            if (srcFieldValue != null) {
                for (int i = 0; i < CollectionUtils.getLengthOfCollection(srcFieldValue); i++) {
                    Object value = CollectionUtils.getValueFromCollection(srcFieldValue, i);
                    // map this value
                    if (fieldMapping.getDestHintContainer() == null) {
                        MappingUtils
                                .throwMappingException("<field type=\"iterate\"> must have a source or destination type hint");
                    }
                    Object converterByDestTypeCache = null;
                    // check for custom converters
                    Class<?> converterClass = MappingUtils.findCustomConverter(converterByDestTypeCache, fieldMapping
                            .getClassMap().getCustomConverters(), value.getClass(), fieldMapping.getDestHintContainer()
                            .getHint());

                    if (converterClass != null) {
                        Class<?> srcFieldClass = srcFieldValue.getClass();
                        value = this.mapUsingCustomConverter(converterClass, srcFieldClass, value, fieldMapping
                                .getDestHintContainer().getHint(), null, fieldMapping, false);
                    } else {
                        value = this.map(value, fieldMapping.getDestHintContainer().getHint());
                    }
                    if (value != null) {
                        this.writeDestinationValue(destObj, value, fieldMapping, srcObj);
                    }
                }
            }
            if (log.isDebugEnabled()) {
                log.debug(LogMsgFactory.createFieldMappingSuccessMsg(srcObj.getClass(), destObj.getClass(),
                        fieldMapping.getSrcFieldName(), fieldMapping.getDestFieldName(), srcFieldValue, null,
                        fieldMapping.getClassMap().getMapId()));
            }
        }

        //@formatter:off
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		private Object addToSet(final Object srcObj, final FieldMap fieldMap, final Collection<?> srcCollectionValue, final Object destObj) {
			throw new UnsupportedOperationException();
		}
	
		private Object mapListToList(final Object srcObj, final Set<?> srcCollectionValue, final FieldMap fieldMap, final Object destObj) {
			throw new UnsupportedOperationException();
		}
	
		private Object addToSet(final Object srcObj, final FieldMap fieldMap, final List<Object> asList, final Object destObj) {
			throw new UnsupportedOperationException();
		}
	
		private Object mapSetToArray(final Object srcObj, final Set<?> srcCollectionValue, final FieldMap fieldMap, final Object destObj) {
			throw new UnsupportedOperationException();
		}
	
		private Object mapListToList(final Object srcObj, final List<?> srcCollectionValue, final FieldMap fieldMap, final Object destObj) {
			throw new UnsupportedOperationException();
		}
	
		private Object mapListToArray(final Object srcObj, final List<?> srcCollectionValue, final FieldMap fieldMap, final Object destObj) {
			throw new UnsupportedOperationException();
		}
	
		private Object mapArrayToList(final Object srcObj, final Object srcCollectionValue, final FieldMap fieldMap, final Object destObj) {
			throw new UnsupportedOperationException();
		}
	
		private Object mapArrayToArray(final Object srcObj, final Object srcCollectionValue, final FieldMap fieldMap, final Object destObj) {
			throw new UnsupportedOperationException();
		}
	
		private void map(final Object object, final Object srcEntryValue, final Object obj, final boolean b, final Object object2) {
			throw new UnsupportedOperationException();
		}
	
		private Object mapOrRecurseObject(final Object srcObj, final Object srcEntryValue, final Class<? extends Object> class1,
				final FieldMap fieldMap, final Object destObj) {
			throw new UnsupportedOperationException();
		}
	
		private void writeDestinationValue(final Object destObj, final Object value, final FieldMap fieldMapping, final Object srcObj) {
			throw new UnsupportedOperationException();
		}
	
		private Object map(final Object value, final Object hint) {
			throw new UnsupportedOperationException();
		}
	
		private Object mapUsingCustomConverter(final Class<?> converterClass, final Class<?> srcFieldClass, final Object value,
				final Object hint, final Object object, final FieldMap fieldMapping, final boolean b) {
			throw new UnsupportedOperationException();
		}
	
		private Object getExistingValue(final FieldMap fieldMap, final Object existingDestFieldValue, final Class<?> destFieldClass) {
			throw new UnsupportedOperationException();
		}
	
	}

	public enum StatisticType {
		CUSTOM_CONVERTER_SUCCESS_COUNT, CUSTOM_CONVERTER_TIME

	}

	private Logger log;
	private Lala statsMgr;

	public class ConfigurableCustomConverter extends CustomConverter {

		public void setParameter(final String param) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Object convert(final Object existingDestFieldValue, final Object srcFieldValue, final Class<?> destFieldClass,
				final Class<?> srcFieldClass) {
			throw new UnsupportedOperationException();
		}

	}

	public class CustomConverter {

		public Object convert(final Object existingDestFieldValue, final Object srcFieldValue, final Class<?> destFieldClass,
				final Class<?> srcFieldClass) {
			throw new UnsupportedOperationException();
		}

	}

	public static class LogMsgFactory {

		public static Object createFieldMappingSuccessMsg(final Class<? extends Object> class1,
				final Class<? extends Object> class2, final Object srcFieldName, final Object destFieldName, final Object srcFieldValue,
				final Object object, final Object mapId) {
			throw new UnsupportedOperationException();
		}

	}

	public static class DestBeanCreator {

		public static Map create(final Class<? extends Map> class1) {
			throw new UnsupportedOperationException();
		}

	}

	public static class MappingUtils {

		public static boolean isSupportedMap(final Class<?> destCollectionType) {
			throw new UnsupportedOperationException();
		}

		public static void throwMappingException(final String string) {
			throw new UnsupportedOperationException();
		}

		public static Class<?> findCustomConverter(final Object converterByDestTypeCache, final Object customConverters,
				final Class<? extends Object> class1, final Object hint) {
			throw new UnsupportedOperationException();
		}

	}

	public static class CollectionUtils {

		public static boolean isArray(final Class<?> srcFieldType) {
			throw new UnsupportedOperationException();
		}

		public static boolean isList(final Class<?> srcFieldType) {
			throw new UnsupportedOperationException();
		}

		public static boolean isSet(final Class<?> srcFieldType) {
			throw new UnsupportedOperationException();
		}

		public static boolean isCollection(final Class<?> srcFieldType) {
			throw new UnsupportedOperationException();
		}

		public static int getLengthOfCollection(final Object srcFieldValue) {
			throw new UnsupportedOperationException();
		}

		public static Object getValueFromCollection(final Object srcFieldValue, final int i) {
			throw new UnsupportedOperationException();
		}

	}

	public static class IteratorUtils {

		public static Object toList(final Iterator<?> srcCollectionValue) {
			throw new UnsupportedOperationException();
		}

	}

	public class HintContainer {

		public void setHintName(final String name) {
			throw new UnsupportedOperationException();
		}

	}

	public class Logger {

		public void info(final String string) {
			throw new UnsupportedOperationException();
		}

		public void debug(final Object createFieldMappingSuccessMsg) {
			throw new UnsupportedOperationException();
		}

		public boolean isDebugEnabled() {
			throw new UnsupportedOperationException();
		}

	}

	public static class ReflectionUtils {

		public static Class<?> determineGenericsType(final Method method, final boolean b) {
			throw new UnsupportedOperationException();
		}

	}

	public class FieldMap {

		public Lala getDestHintContainer() {
			throw new UnsupportedOperationException();
		}

		public String getCustomConverterParam() {
			throw new UnsupportedOperationException();
		}

		public Method getDestFieldWriteMethod(final Class<? extends Object> class1) {
			throw new UnsupportedOperationException();
		}

		public void setDestHintContainer(final HintContainer destHintContainer) {
			throw new UnsupportedOperationException();
		}

		public Class<?> getDestFieldType(final Class<? extends Object> class1) {
			throw new UnsupportedOperationException();
		}

		public Map getDestValue(final Object destObj) {
			throw new UnsupportedOperationException();
		}

		public boolean isNonCumulativeRelationship() {
			throw new UnsupportedOperationException();
		}

		public Lala getClassMap() {
			throw new UnsupportedOperationException();
		}

		public class Lala {

			public Object getCustomConverters() {
				throw new UnsupportedOperationException();
			}

			public void increment(final StatisticType customConverterTime, final long l) {
				throw new UnsupportedOperationException();
			}

			public void increment(final StatisticType customConverterSuccessCount) {
				throw new UnsupportedOperationException();
			}

			public Object getHint() {
				throw new UnsupportedOperationException();
			}

			public Object getMapId() {
				throw new UnsupportedOperationException();
			}

		}

		public Object getSrcFieldName() {
			throw new UnsupportedOperationException();
		}

		public Object getDestFieldName() {
			throw new UnsupportedOperationException();
		}

		public boolean isDestMapNull() {
			throw new UnsupportedOperationException();
		}

	}

}
