package performer.contabil.utils;

 

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import ar.com.fdvs.dj.domain.CustomExpression;

public class DateTimeExpression implements CustomExpression {

	private String alias;
	private SimpleDateFormat formatter;
	
	public DateTimeExpression(String alias, SimpleDateFormat formatter) {
		this.alias = alias;
		this.formatter = formatter;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object evaluate(Map fields, Map variables, Map parameters) {
		
		Map map = (Map) fields;
		Date date = (Date) map.get(alias);
		
		return formatter.format(date);
		
	}

	@Override
	public String getClassName() {
		return String.class.getName();
	}
	
}
