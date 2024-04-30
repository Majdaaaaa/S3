import java.io.IOException;

public class InvalidContentException extends IOException {
    public InvalidContentException() {
    }

    public InvalidContentException(String msg) {
        super(msg);
    }
}
