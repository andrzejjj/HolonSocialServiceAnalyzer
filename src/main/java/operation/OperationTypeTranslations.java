package operation;

import java.util.HashMap;
import java.util.Map;

public class OperationTypeTranslations {

	private static final Map<OperationType, String> operationTranslations = new HashMap<OperationType, String>();
	private static final Map<String, OperationType> operationTranslationsReversed = new HashMap<String, OperationType>();
	
	static {
		getOperationtranslations().put(OperationType.USER_COUNT, "Liczba u¿ytkowników");
		getOperationtranslations().put(OperationType.POST_COUNT_PER_USER, "Liczba postów per u¿ytkownik");
		getOperationtranslations().put(OperationType.POST_SUM, "Liczba postów");
		getOperationtranslations().put(OperationType.POST_AVERAGE_COUNT, "Œrednia liczba postów");
		getOperationtranslations().put(OperationType.POST_AVERAGE_LENGTH_PER_USER, "Œrednia d³ugoœæ postu na u¿ytkownika");
		getOperationtranslations().put(OperationType.POST_AVERAGE_LENGTH, "Œrednia d³ugoœæ postu");
		getOperationtranslations().put(OperationType.POST_LENGTH_SUM, "Suma d³ugoœci postów");
		getOperationtranslations().put(OperationType.COMMENT_COUNT_PER_USER, "Liczba postów(komentuj¹cych) per u¿ytkownik");
		getOperationtranslations().put(OperationType.COMMENT_SUM, "Liczba postów(komentuj¹cych)");
		getOperationtranslations().put(OperationType.COMMENT_AVERAGE_COUNT, "Œrednia liczba postów(komentuj¹cych)");
		getOperationtranslations().put(OperationType.COMMENT_AVERAGE_LENGTH_PER_USER, "Œrednia d³ugoœæ postu(komentuj¹cego) na u¿ytkownika");
		getOperationtranslations().put(OperationType.COMMENT_AVERAGE_LENGTH, "Œrednia d³ugoœæ postu(komentuj¹cego)");
		getOperationtranslations().put(OperationType.COMMENT_LENGTH_SUM, "Suma d³ugoœci postów(komentuj¹cych)");
		getOperationtranslations().put(OperationType.TITLE_COUNT_PER_USER, "Liczba postów(tytu³owych) per u¿ytkownik");
		getOperationtranslations().put(OperationType.TITLE_SUM, "Liczba postów(tytu³owych)");
		getOperationtranslations().put(OperationType.TITLE_AVERAGE_COUNT, "Œrednia liczba postów(tytu³owych)");
		getOperationtranslations().put(OperationType.TITLE_AVERAGE_LENGTH_PER_USER, "Œrednia d³ugoœæ postu(tytu³owego) na u¿ytkownika");
		getOperationtranslations().put(OperationType.TITLE_AVERAGE_LENGTH, "Œrednia d³ugoœæ postu(tytu³owego)");
		getOperationtranslations().put(OperationType.TITLE_LENGTH_SUM, "Suma d³ugoœci postów(tytu³owych)");
		
		for(Map.Entry<OperationType, String> entry : operationTranslations.entrySet()){
			operationTranslationsReversed.put(entry.getValue(), entry.getKey());
		}
	}
	
	public static Map<OperationType, String> getOperationtranslations() {
		return operationTranslations;
	}

	public static Map<String, OperationType> getOperationtranslationsreversed() {
		return operationTranslationsReversed;
	}
}
