package matrixes;


/* Филиппов А.В. 14.05.2020 Комментарий не удалять.
 Не слишком простой метод для хранения двух строковых констант.
 public static final String было бы ничеть не хуже.
*/
public enum MatrixErrorCode {
    NON_POSITIVE_DIMENSION("Matrix dimension must be positive, but was %d"),
    INCORRECT_INDEXES("Incorrect indexes: dimension = %d, row = %d, column = %d");
    
    
    private String errorString;
    
    
    MatrixErrorCode(String errorString) {
        this.errorString = errorString;
    }
    
    
    public String getErrorString() {
        return errorString;
    }
}
