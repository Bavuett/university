
import java.util.*;

public class TreeSetExample2
{
  public static void main (String[ ] args)
  {
    new TreeSetExample2().run();
  } // method main
 
  public void run()
  {
    // Red-black Tree of strings	
    TreeSet<String> tree1 = new TreeSet<String>();
    
    tree1.add ("yes");
    tree1.add ("no");
    tree1.add ("maybe");
    tree1.add ("always");
    tree1.add ("no"); // not added: duplicate element
    System.out.println ("tree1: " + tree1);
    if (!tree1.remove ("often"))
      System.out.println ("How did that happen?");
    else
      System.out.println ("\"maybe\" removed? " + tree1.remove ("maybe"));
    
    TreeSet<String> tree2 = new TreeSet<String>(tree1);
    System.out.println ("tree2: " + tree2);

    TreeSet<String> tree3 = new TreeSet<String>(new Decreasing());
    tree3.addAll(tree2);
    System.out.println ("tree3: " + tree3);

    
    
  } // method run
  
} // class TreeSetExample