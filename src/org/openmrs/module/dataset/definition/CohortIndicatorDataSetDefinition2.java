package org.openmrs.module.dataset.definition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openmrs.module.dataset.column.DataSetColumn;
import org.openmrs.module.dataset.column.SimpleDataSetColumn;
import org.openmrs.module.evaluation.parameter.Mapped;
import org.openmrs.module.indicator.CohortIndicator;
import org.openmrs.module.indicator.dimension.CohortDefinitionDimension;
import org.openmrs.util.OpenmrsUtil;

public class CohortIndicatorDataSetDefinition2 extends BaseDataSetDefinition {
	
	Map<String, Mapped<CohortDefinitionDimension>> dimensions = new HashMap<String, Mapped<CohortDefinitionDimension>>();
	List<ColumnDefinition> columns = new ArrayList<ColumnDefinition>();
	
	public CohortIndicatorDataSetDefinition2() {
		super();
	}
	
	public List<DataSetColumn> getColumns() {
		return new ArrayList<DataSetColumn>(columns);
	}
	
	public Map<String, Mapped<CohortDefinitionDimension>> getDimensions() {
		return dimensions;
	}
	
	public void addDimension(String dimensionKey, Mapped<CohortDefinitionDimension> dimension) {
		dimensions.put(dimensionKey, dimension);
	}
	
	public void addColumn(String key, String displayName, Mapped<CohortIndicator> indicator, Map<String, String> dimensionOptions) {
		columns.add(new ColumnDefinition(key, displayName, indicator, dimensionOptions));
	}
	
	/**
	 * 
	 * Auto generated method comment
	 * 
	 * @param key
	 * @param displayName
	 * @param indicator
	 * @param dimensionOptions something like gender=male|age=adult, where gender and age are keys into 'dimensions'
	 */
	public void addColumn(String key, String displayName, Mapped<CohortIndicator> indicator, String dimensionOptions) {
		addColumn(key, displayName, indicator, OpenmrsUtil.parseParameterList(dimensionOptions));
	}
	
	public Mapped<CohortDefinitionDimension> getDimension(String key) {
	    return dimensions.get(key);
    }
	
	public class ColumnDefinition extends SimpleDataSetColumn {

        private static final long serialVersionUID = 1L;
        
		private Mapped<CohortIndicator> indicator;
		private Map<String, String> dimensionOptions;
		
		public ColumnDefinition(String columnKey, String displayName, Mapped<CohortIndicator> indicator, Map<String, String> dimensionOptions) {
			super(columnKey, displayName, null, Object.class);
			this.indicator = indicator;
			this.dimensionOptions = dimensionOptions;
		}

        /**
         * @return the indicator
         */
        public Mapped<CohortIndicator> getIndicator() {
        	return indicator;
        }
		
        /**
         * @return the dimensionOptions
         */
        public Map<String, String> getDimensionOptions() {
        	return dimensionOptions;
        }
		
	}
	
}