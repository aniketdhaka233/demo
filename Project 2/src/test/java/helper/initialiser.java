package helper;

public class initialiser {
    private static webdriverinitialiser initialize;
    public initialiser(){

        initialize = webdriverinitialiser.getInstance();
    }

    public webdriverinitialiser get()
    {
        return initialize;
    }
}
