# HolonSocialServiceAnalyzer
academic project

Konfiguracja eclipsa:
http://code.makery.ch/library/javafx-8-tutorial/part1/

Tworzenie executable-jar z aplikacji:
# mvn jfx:jar

Tworzenie natywnej wykonywalki:
# mvn jfx:native

Uruchamianie aplikacji:
# mvn jfx:run

Tutorial - Tworzenie nowej metryki:
1. Zadeklaruj typ operacji w OperationType
2. Zadeklaruj jej tlumaczenie w OperationTypeTranslations
3. W OperationFactory.getFactory zadeklaruj factory dla twojego typu operacji
4. Zdefiniuj factory dla operacji
5. Zdefiniuj operacje
6. Ciesz sie z rezultatu wyswietlanego w GUI :P
