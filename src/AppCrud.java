import java.util.Scanner;

public class AppCrud {
  Scanner scan = new Scanner(System.in);
  Crud crud = new Crud();
  String listener;
  public void start() throws Exception{
    do {
      System.out.println("Boa noite senhor(a), o que vai ser hoje?");
      listener = scan.nextLine();
      String separated[] = listener.split(" ");
      switch(separated[0]) {
        case "add":
          crud.add(Integer.parseInt(separated[1]), separated[2], separated[3], separated[4], separated[5]);
          break;
        case "del":
          crud.del(Integer.parseInt(separated[1]));
          break;
        case "info":
          crud.info(Integer.parseInt(separated[1]));
          break;
        case "query":
          String separatedFinal[] = separated[1].split(":");
          crud.query(separatedFinal[0].trim(), separatedFinal[1].trim());
          break;
        case "000":
          System.out.println("Até mais!!");
        default:
          System.out.println("Você provavelmente errou a sintaxe dos comandos");
      }
    }while(!listener.equals("000"));
  }
}
