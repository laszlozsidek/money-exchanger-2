# Money exchanger 2
## A homework for candidates at Bridge

1. Improvement ideas
    - Add UI
    - Simplify used data model (DTO)
2. Suggestions regarding the testing possibilities
    - Add tests which handle currencies as input parameters
3. Installation and execution
    - Clone repo from public [GitHub](https://github.com/laszlozsidek/money-exchanger-2) repository
    - Open it with an appropriate IDE
    - Unit tests can be executed from src/test/java/com/zsidek
    - Application can be executed from src/main/java/com/zsidek/application/Exchanger.java
      - This will do the actual work: decide which currency should we sell to maximize profit based on live data from _YH Finance API_
    - Optional: Other currencies (beside the three default) can be added as input parameters
      - Add currencies as environment variables, according to format: `ME2_CURx=<currencyCode>` (`ME2_CUR` must be part of key) 
      - Example: `ME2_CUR1=BTC;ME2_CUR2=RUB;ME2_CUR3=USD`