//KNAPSACK PROBLEM
package ga;
import java.math.*;
import java.util.Random;
import java.io.*;
import java.util.ArrayList;
public class myclass 
      {
	   Random rd=new Random();
	   int pop[][]=new int[64][12];
	   int profit[]= {2,3,6,9,8,15,1,18,19,20};
	   int weight[]= {8,9,2,4,1,5,7,17,19,12};
	   
	   void randompopulation() 
	     {
	       int i,j;
	       int total_weight=0;
	       //Generating a random population of size 64
	        for(i=0;i<pop.length;i++)
	        {
	           for(j=0;j<10;j++)
	           {
	             pop[i][j]=rd.nextInt(2);
	            } 
	        }
	        int fit=0;
		      for(i=0;i<pop.length;i++)
		      {
		         for(j=0;j<10;j++)
		          {
		           if(pop[i][j]==1) 
		           {
		        	   fit = fit+(profit[j]);
		               total_weight=total_weight+weight[j];
		           }
		          }
		          pop[i][10]=fit;
		          pop[i][11]=total_weight;
		          fit=0;
		          total_weight=0;
		       }
		      //int i,j;
			  /* for(i=0;i<pop.length;i++)
			      {
			         for(j=0;j<=10;j++)
			          {
			           System.out.print(pop[i][j]+" "); 
			          }
			          System.out.println(); 
		          }*/
	        
	     }
	   
	   void fitness(int thresh)
	    {
	      int i,j,fit=0,total_weight=0,weight1=0;
	      for(i=0;i<thresh;i++)
	      {
	         for(j=0;j<10;j++)
	          {
	           if(pop[i][j]==1)
	           {
	           fit = fit + (profit[j]);
	           total_weight=total_weight+weight[j];
	           }
	         }
	         pop[i][10]=fit;
	         pop[i][11]=total_weight;
	         fit=0;
	         total_weight=0;
	    }
	  }
	   
	   void selection(int thresh)
	   {
		   int i=0,j=0,big=0,record=0;
		   int pop1[][]=new int[16][11];
		   int k=0;
		   for(i=0;i<pop1.length;i++)
		      {
		         for(j=0;j<=10;j++)
		          {
		           pop1[i][j]=0; 
		          }
	          } 
		   for(i=3;i<thresh;i=i+4)
		   {
			 //if(i%4==0&&i!=0)
			 {
			   for(j=i-3;j<=i;j++)
			   {
				if(pop[j][10]>big) 
				  {
					big=pop[j][10];
				    record=j;
				  }
			   }
			   big=0;
			  for(j=0;j<=10;j++)
				  pop1[i/4][j]=pop[record][j];
			  k++;
			 }
		   }
		   for(i=0;i<pop.length;i++)
		      {
		         for(j=0;j<=10;j++)
		          {
		           pop[i][j]=0; 
		          }
	          }
		   for(i=0;i<k;i++)
		      {
		         for(j=0;j<=10;j++)
		          {
		           pop[i][j]=pop1[i][j]; 
		          }
	          }
		   for(i=0;i<k;i++)
		      {
		         for(j=0;j<=10;j++)
		          {
		           pop1[i][j]=0; 
		          }
	          } 
	    }
	   
	   void crossover(int thresh)
	   {
		   int cop,temp,i,j;
		   for(i=0;i<thresh;i+=2)
		   {
			   //if(pop[i][10]>0)
			   {
			   cop=rd.nextInt(10);
			   for(j=0;j<cop;j++)
			     {
				   temp=pop[i][j];
				   pop[i][j]=pop[i+1][j];
				   pop[i+1][j]=temp;
			     }
			   }
		   }
	   }

	   void mutation(int thresh)
         {
		   int i,j,n;
		   for(i=0;i<thresh;i++)
		   {
			   n=rd.nextInt(6);
			   for(j=n;j<n+3;j++)
			     {
				   if(pop[i][j]==1)
					   pop[i][j]=0;
				   else
					   pop[i][j]=1;
			     }
		       } 
	   }
	   
	   int[] print(int thresh)
	   {
		   int i,j;
		   int pw[]=new int[2];
		   for(i=0;i<thresh/4;i++)
		      {
		         for(j=0;j<=11;j++)
		          { 
		           System.out.print(pop[i][j]+" ");
		          }
		          System.out.println(); 
	          }
		   pw[0]=pop[0][10];
		   pw[1]=pop[0][11];
		   return pw;
	   }
	  
	   public static void main(String[] args) 
	   {
		    myclass genetic;
	        genetic=new myclass();
	        ArrayList<Integer> list = new ArrayList<>();
	        ArrayList<Integer> list1 = new ArrayList<>();
	        ArrayList<Integer> list2 = new ArrayList<>();
	        int gen=0,p=0,w=0,i,big=0,gen1=0,w1=0;
	        while(true)
	        {
	        System.out.println("----------Generation "+gen+" --------");
	        System.out.println("Random Population and profits weights:");
	        genetic.randompopulation();
	        //genetic.fitness();
	        genetic.print(64*4);
	        int z=1;
	        int thresh=0;
	        while(z<4)
	        {
	        thresh=64/((int)Math.pow(4, z-1));
	        
	        genetic.selection(thresh);
	        
	        genetic.crossover(thresh);
	        
	        genetic.mutation(thresh);
	        
	        genetic.fitness(thresh);
	        
	        System.out.println("-----------------------------");
	        System.out.println("Tournament "+z+" result:");
	        int[] pw=genetic.print(thresh);
	        if(z==3)
	        {
	         p=pw[0];
	         w=pw[1];
	        }
	        z++;
	        }
	        System.out.println("------------------------------------");
	       if(w<=40)
	       {
	    	list.add(p);
	    	list1.add(gen);
	    	list2.add(w);
	       }
	       
	       if(gen==100)
	       {
	    	for(i=0;i<list.size();i++) 
		      {
		        if(list.get(i)>big) {
		        big=list.get(i);
		        gen1=list1.get(i);
		        w1=list2.get(i);}
	   	      }
	       System.out.println("Solution found in Generation: "+gen1+"\n");
  	       System.out.println("Maximum Profit: "+big);
  	       System.out.println("Corresponding weight: "+w1);
  	       break;
  	       }
	       gen++;
           }
	        
      }
    }
