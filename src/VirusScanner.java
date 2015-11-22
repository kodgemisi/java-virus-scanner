/**
 * @author destan
 *         November 2015
 */
public class VirusScanner {

    /**
     * @param filePath full path of the <strong>file</strong> to be scanned
     */
    public native void scanFile(String filePath);

    static {

        /*
         * Use this to load the library in a platform independent way
         * Note that in this way you need to set "java.library.path" to point
         * the library path
         */
//        System.loadLibrary("virscan");

        // Use this to load the native (platform dependent) library directly
        String libPath = VirusScanner.class.getClassLoader().getResource("./libvirscan.so").getPath().toString();
        System.load(libPath);
    }

}
