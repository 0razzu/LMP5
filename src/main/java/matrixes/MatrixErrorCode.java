package matrixes;


public enum MatrixErrorCode {
    NON_POSITIVE_DIMENSTION("Matrix dimension must be positive, but was %d"),
    INCORRECT_INDEXES("Incorrect indexes: dimension = %d, row = %d, column = %d");
    
    
    private String errorString;
    
    
    MatrixErrorCode(String errorString) {
        this.errorString = errorString;
    }
    
    
    public String getErrorString() {
        return errorString;
    }
}
