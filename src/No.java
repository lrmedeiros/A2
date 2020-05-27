public class No {
  int id;
  String first_name, last_name, birthday, phone_number;
  No next;
  No back;
  public No(int id, String first_name, String last_name, String birthday, String phone_number) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.birthday = birthday;
    this.phone_number = phone_number;
    this.back = this.next = null;
  }
}