public class TriangleError extends Throwable {
    public TriangleError(String cause){
        String errorMessage = "Triangle creation error: ";
        System.err.println(errorMessage +cause);
    }
}
