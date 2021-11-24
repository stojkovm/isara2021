package rs.ac.uns.ftn.isa;

public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("\n### LOST UPDATE ###");
    System.out.println("\nMySQL MyISAM engine");
    LostUpdate.run("schema1.sql");
    System.out.println("\nMySQL INNODB engine");
    LostUpdate.run("schema2.sql");

    System.out.println("\n### DIRTY READ ###");
    System.out.println("\nMySQL MyISAM engine");
    DirtyRead.run("schema1.sql");
    System.out.println("\nMySQL INNODB engine");
    DirtyRead.run("schema2.sql");

    System.out.println("\n### UNREPEATABLE READ ###");
    UnrepeatableRead.run("schema2.sql");

    System.out.println("\n### PHANTOM READ ###");
    PhantomRead.run("schema2.sql");
  }
}