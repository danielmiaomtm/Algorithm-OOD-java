Class Singleton {
      private static Singleton sc = null;
      
      private Singleton() {
           /* do something */
      }

     public static synchronized Singleton getInstance() {
           /* lazy initialization */
           if(sc == null) {
                 sc = new Singleton();
           }
           return sc;
     }
}
