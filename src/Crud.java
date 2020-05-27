public class Crud {
  No begin;
  No end;
  int quantity;
  public Crud() {
    this.begin = this.end = null;
    this.quantity = 0;
  }

  public int size() {
    return this.quantity;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public boolean exist(int id) {
    if (!isEmpty()) {
      No now = this.begin;
      while (now != null) {
        if (now.id == id) {
          return true;
        }
        now = now.next;
      }
    }
    return false;
  }

  public void add( int id, String firstName, String lastName, String birthday, String phoneNumber) {
    if(id > 0 && !exist(id)){
      No now = new No(id, firstName, lastName, birthday, phoneNumber);
      if(this.isEmpty()){
      this.begin = this.end = now;
      } else if(id < begin.id) {
        now.next = begin;
        begin.back = now;
        begin = now;
      } else if(id > end.id) {
        end.next = now;
        now.back = end;
        end = now;
      } else {
        No travel = this.begin;
        while(travel.id < id) {
          travel = travel.next;
        }
        No backTravel = travel.back;
        backTravel.next = now;
        now.back = backTravel;
        travel.back = now;
        now.next = travel;
      }
      quantity++;
    } else {
      System.out.println("O id está incorreto ou já existe, favor verificar novamente");
    }
  }

  public void del(int id) throws Exception{
      No cursor = this.begin;
      boolean found = false;
      if(id == this.begin.id){
        No secondNo = cursor.next;
        secondNo.back = null;
      }
      else if(id == this.end.id){
        No beforeLastNo = this.end.back;
        beforeLastNo.next = null;
      }else{
        while(!found){
          if(cursor.id == id){
            No lastNo = cursor.back;
            No nextNo = cursor.next;
            lastNo.next = nextNo;
            nextNo.back = lastNo;        
            found = true;
            quantity--;
          }
          cursor = cursor.next;
        }
        if(found == false){
          throw new Exception("ID: "+id+" não existe");
        }
      }    
  } 

  public void info(int id) {
    String response;
    if(!exist(id)) {
      response = "Não foi possível encontrar o id, favor tentar novamente";
    } else {
      No travel = this.begin;
      while(travel.id != id) {
        travel = travel.next;
      }
      response = "Id: "+travel.id+"\n";
      response += "Primeiro nome: "+travel.first_name+"\n";
      response += "Último nome: "+travel.last_name+"\n";
      response += "Aniversário: "+travel.birthday+"\n";
      response += "Telefone: "+travel.phone_number+"\n";
    }
    System.out.println(response);
  }

  public void query(String tag, String data) {
    No now = this.begin;
    switch(tag) {
      case "fn": 
        while(now != null) {
          if(now.first_name.equals(data))
            this.info(now.id);
          now = now.next;
        }
        break;
      case "ln":
        while(now != null) {
          if(now.last_name.equals(data))
            this.info(now.id);
          now = now.next;
        }
        break;
      case "bd":
      while(now != null) {
          if(now.birthday.equals(data))
            this.info(now.id);
          now = now.next;
        }
        break;
      case "pn":
        while(now != null) {
          if(now.phone_number.equals(data))
            this.info(now.id);
          now = now.next;
        }
        break;
      default:
        System.out.println("Método não encontrado");
    }
  }
}