package lookupabstracttask;

public abstract class SingletonBean {

  public abstract PrototypeBean prototypeBean();

  public void doSmth(){
    int randomNumber = prototypeBean().getRandomNumber();
    System.out.println("Number is " + randomNumber);
  }
}
