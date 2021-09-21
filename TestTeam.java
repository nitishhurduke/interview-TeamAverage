import java.util.*;

public class TestTeam
{
	ArrayList<Team>teams = new ArrayList <Team>();
	ArrayList <Integer> points = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	ArrayList<Float>averages = new ArrayList<>();
	ArrayList<Team>sortedTeams = new ArrayList<Team>();
	
	public void setTeam()
	{
		
		System.out.print("Enter Team Name : ");
		String name = sc.next();

		Team t = new Team(name);

		System.out.println("Enter Points : ");
		while(true){
			int point = sc.nextInt();
			if(point == 0){
				break;
			}else{
			t.points.add(point);
			}
		}
		
		t.avg = getAverage(t);
		averages.add(t.avg);
		teams.add(t);
		
	}
	public void sortTeams()
	{
		Collections.sort(averages,Collections.reverseOrder());
		int index = 0;
		for(float f : averages)
		{
			
			for(Team t : teams)
			{
				if(t.avg == f)
				{
					sortedTeams.add(t);
					
				}
			}
		}
				
	}
	
	public void getTeam()
	{	
		sortTeams();
		int i =1;
		System.out.println("*ALL TEAMS*");
		for(Team t : sortedTeams)
		{	
			System.out.println("Team Name : "+t.teamName);
			System.out.print("Points : ");
			for(int j: t.points){
				System.out.print(j+" ");
			}
			
			System.out.println("\nAverage of Team '"+t.teamName+"' = "+t.avg);
			System.out.println("Count = "+t.points.size());
			System.out.println();	
		}	
		
	}
	public float getAverage(Team t)
	{
		int totalPoints = 0;
		for(int s : t.points)
		{
			totalPoints += s;			 
		}
		float avg = (float) (totalPoints/t.points.size());
		return avg;
	}
	
	public static void main(String args[])
	
	{	Scanner sc1 = new Scanner(System.in);
		TestTeam tt = new TestTeam();	
		
		while(true){
			
			System.out.println("PRESS 1 TO ADD TEAM");
			System.out.println("PRESS 2 TO GET TEAM AVERAGE");
			
			int input = sc1.nextInt();
			if(input == 1){
				tt.setTeam();
			}else if(input == 2){
				tt.getTeam();
			}else{
			 break;
			}
	  	
		}		
		
	}
}
