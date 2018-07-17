package se.abalon.exception;


import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 *  Custom made Exception when not being able to redeem an offer or a check. Generates a more structured JSON-response.
 */
public class UnableToRedeemException extends Exception {

   private String errorCode;


    /**
     * @param clazz the class that could not be found.
     * @param errorCode the error code for the Exception.
     * @param searchParamsMap takes a number of parameters for better understanding of the exception.
     */
    public UnableToRedeemException(Class clazz, String errorCode, String... searchParamsMap) {
        super(UnableToRedeemException.generateMessage(clazz.getSimpleName(), toMap(String.class, String.class, searchParamsMap)));
        this.errorCode = errorCode;
    }

    private static String generateMessage(String entity, Map<String, String> searchParams) {
        return StringUtils.capitalize(entity) +
                " could not be redeemed using " +
                searchParams;
    }

    private static <K, V> Map<K, V> toMap(
            Class<K> keyType, Class<V> valueType, Object... entries) {
        if (entries.length % 2 == 1)
            throw new IllegalArgumentException("Invalid entries");
        return IntStream.range(0, entries.length / 2).map(i -> i * 2)
                .collect(HashMap::new,
                        (m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])),
                        Map::putAll);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}