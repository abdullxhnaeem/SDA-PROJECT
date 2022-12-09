public class person {
    public String username;
    public String password;
    String phone_number;
    String CNIC;
    String Email;
    String Address;

    public person(String u,String p,String pn,String c,String e,String a)
    {
        this.username=u;
        this.password=p;
        this.phone_number=pn;
        this.CNIC=c;
        this.Email=e;
        this.Address=a;
    }

    public person() {

    }
}
