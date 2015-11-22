/**
 * @author destan
 *         November 2015
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        System.out.println("Scan program started.");

        String filePathToBeScanned = args[0];

         /*
         * Set library path programmatically
         * Hint from http://blog.cedarsoft.com/2010/11/setting-java-library-path-programmatically/
         */
//        System.setProperty("java.library.path", "/home/destan/Desktop/clamav/java/src");

        /* Following snippet causes "java.library.path" to be reloaded */
//        Field fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
//        fieldSysPath.setAccessible( true );
//        fieldSysPath.set( null, null );

        VirusScanner virusScanner = new VirusScanner();
        virusScanner.scanFile(filePathToBeScanned);

        System.out.println("The End");
    }
}
