package matrixes;


/* Филиппов А.В. 14.05.2020 Комментарий не удалять.
 Не слишком простой метод для хранения двух строковых констант.
 public static final String было бы ничеть не хуже.
*/

// fixed

public class MatrixErrorCode {
    public static final String NEGATIVE_DIMENSION = "Matrix dimension cannot be negative, but was %d";
    public static final String ZERO_DIMENSION = "Matrix dimension is 0";
    public static final String INCORRECT_INDEXES = "Incorrect indexes: dimension = %d, row = %d, column = %d";
}
