public class Addition
{
public void add(int a, double b)
{
System.out.println(a+b);
}

public void add(double a, int b)
{
System.out.println(a+b);
}

public void add(String a, String b)
{
System.out.println(a+b);
}

public static void main(String args[])
{
Addition obj=new Addition();
obj.add(10,20.5);
obj.add(10.5,20);
obj.add("hello","java");
}
}
