public class Main {
  public static void main(String[] args) {
    StringLinkedList list = new StringLinkedList();
    System.out.println( list );
    list.add( "I don't have a feeling of inferiority." );
    list.add( "I'm as good as anybody, but no better." );
    list.add( 1, "Never had." );
    list.add( 3, "- Katherine Johnson");
    System.out.println( list );
    
    try {
      list.add( -1, "Noooooo" );
      System.out.println( "Bad!" );
    }
    catch ( Exception e ) {
      System.out.println( "Good!" );
    }
    
    try {
      list.add( 5, "Nooooo" );
      System.out.println( "Bad!" );
    }
    catch ( Exception e ) {
      System.out.println( "Good!" );
    }
    list.clear();

  }
}