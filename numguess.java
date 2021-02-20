import java.util.Scanner;
public class numguess
{
public static void main()
{
    int i,j,x1,x2,count=0,num2=0,range;
    double num1,mid;
    Scanner sc=new Scanner(System.in);
    System.out.println("SPECIFY VALUE OF LIMITS SUCH THAT PLAYER 1 SELECTS A RANDOM INTEGER FROM LIMIT1-LIMIT2");
    System.out.println("ENTER LOWER LIMIT");
    x1=sc.nextInt();
    System.out.println("ENTER UPPER LIMIT");
    x2=sc.nextInt();
    range=x2-x1+1;
    num1=x1+(Math.random()*range);
    System.out.println("GUESS THE NUMBER BETWEEN THE ENTERED RANGE(MAXIMUM GUESSES IS 10)");
    num2=sc.nextInt();
    if((num2>=x1)&&(num2<=x2))
    {
    while(count<10)
    {
    if(num2==(int)num1)
    {
    count++;
    System.out.println("Number found in "+count+" attempts");
    break;
    }
    else if(num2>(int)num1)
    {
    count++;
    System.out.println("too high,take another try");
    x2=num2;
    num2=sc.nextInt();
    }
    else if(num2<(int)num1)
    {
    count++;
    System.out.println("too low,take another try");
    x1=num2;
    num2=sc.nextInt();
     }
     }
    }
else
{
    System.out.println("OUT OF RANGE");
}
}
}


