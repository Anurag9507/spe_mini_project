package com.example;
import java.util.Scanner;

public class ScientificCalculator
{
    public static double sqrt(double x)
    {
        if(x<0)
        	throw new IllegalArgumentException("Square root for negative numbers is undefined");
        return Math.sqrt(x);
    }

    public static long factorial(double n)
    {
        if (n<0)
            throw new IllegalArgumentException("Factorial for negative numbers is undefined");
        if(Math.floor(n)!=n)
            throw new IllegalArgumentException("Factorial for fractional numbers is undefined");
        long result=1;
        for(int i=2;i<=n;i++)
           result*=i;
        return result;
    }
    public static double natural_log(double x)
    {
        if(x<=0)
            throw new IllegalArgumentException("Natural logarithm for negative numbers or zero is undefined");
        return Math.log(x);
    }
    public static double power(double base,double exponent)
    {
        return Math.pow(base,exponent);
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("Scientific Calculator Menu:");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Logarithm");
            System.out.println("4. Power");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();
            try
            {
                switch(choice)
                {
                    case 1:
                        System.out.print("Enter number: ");
                        double x=sc.nextDouble();
                        System.out.println(sqrt(x));
                        break;
                    case 2:
                        System.out.print("Enter integer: ");
                        double y=sc.nextDouble();
                        System.out.println(factorial(y));
                        break;
                    case 3:
                        System.out.print("Enter number: ");
                        double z=sc.nextDouble();
                        System.out.println(natural_log(z));
                        break;
                    case 4:
                        System.out.print("Enter base: ");
                        double a=sc.nextDouble();
                        System.out.print("Enter exponent: ");
                        double b=sc.nextDouble();
                        System.out.println(power(a,b));
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Enter a number from 1 to 5");
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}