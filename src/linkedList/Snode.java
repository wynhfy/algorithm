package linkedList;

public class Snode<T> {
  private T element;
  private Snode next;

  public Snode(){
    this.next=null;
  }

  public Snode(T element){
    this.element=element;
  }

  public Snode(T element,Snode next){
    this.element=element;
    this.next=next;
  }

  public T getElement() {
    return element;
  }

  public void setElement(T element) {
    this.element = element;
  }

  public Snode getNext() {
    return next;
  }

  public void setNext(Snode next) {
    this.next = next;
  }
}
