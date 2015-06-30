package operation;

import java.util.HashMap;
import java.util.Map;

public class OperationTypeTranslations {

	private static final Map<OperationType, String> operationTranslations = new HashMap<OperationType, String>();
	private static final Map<String, OperationType> operationTranslationsReversed = new HashMap<String, OperationType>();
	
	static {
		getOperationtranslations().put(OperationType.USER_COUNT, "Liczba u�ytkownik�w");
		getOperationtranslations().put(OperationType.POST_COUNT_PER_USER, "Liczba post�w per u�ytkownik");
		getOperationtranslations().put(OperationType.POST_SUM, "Liczba post�w");
		getOperationtranslations().put(OperationType.POST_AVERAGE_COUNT, "�rednia liczba post�w");
		getOperationtranslations().put(OperationType.POST_AVERAGE_LENGTH_PER_USER, "�rednia d�ugo�� postu na u�ytkownika");
		getOperationtranslations().put(OperationType.POST_AVERAGE_LENGTH, "�rednia d�ugo�� postu");
		getOperationtranslations().put(OperationType.POST_LENGTH_SUM, "Suma d�ugo�ci post�w");
		getOperationtranslations().put(OperationType.COMMENT_COUNT_PER_USER, "Liczba post�w(komentuj�cych) per u�ytkownik");
		getOperationtranslations().put(OperationType.COMMENT_SUM, "Liczba post�w(komentuj�cych)");
		getOperationtranslations().put(OperationType.COMMENT_AVERAGE_COUNT, "�rednia liczba post�w(komentuj�cych)");
		getOperationtranslations().put(OperationType.COMMENT_AVERAGE_LENGTH_PER_USER, "�rednia d�ugo�� postu(komentuj�cego) na u�ytkownika");
		getOperationtranslations().put(OperationType.COMMENT_AVERAGE_LENGTH, "�rednia d�ugo�� postu(komentuj�cego)");
		getOperationtranslations().put(OperationType.COMMENT_LENGTH_SUM, "Suma d�ugo�ci post�w(komentuj�cych)");
		getOperationtranslations().put(OperationType.TITLE_COUNT_PER_USER, "Liczba post�w(tytu�owych) per u�ytkownik");
		getOperationtranslations().put(OperationType.TITLE_SUM, "Liczba post�w(tytu�owych)");
		getOperationtranslations().put(OperationType.TITLE_AVERAGE_COUNT, "�rednia liczba post�w(tytu�owych)");
		getOperationtranslations().put(OperationType.TITLE_AVERAGE_LENGTH_PER_USER, "�rednia d�ugo�� postu(tytu�owego) na u�ytkownika");
		getOperationtranslations().put(OperationType.TITLE_AVERAGE_LENGTH, "�rednia d�ugo�� postu(tytu�owego)");
		getOperationtranslations().put(OperationType.TITLE_LENGTH_SUM, "Suma d�ugo�ci post�w(tytu�owych)");
		
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
